/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import java.awt.Color;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author tanysha
 */
public class MainMenu extends javax.swing.JFrame {
    
   private CategoryPanel categoryP = new CategoryPanel();
   private HistoryPanel historyP = new HistoryPanel();
   private PersonnelPanel personelP = new PersonnelPanel();
   
   String path=System.getProperty("user.dir");
     private int FORM_WIDTH =1000;
     private int FORM_HEIGHT = 500;
    /**
     * Creates new form MainMenu
     */
   
    public MainMenu() {
        
       
       // jPanel1=new NumberPanel();
        this.add(categoryP);
         this.pack();
        this.add(historyP);
         this.pack();
        this.add(personelP);
        this.pack();
        this.setSize(FORM_WIDTH, FORM_HEIGHT);
        historyP.setVisible(false);
        personelP.setVisible(false);
        this.getContentPane().setBackground(Color.getHSBColor(276,9,95));
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(path+"\\src\\main\\java\\manager\\image\\pizza.png"));
        initComponents();
        
        setVisible(true);
        
                
                
        
        //System.out.print(path);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void empty(){
        categoryP.setVisible(false);
        historyP.setVisible(false);
        personelP.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        viewCategory = new javax.swing.JMenuItem();
        deleteCategory = new javax.swing.JMenuItem();
        addCategory = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        viewPersonnel = new javax.swing.JMenuItem();
        searchPersonel = new javax.swing.JMenuItem();
        addPersonnel = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        history = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        changePassword = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        support = new javax.swing.JMenuItem();
        about = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager");
        setName("frame"); // NOI18N

        jMenu1.setText("Category");

        viewCategory.setIcon(new javax.swing.ImageIcon(path+"\\src\\main\\java\\manager\\image\\view1.png"));
        viewCategory.setText("view");
        viewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCategoryActionPerformed(evt);
            }
        });
        jMenu1.add(viewCategory);

        deleteCategory.setIcon(new javax.swing.ImageIcon(path+"\\src\\main\\java\\manager\\image\\delete.png"));
        deleteCategory.setText("delette");
        deleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCategoryActionPerformed(evt);
            }
        });
        jMenu1.add(deleteCategory);

        addCategory.setIcon(new javax.swing.ImageIcon(path+"\\src\\main\\java\\manager\\image\\add.png"));
        addCategory.setText("add category");
        addCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCategoryActionPerformed(evt);
            }
        });
        jMenu1.add(addCategory);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Personnel");

        viewPersonnel.setIcon(new javax.swing.ImageIcon(path+"\\src\\main\\java\\manager\\image\\view.png"));
        viewPersonnel.setText("view");
        viewPersonnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPersonnelActionPerformed(evt);
            }
        });
        jMenu4.add(viewPersonnel);

        searchPersonel.setIcon(new javax.swing.ImageIcon(path+"\\src\\main\\java\\manager\\image\\search.png"));
        searchPersonel.setText("search");
        jMenu4.add(searchPersonel);

        addPersonnel.setIcon(new javax.swing.ImageIcon(path+"\\src\\main\\java\\manager\\image\\add.png"));
        addPersonnel.setText("add");
        addPersonnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPersonnelActionPerformed(evt);
            }
        });
        jMenu4.add(addPersonnel);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Custom");

        history.setIcon(new javax.swing.ImageIcon(path+"\\src\\main\\java\\manager\\image\\history.png"));
        history.setText("history");
        history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyActionPerformed(evt);
            }
        });
        jMenu5.add(history);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Settings");

        changePassword.setIcon(new javax.swing.ImageIcon(path+"\\src\\main\\java\\manager\\image\\pw.png"));
        changePassword.setText("change password");
        changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordActionPerformed(evt);
            }
        });
        jMenu6.add(changePassword);

        jMenuBar1.add(jMenu6);

        jMenu2.setText("Help");

        support.setIcon(new javax.swing.ImageIcon(path+"\\src\\main\\java\\manager\\image\\support.png"));
        support.setText("support");
        support.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supportActionPerformed(evt);
            }
        });
        jMenu2.add(support);

        about.setIcon(new javax.swing.ImageIcon(path+"\\src\\main\\java\\manager\\image\\about.png"));
        about.setText("about");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        jMenu2.add(about);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Exit");

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        exit.setIcon(new javax.swing.ImageIcon(path+"\\src\\main\\java\\manager\\image\\close.png"));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu3.add(exit);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void visability(){
      //  categoryPanel1.setVisible(false);
  }
    private void viewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCategoryActionPerformed
        // TODO add your handling code here:
      //  categoryPanel1.setVisible(true);
        empty();
        categoryP.setVisible(true);
	
        
        
    }//GEN-LAST:event_viewCategoryActionPerformed

    private void supportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supportActionPerformed
        // TODO add your handling code here:
        new SupportFrame().setVisible(true);
        
    }//GEN-LAST:event_supportActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
       this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        // TODO add your handling code here:
        new AboutFrame().setVisible(true);
    }//GEN-LAST:event_aboutActionPerformed

    private void changePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordActionPerformed
        // TODO add your handling code here:
        new ChangePasswordFrame().setVisible(true);
    }//GEN-LAST:event_changePasswordActionPerformed

   
    private void historyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyActionPerformed
        // TODO add your handling code here:
             
        empty();
        historyP.setVisible(true);
                
                
    }//GEN-LAST:event_historyActionPerformed

    private void viewPersonnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPersonnelActionPerformed
        // TODO add your handling code here:
        empty();
        personelP.setVisible(true);
    }//GEN-LAST:event_viewPersonnelActionPerformed

    private void addCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCategoryActionPerformed
        // TODO add your handling code here:
        new AddCategoryFrame().setVisible(true);
    }//GEN-LAST:event_addCategoryActionPerformed

    private void addPersonnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPersonnelActionPerformed
        // TODO add your handling code here:
        new AddPersonnelFrame().setVisible(true);
    }//GEN-LAST:event_addPersonnelActionPerformed

    private void deleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCategoryActionPerformed
        // TODO add your handling code here:
        new DeleteCategoryFrame().setVisible(true);
    }//GEN-LAST:event_deleteCategoryActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JMenuItem addCategory;
    private javax.swing.JMenuItem addPersonnel;
    private javax.swing.JMenuItem changePassword;
    private javax.swing.JMenuItem deleteCategory;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenuItem history;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem searchPersonel;
    private javax.swing.JMenuItem support;
    private javax.swing.JMenuItem viewCategory;
    private javax.swing.JMenuItem viewPersonnel;
    // End of variables declaration//GEN-END:variables
   
}
