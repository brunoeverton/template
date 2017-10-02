package br.com.bes.template.base.vo;

import br.com.bes.template.base.enums.MessageTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * Estrutura da mensagem de retorno
 * @author bruno.everton
 *
 */
@ApiModel("Estrutura da mensagem de retorno")
public class MessageVO {
	
	@ApiModelProperty(notes = "Texto da mensagem")
	private String text;
	
	@ApiModelProperty(notes = "Tipo da mensagem")
	private MessageTypeEnum type;
	
	
	/**
	 * Cria instancia da entidade com todas as propriedades
	 * @param text
	 * @param type
	 */
	public MessageVO(String text, MessageTypeEnum type) {
		super();
		this.text = text;
		this.type = type;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public MessageTypeEnum getType() {
		return type;
	}
	public void setType(MessageTypeEnum type) {
		this.type = type;
	}
	
	
}
