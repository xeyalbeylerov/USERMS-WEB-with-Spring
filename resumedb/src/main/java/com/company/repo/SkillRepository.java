package com.company.repo;

import com.company.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface SkillRepository extends JpaRepository<Skill,Integer> {

    List<Skill> findByName(String skillName);
}
