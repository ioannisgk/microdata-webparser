package com.ioannisgk.microdatawebparser.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class GenerateMicrodataService {
	
	public String generate(HashMap extractedCondition1, HashMap extractedCondition2) {
		String htmlCode = 
				"<div id=\"itemscope\" itemscope itemtype=\"http://schema.org/MedicalCondition\">\n" + 
				    "<strong>Name</strong>: <span itemprop=\"name\">" + extractedCondition1.get("Name") + "</span></br></br>\n" + 
				    "<strong>Alternate Name</strong>: <span itemprop=\"alternateName\">" + extractedCondition2.get("Alternate Name") + "</span></br></br>\n" + 
				    "<div itemprop=\"relevantSpecialty\" itemscope itemtype=\"http://schema.org/MedicalSpecialty\">\n" + 
				        "<strong>Relevant keywords</strong>: <span itemprop=\"name\">" + extractedCondition1.get("Keywords") + " " + extractedCondition2.get("Keywords") + "</span>\n" + 
				    "</div></br>\n" + 
				    "<strong>Description</strong>: <div itemprop=\"description\">" + extractedCondition1.get("Description") + "</div></br>\n" + 
				    "<strong>Pathophysiology</strong>: <div itemprop=\"pathophysiology\">" + extractedCondition2.get("Pathophysiology") + "</div></br>\n" + 
				    "<strong>Possible Treatment</strong>: <div itemprop=\"possibleTreatment\">" + extractedCondition2.get("Treatment") + "</div></br>\n" + 
				"</div>";
	
		return htmlCode;
	}
}