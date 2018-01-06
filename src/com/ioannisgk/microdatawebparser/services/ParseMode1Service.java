package com.ioannisgk.microdatawebparser.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class ParseMode1Service {
	
	public HashMap parse(Document document) {
		
		// Variable used to check for valid data in microdata properties
		boolean valid = true;
		
		// Arraylists that contain actual microdata
		ArrayList<String> schemaKeywords = new ArrayList<String>();
		ArrayList<String> schemaDescription = new ArrayList<String>();
		
		String keywords = "", description = "";
		HashMap extractedCondition = new HashMap();
		
		// Select itemprop and iterate document element
		Elements elements = document.select("*[itemprop]");
		for (Element el:elements){
				
			// Save only valid data
			if (el.attr("itemprop").equals("name") && valid) {
				if (el.text().equals("View disclaimer")) {
					valid = false;
					
			        // Add valid data to arraylist
				} else schemaKeywords.add(el.text());
			}
			
			// Add valid data to arraylist and discard ‘...’
			if (el.attr("itemprop").equals("description") && !el.text().contains("...")) schemaDescription.add(el.text());
		}
		
		// Concatenate keywords
		for (int i = 1; i < schemaKeywords.size(); i++) {
			keywords = keywords + " " + schemaKeywords.get(i);
		}
		
		// Concatenate description
		for (int i = 0; i < schemaDescription.size(); i++) {
			description = description + " " + schemaDescription.get(i);
		}
		
		// Update hashmaps with microdata properties and values
		extractedCondition.put("Name", schemaKeywords.get(0));
		extractedCondition.put("Keywords", (keywords.isEmpty()) ? keywords : keywords.substring(1));
		extractedCondition.put("Description", (description.isEmpty()) ? description : description.substring(1));
		return extractedCondition;
	}
}
