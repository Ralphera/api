package com.udemyapi.api.services.impl;

import com.udemyapi.api.domain.User;
import com.udemyapi.api.domain.dto.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
class UserServiceImplTest {
    public static final Integer ID      = 1;
    public static final String NAME     = "ralph";
    public static final String EMAIL    = "ralph@email.com";
    public static final String PASSWORD = "1234";
    @InjectMocks
    private UserServiceImpl service;
    @Mock
    private UserServiceImpl repository;

    @Mock
    private ModelMapper mapper;

    private User user;
    private UserDTO userDTO;
    private Optional<User> optionalUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test  //quando faz a busca pelo ID me retorne uma instancia de usuario
    void whenFindByIdThenReturnAnUserInstance() {
        //Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(optionalUser);
        Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(optionalUser);

        User response = service.findById(ID);

        Assertions.assertEquals(User.class, response.getClass());
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
     //método que inicia os valores das instancias de usuario o método é chamado no método setup linha 38
    private void startUser(){
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));


    }
}