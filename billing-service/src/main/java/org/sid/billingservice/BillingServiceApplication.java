package org.sid.billingservice;

import org.sid.billingservice.entities.*;
import org.sid.billingservice.openFeign.CustomerRestClient;
import org.sid.billingservice.openFeign.ProductRestClient;
import org.sid.billingservice.repositories.BillingRepository;
import org.sid.billingservice.repositories.ProductItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillingRepository billingRepository,
                            ProductItemRepository productItemRepository,
                            CustomerRestClient customerRestClient,
                            ProductRestClient productRestClient,
                            ConfigValues configValues){

        return args -> {
            //String token = configValues.getToken();

            /*Customer customer = customerRestClient.getCustomerById(1L);

            Bill bill = billingRepository.save(new Bill(null, new Date(),null, customer.getId(), null));

            PagedModel<Product> products = productRestClient.pageOfProducts(0,5);

            products.forEach(product -> {
                ProductItem productItem = new ProductItem();
                productItem.setPrice(product.getPrice()+(Math.random()*10));
                productItem.setQuantity(2);
                productItem.setProductId(product.getId());
                productItem.setBill(bill);
                productItemRepository.save(productItem);
            });*/
        };
    }
}
