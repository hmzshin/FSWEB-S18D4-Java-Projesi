package com.workintech.s18d4.dto;

public record AccountResponse(Long Id, String accountName, Double balance, CustomerResponse CustomerResponse) {
}