package com.cg.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.lms.entity.BooksOrder;

public interface BooksOrderDao extends JpaRepository<BooksOrder, Integer>{

}
