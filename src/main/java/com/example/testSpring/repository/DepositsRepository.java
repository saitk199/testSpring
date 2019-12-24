package com.example.testSpring.repository;

import com.example.testSpring.model.Deposit;

import java.util.List;

public interface DepositsRepository {
    List<Deposit> getAllDeposit();
}
