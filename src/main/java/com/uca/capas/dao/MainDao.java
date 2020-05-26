package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.categoria;
import com.uca.capas.domain.libro;

public interface MainDao {
	public List<libro> findAllBooks() throws DataAccessException;
	public List<categoria> findAllCategories() throws DataAccessException;
	public void createBook(libro l) throws DataAccessException;
	public void createCat(categoria c) throws DataAccessException;
}