package com.uca.capas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="cat_libro")
public class libro {
	@Id
	@Column(name="c_libro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contribuyente;
	
	@Column(name="s_titulo")
	@NotEmpty(message="El campo no puede estar vacio")
	@Size(max=500,message="El campo no puede tener mas de 500 caracteres")
	private String titulo;
	
	@Column(name="s_autor")
	@NotEmpty(message="El campo no puede estar vacio")
	@Size(max=150,message="El campo no puede tener mas de 150 caracteres")
	private String autor;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "c_categoria")
	private categoria categoria;
	
	@Column(name="f_ingreso")
	private Date fecha;
	
	@Column(name="b_estado")
	private Boolean estado;
	
	@Column(name="s_isbn")
	@NotEmpty(message="El campo no puede estar vacio")
	@Size(max=10,message="El campo no puede tener mas de 10 caracteres")
	private String isbn;

	public Integer getContribuyente() {
		return contribuyente;
	}

	public void setContribuyente(Integer contribuyente) {
		this.contribuyente = contribuyente;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(categoria categoria) {
		this.categoria = categoria;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public libro() {
		super();

	}


	
	

	
	
	
	
}