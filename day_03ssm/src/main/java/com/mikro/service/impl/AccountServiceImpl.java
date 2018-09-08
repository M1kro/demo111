package com.mikro.service.impl;

import com.mikro.dao.AccountDao;
import com.mikro.domain.Account;
import com.mikro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
         System.out.println("业务层:查询所有账户信息");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层:保存账户");
        accountDao.saveAccount(account);
    }
}
