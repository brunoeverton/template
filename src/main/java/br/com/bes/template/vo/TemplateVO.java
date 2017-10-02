package br.com.bes.template.vo;

import br.com.bes.template.entity.Template;

/**
 * VO de template
 * @author bruno.everton
 *
 */
public class TemplateVO {
	private Long id;
	private String name;
	private Integer value;
	
	/**
	 * Cria instancia do objeto sem definir os atributos
	 */
	public TemplateVO() {
		super();
	}
	
	/**
	 * Cria a instancia do objeto defindo todos os atributos	
	 * @param id
	 * @param name
	 * @param value
	 */
	public TemplateVO(Long id, String name, Integer value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}

	/**
	 * Constroi vo a partir da entidade
	 * @param template
	 */
	public TemplateVO(Template template) {
		super();
		this.id = template.getId();
		this.name = template.getName();
		this.value = template.getValue();
	}
	
	/**
	 * Cria instancia da entidade Template a partir deste VO
	 * @return
	 */
	public Template createEntity() {
		Template template = new Template();
		template.setName(this.name);
		template.setValue(this.value.intValue());
		return template;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
