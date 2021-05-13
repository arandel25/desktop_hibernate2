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
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Felipe
 */
public class CadastroChamado extends javax.swing.JFrame {

    private Session session;
    private Chamado chamado;
    private ChamadoDao chamadoDao;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");

    public CadastroChamado() {
        initComponents();
        labelDataCadastro.setText(dateFormat.format(new Date()));
        chamadoDao = new ChamadoDaoImpl();
    }

    public CadastroChamado(Chamado chamado) {
        initComponents();
        chamadoDao = new ChamadoDaoImpl();
        this.chamado = chamado;
        janelaAlterar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        dataCadastro = new javax.swing.JLabel();
        labelDataCadastro = new javax.swing.JLabel();
        equipamento = new javax.swing.JLabel();
        descricao = new javax.swing.JLabel();
        tfEquipamento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfDescricao = new javax.swing.JTextArea();
        btLimpar = new javax.swing.JButton();
        jLSituacao1 = new javax.swing.JLabel();
        jLSituacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Chamado");

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Cadastro de Chamado");

        btSalvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setPreferredSize(new java.awt.Dimension(90, 25));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        dataCadastro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dataCadastro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dataCadastro.setText("Data Cadastro: ");

        labelDataCadastro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelDataCadastro.setText(" ");

        equipamento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        equipamento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        equipamento.setText("Equipamentro:*");

        descricao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        descricao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        descricao.setText("Descrição:*");

        tfEquipamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfEquipamento.setText(" ");

        tfDescricao.setColumns(20);
        tfDescricao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfDescricao.setRows(5);
        jScrollPane1.setViewportView(tfDescricao);

        btLimpar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.setPreferredSize(new java.awt.Dimension(90, 25));
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        jLSituacao1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLSituacao1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLSituacao1.setText("Situação: ");

        jLSituacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLSituacao.setText(" ");

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                            .addGap(205, 205, 205)
                            .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(57, 57, 57))
                        .addGroup(painelPrincipalLayout.createSequentialGroup()
                            .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1))
                        .addGroup(painelPrincipalLayout.createSequentialGroup()
                            .addComponent(equipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLSituacao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dataCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelDataCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(jLSituacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSituacao1)
                    .addComponent(jLSituacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataCadastro)
                    .addComponent(labelDataCadastro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(equipamento)
                    .addComponent(tfEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descricao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (validarCampo()) {
            session = HibernateUtil.abrirConexao();
            String mensagem = "";
            try {
                if (chamado == null) {
                    mensagem = "Salvar";
                    chamado = new Chamado(null, new Date(), tfEquipamento.getText().trim(), tfDescricao.getText().trim());
                    JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
                } else {
                    mensagem = "Alterar";
                    chamado.setDescricao(tfDescricao.getText());
                    chamado.setEquipamento(tfEquipamento.getText());
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
                    janelaSalvar();
                }
                chamadoDao.salvarOuAlterar(chamado, session);
            } catch (HeadlessException | HibernateException e) {
                JOptionPane.showMessageDialog(null, "Erro ao " + mensagem);
                System.err.println(e.getMessage());
            } finally {
                chamado = null;
                session.close();
                limpar();
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void janelaAlterar() {
        labelDataCadastro.setText(dateFormat.format(chamado.getCadastro()));
        tfEquipamento.setText(chamado.getEquipamento());
        tfDescricao.setText(chamado.getDescricao());
        btSalvar.setText("Alterar");
        jLabelTitulo.setText("Alterar Chamado");
        setTitle("Alterar Chamado");
        jLSituacao.setVisible(true);
        jLSituacao1.setVisible(true);
        jLSituacao.setText(chamado.isAtivo() ? "Aberto" : "Encerrado");
    }

    private void janelaSalvar() {
        btSalvar.setText("Salvar");
        jLabelTitulo.setText("Cadastro de Chamado");
        labelDataCadastro.setText(dateFormat.format(new Date()));
        setTitle("Cadastro de Chamado");
        jLSituacao.setVisible(false);
        jLSituacao1.setVisible(false);
    }

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btLimparActionPerformed

    private boolean validarCampo() {
        String mensagem = "";
        boolean erro = true;
        if (tfEquipamento.getText().trim().length() < 2) {
            mensagem += "Campo equipamento é obrigatório!\n";
            erro = false;
        }
        if (tfDescricao.getText().trim().length() < 6) {
            mensagem += "Campo descrição é obrigatório!";
            erro = false;
        }
        if (!erro) {
            JOptionPane.showMessageDialog(null, mensagem);
        }
        return erro;
    }

    private void limpar() {
        tfEquipamento.setText("");
        tfDescricao.setText("");
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CadastroChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroChamado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel dataCadastro;
    private javax.swing.JLabel descricao;
    private javax.swing.JLabel equipamento;
    private javax.swing.JLabel jLSituacao;
    private javax.swing.JLabel jLSituacao1;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDataCadastro;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JTextArea tfDescricao;
    private javax.swing.JTextField tfEquipamento;
    // End of variables declaration//GEN-END:variables
}
