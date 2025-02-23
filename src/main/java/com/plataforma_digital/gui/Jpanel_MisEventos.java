package com.plataforma_digital.gui;

import com.plataforma_digital.config.Colors;

public class Jpanel_MisEventos extends javax.swing.JPanel {
    public Jpanel_MisEventos() {
        initComponents();
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jButton_Edit = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();
        jLabelFechainicio = new javax.swing.JLabel();
        jLabelFechaFin = new javax.swing.JLabel();
        jLabel_Feinicio = new javax.swing.JLabel();
        jLabel_FeFin = new javax.swing.JLabel();
        jLabel_Imagen = new javax.swing.JLabel();
        jLabel_Titulo = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jButton_Edit.setBackground(Colors.BACKGROUND_COLOR);
        jButton_Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Edit.png")));
        jButton_Edit.setBorderPainted(false);

        jButton_Delete.setBackground(Colors.BACKGROUND_COLOR);
        jButton_Delete.setIcon(new javax.swing.ImageIcon(getClass()
                .getResource("/delete-button-trash-can-bin-symbol-delete-web-icon-illustration-free-vector (1).jpg")));
        jButton_Delete.setText("jButton2");

        jLabelFechainicio.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabelFechainicio.setText("Fecha de Inicio");

        jLabelFechaFin.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabelFechaFin.setText("Fecha de Fin");

        jLabel_Feinicio.setText("15/12/24");

        jLabel_FeFin.setText("15/12/24");

        jLabel_Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Leuctra.inermis.-.lindsey (1).jpg")));
        jLabel_Imagen.setText("jLabel4");

        jLabel_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel_Titulo.setText("Charla sobre las plecopteras");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabelFechainicio)
                                                .addGap(44, 44, 44)
                                                .addComponent(jLabelFechaFin)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37,
                                                        Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(jLabel_Feinicio)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel_FeFin)
                                                .addGap(57, 57, 57)))
                                .addComponent(jButton_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 117,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel_Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_Titulo)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_Titulo)
                                        .addComponent(jLabel_Imagen, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelFechaFin)
                                                        .addComponent(jLabelFechainicio))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel_FeFin)
                                                        .addComponent(jLabel_Feinicio))
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jButton_Delete, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))));
        setVisible(true);
    }

    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_Edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFechaFin;
    private javax.swing.JLabel jLabelFechainicio;
    private javax.swing.JLabel jLabel_FeFin;
    private javax.swing.JLabel jLabel_Feinicio;
    private javax.swing.JLabel jLabel_Imagen;
    private javax.swing.JLabel jLabel_Titulo;
}
