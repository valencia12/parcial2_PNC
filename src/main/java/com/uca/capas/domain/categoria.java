package com.uca.capas.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="cat_categoria")
public class categoria {
	@Id
	@Column(name="c_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cat;
	
	@Column(name="s_categoria")
	@NotEmpty(message="El campo no puede estar vacio")
	@Size(max=150,message="El campo no puede tener mas de 150 caracteres")
	private String ccategoria;

	@OneToMany(mappedBy="categoria", cascade=CascadeType.ALL)
	private List<libro> libros;
	
	public Integer getCat() {
		return cat;
	}

	public void setCat(Integer cat) {
		this.cat = cat;
	}

	public String getCcategoria() {
		return ccategoria;
	}

	public void setCcategoria(String ccategoria) {
		this.ccategoria = ccategoria;
	}

	public categoria() {
		super();

	}
	
	
}
