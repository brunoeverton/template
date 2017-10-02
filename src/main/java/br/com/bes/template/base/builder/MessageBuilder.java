package br.com.bes.template.base.builder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import br.com.bes.template.base.enums.MessageTypeEnum;
import br.com.bes.template.base.enums.ResponseStatusEnum;
import br.com.bes.template.base.vo.MessageVO;
import br.com.bes.template.base.vo.ResponseVO;

/**
 * Builder para criar resposta do servidor
 * @author bruno.everton
 *
 * @param <E>
 */
public class MessageBuilder<E> {
	private Set<String> errorMessages = new HashSet<String>();
	private Set<String> successMessages = new HashSet<String>();
	private Set<String> warningMessages = new HashSet<String>();
	
	private E entityReturn;
	
	/**
	 * Cria instancia do builder
	 */
	public MessageBuilder() {
		super();
	}
	/**
	 * Cria instancia do builder com a entidade de retorno
	 * @param entityReturn
	 */
	public MessageBuilder(E entityReturn) {
		this();
		this.entityReturn = entityReturn;
	}
	
	/**
	 * Adiciona mensagem de erro
	 * @param param
	 * @return
	 */
	public MessageBuilder<E> addErrorMessage(String param) {
		errorMessages.add(param);
		return this;
	}
	
	/**
	 * Define a entidade de retorno
	 * @param entityReturn 
	 */
	public MessageBuilder<E> setEntityReturn(E entityReturn) {
		this.entityReturn = entityReturn;
		return this;
	}
	/**
	 * Indica se ja existe algum erro
	 * @return
	 */
	public boolean hasError() {
		return !errorMessages.isEmpty();
	}
	/**
	 * Build das informaçoes e cria ResponseVO
	 * @return
	 */
	public ResponseVO<E> build(){
		ResponseVO<E> responseVO = new ResponseVO<E>(entityReturn);
		responseVO.setStatus(errorMessages.isEmpty()?ResponseStatusEnum.SUCCESS:ResponseStatusEnum.ERROR);
		responseVO.setMessages(new ArrayList<MessageVO>());
		for (String string : errorMessages) {
			responseVO.getMessages().add(new MessageVO(string, MessageTypeEnum.ERROR));
		}
		
		for (String string : warningMessages) {
			responseVO.getMessages().add(new MessageVO(string, MessageTypeEnum.WARN));
		}
		
		for (String string : successMessages) {
			responseVO.getMessages().add(new MessageVO(string, MessageTypeEnum.SUCCESS));
		}
		
		return responseVO;
	}

}
