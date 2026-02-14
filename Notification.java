package service;

import model.Member;

public class Notification {
    public static void sendNotification(Member member, String message) {
        System.out.println("Notification to " + member.getName() + ": " + message);
    }
}
