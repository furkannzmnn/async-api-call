package org.example;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SmsFetcher implements ApiFetcher {

    private final Logger LOGGER = Logger.getLogger(SmsFetcher.class.getName());

    @Override
    public CompletableFuture<List<Notify>> fetchSms(String owner) {
        final Executor executor = CompletableFuture.delayedExecutor(400, TimeUnit.MILLISECONDS);
        return CompletableFuture.supplyAsync(() -> {
            LOGGER.log(Level.INFO, "Fetching posts from sms for owner %s", owner);
            LOGGER.info(Thread.currentThread().getName());
            return List.of(
                    new Sms("sms 1"),
                    new Sms("sms 2"),
                    new Sms("sms 3"),
                    new Sms("sms 4")
            );
        }, executor);
    }
}
