
package gerenciamentomoveis.view;


public class frmPrincipal extends javax.swing.JFrame {


    public frmPrincipal() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuImovel = new javax.swing.JMenuItem();
        menuProprietario = new javax.swing.JMenuItem();
        menuLocacao = new javax.swing.JMenuItem();
        menuInquilino = new javax.swing.JMenuItem();
        menuContrato = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuListaImoveis = new javax.swing.JMenuItem();
        menuListaLocacao = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Cadastros");

        menuImovel.setText("Imovel");
        menuImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuImovelActionPerformed(evt);
            }
        });
        jMenu1.add(menuImovel);

        menuProprietario.setText("Proprietário");
        menuProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProprietarioActionPerformed(evt);
            }
        });
        jMenu1.add(menuProprietario);

        menuLocacao.setText("Locação");
        menuLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLocacaoActionPerformed(evt);
            }
        });
        jMenu1.add(menuLocacao);

        menuInquilino.setText("Inquilino");
        menuInquilino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInquilinoActionPerformed(evt);
            }
        });
        jMenu1.add(menuInquilino);

        menuContrato.setText("Contrato");
        menuContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuContratoActionPerformed(evt);
            }
        });
        jMenu1.add(menuContrato);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Relatórios");

        menuListaImoveis.setText("Listagem de imóveis");
        menuListaImoveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListaImoveisActionPerformed(evt);
            }
        });
        jMenu2.add(menuListaImoveis);

        menuListaLocacao.setText("Listagem de locação");
        menuListaLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListaLocacaoActionPerformed(evt);
            }
        });
        jMenu2.add(menuListaLocacao);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 729, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProprietarioActionPerformed
        frmProprietario proprietario = new frmProprietario();
        proprietario.show();
    }//GEN-LAST:event_menuProprietarioActionPerformed

    private void menuInquilinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInquilinoActionPerformed
        frmInquilino inquilino = new frmInquilino();
        inquilino.show();
    }//GEN-LAST:event_menuInquilinoActionPerformed

    private void menuImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuImovelActionPerformed
        // TODO add your handling code here:
        frmImovel imovel = new frmImovel();
        imovel.show();
    }//GEN-LAST:event_menuImovelActionPerformed

    private void menuLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLocacaoActionPerformed
        // TODO add your handling code here:
        frmLocacao locacao = new frmLocacao();
        locacao.show();
    }//GEN-LAST:event_menuLocacaoActionPerformed

    private void menuContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuContratoActionPerformed
        frmContrato contrato = new frmContrato();
        contrato.show();        // TODO add your handling code here:
    }//GEN-LAST:event_menuContratoActionPerformed

    private void menuListaLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListaLocacaoActionPerformed
        // TODO add your handling code here:
        frmListagemLocacao listagemLocacao = new frmListagemLocacao();
        listagemLocacao.show();
    }//GEN-LAST:event_menuListaLocacaoActionPerformed

    private void menuListaImoveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListaImoveisActionPerformed
        frmListagemImoveis listagemImoveis = new frmListagemImoveis();
        listagemImoveis.show();
    }//GEN-LAST:event_menuListaImoveisActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuContrato;
    private javax.swing.JMenuItem menuImovel;
    private javax.swing.JMenuItem menuInquilino;
    private javax.swing.JMenuItem menuListaImoveis;
    private javax.swing.JMenuItem menuListaLocacao;
    private javax.swing.JMenuItem menuLocacao;
    private javax.swing.JMenuItem menuProprietario;
    // End of variables declaration//GEN-END:variables
}
