package com.plataforma_digital.views;

import java.awt.Color;
import javax.swing.*;
import com.plataforma_digital.controllers.NavigationController;

public class Navigation extends JPanel {
        public Home home;
        private NavigationController navigationController;
        private JButton ButtonAdd;
        private JButton ButtonEvent;
        private JButton ButtonCalendar;
        private JButton ButtonEye;
        private JButton ButtonHome;
        private JPanel jPanel1;
        public Navigation(Home home) {
                this.home = home;
                this.navigationController = new NavigationController(home);
                initComponents();
        }

        private void initComponents() {
                jPanel1 = new JPanel();
                ButtonHome = new JButton();
                ButtonEvent = new JButton();
                ButtonCalendar = new JButton();
                ButtonEye = new JButton();
                ButtonAdd = new JButton();

                jPanel1.setBackground(Color.BLACK);

                ButtonHome.setBackground(Color.BLACK);
                ButtonHome.setIcon(new ImageIcon(getClass().getResource("/Home.png")));
                ButtonHome.setBorderPainted(false);
                ButtonHome.addActionListener(e -> navigationController.showViewAllPublications());

                ButtonEvent.setBackground(Color.BLACK);
                ButtonEvent.setIcon(new ImageIcon(getClass().getResource("/AddEvent.png")));
                ButtonEvent.setBorderPainted(false);
                ButtonEvent.addActionListener(e -> navigationController.showCreateEvent());

                ButtonCalendar.setBackground(Color.BLACK);
                ButtonCalendar.setIcon(new ImageIcon(getClass().getResource("/Calendar.png")));
                ButtonCalendar.setBorderPainted(false);
                ButtonCalendar.addActionListener(e -> navigationController.showEventsCalendar());

                ButtonEye.setBackground(Color.BLACK);
                ButtonEye.setIcon(new ImageIcon(getClass().getResource("/Eye.png")));
                ButtonEye.setBorderPainted(false);
                ButtonEye.addActionListener(e -> navigationController.showModeration());

                ButtonAdd.setBackground(Color.BLACK);
                ButtonAdd.setIcon(new ImageIcon(getClass().getResource("/Add.png")));
                ButtonAdd.setBorderPainted(false);
                ButtonAdd.addActionListener(e -> navigationController.showCreatePublication());

                GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addComponent(ButtonHome,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                30,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(ButtonEvent,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                30,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(ButtonCalendar,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                30,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(ButtonEye,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                30,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(ButtonAdd,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                30,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(15, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(49, 49, 49)
                                                                .addComponent(ButtonHome,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(ButtonEvent,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(ButtonCalendar,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(ButtonEye,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED,
                                                                                172,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(ButtonAdd,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(36, 36, 36)));

                GroupLayout layout = new GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, GroupLayout.Alignment.TRAILING,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE));
        }
}