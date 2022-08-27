package org.example;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface NotificationService {
    CompletableFuture<List<Notify>> sendNotify();
}
