package com.yourgoods.retailerservicejava.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Document("retailer")
public class Retailer {

    @Id
    private String id;
    private String retailerId;
    @NotBlank
    private String retailerName;
    @Email
    private String retailerEmail;
    @NotBlank
    private String retailerPassword;
    @NotBlank
    private String retailerPhone;
    @NotBlank
    private String retailerAddress;
    @NotBlank
    private String retailerPincode;
    public void setRetailerPassword(String retailerPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.retailerPassword = encoder.encode(retailerPassword);
    }
}
