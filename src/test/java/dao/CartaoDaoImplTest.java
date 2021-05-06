/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Cartao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;
import util.UtilGerador;

/**
 * @author felipe.souza2
 */
public class CartaoDaoImplTest {

    private Cartao cartao;
    private CartaoDao cartaoDao;
    private Session sessao;

    public CartaoDaoImplTest() {
        cartaoDao = new CartaoDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("Salvar");
        cartao = new Cartao();
        cartao.setNumero(UtilGerador.gerarNumero(16));
        cartao.setBandeira(UtilGerador.gerarCaracter(6));
        cartao.setValidade(UtilGerador.criarNumeroEntre2Valores(0, 32)
                + "/" + UtilGerador.criarNumeroEntre2Valores(20, 30));
        sessao = HibernateUtil.abrirConexao();
        cartaoDao.salvarOuAlterar(cartao, sessao);
        sessao.close();

        assertNotNull(cartao.getId());
    }

//    @Test
    public void testSalvar2() {
        System.out.println("Salvar Cartão");
        cartao = new Cartao(null, UtilGerador.gerarCaracter(16), "Visa", "25/26");
        sessao = HibernateUtil.abrirConexao();
        cartaoDao.salvarOuAlterar(cartao, sessao);
        sessao.close();

        assertNotNull(cartao.getId());
    }

//    @Test
    public void testAlterar() {
        System.out.println("Alterar");
        buscarCartaoBd();
        cartao.setBandeira(UtilGerador.gerarCaracter(6));
        sessao = HibernateUtil.abrirConexao();
        cartaoDao.salvarOuAlterar(cartao, sessao);
        
        Cartao cartaoAlt = cartaoDao.pesquisarPorId(cartao.getId(), sessao);
        sessao.close();
        
        assertEquals(cartao.getBandeira(), cartaoAlt.getBandeira());
    }
    
//    @Test
    public void testExcluir(){
        System.out.println("Excluir");
        
        buscarCartaoBd();
        sessao = HibernateUtil.abrirConexao();
        cartaoDao.excluir(cartao, sessao);
        Cartao cartaoExc = cartaoDao.pesquisarPorId(cartao.getId(), sessao);
        sessao.close();
        
        assertNull(cartaoExc);
    }
//    @Test

    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");

    }

    public Cartao buscarCartaoBd(){
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Cartao");
        List<Cartao> cartoes = consulta.list();
        sessao.close();
        if (cartoes.isEmpty()) {
            testSalvar();
        }else{
            cartao = cartoes.get(UtilGerador.criarNumeroEntre2Valores(-1, cartoes.size()));
        }
        return cartao;
    }
    
}
