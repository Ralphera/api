package com.udemyapi.api.domain;


import lombok.*;

import javax.persistence.*;

//@EqualsAndHashCode // Atenção ao usar quando a classe tem muito atributos a aplicação fica lenta perdendo performance
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;



}
