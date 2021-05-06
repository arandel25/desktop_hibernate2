/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Chamado;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Felipe
 */
public interface ChamadoDao extends BaseDao<Chamado, Long> {

    List<Chamado> pesquisarChamadosAbertos(Session sessao) throws HibernateException;

    List<Chamado> pesquisarPorEquipamento(Session sessao, String equip) throws HibernateException;
}
