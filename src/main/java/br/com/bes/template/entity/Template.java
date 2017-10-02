package br.com.bes.template.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.bes.template.base.entity.BaseEntity;

/**
 * 
 * @author bruno.everton
 *
 */
@Entity
@Table(name="template")
public class Template extends BaseEntity{

	private static final long serialVersionUID = 1L;

	
	/**
	 * Cria instancia do template
	 */
	public Template() {
		super();
	}
	
	@Column(name = "name", nullable = false,length=200)
	private String name;
	

	@Column(name = "value", nullable = false)
	private Integer value;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getValue() {
		return value;
	}


	public void setValue(Integer value) {
		this.value = value;
	}

}
