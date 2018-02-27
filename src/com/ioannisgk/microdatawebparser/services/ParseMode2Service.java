package com.ioannisgk.microdatawebparser.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class ParseMode2Service {
	
	public HashMap parse(Document document) {
		
		// Arraylists that contain actual microdata
		ArrayList<String> schemaKeywords = new ArrayList<String>();
		ArrayList<String> schemaPathophysiology = new ArrayList<String>();
		ArrayList<String> schemaTreatment = new ArrayList<String>();
		
		String keywords = "", pathophysiology = "", treatment = "";
		HashMap extractedCondition = new HashMap();
		
		// Select itemprop and iterate document element
		Elements elements = document.select("*[itemprop]");
		for (Element el:elements){
					
			// Save only valid data
			if (el.attr("itemprop").equals("name") || el.attr("itemprop").equals("relevantSpecialty")) {
				
				// Add valid data to arraylist
				schemaKeywords.add(el.text());
			}
			
			// Add valid data to arraylist
			if (el.attr("itemprop").equals("pathophysiology")) schemaPathophysiology.add(el.text());
			if (el.attr("itemprop").equals("possibleTreatment")) schemaTreatment.add(el.text());
		}
		
		// Concatenate keywords
		for (int i = 1; i < schemaKeywords.size(); i++) {
			keywords = keywords + " " + schemaKeywords.get(i);
		}
		
		// Concatenate pathophysiology
		for (int i = 0; i < schemaPathophysiology.size(); i++) {
			pathophysiology = pathophysiology + " " + schemaPathophysiology.get(i);
		}
		
		// Concatenate treatment
		for (int i = 0; i < schemaTreatment.size(); i++) {
			treatment = treatment + " " + schemaTreatment.get(i);
		}
		
		// Update hashmaps with microdata properties and values
		extractedCondition.put("Alternate Name", (schemaKeywords.isEmpty()) ? "" : schemaKeywords.get(0));
		extractedCondition.put("Keywords", (keywords.isEmpty()) ? keywords : keywords.substring(1));
		extractedCondition.put("Pathophysiology", (pathophysiology.isEmpty()) ? pathophysiology : pathophysiology.substring(1));		
		extractedCondition.put("Treatment", (treatment.isEmpty()) ? treatment : treatment.substring(1));
		return extractedCondition;
	}
}
