/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import br.com.sige.entidade.Produto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pedro
 */
@Stateless
public class ProdutoSBean {
    
    @PersistenceContext(unitName = "sigePU")
    private EntityManager em;
    
    public void salvar(Produto produto) {
        em.merge(produto);
    }
    
}
