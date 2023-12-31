package com.ar.cac.homebanking.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido")
    private String surname;
    @Column(name = "mail")
    private String email;
    @Column(name = "contrasena")
    private String password;
    private String dni;
    @Column(name = "fecha_nacimiento")
    private Date date_birth;
    @Column(name = "domicilio")
    private String address;

    @Column(name = "creado_el")
    private Date created_at;
    @Column(name = "modificado_el")
    private Date updated_at;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

    //private Date created_at;
    //private Date updated_at;
}
