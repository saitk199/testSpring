package com.example.testSpring.service;

import com.example.testSpring.model.Deposit;
import com.example.testSpring.repository.DepositsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepositManagerImpl implements DepositManager {
    private final DepositsRepository depositsRepository;

    @Override
    public List<Deposit> getAll() {
        return depositsRepository.getAllDeposit();
    }
}
