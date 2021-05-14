/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Perfil;
import entidade.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import util.UtilGerador;

/**
 * @author Felipe
 */
public class UsuarioDaoImplTest {

    private Session session;
    private Usuario usuario;
    private UsuarioDao usuarioDao;
    
    
    public UsuarioDaoImplTest() {
        usuarioDao = new UsuarioDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("Salvar");
        PerfilDao perfilDao = new PerfilDaoImpl();
        session = HibernateUtil.abrirConexao();

        usuario = new Usuario();
        usuario.setNome(UtilGerador.gerarNome());
        usuario.setLogin(UtilGerador.gerarEmail());        
        usuario.setSenha("123456");
        usuario.setPerfil((Perfil) perfilDao.pesquisarPerfil(session).get(UtilGerador.criarNumeroEntre2Valores(-1, 3)));
        
        usuarioDao.salvarOuAlterar(usuario, session);
        session.close();

        assertNotNull(usuario.getId());
    }

//    @Test
    public void testAlterar() {
        System.out.println("alterar");
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
    }

//    @Test
    public void testListarTodo() {
        System.out.println("listarTodo");
    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
    }

//    @Test
    public void testLogin() {
        System.out.println("login");
        buscarUsuarioBd();
        session = HibernateUtil.abrirConexao();
        Usuario usuarioLogado = usuarioDao.login(usuario.getLogin(), usuario.getSenha(), session);
        assertNotNull(usuarioLogado);
    }

//    @Test
    public void testAtualizarUltimoAcesso() {
        System.out.println("atualizarUltimoAcesso");
        buscarUsuarioBd();
        session = HibernateUtil.abrirConexao();
        usuarioDao.atualizarUltimoAcesso(usuario.getId(), session);
        session.close();
    }

//    @Test
    public void testAlterarStatus() {
        System.out.println("alterarStatus");
        buscarUsuarioBd();
        
        session = HibernateUtil.abrirConexao();
        usuarioDao.alterarStatus(usuario.getId(), !usuario.isAtivo(), session);
        session.close();
        
        session = HibernateUtil.abrirConexao();
        Usuario usuarioAlt = usuarioDao.pesquisarPorId(usuario.getId(), session);
        session.close();
        
        Assert.assertNotEquals(usuario.isAtivo(), usuarioAlt.isAtivo());
    }

    public Usuario buscarUsuarioBd() {
        session = HibernateUtil.abrirConexao();
        Query consulta = session.createQuery("from Usuario");
        List<Usuario> usuarios = consulta.list();
        session.close();

        if (usuarios.isEmpty()) {
            testSalvar();
        } else {
            usuario = usuarios.get(UtilGerador.criarNumeroEntre2Valores(-1, usuarios.size()));
        }

        return usuario;
    }
}
