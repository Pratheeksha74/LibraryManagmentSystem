package com.cg.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.lms.entity.Users;

public interface UsersDao extends JpaRepository<Users, Integer>{

}
