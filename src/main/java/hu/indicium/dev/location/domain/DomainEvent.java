package hu.indicium.dev.location.domain;

import java.util.Date;

public interface DomainEvent {

    int eventVersion();

    Date occurredOn();
}
