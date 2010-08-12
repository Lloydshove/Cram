package com.lloydshove.cram;

import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DictionaryEntry{
    private String traditional;
    private String simplified;
    private String english;
    private String pinyin;

    public static DictionaryEntry parse(String entry) {
        StringTokenizer tokenizer = new StringTokenizer(entry);

        return new DictionaryEntry(tokenizer.nextToken(),
                                   tokenizer.nextToken(),
                                   extractPinyin(entry),
                                   extractEnglish(entry)
                                  );
    }

    private static String extractEnglish(String entry) {
        Pattern pattern = Pattern.compile("\\/.*\\/");
        Matcher matcher = pattern.matcher(entry);
        matcher.find();
        String english = matcher.group();
        english = english.substring(1, english.length() -1);
        english = english.replaceAll("\\/", ", ");
        return english;
    }

    private static String extractPinyin(String entry) {
        Pattern pattern = Pattern.compile("\\[.*?\\]");
        Matcher matcher = pattern.matcher(entry);
        matcher.find();
        String pinyin = matcher.group();
        pinyin = pinyin.substring(1, pinyin.length() -1);
        return pinyin;
    }

    private DictionaryEntry(String traditional, String simplified, String pinyin, String english) {
        this.traditional = traditional;
        this.simplified = simplified;
        this.pinyin = pinyin;
        this.english = english;
    }

    public String getTraditional() {
        return traditional;
    }

    public String getSimplified() {
        return simplified;
    }

    public String getPinyin() {
        return pinyin;
    }

    public String getEnglish() {
        return english;
    }
}