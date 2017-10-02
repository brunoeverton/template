package br.com.bes.template.base.vo;

import br.com.bes.template.base.enums.MessageTypeEnum;

public class MessageVO {
	
	private String text;
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
