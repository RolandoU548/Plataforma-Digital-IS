package com.plataforma_digital.views.components;

import javax.swing.JOptionPane;
import java.awt.Dimension;

import com.plataforma_digital.controllers.components.AddCommentController;
import com.plataforma_digital.models.Publication;

public class AddComment extends javax.swing.JPanel {
        private javax.swing.JButton cancelButton;
        private javax.swing.JTextField commentTextField;
        private javax.swing.JButton commentButton;
        private javax.swing.JLabel file3;
        private Publication publication;
        private CommentsContainer commentsContainer;
        private AddCommentController addCommentController;

        public AddComment(Publication publication, CommentsContainer commentsContainer) {
                this.publication = publication;
                this.commentsContainer = commentsContainer;
                this.addCommentController = new AddCommentController();
                setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
                initComponents();
        }

        private void initComponents() {
                file3 = new javax.swing.JLabel();
                commentTextField = new javax.swing.JTextField();
                cancelButton = new javax.swing.JButton();
                commentButton = new javax.swing.JButton();

                file3.setText("Comentarios");

                cancelButton.setText("Cancelar");

                commentButton.setBackground(new java.awt.Color(0, 0, 0));
                commentButton.setForeground(new java.awt.Color(255, 255, 255));
                commentButton.setText("Comentar");
                commentButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

                commentButton.addActionListener(e -> {
                        if (validateFields()) {
                                addCommentController.addComment(publication, commentTextField.getText());
                                commentsContainer.getComments();
                                clearFields();
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(commentTextField)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                layout.createSequentialGroup()
                                                                                                                .addGap(0, 252, Short.MAX_VALUE)
                                                                                                                .addComponent(cancelButton,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                100,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(commentButton,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                100,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                layout.createSequentialGroup()
                                                                                                                .addComponent(file3)
                                                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(file3)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(commentTextField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(cancelButton)
                                                                                .addComponent(commentButton))
                                                                .addContainerGap()));
        }

        private boolean validateFields() {
                if (commentTextField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Escribe un comentario", "Comentario requerido",
                                        JOptionPane.INFORMATION_MESSAGE);
                        return false;
                }
                return true;
        }

        private void clearFields() {
                commentTextField.setText("");
        }
}