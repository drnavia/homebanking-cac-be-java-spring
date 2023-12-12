package com.ar.cac.homebanking.controllers;

import com.ar.cac.homebanking.models.dtos.UserDTO;
import com.ar.cac.homebanking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UserDTO>> getUsers() {

        List<UserDTO> lista = service.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }
    /*public List<String> getUsers() {
        List<String> lista = service.getUsers();
        return lista;
    }
    public List<String> getUsers() {
        // Vamos a llamar al servicio de usuarios para obtener la lista desde la base de datos
        return List.of("Cristian", "Martina", "Lucas");
    }*/

    @GetMapping(value= "/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(service.getUserById(id));
    }

    @PostMapping(value = "/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(dto));
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<UserDTO> updateAllUser(@PathVariable Long id, @RequestBody UserDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateUser(id, dto));
    }

//    @PatchMapping(value = "/users/{id}")
//    public void updateUser(@PathVariable Long id) {
//
//    }

    // TODO: Refactor en Exception
    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteUser(id));
    }

    /*
     * CONTROLADOR >>> CAPA DE PRESENTACIÓN
     */
    // Método para validar datos de entrada
    // * Caracteres del email
    // * Seguridad
}
