package com.plataforma_digital.views;

import javax.swing.JOptionPane;

import com.plataforma_digital.config.Colors;
import com.plataforma_digital.controllers.EditEventController;
import com.plataforma_digital.models.Event;
import com.plataforma_digital.utils.DateUtils;
import com.plataforma_digital.views.components.ProfileButton;

public class EditEvent extends javax.swing.JPanel {
    private javax.swing.JLabel LabelDescription;
    private javax.swing.JLabel LabelEstado;
    private javax.swing.JLabel LabelFechaFin;
    private javax.swing.JLabel LabelFechaInicio;
    private javax.swing.JLabel LabelLugar;
    private javax.swing.JLabel LabelMainTitle;
    private javax.swing.JLabel LabelTitle;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonCrearEvent;
    private javax.swing.JButton jButtonMisEventos;
    private javax.swing.JButton jButtonPublicar;
    private ProfileButton jButtonUser;
    private javax.swing.JCheckBox jCheckBoxRealizarCambios;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldFechaFin;
    private javax.swing.JTextField jTextFieldFechaInicio;
    private javax.swing.JTextField jTextFieldLugar;
    private javax.swing.JTextField jTextFieldTitulo;
    private Home home;
    private Event event;
    private EditEventController editEventController;

    public EditEvent(Home home, Event event) {
        this.home = home;
        this.event = event;
        this.editEventController = new EditEventController();
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonBack = new javax.swing.JButton();
        jButtonCrearEvent = new javax.swing.JButton();
        jButtonMisEventos = new javax.swing.JButton();
        LabelMainTitle = new javax.swing.JLabel();
        LabelTitle = new javax.swing.JLabel();
        LabelDescription = new javax.swing.JLabel();
        LabelLugar = new javax.swing.JLabel();
        LabelEstado = new javax.swing.JLabel();
        LabelFechaInicio = new javax.swing.JLabel();
        LabelFechaFin = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jTextFieldLugar = new javax.swing.JTextField();
        jTextFieldFechaInicio = new javax.swing.JTextField();
        jTextFieldFechaFin = new javax.swing.JTextField();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        jCheckBoxRealizarCambios = new javax.swing.JCheckBox();
        jButtonUser = new ProfileButton(home);
        jButtonCancel = new javax.swing.JButton();
        jButtonPublicar = new javax.swing.JButton();

        jTextFieldTitulo.setText(event.getTitle());
        jTextFieldDescripcion.setText(event.getDescription());
        jTextFieldFechaInicio.setText(event.getStartDate());
        jTextFieldFechaFin.setText(event.getEndDate());
        jTextFieldLugar.setText(event.getLocation());

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonBack.setBackground(Colors.BACKGROUND_COLOR);
        jButtonBack.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arrow.png")));
        jButtonBack.setText(" Eventos");
        jButtonBack.setBorderPainted(false);

        jButtonCrearEvent.setBackground(Colors.BACKGROUND_COLOR);
        jButtonCrearEvent.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButtonCrearEvent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plain.png")));
        jButtonCrearEvent.setText("Crear Evento");
        jButtonCrearEvent.setBorder(null);
        jButtonCrearEvent.setBorderPainted(false);
        jButtonCrearEvent.setIconTextGap(10);
        jButtonCrearEvent.addActionListener(e -> {
            CreateEvent createEvent = new CreateEvent(home);
            home.createEvent = createEvent;
            home.addAndShowPanel(createEvent, "createEvent");
        });

        jButtonMisEventos.setBackground(Colors.BACKGROUND_COLOR);
        jButtonMisEventos.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButtonMisEventos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Folder.png")));
        jButtonMisEventos.setText("Mis Eventos");
        jButtonMisEventos.setBorder(null);
        jButtonMisEventos.setBorderPainted(false);
        jButtonMisEventos.setIconTextGap(10);
        jButtonMisEventos.addActionListener(e -> {
            ViewAllEvents viewAllEvents = new ViewAllEvents(home);
            home.viewAllEvents = viewAllEvents;
            home.addAndShowPanel(viewAllEvents, "viewAllEvents");
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonMisEventos)
                                        .addComponent(jButtonCrearEvent)
                                        .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 135,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(28, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jButtonBack)
                                .addGap(45, 45, 45)
                                .addComponent(jButtonCrearEvent)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonMisEventos)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        LabelMainTitle.setFont(new java.awt.Font("Segoe UI", 1, 30));
        LabelMainTitle.setText("Editar Evento");

        LabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 15));
        LabelTitle.setText("Título");

        LabelDescription.setFont(new java.awt.Font("Segoe UI", 1, 15));
        LabelDescription.setText("Descripción");

        LabelLugar.setFont(new java.awt.Font("Segoe UI", 1, 15));
        LabelLugar.setText("Lugar");

        LabelEstado.setFont(new java.awt.Font("Segoe UI", 1, 15));
        LabelEstado.setText("Estado");

        LabelFechaInicio.setFont(new java.awt.Font("Segoe UI", 1, 15));
        LabelFechaInicio.setText("Fecha inicio");

        LabelFechaFin.setFont(new java.awt.Font("Segoe UI", 1, 15));
        LabelFechaFin.setText("Fecha fin");

        jTextFieldFechaInicio.setToolTipText("");

        jComboBoxEstado.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jComboBoxEstado.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Proximamente", "Empezado", "Terminado" }));

        jCheckBoxRealizarCambios.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jCheckBoxRealizarCambios.setText("Seguro que quieres realizar estos cambios?");
        jCheckBoxRealizarCambios.setBorderPainted(true);
        jCheckBoxRealizarCambios.setIconTextGap(7);
        jCheckBoxRealizarCambios.setMargin(new java.awt.Insets(2, 6, 2, 6));

        jButtonUser.setBackground(Colors.BACKGROUND_COLOR);
        jButtonUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user2.png")));
        jButtonUser.setBorderPainted(false);

        jButtonCancel.setBackground(new java.awt.Color(204, 204, 204));
        jButtonCancel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButtonCancel.setText("Cancelar");

        jButtonPublicar.setBackground(new java.awt.Color(51, 51, 51));
        jButtonPublicar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButtonPublicar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPublicar.setText("Guardar");
        jButtonPublicar.setBorderPainted(false);
        jButtonPublicar.addActionListener(e -> {
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
            editEventController.updateEvent(event.getId(), event.getUserId(), jTextFieldTitulo.getText(),
                    jTextFieldDescripcion.getText(), event.getState(), event.getCreatedAt(),
                    jTextFieldFechaInicio.getText(), jTextFieldFechaFin.getText(), jTextFieldLugar.getText());
            JOptionPane.showMessageDialog(null, "El evento se han actualizado!", "Datos actualizados",
                    JOptionPane.INFORMATION_MESSAGE);

        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jCheckBoxRealizarCambios,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 329,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButtonCancel,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(99, 99, 99)
                                                                .addComponent(jButtonPublicar,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(75, 75, 75))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldDescripcion)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(LabelLugar)
                                                                        .addComponent(jTextFieldLugar,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                220,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(LabelEstado)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jComboBoxEstado, 0,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextFieldTitulo)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(LabelMainTitle)
                                                                                        .addComponent(LabelDescription)
                                                                                        .addComponent(LabelTitle))
                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(51, 51, 51)
                                                                                .addComponent(jButtonUser,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        45,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextFieldFechaInicio,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                220,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(LabelFechaInicio))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextFieldFechaFin)
                                                                        .addComponent(LabelFechaFin))))
                                                .addGap(45, 45, 45)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LabelMainTitle)
                                        .addComponent(jButtonUser))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(LabelTitle)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addGap(2, 2, 2)))
                                .addComponent(LabelDescription)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextFieldDescripcion,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(LabelLugar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextFieldLugar,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jComboBoxEstado,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(LabelEstado)
                                                .addGap(40, 40, 40)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addComponent(LabelFechaInicio)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldFechaInicio,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addComponent(LabelFechaFin)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldFechaFin,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12,
                                        Short.MAX_VALUE)
                                .addComponent(jCheckBoxRealizarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonPublicar, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonCancel))
                                .addGap(30, 30, 30)));
    }

    private boolean validateFields() {
        if (jTextFieldDescripcion.getText().isEmpty()
                || !jCheckBoxRealizarCambios.isSelected()
                || jTextFieldTitulo.getText().isEmpty()
                || jTextFieldLugar.getText().isEmpty()
                || jTextFieldFechaInicio.getText().isEmpty()
                || jTextFieldFechaFin.getText().isEmpty())
            return false;

        return true;
    }

    private boolean validateDates() {
        return DateUtils.validateDate(jTextFieldFechaInicio.getText())
                && DateUtils.validateDate(jTextFieldFechaFin.getText());
    }
}
