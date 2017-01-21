package com.buya2z.beans.depricated.user;

import com.buya2z.beans.depricated.category.QueryTransferObject;
import org.apache.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Jinu on 12/25/2016.
 */
public class Seller extends AbstractUser {

    private final Logger LOGGER = Logger.getLogger(Seller.class);

    private int sellerId;

    private String tinNumber;

    private String panNumber;

    private String company;

    private String companyLocation;

    private String businessEmail;

    private String businessPhoneNumber;

    private String faxNumber;

    private String sellerDescription;

    private SellerBankDetail bankDetails;

    public Seller() {
        this.setRole(UserRole.SELLER);
    }

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



    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
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

    @Override
    public boolean validate() {
        boolean isValid = true;
        if(!super.validate()) {
            isValid = false;
        }
        if( !isStringPropertyAssigned(this.tinNumber) ) {
            LOGGER.info("Validation Failed at Seller: Tin number is not set");
            isValid = false;
        }
        if( !isStringPropertyAssigned(this.company) ) {
            LOGGER.info("Validation Failed at Seller: Company is not set");
            isValid = false;
        }
        if( !isStringPropertyAssigned(this.sellerDescription) ) {
            LOGGER.info("Validation Failed at Seller: Seller Descripton is not set");
            isValid = false;
        }
        if( !isStringPropertyAssigned(this.companyLocation) ) {
            LOGGER.info("Validation Failed at Seller: Company Location is not set");
            isValid = false;
        }
        return isValid;
    }

    public Map<String, Object> getSellerCreateValues() {
        Map<String, Object> columnWithValues = new LinkedHashMap<>();
        columnWithValues.put("tin_number", getTinNumber());
        columnWithValues.put("company", getCompany());
        columnWithValues.put("company_location", getCompanyLocation());
        columnWithValues.put("user_id", getId());
        putCreationTimestamp(columnWithValues);
        return columnWithValues;
    }

    public class SellerBankDetail {
        private String bankName;
        private String accountNumber;
        private String ifscCode;
        private String branch;

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getIfscCode() {
            return ifscCode;
        }

        public void setIfscCode(String ifscCode) {
            this.ifscCode = ifscCode;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }
    }

    @Override
    public String toString() {
        return super.toString()+"\n" + "Seller{" +
                "sellerId=" + sellerId +
                ", tinNumber='" + tinNumber + '\'' +
                ", panNumber='" + panNumber + '\'' +
                ", company='" + company + '\'' +
                ", companyLocation='" + companyLocation + '\'' +
                ", businessEmail='" + businessEmail + '\'' +
                ", businessPhoneNumber='" + businessPhoneNumber + '\'' +
                ", faxNumber='" + faxNumber + '\'' +
                ", sellerDescription='" + sellerDescription + '\'' +
                ", bankDetails=" + bankDetails +
                '}';
    }
}
