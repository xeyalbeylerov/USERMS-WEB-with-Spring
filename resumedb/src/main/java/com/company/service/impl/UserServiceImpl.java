/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;


import com.company.repo.UserRepository;

import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Khayal Baylarov
 */

@Service(value = "userService")
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceInter {



    private final UserRepository userDao;

    @Override
    public List<User> getAll(String name, String surname) {
        name=(name==null)?"":name;
        surname=(surname==null)?"":surname;
        return userDao.findByNameContainingAndSurnameContaining(name,surname);
    }
    @Override
    public List<User> getAll(String name, String surname,Integer nationalityId) {
        name=(name==null)?"":name;
        surname=(surname==null)?"":surname;
        return userDao.findByNameContainingAndSurnameContaining(name,surname);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userDao.findByEmailAndPassword(email, password);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public boolean isEmailExists(String email) {
        return userDao.existsUserByEmail(email);
    }

    @Override
    public boolean removeUser(int id) {
        userDao.deleteById(id);
        return true;
    }


    @Override
    public User updateUser(User u) {
        if(u.getId()==null){
           throw new IllegalArgumentException("Id can not be null while update");
        }
        User user = userDao.save(u);
        return user;
    }


    @Override
    public User getById(int userId) {
        User user = userDao.getOne(userId);
        return user;
    }


    @Override
    public User addUser(User u) {
        User user = userDao.save(u);
        return user;
    }


}
