package com.venkat.xml.common;

import com.venkat.xml.ParentCompany;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVFileWriter {

    private static final String COMMA_DELIMITER = "\t";
    private static final String NEW_LINE_SEPARATER = "\n";

    public static void writeCsvFile(String fileName, List<ParentCompany> parentCompanies){
        FileWriter fileWriter = null;
        boolean isHeader = true;

        try{
            fileWriter = new FileWriter(fileName);
            if(isHeader){
                fileWriter.append("ID");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("Status");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("Type");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("Desc");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("Industry");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("Created");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("Updated");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("Name");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("Company Name");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("Created");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("Updated");
                fileWriter.append(NEW_LINE_SEPARATER);
                isHeader = false;
            }

            for(ParentCompany pc : parentCompanies){
                fileWriter.append(pc.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(pc.getStatus());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(pc.getType());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(pc.getDesc());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(pc.getIndustry());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(pc.getCreated());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(pc.getUpdated());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(pc.getNatureOfWork());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(pc.getCompanyName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(pc.getCompanyStatus());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(pc.getCreated2());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(pc.getUpdated2());
                fileWriter.append(NEW_LINE_SEPARATER);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                fileWriter.flush();
                fileWriter.close();
            }catch (IOException io){
                io.printStackTrace();
            }
        }
    }
}
