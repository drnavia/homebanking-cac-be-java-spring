package com.ar.cac.homebanking.models;

import com.ar.cac.homebanking.models.enums.AccountType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cuentas")
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_type")
    private AccountType type;

    private String cbu;

    private String alias;

    private BigDecimal amount;

    //@
    //private User owner;

    //@ManyToOne
    //private List<Transfer> transfers;
}
