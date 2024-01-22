package com.McCahanB.WordFrequencyCounter;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class WordControllerTest {

    @Autowired
    private WordController wordController;
    
    
    @Test
    void countFrequencyTest() {
        
        String inputText = "banan gurka ödla ödla gurka ödla banan";
        
        Map<String,Integer> result = wordController.countFrequency(inputText).getBody();

        assertEquals(3,result.size());
        
        assertEquals(3, result.get("ödla"));
        assertEquals(2,result.get("gurka"));
        assertEquals(2,result.get("banan"));
    }

}
