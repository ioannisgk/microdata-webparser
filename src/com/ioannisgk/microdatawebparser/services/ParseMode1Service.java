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
		boolean valid = true;
		ArrayList<String> schemaKeywords = new ArrayList<String>();
		ArrayList<String> schemaDescription = new ArrayList<String>();
		String keywords = "", description = "";
		HashMap extractedCondition = new HashMap();
		
		Elements elements = document.select("*[itemprop]");
		for (Element el:elements){
						
			if (el.attr("itemprop").equals("name") && valid) {
				if (el.text().equals("View disclaimer")) {
					valid = false;
				} else schemaKeywords.add(el.text());
			}
			
			if (el.attr("itemprop").equals("description") && !el.text().contains("...")) schemaDescription.add(el.text());
		}
		for (int i = 1; i < schemaKeywords.size(); i++) {
			keywords = keywords + " " + schemaKeywords.get(i);
		}
		for (int i = 0; i < schemaDescription.size(); i++) {
			description = description + " " + schemaDescription.get(i);
		}
		extractedCondition.put("Name", schemaKeywords.get(0));
		extractedCondition.put("Keywords", (keywords.isEmpty()) ? keywords : keywords.substring(1));
		extractedCondition.put("Description", (description.isEmpty()) ? description : description.substring(1));
		return extractedCondition;
	}
}