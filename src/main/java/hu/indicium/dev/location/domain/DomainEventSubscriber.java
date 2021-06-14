package hu.indicium.dev.location.domain;

public interface DomainEventSubscriber<T> {

    void handleEvent(final T aDomainEvent);

    Class<T> subscribedToEventType();
}