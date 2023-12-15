package com.ar.cac.homebanking.models;

import com.ar.cac.homebanking.models.enums.AccountType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
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
    @Column(name = "creado_el")
    private Date created_at;
    @Column(name = "modificado_el")
    private Date updated_at;

    @ManyToOne
    private User owner;

    //@ManyToOne
    //private List<Transfer> transfers;
}
