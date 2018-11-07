package com.learning.order.controller;

import com.learning.product.client.ProductClient;
import com.learning.product.common.DecreaseStockInput;
import com.learning.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

    /*@Autowired
    private LoadBalancerClient loadBalancerClient;*/

    /*@Autowired
    private RestTemplate restTemplate;*/

    /*@GetMapping("/getProductMsg")
    public String getProductMsg() {
        //1. 第一种方式(直接使用restTemplate, url写死)
        *//*RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);*//*

        //2. 第二种方式(利用loadBalancerClient通过应用名获取url, 然后在使用restTemplate)
        *//*ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) +"/msg";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);*//*

        //3. 第三种方式(利用@LoadBalanced, 可在restTemplate里使用应用名字)
        *//*String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);*//*

        log.info("response={}", response);
        return response;
    }*/

    @Autowired
    private ProductClient productClient;

    /*@GetMapping("/getProductMsg")
    public String getProductMsg() {
        String response = productClient.productMsg();
        log.info("response={}", response);
        return response;
    }*/

    @GetMapping("/getProductList")
    public String getProductList() {
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(Arrays.asList("157875196366160022", "157875227953464068"));
        log.info("response={}", productInfoList);
        return "ok";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock() {
        DecreaseStockInput decreaseStockInput = new DecreaseStockInput("157875196366160022", 2);
        productClient.decreaseStock(Arrays.asList(decreaseStockInput));
        return "ok";
    }

}
