package com.quannar.film.common;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class ConvertVI {

    public static String createSlug(String s) {

        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").toLowerCase().replace(" ", "_");
    }
}
