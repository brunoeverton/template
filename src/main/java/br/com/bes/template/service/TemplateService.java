package br.com.bes.template.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bes.template.dao.TemplateDAO;
import br.com.bes.template.entity.Template;
import br.com.bes.template.vo.TemplateVO;

@Service
public class TemplateService {

	@Autowired
	private TemplateDAO templateDAO;

	/**
	 * Gera uma lista de templates com valores aleatórios
	 * @param quantity
	 * @return
	 */
	public List<TemplateVO> autoGenerateTemplates(Long quantity){
		Random randomGenerator = new Random();
		List<TemplateVO> result = new ArrayList<TemplateVO>();
		for (Long i=0L;i<quantity;i++) {
			result.add(new TemplateVO(i,"Teste " + i, randomGenerator.nextInt()));
		}
		return result;
	}
	
	/**
	 * Salva um novo registro de template a partir do VO
	 * @param templateVO
	 * @return
	 */
	public Template saveTemplate(TemplateVO templateVO){
		return templateDAO.save(templateVO.createEntity());

	}
	
	public List<TemplateVO> findAll(){
		return templateDAO.findtAll();

	}
}
