package com.lloydshove.cram;


import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.util.ArrayList;

public class CEDictLoader {

    public static final String DEFAULT_CEDICT_FILE_NAME = "cedict_ts.ub";
    private ArrayList<DictionaryEntry> records = new ArrayList<DictionaryEntry>();

    public CEDictLoader(String dictionaryName) {
        try {
            FileReader fileReader = new FileReader(dictionaryName);
            BufferedReader reader = new BufferedReader(fileReader);
            while( reader.ready() ){

                String line = reader.readLine();
                if(! line.startsWith("#") ){
                    records.add(DictionaryEntry.parse(line));
                }
            }
        } catch (Exception e) {
            throw new CramException("Failure to load dictionary file :" + dictionaryName, e );
        }
    }

    public CEDictLoader() {
        this(DEFAULT_CEDICT_FILE_NAME);
    }

    public int getRecordCount() {
        return records.size();
    }

    public DictionaryEntry getRecord(int index) {
        return records.get(index);
    }
}
