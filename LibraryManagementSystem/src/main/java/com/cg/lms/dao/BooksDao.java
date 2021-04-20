package com.cg.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.lms.entity.Books;

public interface BooksDao extends JpaRepository<Books, Integer>{

}
