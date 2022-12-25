package com.udemyapi.api.services.impl;

import com.udemyapi.api.domain.User;
import com.udemyapi.api.domain.dto.UserDTO;
import com.udemyapi.api.repositories.UserRepository;
import com.udemyapi.api.services.UserService;
import com.udemyapi.api.services.exceptions.DataIntegratyViolationException;
import com.udemyapi.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import javax.print.attribute.UnmodifiableSetException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);//condição da validação
        return repository.save(mapper.map(obj, User.class));


    }

    @Override
    public User update(UserDTO obj) {
        findByEmail(obj);//condição da validação
        return repository.save(mapper.map(obj, User.class));
    }

    @Override
    public void delete(Integer id) {
        findById(id);//verifica se o ID ainda existe, senão usa excecao de obj personalizado da linha 31
        repository.deleteById(id);

    }

    private void findByEmail (UserDTO obj){
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if(user.isPresent() && !user.get().getId().equals(obj.getId())){
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");//condição do email
        }

    }

}

