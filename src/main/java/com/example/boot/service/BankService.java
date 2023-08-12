package com.example.boot.service;

import com.example.boot.mapper.BankDao;
import com.example.boot.pojo.Bank;

import java.util.List;

public interface BankService {

    public boolean addBank(Bank bank);

    public boolean updateBank(Bank bank);

    public Bank searchBank(String key);

    public Integer totalBank();

    public List<Bank> allBank();

}
