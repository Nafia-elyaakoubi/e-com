package org.sid.billingservice.openFeign;

import org.sid.billingservice.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {

    @GetMapping("/products")
    PagedModel<Product> pageOfProducts(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size);

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable(name = "id") Long id);

}
