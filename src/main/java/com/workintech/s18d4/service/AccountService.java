package com.workintech.s18d4.service;

import java.util.List;

import com.workintech.s18d4.entity.Account;

public interface AccountService {
    List<Account> findAll();

    Account save(Account account);

    Account findById(Long id);

    Account delete(Long id);

}
