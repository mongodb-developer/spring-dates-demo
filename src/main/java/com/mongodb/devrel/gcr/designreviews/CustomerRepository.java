package com.mongodb.devrel.gcr.designreviews;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String>{

    @Query(value="{$expr:{$eq:[{$year:\"$customerDOB\"}, ?0]}}", sort = "{_id: 1}")
    List<Customer> findCustomerByBirthYear(Integer birthYear);

    @Query(value="{$expr:{$eq:[{$year:{ date:\"$customerDOB\", timezone:?1}}, ?0]}}", sort = "{_id: 1}")
    List<Customer> findCustomerByBirthYearTZ(Integer birthYear, String timeZone);

    @Query(value="{customerDOB:?0}", sort = "{_id: 1}")
    List<Customer> findCustomerByBirthDate(Date dob);


}
