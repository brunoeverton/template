package br.com.bes.template.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bes.template.entity.Template;
import br.com.bes.template.vo.TemplateVO;

/**
 * Interface de persistencia de arquivo utilizando Spring Data
 * @author brunoeverton
 *
 */
public interface TemplateDAO extends JpaRepository<Template, Long>{

	/**
	 * Lista todos os templates salvos no banco de dados convertendo no vo
	 * @return
	 */
	@Query("SELECT new br.com.bes.template.vo.TemplateVO(t) FROM Template t")
	public List<TemplateVO> findtAll();
}
