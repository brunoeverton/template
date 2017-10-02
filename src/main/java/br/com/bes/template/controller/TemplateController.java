package br.com.bes.template.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bes.template.base.builder.MessageBuilder;
import br.com.bes.template.base.vo.ResponseVO;
import br.com.bes.template.service.TemplateService;
import br.com.bes.template.vo.TemplateVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Controlado da entidade template 
 * @author bruno.everton
 *
 */
@RestController
@RequestMapping("/template")
public class TemplateController {
	
	@Autowired
	private TemplateService templateService;
	
	@ApiOperation(value = "Data/hora atual" , nickname = "getDateTime", notes="Retorna a data/hora atual do servidor.")
	@RequestMapping(method = RequestMethod.GET, value = "/getDateTime")
	public ResponseVO<String> getDateTime() {
		MessageBuilder<String> messageBuilder = new MessageBuilder<String>(new Date().toString());
		return messageBuilder.build();
	}
	
	@ApiOperation(value = "Gera Templates" , nickname = "generateTemplates", notes="Retorna uma lista de templates gerados aleatoriamente.")
	@RequestMapping(method = RequestMethod.GET, value = "/generateTemplates/{quantity}")
	public ResponseVO<List<TemplateVO>> generateTemplates(@ApiParam(value = "Quantidade de registros que devem ser gerados") @PathVariable("quantity") Long quantity) {
		MessageBuilder<List<TemplateVO>> result = new MessageBuilder<List<TemplateVO>>(templateService.autoGenerateTemplates(quantity));
		return result.build();
	}
	
	@ApiOperation(value = "Salva novo Template" , nickname = "saveTemplate", notes="Salva um novo registro de template no banco de dados.")
	@RequestMapping(method = RequestMethod.POST, value = "/saveTemplate")
	@ResponseBody
	public ResponseVO<TemplateVO> saveTemplate(@ApiParam(value="Dados do template que deverá ser cadastrado") @RequestBody TemplateVO templateVO) {
		MessageBuilder<TemplateVO> result = new MessageBuilder<TemplateVO>();
		if(templateVO.getId()!=null) {
			result.addErrorMessage("Para cadastrar um novo registro, o ID deve ser nulo.");
		}else {		
			result.setEntityReturn(templateService.saveTemplate(templateVO));
		}
		
		return result.build();
	}
	
	
	@ApiOperation(value = "Listar Templates Salvos" , nickname = "findAllTemplates", notes="Lista todos os templates salvos no banco de dados.")
	@RequestMapping(method = RequestMethod.GET, value = "/findAllTemplates")
	@ResponseBody
	public ResponseVO<List<TemplateVO>> findAllTemplates() {
		MessageBuilder<List<TemplateVO>> result = new MessageBuilder<List<TemplateVO>>();
		result.setEntityReturn(templateService.findAll());
		return result.build();
	}	
}
