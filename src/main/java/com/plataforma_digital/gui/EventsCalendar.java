package com.plataforma_digital.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.util.Date;
import com.plataforma_digital.database.EventDao;
import com.plataforma_digital.database.impl.EventDaoImpl;
import com.plataforma_digital.entities.Event;

public class EventsCalendar extends JPanel {
    public Home home;
    private JLabel monthLabel;
    private JPanel daysPanel;
    private Calendar calendar;
    private List<Date> highlightedDates;

    public EventsCalendar(Home home) {
        this.home = home;
        highlightedDates = getHighlightedDates();
        initComponents();
    }

    public List<Date> getHighlightedDates() {
        highlightedDates = new ArrayList<>();
        EventDao eventDao = new EventDaoImpl();
        List<Event> events = eventDao.getAllEventsByState("approved");
        SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            for (Event event : events) {
                Date date = originalFormat.parse(event.getStartDate());
                String formattedDate = targetFormat.format(date);
                highlightedDates.add(targetFormat.parse(formattedDate));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return highlightedDates;
    }

    private void updateCalendar() {
        daysPanel.removeAll();
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        String[] days = { "Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa" };
        for (String day : days) {
            daysPanel.add(new JLabel(day, SwingConstants.CENTER));
        }

        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 1; i < firstDayOfWeek; i++) {
            daysPanel.add(new JLabel());
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Date currentDate = new Date();

        for (int day = 1; day <= daysInMonth; day++) {
            calendar.set(Calendar.DAY_OF_MONTH, day);
            Date currentIterationDate = calendar.getTime();
            JLabel dayLabel = new JLabel(String.valueOf(day), SwingConstants.CENTER);

            if (sdf.format(currentDate).equals(sdf.format(currentIterationDate))) {
                dayLabel.setOpaque(true);
                dayLabel.setBackground(Color.BLACK);
                dayLabel.setForeground(Color.WHITE);
            }
            if (highlightedDates.stream().anyMatch(date -> sdf.format(date).equals(sdf.format(currentIterationDate)))) {
                dayLabel.setOpaque(true);
                dayLabel.setBackground(new Color(20, 174, 92));
                dayLabel.setForeground(Color.WHITE);
            }

            daysPanel.add(dayLabel);
        }

        monthLabel.setText(new SimpleDateFormat("MMMM yyyy").format(calendar.getTime()));
        daysPanel.revalidate();
        daysPanel.repaint();
    }

    private void initComponents() {
        calendar = Calendar.getInstance();
        monthLabel = new JLabel();
        daysPanel = new JPanel(new GridLayout(0, 7));

        JButton prevButton = new JButton("<");
        JButton nextButton = new JButton(">");

        prevButton.addActionListener(e -> {
            calendar.add(Calendar.MONTH, -1);
            updateCalendar();
        });

        nextButton.addActionListener(e -> {
            calendar.add(Calendar.MONTH, 1);
            updateCalendar();
        });

        JPanel topPanel = new JPanel();
        topPanel.add(prevButton);
        topPanel.add(monthLabel);
        topPanel.add(nextButton);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(daysPanel, BorderLayout.CENTER);
        updateCalendar();
    }
}
