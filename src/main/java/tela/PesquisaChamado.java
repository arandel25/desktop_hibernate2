/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.ChamadoDao;
import dao.ChamadoDaoImpl;
import dao.HibernateUtil;
import entidade.Chamado;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Felipe
 */
public class PesquisaChamado extends javax.swing.JFrame {

    private Session session;
    private Chamado chamado;
    private ChamadoDao chamadoDao;
    List<Chamado> chamados;

    public PesquisaChamado() {
        initComponents();
        chamadoDao = new ChamadoDaoImpl();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfEquipamento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaChamados = new javax.swing.JTable();
        btExcluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Chamado");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pesquisa de Chamado");

        btPesquisar.setText("Pesquisar");
        btPesquisar.setPreferredSize(new java.awt.Dimension(90, 25));
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Equipamento:");

        tfEquipamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tabelaChamados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipamento", "Situa????o", "Abertura", "Descri????o"
            }
        ));
        jScrollPane1.setViewportView(tabelaChamados);
        if (tabelaChamados.getColumnModel().getColumnCount() > 0) {
            tabelaChamados.getColumnModel().getColumn(0).setMinWidth(140);
            tabelaChamados.getColumnModel().getColumn(0).setMaxWidth(150);
            tabelaChamados.getColumnModel().getColumn(1).setMinWidth(50);
            tabelaChamados.getColumnModel().getColumn(1).setMaxWidth(70);
            tabelaChamados.getColumnModel().getColumn(2).setMinWidth(50);
            tabelaChamados.getColumnModel().getColumn(2).setMaxWidth(150);
        }

        btExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setPreferredSize(new java.awt.Dimension(90, 25));
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setPreferredSize(new java.awt.Dimension(90, 25));
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(tfEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        session = HibernateUtil.abrirConexao();
        try {
            if (validarCampo()) {
                chamados = chamadoDao.pesquisarPorEquipamento(session, tfEquipamento.getText().trim());
            } else {
                chamados = chamadoDao.pesquisarChamadosAbertos(session);
                System.out.println(chamados.get(0).getId());
            }
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        } finally {
            session.close();
            carregarTabela(chamados);
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int linha = tabelaChamados.getSelectedRow();
        if (linha >= 0) {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir");
            if (opcao == 0) {
                try {
                    session = HibernateUtil.abrirConexao();
                    chamadoDao.excluir(chamados.get(linha), session);
                    chamados.remove(linha);
                    JOptionPane.showMessageDialog(null, "Chamado excluido com sucesso!");
                    tfEquipamento.setText("");
                } catch (HibernateException e) {
                    System.err.println(e.getMessage());
                } finally {
                    session.close();
                    carregarTabela(chamados);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        int linha = tabelaChamados.getSelectedRow();
        if (linha >= 0) {
            new CadastroChamado(chamados.get(linha)).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");
        }

    }//GEN-LAST:event_btAlterarActionPerformed

    private void carregarTabela(List<Chamado> chamados) {
        DefaultTableModel tabelaModelo = (DefaultTableModel) tabelaChamados.getModel();
        tabelaModelo.setNumRows(0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        String ativo;
        if (chamados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado!");
        } else {
            for (Chamado cham : chamados) {
                ativo = cham.isAtivo() ? "Aberto" : "Encerrado";
                tabelaModelo.addRow(new Object[]{cham.getEquipamento(),
                    ativo, dateFormat.format(cham.getCadastro()), cham.getDescricao()});
            }
        }
    }

    private boolean validarCampo() {
        boolean erro = true;
        if (tfEquipamento.getText().trim().length() <= 1) {
            JOptionPane.showMessageDialog(null, "Equipamento inv??lido");
            erro = false;
        }
        return erro;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PesquisaChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaChamado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JTable tabelaChamados;
    private javax.swing.JTextField tfEquipamento;
    // End of variables declaration//GEN-END:variables
}
