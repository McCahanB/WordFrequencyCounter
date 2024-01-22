package com.McCahanB.WordFrequencyCounter;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringHelper {
	
	private StringHelper() {
	super();
	}

	public static Map<String,Integer>countOccurence(String input){
	
		String[] words =input.split("\\s+");
			Map<String,Integer> wordFrequency = new HashMap<>();
			
			for(String word:words) {
				// remove every none-alphabetic characters
				word = word.replaceAll("[^\\p{L}]","").toLowerCase();
				if(!word.isEmpty()) {
					if(wordFrequency.containsKey(word)) {
						wordFrequency.put(word, wordFrequency.get(word)+1);
					}else {
						wordFrequency.put(word, 1);
					}
				}
				
			}

		return wordFrequency;
	}
	
	
	public static List<Map.Entry<String,Integer>> getTopMostFrequent(Map<String,Integer> wordFrequency, int n){
		//Sort the list in decreasing order limited to n
		return wordFrequency.entrySet()
                .stream()                                                               
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))         
                .limit(n)
                .collect(Collectors.toList());
	}
}
