/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Endereco;
import entidade.Fornecedor;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;
import util.UtilGerador;
import web_service.EnderecoWebService;

/**
 * @author felipe.souza2
 */
public class FornecedorDaoImplTest {
    
    private Fornecedor fornecedor;
    private FornecedorDao fornecedorDao;
    private Session sessao;
    
    public FornecedorDaoImplTest() {
        fornecedorDao = new FornecedorDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("Salvar");
        fornecedor = new Fornecedor();
        fornecedor.setNome(UtilGerador.gerarNome());
        fornecedor.setCadastro(new Date());
        
        EnderecoWebService WebService = new EnderecoWebService();
        String cep = "88132599";
        Endereco endereco = WebService.pesquisaCep(cep);
        fornecedor.setEndereco(endereco);
        endereco.setFornecedor(fornecedor);
        
        fornecedor.setDescricao(UtilGerador.gerarCaracter(20));
        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.salvarOuAlterar(fornecedor, sessao);
        sessao.close();
        
        assertNotNull(fornecedor.getId());
    }
    
//    @Test
    public void testAlterar() {
        System.out.println("Alterar");
        buscarFornecedorBd();
        fornecedor.setNome(UtilGerador.gerarNome());
        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.salvarOuAlterar(fornecedor, sessao);
        
        Fornecedor fornecedorAlt = fornecedorDao.pesquisarPorId(fornecedor.getId(), sessao);
        sessao.close();
        
        assertEquals(fornecedor.getNome(), fornecedorAlt.getNome());
    }
    
//    @Test
    public void testExcluir() {
        System.out.println("Excluir");
        
        buscarFornecedorBd();
        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.excluir(fornecedor, sessao);
        Fornecedor fornecedorExc = fornecedorDao.pesquisarPorId(fornecedor.getId(), sessao);
        sessao.close();
        
        assertNull(fornecedorExc);
    }
//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarFornecedorBd();
        sessao = HibernateUtil.abrirConexao();
        Fornecedor forn = fornecedorDao.pesquisarPorId(fornecedor.getId(), sessao);
        sessao.close();
        assertNotNull(forn);
    }

//    @Test
    public void testListarTodo() {
        System.out.println("listarTodo");
        buscarFornecedorBd();
        sessao = HibernateUtil.abrirConexao();
        List<Fornecedor> fornecedores = fornecedorDao.listarTodo(sessao);
        sessao.close();
        
//        assertFalse(fornecedores.isEmpty()); -> Funciona esse tb
//        assertTrue(!fornecedores.isEmpty()); -> Funciona esse tb
        
        assertTrue(fornecedores.size() > 0);
    }
    
    public Fornecedor buscarFornecedorBd(){
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Fornecedor");
        List<Fornecedor> fornecedores = consulta.list();
        sessao.close();
        if (fornecedores.isEmpty()) {
            testSalvar();
        }else{
            fornecedor = fornecedores.get(UtilGerador.criarNumeroEntre2Valores(-1, fornecedores.size()));
        }
        return fornecedor;
    }
}
