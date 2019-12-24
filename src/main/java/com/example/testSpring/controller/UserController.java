package com.example.testSpring.controller;

import com.example.testSpring.model.Deposit;
import com.example.testSpring.service.DepositManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final DepositManager depositManager;

    @GetMapping("/deposits")
    public List<Deposit> getDeposits() {
        return depositManager.getAll();
    }
}
