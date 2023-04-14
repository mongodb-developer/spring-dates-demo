package com.mongodb.devrel.gcr.designreviews;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String>{

    @Query(value="{$expr:{$eq:[{$month:\"$customerDOB\"}, ?0]}}", sort = "{_id: 1}")
    List<Customer> findCustomerByBirthMonth(Integer birthMonth);

    @Query(value="{$expr:{$gt:[{$year:\"$customerDOB\"}, ?0]}}", sort = "{_id: 1}")
    List<Customer> findCustomerYoungerThanBirthYear(Integer birthYear);

    @Query(value="{customerDOB:?0}", sort = "{_id: 1}")
    List<Customer> findCustomerByDOB(Date dob);


}
