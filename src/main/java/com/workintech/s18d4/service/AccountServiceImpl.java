package com.workintech.s18d4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.repository.AccountRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @SuppressWarnings("null")
    @Override
    public Account findById(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);

        return accountOptional.orElseThrow(() -> new RuntimeException("Account could not find"));
    }

    @SuppressWarnings("null")
    @Override
    public Account delete(Long id) {
        Account existingAccount = findById(id);
        accountRepository.delete(existingAccount);
        return existingAccount;
    }

}
