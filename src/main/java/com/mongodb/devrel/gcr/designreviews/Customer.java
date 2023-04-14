package com.mongodb.devrel.gcr.designreviews;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "customers")
public class Customer {

    @Id
    public String id;
    public String customerName;
    public Date customerDOB;

    public Customer(String id, String customerName, Date customerDOB) {
        this.id = id;
        this.customerName = customerName;
        this.customerDOB = customerDOB;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, name='%s', dob='%s']",
                id, customerName, customerDOB.toString());
    }

}
