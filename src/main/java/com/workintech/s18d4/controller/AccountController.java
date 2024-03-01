package com.workintech.s18d4.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.AccountService;
import com.workintech.s18d4.service.CustomerService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    private final CustomerService customerService;

    private final AccountService accountService;

    @GetMapping
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @PostMapping(path = "/{customerId}")
    public AccountResponse save(@RequestBody Account account, @PathVariable("customerId") Long customerId) {

        Customer customer = customerService.findById(customerId);
        customer.getAccounts().add(account);
        account.setCustomer(customer);
        Account savedAccount = accountService.save(account);

        return new AccountResponse(savedAccount.getId(), savedAccount.getAccountName(), savedAccount.getMoneyAmount(),
                new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary()));
    }

    @PutMapping("/{customerId}")
    public AccountResponse update(@PathVariable Long customerId, @RequestBody Account account) {
        Customer customer = customerService.findById(customerId);
        Account accountToUpdate = null;
        for (Account a : customer.getAccounts()) {
            if (account.getId() == a.getId()) {
                accountToUpdate = a;
            }
        }

        if (accountToUpdate == null) {
            throw new RuntimeException("Account is not found");
        }

        Integer indexOfAccountToUpdate = customer.getAccounts().indexOf(accountToUpdate);
        customer.getAccounts().set(indexOfAccountToUpdate, account);
        account.setCustomer(customer);

        accountService.save(account);

        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),
                new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary()));
    }

    @DeleteMapping(path = "/{id}")
    public AccountResponse remove(@PathVariable Long id) {
        Account account = accountService.findById(id);
        accountService.delete(id);

        Customer customer = account.getCustomer();

        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),
                new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary()));

    }
}
