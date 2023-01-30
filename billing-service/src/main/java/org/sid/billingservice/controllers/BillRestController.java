package org.sid.billingservice.controllers;

import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.entities.ConfigValues;
import org.sid.billingservice.entities.Customer;
import org.sid.billingservice.entities.Product;
import org.sid.billingservice.openFeign.CustomerRestClient;
import org.sid.billingservice.openFeign.ProductRestClient;
import org.sid.billingservice.repositories.BillingRepository;
import org.sid.billingservice.repositories.ProductItemRepository;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {

    private BillingRepository billingRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

    public BillRestController(ConfigValues configValues ,BillingRepository billingRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billingRepository = billingRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }

    @GetMapping(path = "/fullBill/{id}")
    public Bill getBillById(@PathVariable(name = "id") Long id){

        Bill bill = billingRepository.findById(id).get();
        Customer customer = customerRestClient.getCustomerById(bill.getCustomerId());

        bill.getProductItems().forEach(productItem -> {
            Product product = productRestClient.getProductById(productItem.getProductId());
            productItem.setProduct(product);
        });
        bill.setCustomer(customer);

        return bill;
    }

}
