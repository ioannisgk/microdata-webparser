package com.ioannisgk.microdatawebparser.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class GenerateJSONLDService {
	
	public String generate(HashMap extractedCondition1, HashMap extractedCondition2) {
		String htmlCode = 
					"{\n" +
					  "\"@context\": {\n" +
					    "\"cc\": \"http://creativecommons.org/ns#\",\n" +
					    "\"ctag\": \"http://commontag.org/ns#\",\n" +
					    "\"dc\": \"http://purl.org/dc/elements/1.1/\",\n" +
					    "\"dc1\": \"http://purl.org/dc/terms/\",\n" +
					    "\"dc11\": \"http://purl.org/dc/elements/1.1/\",\n" +
					    "\"dcat\": \"http://www.w3.org/ns/dcat#\",\n" +
					    "\"dcterms\": \"http://purl.org/dc/terms/\",\n" +
					    "\"foaf\": \"http://xmlns.com/foaf/0.1/\",\n" +
					    "\"gr\": \"http://purl.org/goodrelations/v1#\",\n" +
					    "\"grddl\": \"http://www.w3.org/2003/g/data-view#\",\n" +
					    "\"hcalendar\": \"http://microformats.org/profile/hcalendar#\",\n" +
					    "\"hcard\": \"http://microformats.org/profile/hcard#\",\n" +
					    "\"ical\": \"http://www.w3.org/2002/12/cal/icaltzd#\",\n" +
					    "\"ma\": \"http://www.w3.org/ns/ma-ont#\",\n" +
					    "\"md\": \"http://www.w3.org/ns/md#\",\n" +
					    "\"og\": \"http://ogp.me/ns#\",\n" +
					    "\"org\": \"http://www.w3.org/ns/org#\",\n" +
					    "\"owl\": \"http://www.w3.org/2002/07/owl#\",\n" +
					    "\"prov\": \"http://www.w3.org/ns/prov#\",\n" +
					    "\"qb\": \"http://purl.org/linked-data/cube#\",\n" +
					    "\"rdf\": \"http://www.w3.org/1999/02/22-rdf-syntax-ns#\",\n" +
					    "\"rdfa\": \"http://www.w3.org/ns/rdfa#\",\n" +
					    "\"rdfs\": \"http://www.w3.org/2000/01/rdf-schema#\",\n" +
					    "\"rev\": \"http://purl.org/stuff/rev#\",\n" +
					    "\"rif\": \"http://www.w3.org/2007/rif#\",\n" +
					    "\"rr\": \"http://www.w3.org/ns/r2rml#\",\n" +
					    "\"schema\": \"http://schema.org/\",\n" +
					    "\"sd\": \"http://www.w3.org/ns/sparql-service-description#\",\n" +
					    "\"sioc\": \"http://rdfs.org/sioc/ns#\",\n" +
					    "\"skos\": \"http://www.w3.org/2004/02/skos/core#\",\n" +
					    "\"skosxl\": \"http://www.w3.org/2008/05/skos-xl#\",\n" +
					    "\"v\": \"http://rdf.data-vocabulary.org/#\",\n" +
					    "\"vcard\": \"http://www.w3.org/2006/vcard/ns#\",\n" +
					    "\"void\": \"http://rdfs.org/ns/void#\",\n" +
					    "\"wdr\": \"http://www.w3.org/2007/05/powder#\",\n" +
					    "\"wdrs\": \"http://www.w3.org/2007/05/powder-s#\",\n" +
					    "\"wdsr\": \"http://www.w3.org/2007/05/powder-s#\",\n" +
					    "\"xhv\": \"http://www.w3.org/1999/xhtml/vocab#\",\n" +
					    "\"xsd\": \"http://www.w3.org/2001/XMLSchema#\"\n" +
					  "},\n" +
					  "\"@graph\": [\n" +
					    "{\n" +
					    "\"@id\": \"_:N66a5cc1576f04825a6edf50f27847fda\",\n" +
					    "\"@type\": \"schema:MedicalCondition\",\n" +
					    "\"schema:name\": \"" + extractedCondition1.get("Name") + "\"" + ",\n" +
					    "\"schema:alternateName\": \"" + extractedCondition2.get("Alternate Name") + "\"" + ",\n" +
					    "\"schema:description\": \"" + extractedCondition1.get("Description") + "\"" + ",\n" +
					    "\"schema:pathophysiology\": \"" + extractedCondition2.get("Pathophysiology") + "\"" + ",\n" +
					    "\"schema:possibleTreatment\": \"" + extractedCondition2.get("Treatment") + "\"" + ",\n" +
					    "\"schema:relevantSpecialty\": {" + "\n" +
					    	"\"@id\": \"_:N062f469df4fd4325a2a48e746634d3d7\"" + "\n" +
						"}" + "\n" + 
						"}," + "\n" +
						"{\n" +
						"\"@id\": \"\",\n" +
					    "\"rdfa:usesVocabulary\": {\n" +
						  "\"@id\": \"schema:\"\n" +
					      "}\n" +
					    "},\n" +
					    "{\n" +
					    "\"@id\": \"_:N062f469df4fd4325a2a48e746634d3d7\",\n" +
					    "\"@type\": \"schema:MedicalSpecialty\",\n" +
					    "\"schema:name\": \"" + extractedCondition1.get("Keywords") + " " + extractedCondition2.get("Keywords") + "\"" + "\n" +
					    "}\n" +
					    "]\n" +
					    "}";
	
		return htmlCode;
	}
}