package com.example.simple_banking_app.account;

import com.example.simple_banking_app.account.api.dto.CurrencyType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
class CurrencyAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private UUID id;
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;
    @ManyToOne
    private AccountEntity account;
    private double amount;
}
