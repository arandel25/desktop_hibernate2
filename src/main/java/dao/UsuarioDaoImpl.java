/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Usuario;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Felipe
 */
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario, Long> implements UsuarioDao, Serializable {

    @Override
    public Usuario pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return (Usuario) sessao.get(Usuario.class, id);
    }

    @Override
    public List<Usuario> listarTodo(Session session) throws HibernateException {
        Query consulta = session.createQuery("from Usuario");
        return consulta.list();
    }

    @Override
    public List<Usuario> pesquisarPorNome(String nome, Session session) throws HibernateException {
        Query consulta = session.createQuery("from Usuario where nome like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.list();
    }

    @Override
    public Usuario login(String login, String senha, Session session) throws HibernateException {
        Query consulta = session.createQuery("from Usuario where login = :login and senha = :senha");
        consulta.setParameter("login", login);
        consulta.setParameter("senha", senha);
        return (Usuario) consulta.uniqueResult();
    }

    @Override
    public void atualizarUltimoAcesso(Long id, Session session) throws HibernateException {
        Transaction transacao = session.beginTransaction();
        Query hql = session.createQuery("update Usuario set ultimoAcesso = current_date()"
                + " where id = :id");
        hql.setParameter("id", id);
        hql.executeUpdate();
        transacao.commit();
    }

    @Override
    public void alterarStatus(Long id, boolean status, Session session) throws HibernateException {
        Transaction transacao = session.beginTransaction();
        Query hql = session.createQuery("update Usuario set ativo = :ativo where id = :id");
        hql.setParameter("ativo", status);
        hql.setParameter("id", id);
        hql.executeUpdate();
        transacao.commit();
    }
}
