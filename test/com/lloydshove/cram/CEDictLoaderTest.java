package com.lloydshove.cram;

import junit.framework.TestCase;
import org.junit.Test;
import com.lloydshove.cram.DictionaryEntry;

public class CEDictLoaderTest extends TestCase {

    @Test  //TODO use EXPECTED!!!
    public void testCEDictLoaderFailsFastWhenNoDictionaryFound() {

        try {
            CEDictLoader loader = new CEDictLoader("FileDefiniteDoesn'tExist");
        } catch (Exception e) {
            return;
        }
        fail("Should not have reached here");
    }

    @Test
    public void testCanLoadTestFileAndHasApptopriateNumberOfRecords() {
        CEDictLoader loader = new CEDictLoader("test_cedict_file");

        assertEquals("Unexpected number of records loaded from test ccedit file", 1, loader.getRecordCount());
        assertTrue("Unexpected record type", loader.getRecord(0) instanceof DictionaryEntry);
    }

    @Test
    public void testFirstEntryIsAsExpected() {
        CEDictLoader loader = new CEDictLoader("test_cedict_file");
        DictionaryEntry entry = loader.getRecord(0);

        assertEquals("Traditional value not as expected", entry.getTraditional(), "⿔");
        assertEquals("Simplified value not as expected", entry.getSimplified(), "⿔");
        assertEquals("Pinyin value not as expected", "gui1", entry.getPinyin() );
        assertEquals("English value not as expected", "variant of 龜|龟[gui1]", entry.getEnglish());
    }
}
