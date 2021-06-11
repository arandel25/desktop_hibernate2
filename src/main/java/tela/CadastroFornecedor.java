/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.FornecedorDao;
import dao.FornecedorDaoImpl;
import dao.HibernateUtil;
import entidade.Endereco;
import entidade.Fornecedor;
import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import web_service.EnderecoWebService;

/**
 *
 * @author Felipe
 */
public class CadastroFornecedor extends javax.swing.JFrame {

    private Fornecedor fornecedor;
    private FornecedorDao fornecedorDao;
    private Session sessao;
    private Endereco endereco;

    public CadastroFornecedor() {
        initComponents();
    }

    public CadastroFornecedor(Session sessao) {
        this.sessao = sessao;
        initComponents();
    }

    public CadastroFornecedor(Session sessao, Fornecedor fornecedor) {
        this.sessao = sessao;
        this.fornecedor = fornecedor;
        initComponents();
        tfNome.setText(this.fornecedor.getNome());
        taDescricao.setText(this.fornecedor.getDescricao());
        btSalvar.setText("Alterar");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        btSalvar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btEndereco = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlLogradouro = new javax.swing.JLabel();
        jlBairro = new javax.swing.JLabel();
        jlCidade = new javax.swing.JLabel();
        jlEstado = new javax.swing.JLabel();
        tfCep = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Fornecedor");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Fornecedor");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        tfNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Descrição:");

        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        jScrollPane1.setViewportView(taDescricao);

        btSalvar.setText("Salvar");
        btSalvar.setPreferredSize(new java.awt.Dimension(90, 25));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btLimpar.setText("Limpar");
        btLimpar.setPreferredSize(new java.awt.Dimension(90, 25));
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Endereço");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("CEP:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Logradouro:");

        btEndereco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btEndereco.setText("Buscar Endereço");
        btEndereco.setPreferredSize(new java.awt.Dimension(90, 25));
        btEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnderecoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Bairro:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Cidade:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Estado:");

        jlLogradouro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlLogradouro.setText(" ");

        jlBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlBairro.setText(" ");
        jlBairro.setMaximumSize(new java.awt.Dimension(200, 17));
        jlBairro.setMinimumSize(new java.awt.Dimension(50, 17));

        jlCidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlCidade.setText(" ");

        jlEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlEstado.setText(" ");

        try {
            tfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelPrincipalLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelPrincipalLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                                        .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(138, 138, 138))
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(58, 58, 58))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9))
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(jlLogradouro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlEstado)))
                .addGap(35, 35, 35)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 499, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnderecoActionPerformed
        EnderecoWebService webService = new EnderecoWebService();
        endereco = webService.pesquisaCep(tfCep.getText().replace("-", ""));
        if (endereco != null) {
            jlBairro.setText(endereco.getBairro());
            jlCidade.setText(endereco.getLocalidade());
            jlEstado.setText(endereco.getUf());
            jlLogradouro.setText(endereco.getLogradouro());
        } else {
            JOptionPane.showMessageDialog(null, "CEP não encontrado");
        }
    }//GEN-LAST:event_btEnderecoActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        tfNome.setText("");
        taDescricao.setText("");
        jlBairro.setText("");
        jlCidade.setText("");
        jlEstado.setText("");
        jlLogradouro.setText("");
        tfCep.setText("");
        endereco = null;
    }//GEN-LAST:event_btLimparActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (verificarCampo()) {
            fornecedorDao = new FornecedorDaoImpl();

            if (fornecedor == null) {
                btSalvar.setText("Salvar");
                fornecedor = new Fornecedor(null, tfNome.getText(),
                        new Date(),
                        taDescricao.getText());
                fornecedor.setEndereco(endereco);
                endereco.setFornecedor(fornecedor);
            } else {
                fornecedor.setNome(tfNome.getText());
                fornecedor.setDescricao(taDescricao.getText());
                fornecedor.setEndereco(endereco);
                endereco.setFornecedor(fornecedor);
            }
            sessao = HibernateUtil.abrirConexao();
            try {
                fornecedorDao.salvarOuAlterar(fornecedor, sessao);
                JOptionPane.showMessageDialog(null,
                        fornecedor.getNome() + " salvo com sucesso");
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, "erro ao salvar "
                        + fornecedor.getNome());
            } finally {
                sessao.close();
            }
            tfNome.setText("");
            taDescricao.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Campo nome é obrigatório");
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tfCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCepActionPerformed
    private boolean verificarCampo() {
        if (tfNome.getText().length() < 3) {
            return false;
        }
        return true;
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
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEndereco;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlBairro;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlLogradouro;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JFormattedTextField tfCep;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
