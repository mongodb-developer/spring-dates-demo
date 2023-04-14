package com.mongodb.devrel.gcr.designreviews;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String>{

    @Query(value="{$expr:{$eq:[{$month:\"$customerDOB\"}, ?0]}}", sort = "{_id: 1}")
    Optional<Customer> findCustomerByBirthMonth(Integer birthMonth);

    @Query(value="{customerDOB:?0}", sort = "{_id: 1}")
    Optional<Customer> findCustomerByDOB(Date dob);


}
