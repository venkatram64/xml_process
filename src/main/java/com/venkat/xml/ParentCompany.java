package com.venkat.xml;

public class ParentCompany {

    private String id;
    private String status;
    private String type;
    private String desc;
    private String industry;
    private String created;
    private String updated;

    private String natureOfWork;
    private String companyName;
    private String companyStatus;
    private String created2;
    private String updated2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getNatureOfWork() {
        return natureOfWork;
    }

    public void setNatureOfWork(String natureOfWork) {
        this.natureOfWork = natureOfWork;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(String companyStatus) {
        this.companyStatus = companyStatus;
    }

    public String getCreated2() {
        return created2;
    }

    public void setCreated2(String created2) {
        this.created2 = created2;
    }

    public String getUpdated2() {
        return updated2;
    }

    public void setUpdated2(String updated2) {
        this.updated2 = updated2;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public static ParentCompany deepCopy(ParentCompany pc){
        ParentCompany parentCompany = new ParentCompany();

        parentCompany.setId(pc.getId());
        parentCompany.setStatus(pc.getStatus());
        parentCompany.setType(pc.getType());
        parentCompany.setDesc(pc.getDesc());
        parentCompany.setIndustry(pc.getIndustry());
        parentCompany.setCreated(pc.getCreated());
        parentCompany.setUpdated(pc.getUpdated());
        parentCompany.setNatureOfWork(pc.getNatureOfWork());
        parentCompany.setCompanyName(pc.getCompanyName());
        parentCompany.setCompanyStatus(pc.getCompanyStatus());
        parentCompany.setCreated2(pc.getCreated2());
        parentCompany.setUpdated2(pc.getUpdated2());

        return parentCompany;
    }
}
