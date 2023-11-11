package com.example.demo;

import java.util.UUID;

public class MyUuid {
    private final UUID uuid;

    public MyUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }
}