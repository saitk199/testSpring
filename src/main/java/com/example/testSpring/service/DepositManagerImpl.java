package com.example.testSpring.service;

import com.example.testSpring.model.Deposit;
import com.example.testSpring.repository.DepositRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositManagerImpl implements DepositManager {

    private final DepositRepository depositRepository;

    public DepositManagerImpl(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    @Override
    public List<Deposit> getAll() {
        return depositRepository.getAllDeposit();
    }
}
