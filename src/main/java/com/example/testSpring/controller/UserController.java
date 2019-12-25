package com.example.testSpring.controller;

import com.example.testSpring.model.Deposit;
import com.example.testSpring.service.DepositManager;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final DepositManager depositManager;

    public UserController(DepositManager depositManager) {
        this.depositManager = depositManager;
    }

    @RequestMapping(value = "/deposits", method = RequestMethod.GET)
    public List<Deposit> getDeposits() {
        return depositManager.getAll();
    }
}
