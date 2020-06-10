/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;


import com.company.dto.UserEditDto;
import com.company.dto.UserRegistrationDto;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import com.company.service.inter.UserServiceMvcInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xeyal
 */


@Service(value = "userServiceMvc")

public class UserServiceMvcImpl implements UserServiceMvcInter {


    @Autowired
    @Qualifier("userService")
    private UserServiceInter userDao;

    @Override
    public List<User> getAll(String name, String surname) {
        return userDao.getAll(name, surname);
    }

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        return userDao.getAll(name, surname);
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
    public boolean removeUser(int id) {
        userDao.removeUser(id);
        return true;
    }


    @Override
    public User updateUser(UserEditDto userEditDto) {
        Integer id = userEditDto.getId();
        if (id == null) return null;
        User user = userDao.getById(id);
        user.setName(userEditDto.getName());
        user.setSurname(userEditDto.getSurname());
        user.setEmail(userEditDto.getEmail());
        user.setAddress(userEditDto.getAddress());
        user.setBirthDate(userEditDto.getBirthDate());
        user.setPhone(userEditDto.getPhone());
        user.setProfileDesc(userEditDto.getProfileDesc());
        return userDao.updateUser(user);
    }


    @Override
    public User getById(int userId) {
        User user = userDao.getById(userId);
        return user;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User addUser(UserRegistrationDto userDto) throws Exception {
      boolean isExists=userDao.isEmailExists(userDto.getEmail());
        if(isExists==true){
            throw new Exception();
        }
        User user=new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        String password=passwordEncoder.encode(userDto.getPassword());
        user.setPassword(password);
        return userDao.addUser(user);
    }


}
