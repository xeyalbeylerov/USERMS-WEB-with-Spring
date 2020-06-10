/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.inter;

import com.company.dto.UserEditDto;
import com.company.dto.UserRegistrationDto;
import com.company.entity.User;

import java.util.List;

/**
 * @author xeyal
 */
public interface UserServiceMvcInter {

    List<User> getAll(String name, String surname);

    List<User> getAll(String name, String surname, Integer nationalityid);

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    User getById(int userId);

    User addUser(UserRegistrationDto u) throws Exception;

    User updateUser(UserEditDto userEditDto);

    boolean removeUser(int i);

}
