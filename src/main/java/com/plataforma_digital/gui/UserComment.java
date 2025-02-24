package com.plataforma_digital.gui;

import com.plataforma_digital.entities.Comment;
import com.plataforma_digital.database.DatabaseConnection;

public class UserComment extends javax.swing.JPanel {
        private Comment comment;
        private javax.swing.JLabel commentText;
        private javax.swing.JLabel commentDate;
        private javax.swing.JLabel commentName;

        public UserComment(Comment comment) {
                this.comment = comment;
                initComponents();
        }

        private void initComponents() {
                commentName = new javax.swing.JLabel();
                commentText = new javax.swing.JLabel();
                commentDate = new javax.swing.JLabel();

                commentName.setFont(new java.awt.Font("Segoe UI", 1, 13));
                commentName.setText(DatabaseConnection.getInstance().getUserById(comment.getUserId()).getEmail());

                commentText.setText(comment.getText());
                commentText.setFont(new java.awt.Font("Segoe UI", 1, 11));

                commentDate.setFont(new java.awt.Font("Segoe UI", 0, 10));
                commentDate.setText(comment.getCreatedAt());

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(commentDate)
                                                                                .addComponent(commentName,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                133,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(commentText,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                465,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(commentName)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(commentDate)
                                                                .addGap(8, 8, 8)
                                                                .addComponent(commentText)
                                                                .addContainerGap(14, Short.MAX_VALUE)));
        }
}
