package com.plataforma_digital.views;

import javax.swing.JOptionPane;

import com.plataforma_digital.models.Publication;
import com.plataforma_digital.views.components.ProfileButton;
import com.plataforma_digital.config.Colors;
import com.plataforma_digital.controllers.EditPublicationController;

public class EditPublication extends javax.swing.JPanel {
    private javax.swing.JLabel LabelAgregarArchivo;
    private javax.swing.JLabel LabelDescription;
    private javax.swing.JLabel LabelMainTitle;
    private javax.swing.JLabel LabelTitle;
    private javax.swing.JButton jButtonAttachment;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonCrearPublicacion;
    private javax.swing.JButton jButtonMisPublicaciones;
    private javax.swing.JButton jButtonPublicar;
    private ProfileButton jButtonUser;
    private javax.swing.JCheckBox jCheckBoxRealizarCambios;
    private javax.swing.JLabel jLabelNombreArchivo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldTitulo; 
    private Home home;
    private Publication publication;
    private EditPublicationController editPublicationController;

    public EditPublication(Home home, Publication publication) {
        this.home = home;
        this.publication = publication;
        this.editPublicationController = new EditPublicationController();
        initComponents();
    }
                        
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jButtonBack = new javax.swing.JButton();
        jButtonCrearPublicacion = new javax.swing.JButton();
        jButtonMisPublicaciones = new javax.swing.JButton();
        LabelMainTitle = new javax.swing.JLabel();
        LabelTitle = new javax.swing.JLabel();
        LabelDescription = new javax.swing.JLabel();
        LabelAgregarArchivo = new javax.swing.JLabel();
        jLabelNombreArchivo = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jCheckBoxRealizarCambios = new javax.swing.JCheckBox();
        jButtonAttachment = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonPublicar = new javax.swing.JButton();
        jButtonUser = new ProfileButton(home);

        jTextFieldDescripcion.setText(publication.getDescription());
        jTextFieldTitulo.setText(publication.getTitle());

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonBack.setBackground(Colors.BACKGROUND_COLOR);
        jButtonBack.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arrow.png")));
        jButtonBack.setText(" Publicaciones");
        jButtonBack.setBorderPainted(false);

        jButtonCrearPublicacion.setBackground(Colors.BACKGROUND_COLOR);
        jButtonCrearPublicacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        jButtonCrearPublicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plain.png")));
        jButtonCrearPublicacion.setText("Crear Publicación");
        jButtonCrearPublicacion.setBorder(null);
        jButtonCrearPublicacion.setBorderPainted(false);
        jButtonCrearPublicacion.setIconTextGap(10);
        jButtonCrearPublicacion.addActionListener(e ->
        {
            CreatePublication createPublication = new CreatePublication(home);
                        home.createPublication = createPublication;
                        home.addAndShowPanel(createPublication, "createPublication");
        });

        jButtonMisPublicaciones.setBackground(Colors.BACKGROUND_COLOR);
        jButtonMisPublicaciones.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButtonMisPublicaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Folder.png")));
        jButtonMisPublicaciones.setText("Mis Publicaciones");
        jButtonMisPublicaciones.setBorder(null);
        jButtonMisPublicaciones.setBorderPainted(false);
        jButtonMisPublicaciones.setIconTextGap(10);
        jButtonMisPublicaciones.addActionListener(e ->
        {
            ViewAllPublications viewAllPublications = new ViewAllPublications(home);
                        home.viewAllPublications = viewAllPublications;
                        home.addAndShowPanel(viewAllPublications, "viewAllPublications");
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBack)
                    .addComponent(jButtonMisPublicaciones)
                    .addComponent(jButtonCrearPublicacion))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButtonBack)
                .addGap(45, 45, 45)
                .addComponent(jButtonCrearPublicacion)
                .addGap(18, 18, 18)
                .addComponent(jButtonMisPublicaciones)
                .addContainerGap(270, Short.MAX_VALUE))
        );

        LabelMainTitle.setFont(new java.awt.Font("Segoe UI", 1, 30));
        LabelMainTitle.setText("Editar Publicación");

        LabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 15));
        LabelTitle.setText("Título");

        LabelDescription.setFont(new java.awt.Font("Segoe UI", 1, 15));
        LabelDescription.setText("Descripción");

        LabelAgregarArchivo.setFont(new java.awt.Font("Segoe UI", 1, 15));
        LabelAgregarArchivo.setText("Agregar Archivo");

        jLabelNombreArchivo.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabelNombreArchivo.setText("Nombre Archivo");

        jCheckBoxRealizarCambios.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jCheckBoxRealizarCambios.setText("Seguro que quieres realizar estos cambios?");
        jCheckBoxRealizarCambios.setBorderPainted(true);
        jCheckBoxRealizarCambios.setIconTextGap(7);
        jCheckBoxRealizarCambios.setMargin(new java.awt.Insets(2, 6, 2, 6));

        jButtonAttachment.setBackground(Colors.BACKGROUND_COLOR);
        jButtonAttachment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Attachment.png")));
        jButtonAttachment.setBorderPainted(false);

        jButtonCancel.setBackground(new java.awt.Color(204, 204, 204));
        jButtonCancel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButtonCancel.setText("Cancelar");

        jButtonPublicar.setBackground(new java.awt.Color(51, 51, 51));
        jButtonPublicar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButtonPublicar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPublicar.setText("Guardar");
        jButtonPublicar.setBorderPainted(false);
        jButtonPublicar.addActionListener(e -> {
            if (validateFields()) {
                editPublicationController.updatePublication(publication.getId(), publication.getUserId(), jTextFieldTitulo.getText(), jTextFieldDescripcion.getText(), publication.getState(), publication.getCreatedAt());
                JOptionPane.showMessageDialog(null, "La publicación se han actualizado!", "Datos actualizados",
                JOptionPane.INFORMATION_MESSAGE);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelMainTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonUser, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelTitle)
                                    .addComponent(LabelDescription)
                                    .addComponent(LabelAgregarArchivo))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextFieldDescripcion)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBoxRealizarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                        .addComponent(jButtonPublicar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)))))
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButtonAttachment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelNombreArchivo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelMainTitle)
                    .addComponent(jButtonUser))
                .addGap(41, 41, 41)
                .addComponent(LabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelAgregarArchivo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAttachment))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabelNombreArchivo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBoxRealizarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonPublicar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
    }
                                                           
    private boolean validateFields() {
                if (jTextFieldDescripcion.getText().isEmpty()
                                || jTextFieldTitulo.getText().isEmpty()
                                || !jCheckBoxRealizarCambios.isSelected()) {
                        JOptionPane.showMessageDialog(null, "Todos los campos son requeridos", "Campos requeridos",
                                        JOptionPane.INFORMATION_MESSAGE);
                        return false;
                }
                return true;
    }
                
                 
}
