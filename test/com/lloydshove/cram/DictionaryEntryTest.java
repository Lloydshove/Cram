package com.lloydshove.cram;

import junit.framework.TestCase;
import org.junit.Test;
import com.lloydshove.cram.DictionaryEntry;

public class DictionaryEntryTest extends TestCase {

    @Test
    public void testCanParseADictionaryLine() {
        DictionaryEntry entry = DictionaryEntry.parse("中國 中国 [Zhong1 guo2] /China/Middle Kingdom/");


        assertEquals("Traditional value not as expected", "中國", entry.getTraditional());
        assertEquals("Simplified value not as expected", "中国", entry.getSimplified());
        assertEquals("Pinyin value not as expected", "Zhong1 guo2", entry.getPinyin());
        assertEquals("English value not as expected", "China, Middle Kingdom", entry.getEnglish());
    }
}
 