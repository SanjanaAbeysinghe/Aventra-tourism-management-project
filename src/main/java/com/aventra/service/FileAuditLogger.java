package com.aventra.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

/** Persists application events in a local text file using Java file handling. */
public class FileAuditLogger implements AuditLogger {
    private final Path logFile;

    public FileAuditLogger() {
        this(Path.of("data", "aventra-audit.log"));
    }

    public FileAuditLogger(Path logFile) {
        this.logFile = logFile;
    }

    @Override
    public void log(String event) throws IOException {
        Path parent = logFile.getParent();
        if (parent != null) Files.createDirectories(parent);
        String line = LocalDateTime.now() + " | " + event + System.lineSeparator();
        Files.writeString(logFile, line, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
    }
}
