package com.plataforma_digital.main;

import com.plataforma_digital.models.database.DatabaseConnection;
import com.plataforma_digital.views.AppUI;

public class App {

    public static void main(String[] args) {
        App.initDatabase();
        App.initAppUI();
    }

    private static void initDatabase() {
        DatabaseConnection.getInstance().createTables();
    }

    private static void initAppUI() {
        AppUI appUI = new AppUI();
        appUI.setVisible(true);
    }
}
