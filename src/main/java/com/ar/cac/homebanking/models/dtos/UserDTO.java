package com.ar.cac.homebanking.models.dtos;

import com.ar.cac.homebanking.models.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String name;
    private String surname;
    private String email;
    private String password;
    private String dni;
    private Date date_birth;
    private String address;
    //private Date created_at;
    //private Date updated_at;

    private List<Account> accounts;
}
