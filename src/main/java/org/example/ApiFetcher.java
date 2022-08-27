package org.example;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ApiFetcher {
    CompletableFuture<List<Notify>> fetchSms(String owner);
}
