/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Chamado;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author Felipe
 */
public class ChamadoDaoImpl extends BaseDaoImpl<Chamado, Long> implements ChamadoDao{

    @Override
    public Chamado pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return (Chamado) sessao.get(Chamado.class, id);
    }

    @Override
    public List<Chamado> pesquisarChamadosAbertos(Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Chamado where ativo = true");
        return consulta.list();
    }

    @Override
    public List<Chamado> pesquisarPorEquipamento(Session sessao, String equip) throws HibernateException {
        Query consulta = sessao.createQuery("from Chamado where equipamento like :nomeHql");
        consulta.setParameter("nomeHql", "%"+ equip + "%");
        return consulta.list();
    }
    
}
