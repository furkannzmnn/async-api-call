package org.example;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailFetcher implements ApiFetcher {
    private final Logger LOGGER = Logger.getLogger(MailFetcher.class.getName());

    @Override
    public CompletableFuture<List<Notify>> fetchSms(String owner) {
        final Executor executor = CompletableFuture.delayedExecutor(100, TimeUnit.MILLISECONDS);
        return CompletableFuture.supplyAsync(() -> {
            LOGGER.log(Level.INFO, "Fetching posts from email for owner {}", owner);
            LOGGER.info(Thread.currentThread().getName());
            return List.of(
                    new Email("email 1"),
                    new Email("email 2"),
                    new Email("email 3"),
                    new Email("email 4")
            );
        }, executor);
    }

}
