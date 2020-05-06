/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.sige.entidade.Produto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import sessionbean.ProdutoSBean;
import br.com.sige.entidade.UnidadeMedida;
import sessionbean.UnidadeMedidaSBean;
import uteis.jsf.UnidadeMedidaConverter;

/**
 *
 * @author Pedro
 */
@Named(value = "produtoMBean")
@SessionScoped
public class ProdutoMBean implements Serializable {

    @EJB
    private UnidadeMedidaSBean unidadeMedidaSBean;

    private Produto produto;

    private String parametroPesquisa;

    private List<Produto> listaProdutos;

    private List<UnidadeMedida> listaUnidadeMedida;
    
    private UnidadeMedidaConverter unidadeMedidaConverter;

    @EJB
    private ProdutoSBean produtoSBean;

    public ProdutoMBean() {

    }

    @PostConstruct
    public void init() {
        produto = new Produto();
        listaProdutos = new ArrayList<>();
    }
    
    private void inicioFormularioCadastro() {
        listaUnidadeMedida = unidadeMedidaSBean.pesquisar("");
        unidadeMedidaConverter = new UnidadeMedidaConverter();
        unidadeMedidaConverter.setUnidadeMedidaSBean(unidadeMedidaSBean);
    }

    public void botaoPesquisar() {
        listaProdutos = produtoSBean.pesquisar(parametroPesquisa);

    }

    public String botaoSalvar() {
        produtoSBean.salvar(produto);
        produto = new Produto();
        return "consProduto?faces-redirect=true";
    }
    
    public String botaoNovo() {
        this.produto = new Produto();
        this.inicioFormularioCadastro();
        return "cad_Produto?faces-redirect=true";
    }

    public void botaoExcluir() {
        produtoSBean.excluir(produto);
        produto = new Produto();
    }

    public String botaoEditar() {
        this.inicioFormularioCadastro();
        return "cad_produto?faces-redirect=true";
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getParametroPesquisa() {
        return parametroPesquisa;
    }

    public void setParametroPesquisa(String parametroPesquisa) {
        this.parametroPesquisa = parametroPesquisa;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> ListaProdutos) {
        this.listaProdutos = ListaProdutos;
    }

    public List<UnidadeMedida> getListaUnidadeMedida() {
        return listaUnidadeMedida;
    }

    public void setListaUnidadeMedida(List<UnidadeMedida> ListaUnidadeMedida) {
        this.listaUnidadeMedida = ListaUnidadeMedida;
    }

    public UnidadeMedidaConverter getUnidadeMedidaConverter() {
        return unidadeMedidaConverter;
    }

    public void setUnidadeMedidaConverter(UnidadeMedidaConverter unidadeMedidaConverter) {
        this.unidadeMedidaConverter = unidadeMedidaConverter;
    }
    
    

}
