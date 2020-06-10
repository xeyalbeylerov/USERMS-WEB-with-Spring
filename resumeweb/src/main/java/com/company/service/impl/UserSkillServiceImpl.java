///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.company.service.impl;
//
//import com.company.entity.UserSkill;
//import com.company.repo.UserSkillRepository;
//import com.company.service.inter.UserSkillServiceInter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * @author Xeyal
// */
//
//@Service(value = "userSkillServiceMvc")
//public class UserSkillServiceImpl implements UserSkillServiceInter {
//
//    @Autowired
//
//    @Qualifier(value = "userSkillService")
//    private UserSkillServiceInter userSkillDao;
//
//    @Override
//    public List<UserSkill> getAllSkillByUserId(int id) {
//        return userSkillDao.getAllSkillByUserId(id);
//    }
//
//    @Override
//    public UserSkill insertUserSkill(UserSkill u) {
//        return userSkillDao.insertUserSkill(u);
//    }
//
//    @Override
//    public UserSkill updateUserSkill(UserSkill u) {
//        return userSkillDao.updateUserSkill(u);
//    }
//
//    @Override
//    public void removeUserSkill(int id) {
//       userSkillDao.removeUserSkill(id);
//    }
//}
