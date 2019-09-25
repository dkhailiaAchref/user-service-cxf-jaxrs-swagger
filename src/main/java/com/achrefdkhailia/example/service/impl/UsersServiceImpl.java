package com.achrefdkhailia.example.service.impl;

import com.achrefdkhailia.example.domain.User;
import com.achrefdkhailia.example.repository.UserRepository;
import com.achrefdkhailia.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class UsersServiceImpl implements UserService {

    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        init();
    }

    @Autowired
    private UserRepository userRepository;

    private void init (){
        User usOne=new User (1L,"jhon","sina");
        User usTwo=new User (2L,"jhon","sina");
        User usThree=new User (3L,"jhon","sina");
        userRepository.save(usOne);
        userRepository.save(usTwo);
        userRepository.save(usThree);
    }

    @Override
    public Optional<User> save(final User user) {
        return Optional.of(userRepository.save(user));
    }

    @Override
    public Optional<User> findById(final long id) {
        return Optional.of(userRepository.findOne(id));
    }

    @Override
    public Optional<List<User>> findAll() {
        return Optional.of(userRepository.findAll());
    }

    @Override
    public Optional<User> update(final long id,
                                 final User user) {

        if (this.findById(id).isPresent()) {
            user.setId(id);
            return this.save(user);
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void deleteById(final long id) {
        System.out.println("delete by id " + id);
        userRepository.delete(id);
    }
}