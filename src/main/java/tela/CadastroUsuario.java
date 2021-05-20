/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.HibernateUtil;
import dao.PerfilDao;
import dao.PerfilDaoImpl;
import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import entidade.Perfil;
import entidade.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.EnviarEmail;
import util.UtilGerador;

/**
 * @author Felipe
 */
public class CadastroUsuario extends javax.swing.JFrame {

    private Session session;
    private PerfilDao perfilDao;
    private List<Perfil> perfils;
    private Usuario usuario;
    private UsuarioDao usuarioDao;

    public CadastroUsuario() {
        initComponents();
        carregarComboPerfil();
        usuarioDao = new UsuarioDaoImpl();
    }

    public CadastroUsuario(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        carregarComboPerfil();
        usuarioDao = new UsuarioDaoImpl();
        telaAlterar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        equipamento = new javax.swing.JLabel();
        descricao = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        btLimpar = new javax.swing.JButton();
        tfLogin = new javax.swing.JTextField();
        equipamento1 = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuário");

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Cadastro de Usuário");

        btSalvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setPreferredSize(new java.awt.Dimension(90, 25));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        equipamento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        equipamento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        equipamento.setText("Nome:");

        descricao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        descricao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        descricao.setText("Login:");

        tfNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btLimpar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.setPreferredSize(new java.awt.Dimension(90, 25));
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        tfLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        equipamento1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        equipamento1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        equipamento1.setText("Perfil:");

        jComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(equipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(equipamento1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(equipamento)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descricao)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(equipamento1)
                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
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
            carregarUsuario();
            try {
                session = HibernateUtil.abrirConexao();
                usuarioDao.salvarOuAlterar(usuario, session);
                EnviarEmail enviarEmail = new EnviarEmail();
                enviarEmail.criarEmailUsuarioNovo(usuario);
                JOptionPane.showMessageDialog(null, "Operação feita com sucesso");
                limpar();
            } catch (HibernateException e) {
                if (e.getCause().toString().contains("usuario_email")) {
                    JOptionPane.showMessageDialog(null, "E-mail já utilizado!");
                } else {
                    JOptionPane.showMessageDialog(null, "Operação não realizada!");
                }
                System.err.println("Causa" + e.getCause());
            } finally {
                session.close();
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void carregarUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
            usuario.setSenha(UtilGerador.gerarCaracter(4));
            usuario.setAtivo(true);
        }
        usuario.setNome(tfNome.getText().trim());
        usuario.setLogin(tfLogin.getText().trim());
        usuario.setPerfil(perfils.get(jComboBox.getSelectedIndex() - 1));
    }

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limpar();
        telaSalvar();
    }//GEN-LAST:event_btLimparActionPerformed

    private void limpar() {
        tfLogin.setText("");
        tfNome.setText("");
        jComboBox.setSelectedIndex(0);
        telaSalvar();
    }

    private boolean validarCampo() {
        String mensagem = "";
        boolean erro = true;
        String login = tfLogin.getText().trim();
        if (login.length() < 5 || !login.contains("@")) {
            mensagem += "Campo login é obrigatório!\nDigite seu e-mail!\n";
            erro = false;
        }
        if (tfNome.getText().trim().length() < 3) {
            mensagem += "Campo nome é obrigatório!";
            erro = false;
        }
        if (jComboBox.getSelectedIndex() < 1) {
            mensagem += "Selecione um perfil";
            erro = false;
        }
        if (!erro) {
            JOptionPane.showMessageDialog(null, mensagem);
        }
        return erro;
    }

    private void carregarComboPerfil() {
        perfilDao = new PerfilDaoImpl();
        try {
            session = HibernateUtil.abrirConexao();
            perfils = perfilDao.pesquisarPerfil(session);
        } catch (HibernateException e) {
            System.err.println("Erro carregar comboBox perfil" + e.getMessage());
        } finally {
            session.close();
        }
        jComboBox.addItem("Selecione uma opção");

        for (Perfil perfil : perfils) {
            jComboBox.addItem(perfil.getNome());
        }
    }

    private void telaSalvar() {
        setTitle("Cadastro Usuário");
        jLabelTitulo.setText("Cadastro de usuário");
        btSalvar.setText("Salvar");
        usuario = null;
    }

    private void telaAlterar() {
        setTitle("Alterar Usuário");
        jLabelTitulo.setText("Alterar Usuário");
        btSalvar.setText("Alterar");
        jComboBox.setSelectedItem(usuario.getPerfil().getNome());
        tfLogin.setText(usuario.getLogin());
        tfNome.setText(usuario.getNome());
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
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel descricao;
    private javax.swing.JLabel equipamento;
    private javax.swing.JLabel equipamento1;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

}
