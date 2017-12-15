package com.wattpad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Flagger {
	
	public static String OUTPUT_FILE_NAME = "output-"+System.currentTimeMillis()+".txt";
	
	public static void calculateOffensiveScore(String path) {
		OffensivePhrases.loadOffensivePhrases();
		File[] files = new File(path).listFiles();
		try {
			for (File file : files) {
			    if (file.isFile()) {
			    	calculateInputScore(file);
			    }
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error reading files ");
		}
	}

	private static void calculateInputScore(File file) throws IOException {
		String inputString = readFile(file);
		long score = OffensiveScoreCalcualtor.getScore(inputString);
		logScore(file.getName(), score);
	}

	private static void logScore(String name, long score) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME, true));
		writer.write(name+":"+score);
		writer.newLine();
		writer.close();
	}

	private static String readFile(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
	    StringBuilder sb = new StringBuilder();

	    while (line != null) {
	        sb.append(line);
	        line = br.readLine();
	    }
	    return sb.toString();
	}
	
	public static void main(String[] args) {
		calculateOffensiveScore("input/");
	}

}
