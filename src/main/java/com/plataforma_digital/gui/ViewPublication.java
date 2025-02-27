package com.plataforma_digital.gui;

import com.plataforma_digital.config.Colors;
import com.plataforma_digital.entities.Publication;
import com.plataforma_digital.gui.components.CommentsSection;
import com.plataforma_digital.gui.components.ProfileButton;
import com.plataforma_digital.database.UserDao;
import com.plataforma_digital.database.impl.UserDaoImpl;

public class ViewPublication extends javax.swing.JPanel {
        private Home home;
        private Publication event;
        private javax.swing.JLabel author;
        private javax.swing.JButton backButton;
        private javax.swing.JButton createEventButton;
        private javax.swing.JLabel description;
        private javax.swing.JLabel image;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JLabel mainTitle;
        private javax.swing.JButton myEvents;
        private javax.swing.JButton notification;
        private ProfileButton profile;
        private CommentsSection commentsSection;

        public ViewPublication(Home home, Publication event) {
                this.home = home;
                this.event = event;
                initComponents();
        }

        private void initComponents() {
                mainTitle = new javax.swing.JLabel();
                author = new javax.swing.JLabel();
                description = new javax.swing.JLabel();
                jPanel1 = new javax.swing.JPanel();
                backButton = new javax.swing.JButton();
                createEventButton = new javax.swing.JButton();
                myEvents = new javax.swing.JButton();
                notification = new javax.swing.JButton();
                profile = new ProfileButton(home);
                image = new javax.swing.JLabel();

                commentsSection = new CommentsSection(event);
                jScrollPane1 = new javax.swing.JScrollPane(commentsSection);
                jScrollPane1.setBorder(null);

                mainTitle.setFont(new java.awt.Font("Segoe UI", 1, 30));
                mainTitle.setText(event.getTitle());

                UserDao userDao = new UserDaoImpl();
                author.setFont(new java.awt.Font("Segoe UI", 1, 15));
                author.setText("Autor: "
                                + userDao.getUserById(event.getUserId()).getEmail());

                description.setFont(new java.awt.Font("Segoe UI", 1, 15));
                description.setText("Descripción: " + event.getDescription());

                jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

                backButton.setBackground(Colors.BACKGROUND_COLOR);
                backButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
                backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arrow.png")));
                backButton.setText("Eventos");
                backButton.setBorder(null);
                backButton.setBorderPainted(false);
                backButton.setIconTextGap(30);

                createEventButton.setBackground(Colors.BACKGROUND_COLOR);
                createEventButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
                createEventButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plain.png")));
                createEventButton.setText("Crear Evento");
                createEventButton.setBorder(null);
                createEventButton.setBorderPainted(false);
                createEventButton.setIconTextGap(10);
                createEventButton.addActionListener(e -> {
                        CreateEvent createEvent = new CreateEvent(home);
                        home.createEvent = createEvent;
                        home.addAndShowPanel(createEvent, "createEvent");
                });

                myEvents.setBackground(Colors.BACKGROUND_COLOR);
                myEvents.setFont(new java.awt.Font("Segoe UI", 1, 14));
                myEvents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder.png")));
                myEvents.setText("Mis Eventos");
                myEvents.setBorder(null);
                myEvents.setBorderPainted(false);
                myEvents.setIconTextGap(10);
                myEvents.addActionListener(e -> {
                        ViewAllEvents viewAllEvents = new ViewAllEvents(home);
                        home.viewAllEvents = viewAllEvents;
                        home.addAndShowPanel(viewAllEvents, "viewAllEvents");
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                false)
                                                                                .addComponent(backButton,
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(createEventButton,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(myEvents,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE))))
                                                                .addContainerGap(9, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(backButton)
                                                                .addGap(40, 40, 40)
                                                                .addComponent(createEventButton)
                                                                .addGap(32, 32, 32)
                                                                .addComponent(myEvents)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                notification.setBackground(Colors.BACKGROUND_COLOR);
                notification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bell3.png")));
                notification.setBorder(null);
                notification.setBorderPainted(false);
                notification.setIconTextGap(0);

                image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images.jpg")));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(44, 44, 44)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(mainTitle)
                                                                                                                                .addGap(12, 12, 12)
                                                                                                                                .addComponent(notification,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                42,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                .addComponent(profile))
                                                                                                                .addComponent(author)
                                                                                                                .addComponent(description)
                                                                                                                .addComponent(image)))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(12, 12, 12)
                                                                                                .addComponent(jScrollPane1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                525,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(0, 33, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(mainTitle)
                                                                                .addComponent(notification)
                                                                                .addComponent(profile))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(author)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(description)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(image,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                141,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                122,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(24, Short.MAX_VALUE)));
        }

}
