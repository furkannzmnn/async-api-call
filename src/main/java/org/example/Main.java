package org.example;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        final Long join = timeNotJoin();
        System.out.println("not join: " + join);

        final Long timewithJoin = timewithJoin();
        System.out.println("with join: " + timewithJoin);


    }

    private static Long timewithJoin() {
        long st = System.currentTimeMillis();
        NotificationService notificationService = new AsyncMailService();
        notificationService.sendNotify().join();
        final long millis = System.currentTimeMillis();
        return millis - st;
    }

    private static Long timeNotJoin() {
        long st = System.currentTimeMillis();
        NotificationService notificationService = new AsyncMailService();
        notificationService.sendNotify();
        final long millis = System.currentTimeMillis();
        return millis - st;
    }

}