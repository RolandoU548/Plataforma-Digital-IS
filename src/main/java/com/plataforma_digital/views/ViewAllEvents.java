package com.plataforma_digital.views;

import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Dimension;

import com.plataforma_digital.config.Colors;
import com.plataforma_digital.controllers.ViewAllEventsController;
import com.plataforma_digital.models.Event;
import com.plataforma_digital.views.components.EventListItem;
import com.plataforma_digital.views.components.ProfileButton;

public class ViewAllEvents extends javax.swing.JPanel {
        private Home home;
        private javax.swing.JButton BottonFlechaeventos;
        private javax.swing.JButton jButtonCrearEvento;
        private javax.swing.JButton jButtonMiseventos;
        private javax.swing.JLabel jLabelCrearevento;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane_MisEventos;
        private ProfileButton profileButton;
        private JPanel eventsContainer = new JPanel();
        private ViewAllEventsController viewAllEventsController;

        public ViewAllEvents(Home home) {
                this.home = home;
                this.viewAllEventsController = new ViewAllEventsController();
                initComponents();
                loadEvents();
        }

        private void initComponents() {
                jPanel1 = new javax.swing.JPanel();
                BottonFlechaeventos = new javax.swing.JButton();
                jButtonCrearEvento = new javax.swing.JButton();
                jButtonMiseventos = new javax.swing.JButton();
                jLabelCrearevento = new javax.swing.JLabel();
                profileButton = new ProfileButton(home);

                eventsContainer.setLayout(new BoxLayout(eventsContainer, BoxLayout.Y_AXIS));
                eventsContainer.setAlignmentY(TOP_ALIGNMENT);
                jScrollPane_MisEventos = new javax.swing.JScrollPane(eventsContainer);
                jScrollPane_MisEventos.setBorder(null);

                jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

                BottonFlechaeventos.setBackground(Colors.BACKGROUND_COLOR);
                BottonFlechaeventos.setFont(new java.awt.Font("Segoe UI", 1, 14));
                BottonFlechaeventos.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/Arrow.png")));
                BottonFlechaeventos.setText("  Evento");
                BottonFlechaeventos.setBorderPainted(false);
                BottonFlechaeventos.addActionListener(e -> {
                        EventsCalendar eventsCalendar = new EventsCalendar(home);
                        home.eventsCalendar = eventsCalendar;
                        home.addAndShowPanel(eventsCalendar, "eventsCalendar");
                });

                jButtonCrearEvento.setBackground(Colors.BACKGROUND_COLOR);
                jButtonCrearEvento.setFont(new java.awt.Font("Segoe UI", 1, 14));
                jButtonCrearEvento.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/plain.png")));
                jButtonCrearEvento.setText("Crear Evento");
                jButtonCrearEvento.setBorderPainted(false);
                jButtonCrearEvento.addActionListener(e -> {
                        CreateEvent createEvent = new CreateEvent(home);
                        home.createEvent = createEvent;
                        home.addAndShowPanel(createEvent, "createEvent");
                });

                jButtonMiseventos.setBackground(Colors.BACKGROUND_COLOR);
                jButtonMiseventos.setFont(new java.awt.Font("Segoe UI", 1, 14));
                jButtonMiseventos.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/folder.png")));
                jButtonMiseventos.setText("Mis Eventos");
                jButtonMiseventos.setBorderPainted(false);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(BottonFlechaeventos)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jButtonCrearEvento)
                                                                                .addComponent(jButtonMiseventos,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                173,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(15, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(BottonFlechaeventos)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jButtonCrearEvento,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                60,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonMiseventos)
                                                                .addGap(0, 331, Short.MAX_VALUE)));

                jLabelCrearevento.setFont(new java.awt.Font("Segoe UI", 1, 30));
                jLabelCrearevento.setText("Mis Eventos");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabelCrearevento)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                224,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(profileButton))
                                                                                .addComponent(jScrollPane_MisEventos))
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(35, 35, 35)
                                                                                                .addComponent(jLabelCrearevento))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(profileButton,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                32,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane_MisEventos)));
        }

        public void loadEvents() {
                List<Event> events = viewAllEventsController.getApprovedEvents();
                eventsContainer.removeAll();
                eventsContainer.setLayout(new BoxLayout(eventsContainer, BoxLayout.Y_AXIS));
                for (Event event : events) {
                        eventsContainer.add(new EventListItem(home, this, event));
                        eventsContainer.add(Box.createRigidArea(new Dimension(0, 10)));
                }
                eventsContainer.revalidate();
                eventsContainer.repaint();
        }
}