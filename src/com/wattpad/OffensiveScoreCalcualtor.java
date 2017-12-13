package com.wattpad;

import java.util.Arrays;

public class OffensiveScoreCalcualtor {
	
	//(number of low risk phrases) + (number of high risk phrases * 2)
	public static long getScore(String inputString) {
		inputString = inputString.toLowerCase();
		return getLowRiskScore(inputString) + getHighRiskScore(inputString)*2;
	}

	private static long getLowRiskScore(String inputString) {
		String[] lowRiskPhrases = OffensivePhrases.LOW_RISK_PHRASES.toArray(new String[OffensivePhrases.LOW_RISK_PHRASES.size()]);
		return Arrays.stream(lowRiskPhrases).parallel().filter(inputString::contains).count();
	}

	private static long getHighRiskScore(String inputString) {
		String[] lowRiskPhrases = OffensivePhrases.HIGH_RISK_PHRASES.toArray(new String[OffensivePhrases.HIGH_RISK_PHRASES.size()]);
		return Arrays.stream(lowRiskPhrases).parallel().filter(inputString::contains).count();
	}

	public static void main(String[] args) {
		OffensivePhrases.loadOffensivePhrases();
		long score = getScore("Let me sit by you and whisper sweet-nothings in your mundane ear, you Gangster. eSolutions!");
		System.out.println(score);
	}

}
