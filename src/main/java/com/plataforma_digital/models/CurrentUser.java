package com.plataforma_digital.models;

public class CurrentUser {
    static private User currentUser = new User(0, null, null, null, null, null);;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static void clear() {
        currentUser = new User(0, null, null, null, null, null);
    }
}
