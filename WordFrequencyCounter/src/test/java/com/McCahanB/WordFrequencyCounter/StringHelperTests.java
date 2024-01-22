package com.McCahanB.WordFrequencyCounter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StringHelperTests {


	@Test
	void countOccurenceTest() {
String inputText = "banan gurka ödla tomat citron äpple gurka tomat katt hund katt snigel skata älg clementin älg gurka ninja ninja";
        
        Map<String,Integer> result = StringHelper.countOccurence(inputText);

        assertEquals(13,result.size());
        
        assertEquals(1, result.get("banan"));
        assertEquals(1, result.get("ödla"));
        assertEquals(1, result.get("äpple"));
        assertEquals(1,result.get("citron"));
        assertEquals(2,result.get("tomat"));
        assertEquals(3,result.get("gurka"));
        assertEquals(2,result.get("katt"));
        assertEquals(2,result.get("ninja"));
        assertEquals(2,result.get("älg"));
        assertEquals(1,result.get("hund"));
        assertEquals(1,result.get("snigel"));
        assertEquals(1,result.get("skata"));
        assertEquals(1,result.get("clementin"));
    }
	
	@Test
    void top10Test() {
        
        Map<String,Integer> input = new HashMap<String,Integer>();
        input.put("banan", 1);
        input.put("päron", 3);
        input.put("katt", 3);
        input.put("hund", 4);
        input.put("citron", 4);
        input.put("snigel", 5);
        input.put("äpple", 2);
        input.put("clementin", 6);
        input.put("ninja", 12);
        input.put("älg", 5);
        input.put("gurka", 4);
        
        List<Map.Entry<String,Integer>> resultList = StringHelper.getTopMostFrequent(input, 10);

        // create hash map for easier assertion
        Map<String, Integer> result = new LinkedHashMap<>();                            
            for(Map.Entry<String, Integer> entry : resultList) {
                result.put(entry.getKey(), entry.getValue());
            }

        assertEquals(10, result.size());
        
        // expect all but "banan", 1
        assertEquals(12, result.get("ninja"));
        assertEquals(2, result.get("äpple"));
        assertEquals(4,result.get("citron"));
        assertEquals(4,result.get("gurka"));
        assertEquals(3,result.get("katt"));
        assertEquals(5,result.get("älg"));
        assertEquals(4,result.get("hund"));
        assertEquals(5,result.get("snigel"));
        assertEquals(6,result.get("clementin"));
        assertEquals(3,result.get("päron"));
    }

    @Test
    void top2Test() {
        
        Map<String,Integer> input = new HashMap<String,Integer>();
        input.put("banan", 1);
        input.put("päron", 3);
        input.put("katt", 3);
        input.put("hund", 4);
        input.put("citron", 4);
        input.put("snigel", 5);
        input.put("äpple", 2);
        input.put("clementin", 6);
        input.put("ninja", 12);
        input.put("älg", 5);
        input.put("gurka", 4);
        
        List<Map.Entry<String,Integer>> result = StringHelper.getTopMostFrequent(input, 2);

        assertEquals(2,result.size());
    }

}
