package com.ioannisgk.microdatawebparser.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.ioannisgk.evsharing.entities.User;
import com.ioannisgk.microdatawebparser.services.GenerateJSONLDService;
import com.ioannisgk.microdatawebparser.services.GenerateMicrodataService;
import com.ioannisgk.microdatawebparser.services.GenerateRDFaService;
import com.ioannisgk.microdatawebparser.services.GetSourcesService;
import com.ioannisgk.microdatawebparser.services.ParseMode1Service;
import com.ioannisgk.microdatawebparser.services.ParseMode2Service;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	// Inject the get sources service
	@Autowired
	private GetSourcesService getSourcesService;
	
	// Inject the get parse mode 1 service
	@Autowired
	private ParseMode1Service parseMode1Service;
	
	// Inject the get parse mode 2 service
	@Autowired
	private ParseMode2Service parseMode2Service;
	
	// Inject the generate microdata service
	@Autowired
	private GenerateMicrodataService generateMicrodataService;
	
	// Inject the generate rdfa service
	@Autowired
	private GenerateRDFaService generateRDFaService;
	
	// Inject the generate jsonld service
	@Autowired
	private GenerateJSONLDService generateJSONLDService;
	
	@GetMapping("/main")
	public String main(Model theModel) {
		
		// Get all sources
		HashMap medicalConditions = getSourcesService.getSources();
		
		// Add sources to tree map to order the keys alphabetically
		Map<String, String> orderedMedicalConditions = new TreeMap<>(medicalConditions);
		
		// Add tree map to the model
		theModel.addAttribute("medicalConditions", orderedMedicalConditions);
		
		// Open main.jsp
		return "main";
	}
	
	@GetMapping("/generate")
	public String generate(HttpServletRequest request, Model model) {
		
		HashMap medicalConditions = getSourcesService.getSources();
		HashMap extractedCondition1 = new HashMap();
		HashMap extractedCondition2 = new HashMap();
		
		// Get user selection
		String selection = request.getParameter("selection");
		
		// Get sources urls from user selection
		String source1 = ((String[])medicalConditions.get(selection))[0];
		String source2 = ((String[])medicalConditions.get(selection))[1];
		
		// Create document1 and document2 from sources urls
		Document document1, document2;
		
		// Extract hashmaps with source information based on microdata tags
		try {
			document1 = Jsoup.connect(source1).get();
			document2 = Jsoup.connect(source2).get();
			
			extractedCondition1 = parseMode1Service.parse(document1);
			extractedCondition2 = parseMode2Service.parse(document2);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Add variables to the model
		model.addAttribute("selection", selection);
		model.addAttribute("source1", source1);
		model.addAttribute("source2", source2);
		model.addAttribute("extractedCondition1", extractedCondition1);
		model.addAttribute("extractedCondition2", extractedCondition2);
		
		// Open generate.jsp
		return "generate";
	}
	
	@PostMapping("/webservice")
	public String webservice(HttpServletRequest request, Model model) {
		
		HashMap medicalConditions = getSourcesService.getSources();
		HashMap extractedCondition1 = new HashMap();
		HashMap extractedCondition2 = new HashMap();
		
		// Get user selection and type of conversion
		String selection = request.getParameter("selection");
		String type = request.getParameter("type");
		String htmlCode = "";
		
		// Get sources urls from user selection
		String source1 = ((String[])medicalConditions.get(selection))[0];
		String source2 = ((String[])medicalConditions.get(selection))[1];
		
		// Create document1 and document2 from sources urls
		Document document1, document2;
		
		// Extract hashmaps with source information based on microdata tags
		try {
			document1 = Jsoup.connect(source1).get();
			document2 = Jsoup.connect(source2).get();
			
			extractedCondition1 = parseMode1Service.parse(document1);
			extractedCondition2 = parseMode2Service.parse(document2);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Generate code according to type selection from user
		if (type.equals("microdata"))
			htmlCode = generateMicrodataService.generate(extractedCondition1, extractedCondition2);
		else if (type.equals("rdfa"))
			htmlCode = generateRDFaService.generate(extractedCondition1, extractedCondition2);
		else if (type.equals("jsonld"))
			htmlCode = generateJSONLDService.generate(extractedCondition1, extractedCondition2);
		
		// Add variables to the model
		model.addAttribute("htmlCode", htmlCode);
		model.addAttribute("type", type);

		// Open webservice.jsp
		return "webservice";
	}
}