package com.java_8_training.problems.collectors;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static junit.framework.Assert.assertEquals;
import java.lang.String;
import java.util.stream.Stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

@Ignore
public class OccurrencesTest {

    @Test
    public void occurrencesForAWord() {
        String word = "cool";
        Stream<String> words = Stream.of("c","o","o","l");
        //TODO #C9

        Map<String, Long> occ = new HashMap<>();
        //occ = words.stream().map(w -> w.split("")).flatMap(Arrays::stream).collect(groupingBy(identity(), counting()));



        assertEquals(2, (long) occ.get("o"));
        assertEquals(1, (long) occ.get("c"));
        assertEquals(1, (long) occ.get("l"));
        assertEquals(3, occ.size());

    }

    @Test
    public void occurrencesForAListOfSentences() {
        List<String> sentences = Arrays.asList("Hello everyone!", "Java 8 is here!");

        //TODO #C9
        Map<String, Long> occ = new HashMap<>();


        assertEquals(2, (long) occ.get("l"));
        assertEquals(4, (long) occ.get(" "));
        assertEquals(2, (long) occ.get("!"));
        assertEquals(2, (long) occ.get("a"));
        assertEquals(6, (long) occ.get("e"));
        assertEquals(16, occ.size());
    }

}
