package com.ar.cac.homebanking.mappers;

import com.ar.cac.homebanking.models.User;
import com.ar.cac.homebanking.models.dtos.UserDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    // Métodos para transformar objetos

    // Recibo del FRONT un UserDTO y lo transformo
    public static User dtoToUser(UserDTO dto) {
        // Le setteo los datos al objeto "user" y obtengo los datos del "dto"
        User user = new User();
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setDni(dto.getDni());
        user.setDate_birth(dto.getDate_birth());
        user.setAddress(dto.getAddress());
        user.setAccounts(dto.getAccounts());

        return user;
    }

    // Envio al FRONT un User y lo transformo
    public static UserDTO userToDto (User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setDni(user.getDni());
        dto.setDate_birth(user.getDate_birth());
        dto.setAddress(user.getAddress());
        dto.setAccounts(user.getAccounts());

        return dto;
    }
}
