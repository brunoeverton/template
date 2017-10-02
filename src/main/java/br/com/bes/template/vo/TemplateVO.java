package br.com.bes.template.vo;

import br.com.bes.template.entity.Template;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * VO de template
 * @author bruno.everton
 *
 */
@ApiModel(description="Template VO com as propriedades da entidade template")
public class TemplateVO {
	
	@ApiModelProperty("Identificador do Template salvo no banco de dados")
	private Long id;
	
	@ApiModelProperty("Nome do template. Não é único no banco e pode ser nulo")
	private String name;
	
	@ApiModelProperty("Valor associado ao template. Deve ser numérico, não é único e pode ser nulo")
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
