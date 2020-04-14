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
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import uteis.UnidadeMedida;

/**
 *
 * @author Pedro
 */
@Named(value = "produtoMBean")
@SessionScoped
public class ProdutoMBean implements Serializable {
    
    private Produto produto;
    
    private String parametroPesquisa;
    
    private List<Produto> listaProdutos;
    
    private List<UnidadeMedida> listaUnidadeMedida;

    public ProdutoMBean() {
        
    }
    
    @PostConstruct
    public void init() {
        produto = new Produto();
        listaProdutos = new ArrayList<>();
        listaUnidadeMedida = Arrays.asList(UnidadeMedida.values());
    }
    
    public void botaoPesquisar() {
        
        
    }
    
    public String botaoSalvar () {
        listaProdutos.add(produto);
        produto = new Produto();
        return "consProduto?faces-redirect=true";
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
    
    
    
    
    
}
