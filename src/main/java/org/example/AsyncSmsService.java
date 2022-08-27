package org.example;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BinaryOperator;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AsyncSmsService implements NotificationService{
    private final Logger LOGGER = Logger.getLogger(AsyncMailService.class.getName());

    @Override
    public CompletableFuture<List<Notify>> sendNotify(){
        final List<CompletableFuture<List<Notify>>> futures = Stream.of(NotifyType.values())
                .map(s -> {
                    final ApiFetcher apiFetcher = NotificationFactory.fromFetch(s);
                    return apiFetcher.fetchSms("system");
                })
                .collect(Collectors.toList());

        final Sms sms = new Sms("ASYNC SMS TRIGGERED");
        LOGGER.info(sms.getMessage());

        return futures.
                stream()
                .reduce(completeCall())
                .orElse(new CompletableFuture<>());
    }

    private BinaryOperator<CompletableFuture<List<Notify>>> completeCall() {
        return (future, future2) -> future.thenCombine(future2, ((notifies, notifies2) ->
                Stream.concat(notifies.stream(), notifies2.stream()).collect(Collectors.toList())));
    }

}
