package org.sid.billingservice.openFeign;

import org.sid.billingservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    //@RequestHeader("Authorization") String token
    @GetMapping(path ="/customers/{id}")
    Customer getCustomerById(@PathVariable(name = "id") Long id);
}
