package com.ioannisgk.microdatawebparser.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class GenerateRDFaService {
	
	public String generate(HashMap extractedCondition1, HashMap extractedCondition2) {
		String htmlCode = 
				"<div xmlns=\"http://www.w3.org/1999/xhtml\"\n" +
				    "prefix=\"\n" +
				        "schema: http://schema.org/\n" +
				        "rdf: http://www.w3.org/1999/02/22-rdf-syntax-ns#\n" +
				        "rdfa: http://www.w3.org/ns/rdfa#\n" +
				        "rdfs: http://www.w3.org/2000/01/rdf-schema#\">\n" +
				    "<div typeof=\"schema:MedicalCondition\">\n" +
				        "<div property=\"schema:name\" content=\"" + extractedCondition1.get("Name") + "\"></div>\n" +
				        "<div property=\"schema:alternateName\" content=\"" + extractedCondition2.get("Alternate Name") + "\"></div>\n" +
				        "<div rel=\"schema:relevantSpecialty\">\n" +
				           "<div typeof=\"schema:MedicalSpecialty\">\n" +
				              "<div property=\"schema:name\" content=\"" + extractedCondition1.get("Keywords") + " " + extractedCondition2.get("Keywords") + "\"></div>\n" +
				           "</div>\n" +
				        "</div>\n" +
				        "<div property=\"schema:description\" content=\"" + extractedCondition1.get("Description") + "\"></div>\n" +
				        "<div property=\"schema:pathophysiology\" content=\"" + extractedCondition2.get("Pathophysiology") + "\"></div>\n" +
				        "<div property=\"schema:possibleTreatment\" content=\"" + extractedCondition2.get("Treatment") + "\"></div>\n" +
				    "</div>\n" +
				"</div>";
	
		return htmlCode;
	}
}