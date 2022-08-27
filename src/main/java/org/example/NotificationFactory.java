package org.example;

import java.util.Map;

public class NotificationFactory {
    private static final Map<NotifyType, ApiFetcher>  API_FETCHER_MAP = Map.of(
            NotifyType.EMAIL, new MailFetcher(),
            NotifyType.SMS, new SmsFetcher()
    );

    public static ApiFetcher fromFetch(NotifyType type) {
        return API_FETCHER_MAP.get(type);
    }
}
