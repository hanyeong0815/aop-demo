package com.example.demo.common.utils.time;

import com.example.demo.common.properties.time.ServerTimeProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@Component
public final class ServerTime {
    public final ZoneId zoneId;

    public ServerTime(ServerTimeProperties serverTimeProperties) {
        zoneId = ZoneId.of(serverTimeProperties.timeZone());
    }

    public OffsetDateTime now() {
        return OffsetDateTime.now(zoneId);
    }

    public LocalDateTime nowLocal() {
        return now().toLocalDateTime();
    }
}
