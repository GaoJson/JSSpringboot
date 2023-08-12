package com.example.boot.service.impl;

import com.example.boot.mapper.BankDao;
import com.example.boot.mapper.ProductDao;
import com.example.boot.pojo.Bank;
import com.example.boot.service.BankService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bankService")
public class BankServiceImpl implements BankService {

    private BankDao bankDao;
    @Resource(name = "bankDao")
    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }


    @Override
    public boolean addBank(Bank bank) {
        return bankDao.addBank(bank);
    }

    @Override
    public boolean updateBank(Bank bank) {
        return bankDao.updateBank(bank);
    }

    @Override
    public Bank searchBank(String key) {
        return bankDao.searchBank(key);
    }

    @Override
    public Integer totalBank() {
        return bankDao.totalBank();
    }

    @Override
    public List<Bank> allBank() {
        return bankDao.allBank();
    }
}
