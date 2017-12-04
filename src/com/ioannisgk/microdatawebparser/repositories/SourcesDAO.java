package com.ioannisgk.microdatawebparser.repositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class SourcesDAO {
	
	private HashMap<String, String[]> medicalConditions = new HashMap<String, String[]>();
	
	String data01 = "https://blausen.com/en/video/pulmonary-embolism/";
	String data02 = "https://coreem.net/core/hd-unstable-pe/";
	String data03 = "https://blausen.com/en/video/asthma/";
	String data04 = "https://coreem.net/core/life-threatening-asthma/";
	String data05 = "https://blausen.com/en/video/myocardial-infarction/";
	String data06 = "https://coreem.net/core/stemi-lbbb/";
	String data07 = "https://blausen.com/en/video/abdominal-aneurysm/";
	String data08 = "https://coreem.net/core/abdominal-aortic-aneurysm/";
	String data09 = "https://blausen.com/en/video/atrial-fibrillation/";
	String data10 = "https://coreem.net/core/recent-onset-atrial-fibrillation/";
	String data11 = "https://blausen.com/en/video/shingles/";
	String data12 = "https://coreem.net/core/herpes-zoster/";
	String data13 = "https://blausen.com/en/video/otitis-media/";
	String data14 = "https://coreem.net/core/acute-otitis-media/";	
	String data15 = "https://blausen.com/en/video/ectopic-pregnancy/";
	String data16 = "https://coreem.net/core/ectopic-pregnancy/";
	
	public SourcesDAO() {
		this.medicalConditions.put("Abdominal Aneurysm", new String[]{data07, data08});
		this.medicalConditions.put("Asthma", new String[]{data03, data04});
		this.medicalConditions.put("Atrial Fibrillation", new String[]{data09, data10});
		this.medicalConditions.put("Ectopic Pregnancy", new String[]{data15, data16});
		this.medicalConditions.put("Herpes Zoster", new String[]{data11, data12});
		this.medicalConditions.put("Myocardial Infarction", new String[]{data05, data06});
		this.medicalConditions.put("Otitis Media", new String[]{data13, data14});
		this.medicalConditions.put("Pulmonary Embolism", new String[]{data01, data02});
	}
		
	public HashMap allSources() {
		return medicalConditions;
	}
}