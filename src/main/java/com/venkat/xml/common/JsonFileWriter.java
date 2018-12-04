package com.venkat.xml.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.venkat.xml.Supplier;

import java.io.File;
import java.util.List;

public class JsonFileWriter {

    public static void writeJsonFile(String fileName, List<Supplier> suppliers){
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.writeValue(new File(fileName),suppliers);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
