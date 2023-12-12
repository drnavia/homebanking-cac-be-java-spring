package com.ar.cac.homebanking.services;

import com.ar.cac.homebanking.exceptions.UserNotExistsException;
import com.ar.cac.homebanking.mappers.UserMapper;
import com.ar.cac.homebanking.models.User;
import com.ar.cac.homebanking.models.dtos.UserDTO;
import com.ar.cac.homebanking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    /*
     * Inyectar una instancia del Repositorio
     */
    @Autowired
    private UserRepository repository;

    // MÉTODOS
    public List<UserDTO> getUsers() {
        // Obtengo la lista de la entidad usuario de la db
        List<User> users = repository.findAll();
        // Mapear cada usuario de la lista hacia un dto
        List<UserDTO> usersDtos = users.stream()
                .map(UserMapper::userToDto)
                .collect(Collectors.toList());
        return usersDtos;
    }
    /*public List<String> getUsers() {
        List<String> nombres = List.of("Cristian", "Luis", "Amanda");
        return nombres;
    }*/

    public UserDTO getUserById(Long id) {
        User entity = repository.findById(id).get();
        return UserMapper.userToDto(entity);
    }

    public UserDTO createUser(UserDTO userDto) {
        User userValidated = validateUserByEmail(userDto);
        if (userValidated == null) {
            User userSaved = repository.save(UserMapper.dtoToUser(userDto));
            return UserMapper.userToDto(userSaved);
        } else {
            throw new UserNotExistsException("Usuario con mail: " + userDto.getEmail() + " ya existe");
        }
    }

    public UserDTO updateUser(Long id, UserDTO dto) {
        if (repository.existsById(id)) {
            User userToModify = repository.findById(id).get();

            // Validar qué datos no vienen en null para setearlos al objeto ya creado.
            // Lógica del Patch
            if (dto.getName() != null) {
                userToModify.setName(dto.getName());
            }
            if (dto.getSurname() != null) {
                userToModify.setSurname(dto.getSurname());
            }
            if (dto.getEmail() != null) {
                userToModify.setEmail(dto.getEmail());
            }
            if (dto.getPassword() != null) {
                userToModify.setPassword(dto.getPassword());
            }
            if (dto.getDni() != null) {
                userToModify.setDni(dto.getDni());
            }
            User userModified = repository.save(userToModify);
            return UserMapper.userToDto(userModified);
        }
        return null;
    }

    public String deleteUser(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "El usuario con id: " + id + " ha sido eliminado";
        } else {
            throw new UserNotExistsException("El usuario a eliminar no existe");
        }
    }

    /*
     * SERVICIO >>> CAPA DE NEGOCIO
     */
    // Método para validar temas del negocio:
    // * Validar que el mail sea único por usuario
    public User validateUserByEmail(UserDTO dto) {
        return repository.findByEmail(dto.getEmail());
    }
}
