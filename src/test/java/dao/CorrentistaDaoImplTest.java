/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Correntista;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;
import util.UtilGerador;

/**
 * @author Felipe
 */
public class CorrentistaDaoImplTest {
    
    private Correntista correntista;
    private CorrentistaDao correntistaDao;
    private Session sessao;
    
    public CorrentistaDaoImplTest() {
        correntistaDao = new CorrentistaDaoImpl();
    }

//    @Test
    public void testSalvar(){
        System.out.println("salvar");
        CartaoDaoImplTest cartaoTeste = new CartaoDaoImplTest();
        correntista = new Correntista();
        correntista.setCpf(UtilGerador.gerarCaracter(12));
        correntista.setNascimento(new Date());
        correntista.setEmail(UtilGerador.gerarEmail());
        correntista.setNome(UtilGerador.gerarNome());
        correntista.setSalario(BigDecimal.valueOf(Double.parseDouble(UtilGerador.gerarNumero(5))));
        correntista.setHistorico(UtilGerador.gerarCaracter(20));
        
        correntista.setCartao(cartaoTeste.buscarCartaoBd());
        
        sessao = HibernateUtil.abrirConexao();
        correntistaDao.salvarOuAlterar(correntista, sessao);
        sessao.close();
        assertNotNull(correntista.getId());
    }
    
//    @Test
    public void testAlterar(){
        System.out.println("alterar");
        buscarCorrentistaBd();
        correntista.setEmail(UtilGerador.gerarEmail());
        sessao = HibernateUtil.abrirConexao();
        correntistaDao.salvarOuAlterar(correntista, sessao);
        Correntista correntistaAlt = correntistaDao.pesquisarPorId(correntista.getId(), sessao);
        sessao.close();
        
        assertEquals(correntista.getEmail(), correntistaAlt.getEmail());
    }
            
    
//    @Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarCorrentistaBd();
        sessao = HibernateUtil.abrirConexao();
        correntistaDao.excluir(correntista, sessao);
        
        Correntista correntistaExc = correntistaDao.pesquisarPorId(correntista.getId(), sessao);
        sessao.close();
        
        assertNull(correntistaExc);
    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        buscarCorrentistaBd();
        sessao = HibernateUtil.abrirConexao();
        List<Correntista> correntistas = correntistaDao.pesquisarPorNome(UtilGerador.gerarCaracter(1), sessao);
        
        assertTrue(!correntistas.isEmpty());
    }
    
    public Correntista buscarCorrentistaBd(){
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Correntista");
        List<Correntista> correntistas = consulta.list();
        sessao.close();
        if (correntistas.isEmpty()) {
            testSalvar();
        }else{
            correntista = correntistas.get(UtilGerador.criarNumeroEntre2Valores(-1, correntistas.size()));
        }
        return correntista;
    }
    
}