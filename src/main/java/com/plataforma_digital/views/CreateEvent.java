package com.plataforma_digital.views;

import java.awt.Color;

import javax.swing.JOptionPane;
import com.plataforma_digital.views.components.ProfileButton;

import com.plataforma_digital.config.Colors;
import com.plataforma_digital.utils.DateUtils;
import com.plataforma_digital.controllers.CreateEventController;

public class CreateEvent extends javax.swing.JPanel {
        private Home home;
        private javax.swing.JButton BottonFlechaeventos;
        private javax.swing.JButton jButtonAGGimg;
        private javax.swing.JButton jButtonCancelar;
        private javax.swing.JButton jButtonCrearEvento;
        private javax.swing.JButton jButtonMiseventos;
        private javax.swing.JButton jButtonPublicarEvento;
        private javax.swing.JButton jButtonbell;
        private ProfileButton profileButton;
        private javax.swing.JLabel jLabelCrearevento;
        private javax.swing.JLabel jLabelDescripcion;
        private javax.swing.JLabel jLabelEstado;
        private javax.swing.JLabel jLabelFechaFin;
        private javax.swing.JLabel jLabelFechainicio;
        private javax.swing.JLabel jLabelLugar;
        private javax.swing.JLabel jLabelTitulodelevento;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JTextField jTextFieldDescripcion;
        private javax.swing.JTextField jTextFieldFechaFin;
        private javax.swing.JTextField jTextFieldFechainicio;
        private javax.swing.JTextField jTextFieldLugar;
        private javax.swing.JTextField jTextFieldTitulo;
        private javax.swing.JComboBox<String> listadeEstados;
        private CreateEventController createEventController;

        public CreateEvent(Home home) {
                this.home = home;
                this.createEventController = new CreateEventController();
                initComponents();
        }

        private void initComponents() {
                jPanel1 = new javax.swing.JPanel();
                BottonFlechaeventos = new javax.swing.JButton();
                jButtonCrearEvento = new javax.swing.JButton();
                jButtonMiseventos = new javax.swing.JButton();
                jLabelCrearevento = new javax.swing.JLabel();
                jLabelTitulodelevento = new javax.swing.JLabel();
                jLabelDescripcion = new javax.swing.JLabel();
                jLabelLugar = new javax.swing.JLabel();
                jLabelEstado = new javax.swing.JLabel();
                jLabelFechainicio = new javax.swing.JLabel();
                jLabelFechaFin = new javax.swing.JLabel();
                jTextFieldTitulo = new javax.swing.JTextField();
                jTextFieldDescripcion = new javax.swing.JTextField();
                jTextFieldLugar = new javax.swing.JTextField();
                jButtonCancelar = new javax.swing.JButton();
                jButtonPublicarEvento = new javax.swing.JButton();
                listadeEstados = new javax.swing.JComboBox<>();
                jTextFieldFechainicio = new javax.swing.JTextField();
                jTextFieldFechaFin = new javax.swing.JTextField();
                profileButton = new ProfileButton(home);
                jButtonbell = new javax.swing.JButton();
                jButtonAGGimg = new javax.swing.JButton();

                setFont(new java.awt.Font("Arial", 1, 18));
                setPreferredSize(new java.awt.Dimension(740, 500));

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

                jButtonMiseventos.setBackground(Colors.BACKGROUND_COLOR);
                jButtonMiseventos.setFont(new java.awt.Font("Segoe UI", 1, 14));
                jButtonMiseventos.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/folder.png")));
                jButtonMiseventos.setText("Mis Eventos");
                jButtonMiseventos.setBorderPainted(false);
                jButtonMiseventos.addActionListener(e -> {
                        ViewAllEvents viewAllEvents = new ViewAllEvents(home);
                        home.viewAllEvents = viewAllEvents;
                        home.addAndShowPanel(viewAllEvents, "viewAllEvents");
                });

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
                                                                .addGap(0, 297, Short.MAX_VALUE)));

                jLabelCrearevento.setFont(new java.awt.Font("Segoe UI", 1, 30));
                jLabelCrearevento.setText("Crear Evento");

                jLabelTitulodelevento.setFont(new java.awt.Font("Segoe UI", 1, 14));
                jLabelTitulodelevento.setText("Título del Evento");

                jLabelDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 14));
                jLabelDescripcion.setText("Descripción");

                jLabelLugar.setFont(new java.awt.Font("Segoe UI", 1, 14));
                jLabelLugar.setText("Lugar");

                jLabelEstado.setFont(new java.awt.Font("Segoe UI", 1, 14));
                jLabelEstado.setText("Estado");

                jLabelFechainicio.setFont(new java.awt.Font("Segoe UI", 1, 14));
                jLabelFechainicio.setText("Fecha de Inicio");

                jLabelFechaFin.setFont(new java.awt.Font("Segoe UI", 1, 14));
                jLabelFechaFin.setText("Fecha de Fin");

                jTextFieldTitulo.setForeground(new java.awt.Color(153, 153, 153));
                jTextFieldTitulo.setText("Plecopteras");

                jTextFieldDescripcion.setForeground(new java.awt.Color(153, 153, 153));
                jTextFieldDescripcion.setText("Cuerpo Lotidos de Plecopteras ");

                jTextFieldLugar.setForeground(new java.awt.Color(153, 153, 153));
                jTextFieldLugar.setText("Plaza Langosta");

                jButtonCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14));
                jButtonCancelar.setText("Cancelar");

                jButtonPublicarEvento.setBackground(Color.BLACK);
                jButtonPublicarEvento.setFont(new java.awt.Font("Segoe UI", 1, 14));
                jButtonPublicarEvento.setForeground(new java.awt.Color(255, 255, 255));
                jButtonPublicarEvento.setText("Publicar Evento");
                jButtonPublicarEvento.addActionListener(e -> {
                        if (!validateFields()) {
                                JOptionPane.showMessageDialog(null, "Todos los campos son requeridos",
                                                "Campos requeridos",
                                                JOptionPane.INFORMATION_MESSAGE);
                                return;
                        }
                        if (!validateDates()) {
                                JOptionPane.showMessageDialog(null,
                                                "Formato de fechas incorrecto. Formato correcto: DD/MM/AAAA",
                                                "Fechas incorrectas",
                                                JOptionPane.ERROR_MESSAGE);
                                return;
                        }
                        createEvent();
                        clearFields();
                });

                listadeEstados.setForeground(new java.awt.Color(153, 153, 153));
                listadeEstados.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new String[] { "Próximamente", "Empezado", "Terminado." }));

                jTextFieldFechainicio.setForeground(new java.awt.Color(153, 153, 153));
                jTextFieldFechainicio.setText("DD/MM/AAAA");

                jTextFieldFechaFin.setForeground(new java.awt.Color(153, 153, 153));
                jTextFieldFechaFin.setText("DD/MM/AAAA");

                jButtonbell.setBackground(Colors.BACKGROUND_COLOR);
                jButtonbell.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/Bell3.png")));
                jButtonbell.setBorderPainted(false);

                jButtonAGGimg.setBackground(Colors.BACKGROUND_COLOR);
                jButtonAGGimg.setFont(new java.awt.Font("Segoe UI", 0, 10));
                jButtonAGGimg.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/Agregarimagen (1).png")));
                jButtonAGGimg.setText("Agregar Imagen");
                jButtonAGGimg.setBorderPainted(false);

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
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(8, 8, 8)
                                                                                                                                .addComponent(jLabelTitulodelevento))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(jLabelCrearevento)))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jButtonAGGimg)
                                                                                                .addComponent(jButtonbell)
                                                                                                .addComponent(profileButton)
                                                                                                .addContainerGap(
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jTextFieldTitulo,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                403,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jTextFieldDescripcion,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                403,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabelDescripcion)
                                                                                                                .addComponent(jTextFieldLugar,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                403,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabelLugar)
                                                                                                                .addComponent(jLabelEstado)
                                                                                                                .addComponent(listadeEstados,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                403,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                .addComponent(jButtonCancelar)
                                                                                                                                .addComponent(jTextFieldFechainicio,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                135,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(jLabelFechainicio)
                                                                                                                                .addGap(120, 120,
                                                                                                                                                120)
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabelFechaFin)
                                                                                                                                                .addComponent(jTextFieldFechaFin,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                135,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                                .addGap(6, 6, 6)
                                                                                                                                                                .addComponent(jButtonPublicarEvento)))))
                                                                                                .addGap(0, 0, Short.MAX_VALUE)))));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap(11, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabelCrearevento)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jLabelTitulodelevento))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jButtonAGGimg,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                77,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(2, 2, 2)
                                                                                                                                .addComponent(profileButton,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                32,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addComponent(jButtonbell,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                34,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextFieldTitulo,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                28,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabelDescripcion)
                                                                .addGap(12, 12, 12)
                                                                .addComponent(jTextFieldDescripcion,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                28,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabelLugar)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextFieldLugar,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                28,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabelEstado)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(listadeEstados,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabelFechainicio)
                                                                                .addComponent(jLabelFechaFin))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jTextFieldFechainicio,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                28,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jTextFieldFechaFin,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                28,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(24, 24, 24)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jButtonPublicarEvento)
                                                                                .addComponent(jButtonCancelar))
                                                                .addGap(61, 61, 61))
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));
        }

        private void clearFields() {
                jTextFieldTitulo.setText("");
                jTextFieldDescripcion.setText("");
                jTextFieldFechaFin.setText("");
                jTextFieldFechainicio.setText("");
                jTextFieldLugar.setText("");
                listadeEstados.setSelectedIndex(0);
        }

        private boolean validateFields() {
                if (jTextFieldTitulo.getText().isEmpty() || jTextFieldDescripcion.getText().isEmpty()
                                || jTextFieldFechaFin.getText().isEmpty()
                                || jTextFieldFechainicio.getText().isEmpty()
                                || jTextFieldLugar.getText().isEmpty())
                        return false;
                return true;
        }

        private boolean validateDates() {
                return DateUtils.validateDate(jTextFieldFechainicio.getText())
                                && DateUtils.validateDate(jTextFieldFechaFin.getText());
        }

        private void createEvent() {
                createEventController.createEvent(
                                jTextFieldTitulo.getText(),
                                jTextFieldDescripcion.getText(),
                                jTextFieldFechainicio.getText(),
                                jTextFieldFechaFin.getText(),
                                jTextFieldLugar.getText());
        }
}
