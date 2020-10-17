package com.hh.optaplanner.service;

import java.util.UUID;

public interface ResolveService {
    String NAME = "optaplanner_ResolveService";

    void resolve(UUID uuid);
}