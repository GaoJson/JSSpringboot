package com.example.boot.mapper;

import com.example.boot.pojo.Bank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BankDao {

    public boolean addBank(@Param("bank") Bank bank);

    public Bank searchBank(@Param("key") String key);

    public boolean updateBank(@Param("bank") Bank bank);

    public Integer totalBank();

    public List<Bank> allBank();

}
