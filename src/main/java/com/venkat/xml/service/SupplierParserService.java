package com.venkat.xml.service;

import com.venkat.xml.Company;
import com.venkat.xml.ParentCompany;
import com.venkat.xml.Supplier;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SupplierParserService {

    public List<Supplier> parseXML(String fileName){
        Supplier supplier = null;
        List<Supplier> suppliers = null;
        Company company = null;
        List<Company> companies = null;
        boolean isSupplier = false;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        String tagContent = null;

        try{
            XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(new FileReader(fileName));
            while(reader.hasNext()){
                int event = reader.next();
                switch (event){
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("Start Document...");
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        tagContent = reader.getText().trim();
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        String qName = reader.getLocalName();
                        if(qName.equalsIgnoreCase("parent_company")){
                            suppliers = new ArrayList<>();
                        }else if(qName.equalsIgnoreCase("suppliers")){
                            supplier = new Supplier();
                            isSupplier = true;
                        }else if(qName.equalsIgnoreCase("child_companies")){
                            companies = new ArrayList<>();
                        }else if(qName.equalsIgnoreCase("company")){
                            company = new Company();
                            isSupplier = false;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if(!isSupplier){
                            if(reader.getLocalName().equals("created")){
                                company.setCreated(tagContent);
                            }else if(reader.getLocalName().equals("updated")){
                                company.setUpdated(tagContent);
                            }
                        }
                        switch (reader.getLocalName()){
                            case "id":
                                supplier.setId(tagContent);
                                break;
                            case "status":
                                supplier.setStatus(tagContent);
                                break;
                            case "type":
                                supplier.setType(tagContent);
                                break;
                            case "desc":
                                supplier.setDesc(tagContent);
                                break;
                            case "industry":
                                supplier.setIndustry(tagContent);
                                break;
                            case "created":
                                supplier.setCreated(tagContent);
                                break;
                            case "updated":
                                supplier.setUpdated(tagContent);
                                break;
                            case "suppliers":
                                suppliers.add(supplier);
                                break;
                            case "child_companies":
                                supplier.setCompanies(companies);
                                break;
                            case "company":
                                companies.add(company);
                                break;
                            case "nature_of_work":
                                company.setNatureOfWork(tagContent);
                                break;
                            case "company_name":
                                company.setCompanyName(tagContent);
                                break;
                            case "company_status":
                                company.setCompanyStatus(tagContent);
                                break;

                        }
                        break;
                    case XMLStreamConstants.END_DOCUMENT:
                        System.out.println("End Document...");
                        break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return suppliers;
    }

    public static List<ParentCompany> populateVO(List<Supplier> suppliers){
        List<ParentCompany> parentCompanies = new ArrayList<>();
        ParentCompany pc = null;
        for(Supplier s: suppliers){
            pc = new ParentCompany();
            pc.setId(s.getId());
            pc.setStatus(s.getStatus());
            pc.setType(s.getType());
            pc.setDesc(s.getDesc());
            pc.setIndustry(s.getIndustry());
            pc.setCreated(s.getCreated());
            pc.setUpdated(s.getUpdated());

            if(s.getCompanies() != null && s.getCompanies().size() > 0){
                for(Company c: s.getCompanies()){
                    ParentCompany parentCompany = ParentCompany.deepCopy(pc);
                    parentCompany.setNatureOfWork(c.getNatureOfWork());
                    parentCompany.setCompanyName(c.getCompanyName());
                    parentCompany.setCompanyStatus(c.getCompanyStatus());
                    parentCompany.setCreated2(c.getCreated());
                    parentCompany.setUpdated2(c.getUpdated());
                    parentCompanies.add(parentCompany);
                }
            }else{
                parentCompanies.add(pc);
            }
        }

        return parentCompanies;
    }
}
