package com.ar.cac.homebanking.mappers;

import com.ar.cac.homebanking.models.Transfer;
import com.ar.cac.homebanking.models.dtos.TransferDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TransferMapper {

    public Transfer dtoToTransfer(TransferDTO dto){
        return Transfer.builder()
                .amount(dto.getAmount())
                .date(dto.getDate())
                .account_origin(dto.getAccount_origin())
                .account_target(dto.getAccount_target())
                .date(dto.getDate())
                .build();
    }

    public TransferDTO transferToDto(Transfer transfer){
        return TransferDTO.builder()
                .id(transfer.getId())
                .amount(transfer.getAmount())
                .account_origin(transfer.getAccount_origin())
                .account_target(transfer.getAccount_target())
                .date(transfer.getDate())
                .build();
    }
}
