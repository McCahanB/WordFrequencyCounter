package com.McCahanB.WordFrequencyCounter;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WordController {
	
	@PostMapping("/count")
	public ResponseEntity<Map<String,Integer>> countFrequency(@RequestBody String input){
		
		try {
												
			Map<String,Integer> wordFrequency = StringHelper.countOccurence(input);
			
			List<Map.Entry<String,Integer>> result=StringHelper.getTopMostFrequent(wordFrequency, 10);
			
			Map<String,Integer>resultMap=new LinkedHashMap<>();
			for(Map.Entry<String, Integer> entry :result) {
				resultMap.put(entry.getKey(),entry.getValue());
				
			}
			
			return ResponseEntity.ok(resultMap);
			
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(Collections.emptyMap());
		}
	}
			

}
