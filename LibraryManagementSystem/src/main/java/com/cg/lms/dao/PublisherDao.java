package com.cg.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.lms.entity.Publishers;

@Repository
public interface PublisherDao extends JpaRepository<Publishers, Integer>{

}
