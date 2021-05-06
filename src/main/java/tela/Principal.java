/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.io.File;
import java.io.IOException;

/**
 * @author Felipe
 */
public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelPrincipal = new javax.swing.JPanel();
        btNovoChamado = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        arquivo = new javax.swing.JMenu();
        ajuda = new javax.swing.JMenuItem();
        editar = new javax.swing.JMenuItem();
        cadastro = new javax.swing.JMenu();
        novoChamado = new javax.swing.JMenuItem();
        pesquisaChamado = new javax.swing.JMenuItem();
        relatorios = new javax.swing.JMenu();
        sair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema XYZ");

        btNovoChamado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btNovoChamado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/imagem/call_icon_32.png"))); // NOI18N
        btNovoChamado.setText("Novo Chamado");
        btNovoChamado.setPreferredSize(new java.awt.Dimension(150, 60));
        btNovoChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoChamadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelPrincipalLayout = new javax.swing.GroupLayout(PainelPrincipal);
        PainelPrincipal.setLayout(PainelPrincipalLayout);
        PainelPrincipalLayout.setHorizontalGroup(
            PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelPrincipalLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btNovoChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(582, Short.MAX_VALUE))
        );
        PainelPrincipalLayout.setVerticalGroup(
            PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelPrincipalLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btNovoChamado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(328, Short.MAX_VALUE))
        );

        arquivo.setMnemonic('a');
        arquivo.setText("Arquivo");

        ajuda.setText("Ajuda");
        ajuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajudaActionPerformed(evt);
            }
        });
        arquivo.add(ajuda);

        editar.setText("Editar");
        arquivo.add(editar);

        jMenuBar1.add(arquivo);

        cadastro.setMnemonic('c');
        cadastro.setText("Cadastro");

        novoChamado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        novoChamado.setText("Novo Chamado");
        novoChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoChamadoActionPerformed(evt);
            }
        });
        cadastro.add(novoChamado);

        pesquisaChamado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        pesquisaChamado.setText("Pesquisar Chamado");
        pesquisaChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaChamadoActionPerformed(evt);
            }
        });
        cadastro.add(pesquisaChamado);

        jMenuBar1.add(cadastro);

        relatorios.setMnemonic('r');
        relatorios.setText("Relatórios");
        jMenuBar1.add(relatorios);

        sair.setMnemonic('s');
        sair.setText("Sair");
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });
        jMenuBar1.add(sair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajudaActionPerformed
        // File file = new File("./META-INF/arquivos/manual.pdf");
        File file = new File("./target/classes/META-INF/arquivos/manual.pdf");
        String absolutePath = file.getAbsolutePath();
//        JOptionPane.showMessageDialog(null, absolutePath);
        try {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            desktop.open(new File(absolutePath));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }//GEN-LAST:event_ajudaActionPerformed

    private void novoChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoChamadoActionPerformed
        new CadastroChamado().setVisible(true);
    }//GEN-LAST:event_novoChamadoActionPerformed

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        dispose();
    }//GEN-LAST:event_sairMouseClicked

    private void pesquisaChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaChamadoActionPerformed
        new PesquisaChamado().setVisible(true);
    }//GEN-LAST:event_pesquisaChamadoActionPerformed

    private void btNovoChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoChamadoActionPerformed
        new CadastroChamado().setVisible(true);
    }//GEN-LAST:event_btNovoChamadoActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelPrincipal;
    private javax.swing.JMenuItem ajuda;
    private javax.swing.JMenu arquivo;
    private javax.swing.JButton btNovoChamado;
    private javax.swing.JMenu cadastro;
    private javax.swing.JMenuItem editar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem novoChamado;
    private javax.swing.JMenuItem pesquisaChamado;
    private javax.swing.JMenu relatorios;
    private javax.swing.JMenu sair;
    // End of variables declaration//GEN-END:variables
}