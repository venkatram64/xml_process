package com.venkat.xml;

import com.venkat.xml.common.CSVFileWriter;
import com.venkat.xml.common.JsonFileWriter;
import com.venkat.xml.service.SupplierParserService;

import java.util.List;

public class SupplierParserServiceTest {

    public static void main(String[] args) {
        /*if(args.length < 3){
            System.out.println("Give <input: xml file> and <output: csv file> ");
            return;
        }*/

        String inputFile = "test.xml";//args[1];
        System.out.println("XML file :" + inputFile);

        String outFile = "out.csv";//args[2];
        System.out.println("CSV file :" + outFile);

        exportToCSV(inputFile, outFile);
        exportToJson(inputFile, "out.json");
    }

    public static void exportToJson(String inputFile, String outFile){
        SupplierParserService supplierParserService = new SupplierParserService();
        long startTime = System.currentTimeMillis();
        List<Supplier> suppliers =  supplierParserService.parseXML(inputFile);
        JsonFileWriter.writeJsonFile(outFile, suppliers);
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("Time taken to run the program in milli seconds " + timeTaken);
    }

    public static void exportToCSV(String inputFile, String outFile){
        SupplierParserService supplierParserService = new SupplierParserService();
        long startTime = System.currentTimeMillis();
        List<Supplier> suppliers =  supplierParserService.parseXML(inputFile);
        List<ParentCompany> parentCompanies = SupplierParserService.populateVO(suppliers);
        CSVFileWriter.writeCsvFile(outFile, parentCompanies);
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("Time taken to run the program in milli seconds " + timeTaken);
    }
}
