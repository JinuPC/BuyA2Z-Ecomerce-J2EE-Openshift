package com.buya2z.beans.user;

import com.buya2z.beans.QueryTransferObject;

/**
 * Created by Jinu on 12/25/2016.
 */
public class Seller extends AbstractUser {
    private String tinNumber;
    private String panNumber;
    private String company;
    private String companyLocation;
    private String businessEmail;
    private String businessPhoneNumber;
    private String faxNumber;
    private String bankName;
    private String sellerDescription;
    private SellerBankDetail bankDetails;

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public String getBusinessPhoneNumber() {
        return businessPhoneNumber;
    }

    public void setBusinessPhoneNumber(String businessPhoneNumber) {
        this.businessPhoneNumber = businessPhoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSellerDescription() {
        return sellerDescription;
    }

    public void setSellerDescription(String sellerDescription) {
        this.sellerDescription = sellerDescription;
    }

    public SellerBankDetail getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(SellerBankDetail bankDetails) {
        this.bankDetails = bankDetails;
    }

    @Override
    public QueryTransferObject getCreateQuery() {
        return null;
    }

    private class SellerBankDetail {
        private String bankName;
        private String accountNumber;
        private String ifscCode;
        private String branch;
    }
}
