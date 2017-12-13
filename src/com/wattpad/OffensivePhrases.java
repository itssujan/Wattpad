package com.wattpad;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class OffensivePhrases {
	
	public static final Set<String> LOW_RISK_PHRASES = new HashSet<>();
	public static final Set<String> HIGH_RISK_PHRASES = new HashSet<>();
	
	public static void loadOffensivePhrases() {
		loadLowRiskPhrases();
		loadHighRiskPhrases();
	}

	private static void loadHighRiskPhrases() {
		try {
			loadPhrases("/high_risk_phrases.txt", HIGH_RISK_PHRASES);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void loadPhrases(String fileName, Set<String> phraseSet) throws IOException {
	    InputStream res = OffensivePhrases.class.getResourceAsStream(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(res));
		String line = br.readLine();
	    StringBuilder sb = new StringBuilder();

	    while (line != null) {
	    	phraseSet.add(line.toLowerCase());
	        line = br.readLine();
	    }

	}

	private static void loadLowRiskPhrases() {
		try {
			loadPhrases("/low_risk_phrases.txt", LOW_RISK_PHRASES);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		loadOffensivePhrases();
		System.out.println(HIGH_RISK_PHRASES);
		System.out.println(LOW_RISK_PHRASES);
	}

}
