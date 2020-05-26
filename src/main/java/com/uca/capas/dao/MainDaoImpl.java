package com.uca.capas.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.categoria;
import com.uca.capas.domain.libro;


@Repository
public class MainDaoImpl implements MainDao{
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<libro> findAllBooks() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from public.cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(), libro.class);
		List<libro> resulset = query.getResultList();
		
		return resulset;
	}
	@Override
	public List<categoria> findAllCategories() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from public.cat_categoria");
		Query query = entityManager.createNativeQuery(sb.toString(), categoria.class);
		List<categoria> resulset = query.getResultList();
		
		return resulset;
	}
	
	@Override
	@Transactional
	public void createBook(libro l) throws DataAccessException {
		entityManager.persist(l);
	}
	@Override
	@Transactional
	public void createCat(categoria c) throws DataAccessException {
		entityManager.persist(c);
	}
	
	
	
}
