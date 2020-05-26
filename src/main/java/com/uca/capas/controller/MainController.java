package com.uca.capas.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.MainDao;
import com.uca.capas.domain.*;


@Controller
public class MainController {
	@Autowired
	private MainDao dao;
	
	@RequestMapping("/index")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping("/libro")
	public ModelAndView libro() {
		ModelAndView mav = new ModelAndView();
		libro libronuevo = new libro();
		List<categoria> categorias = null;
		
		try {
			categorias = dao.findAllCategories();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("libro",libronuevo);
		mav.addObject("categorias",categorias);

		mav.setViewName("libro");
		
		return mav;
	}
	@RequestMapping("/categoria")
	public ModelAndView categoria() {
		ModelAndView mav = new ModelAndView();
		categoria catnuevo = new categoria();
		mav.addObject("categoria",catnuevo);
		mav.setViewName("categoria");
		return mav;
	}
	
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<libro> libros = null;
		
		try {
			libros = dao.findAllBooks();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("libros", libros);
		mav.setViewName("listado");
		
		return mav;
	}
	
	@RequestMapping("/validacioncat")
	public ModelAndView validacioncat(@Valid @ModelAttribute categoria cat, BindingResult result) {
		ModelAndView mav = new ModelAndView();
				
		if(result.hasErrors()) 
		{
			mav.setViewName("categoria");
		}else
		{
			dao.createCat(cat);
			mav.addObject("successcat", true);
			mav.setViewName("index");

		}
		
		return mav;
	}
	
	@RequestMapping("/validacionlib")
	public ModelAndView validacionlib(@Valid @ModelAttribute libro lib, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		List<categoria> categoriasx = null;

		try {
			categoriasx = dao.findAllCategories();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		if(lib.getEstado()==null) {
			lib.setEstado(false);
		}
		if(result.hasErrors()) 
		{
			mav.addObject("categorias",categoriasx);
			mav.setViewName("libro");
		}else
		{
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");  
		    Date date = new Date();
		    String datex=formatter.format(date);
		    Date date1;
			try {
				date1 = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(datex);
				lib.setFecha(date1);
				dao.createBook(lib);
				mav.addObject("successlib", true);
			} catch (ParseException e) {
				e.printStackTrace();
			}  
			mav.setViewName("index");

		}
		
		
		return mav;
	}
	
	
	
	
	
}