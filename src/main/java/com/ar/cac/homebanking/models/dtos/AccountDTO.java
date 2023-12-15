package com.ar.cac.homebanking.models.dtos;

import com.ar.cac.homebanking.models.User;
import com.ar.cac.homebanking.models.enums.AccountType;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AccountDTO {

    private Long id;

    private AccountType type;
    private String cbu;
    private String alias;
    private BigDecimal amount;
    //private Date created_at;
    //private Date updated_at;

    private User owner;
}
