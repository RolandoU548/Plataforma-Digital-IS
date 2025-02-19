package com.plataforma_digital.gui;

import javax.swing.JPanel;

public class Navigation extends JPanel {
        public Home home;
        private javax.swing.JButton ButtonAdd;
        private javax.swing.JButton ButtonBell;
        private javax.swing.JButton ButtonCalendar;
        private javax.swing.JButton ButtonEye;
        private javax.swing.JButton ButtonHome;
        private javax.swing.JPanel jPanel1;

        public Navigation(Home home) {
                initComponents();
        }

        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                ButtonHome = new javax.swing.JButton();
                ButtonBell = new javax.swing.JButton();
                ButtonCalendar = new javax.swing.JButton();
                ButtonEye = new javax.swing.JButton();
                ButtonAdd = new javax.swing.JButton();

                jPanel1.setBackground(new java.awt.Color(0, 0, 0));

                ButtonHome.setBackground(new java.awt.Color(0, 0, 0));
                ButtonHome.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/Home.png")));
                ButtonHome.setBorderPainted(false);

                ButtonBell.setBackground(new java.awt.Color(0, 0, 0));
                ButtonBell.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/Bell1.png")));
                ButtonBell.setBorderPainted(false);

                ButtonCalendar.setBackground(new java.awt.Color(0, 0, 0));
                ButtonCalendar.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/Calendar.png")));
                ButtonCalendar.setBorderPainted(false);

                ButtonEye.setBackground(new java.awt.Color(0, 0, 0));
                ButtonEye.setIcon(
                                new javax.swing.ImageIcon(
                                                getClass().getResource("/Eye.png")));
                ButtonEye.setBorderPainted(false);

                ButtonAdd.setBackground(new java.awt.Color(0, 0, 0));
                ButtonAdd.setIcon(
                                new javax.swing.ImageIcon(
                                                getClass().getResource("/Add.png")));
                ButtonAdd.setBorderPainted(false);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(ButtonHome,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                30,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(ButtonBell,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                30,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(ButtonCalendar,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                30,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(ButtonEye,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                30,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(ButtonAdd,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                30,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(15, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(49, 49, 49)
                                                                .addComponent(ButtonHome,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(ButtonBell,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(ButtonCalendar,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(ButtonEye,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                172, Short.MAX_VALUE)
                                                                .addComponent(ButtonAdd,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(36, 36, 36)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        }
}
