package com.ar.cac.homebanking.models.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TransferDTO {

    private Long id;

    private BigDecimal amount;
    private Long account_origin;
    private Long account_target;

    private Date date;
}
