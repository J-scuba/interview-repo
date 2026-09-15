package com.example.helloworld;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class AppLoggerTest {
    private final List<String> logged = new ArrayList<>();
    private final AppLogger.Sink sink = new AppLogger.Sink() {
        @Override
        public void log(String tag, String message) {
            logged.add(tag + ": " + message);
        }
    };

    @Test
    public void logsWhenEnableLogsIsTrue() {
        new AppLogger(AppConfig.parseFlag("true"), sink).d("Test", "hello");

        assertEquals(Collections.singletonList("Test: hello"), logged);
    }

    @Test
    public void logsStopWhenEnableLogsIsFalse() {
        new AppLogger(AppConfig.parseFlag("false"), sink).d("Test", "hello");

        assertTrue(logged.isEmpty());
    }

    @Test
    public void appLoggerFollowsEnableLogsFromDotEnv() {
        AppLogger.fromConfig(sink).d("Test", "hello");

        assertEquals(AppConfig.isLoggingEnabled(), !logged.isEmpty());
    }
}
