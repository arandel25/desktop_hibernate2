/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Felipe
 */
public interface UsuarioDao extends BaseDao<Usuario, Long>{
    List<Usuario> listarTodo(Session session) throws HibernateException;
    List<Usuario> pesquisarPorNome (String nome, Session session) throws HibernateException;
    Usuario login(String login, String senha, Session session) throws HibernateException;
    void atualizarUltimoAcesso(Long id, Session session) throws HibernateException;
    void alterarStatus(Long id, boolean status, Session session) throws HibernateException;
}
