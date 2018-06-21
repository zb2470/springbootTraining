package com.agentpay.controller;

import com.agentpay.service.BankService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    private BankService bankService;

    public String hello(){
        return "hello agentpay";
    }

    @GetMapping(value = "/hehe")
    public String haha() throws JsonProcessingException {
        return bankService.sendOrderToBank(1);
    }
}
