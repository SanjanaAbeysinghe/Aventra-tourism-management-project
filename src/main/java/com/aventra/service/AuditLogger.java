package com.aventra.service;

import java.io.IOException;

/** Abstraction for recording important application events. */
public interface AuditLogger {
    void log(String event) throws IOException;
}
