package com.ar.cac.homebanking.controllers;

import com.ar.cac.homebanking.models.dtos.UserDTO;
import com.ar.cac.homebanking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ANOTACIONES
@RestController
@RequestMapping("/api")
// CLASE
public class UserController {
    /*
     * Generar una instancia del Service (UserService) -> Inyectar una instancia mediante Spring Boot
     */
    @Autowired
    private final UserService service;
    // Constructor
    public UserController(UserService service) {
        this.service = service;
    }

    /*
    * 1) Definir la url de origen para cada solicitud
    * 2) Para cada método HTTP permitido debemos realizar una acción
    * 3) Definir el DTO y el Service (Inyección de Dependencias)
    * */

    /*
     + CRUD: Crear, Leer, Modificar y Eliminar
     */

    // TODO: Refactorizar el método para que retorne una ResponseEntity <List<UserDTO>>
    @GetMapping(value= "/users")
    public List<String> getUsers() {
        List<String> lista = service.getUsers();
        return lista;

        // Vamos a llamar al servicio de usuarios para obtener la lista desde la base de datos
        //return List.of("Cristian", "Martina", "Lucas");
    }

    @GetMapping(value= "/users/{id}")
    public void getUserById(@PathVariable Long id) {

    }

    @PostMapping(value = "/users")
    public void createUser(@RequestBody UserDTO user) {

    }

    public void updateAllUser() {

    }

    public void updateUser() {

    }

    public void deleteUser() {

    }
}
