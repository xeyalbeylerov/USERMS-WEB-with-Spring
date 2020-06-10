///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.company.service.impl;
//
//import com.company.entity.Skill;
//import com.company.repo.SkillRepository;
//import com.company.service.inter.SkillServiceInter;
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
//@Service(value = "skillServiceMvc")
//public class SkillServiceImpl implements SkillServiceInter {
//
//    @Autowired
//    @Qualifier(value = "skillService")
//    private SkillServiceInter skillDao;
//
//    @Override
//    public List<Skill> getAll() {
//        return skillDao.getAll();
//    }
//
//    @Override
//    public Skill getById(int id) {
////        return skillDao.findByUser_id(id);
//        return null;
//    }
//
//    @Override
//    public Skill updateSkill(Skill u) {
//        return skillDao.updateSkill(u);
//    }
//
//    @Override
//    public Skill insertSkill(Skill skill) {
//        return skillDao.insertSkill(skill);
//    }
//
//
//    @Override
//    public void removeSkill(int id) {
//         skillDao.removeSkill(id);
//    }
//
//    @Override
//    public List<Skill> getByName(String name) {
//        return skillDao.getByName(name);
//    }
//
//}
