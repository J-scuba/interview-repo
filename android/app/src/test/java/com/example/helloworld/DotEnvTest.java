package com.example.helloworld;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class DotEnvTest {
    private static final Map<String, String> dotEnv = new HashMap<>();

    @BeforeClass
    public static void readDotEnvFile() throws IOException {
        String path = System.getProperty("dotenv.file");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                int separator = line.indexOf('=');
                if (line.isEmpty() || line.startsWith("#") || separator < 0) {
                    continue;
                }
                dotEnv.put(line.substring(0, separator).trim(), line.substring(separator + 1).trim());
            }
        }
    }

    @Test
    public void enableLogsIsLoadedFromDotEnv() {
        assertNotNull("ENABLE_LOGS missing from .env", dotEnv.get("ENABLE_LOGS"));
        assertEquals(dotEnv.get("ENABLE_LOGS"), Env.enableLogs);
    }

    @Test
    public void apiKeyIsLoadedFromDotEnv() {
        assertNotNull("API_KEY missing from .env", dotEnv.get("API_KEY"));
        assertFalse("API_KEY is empty", AppConfig.apiKey().isEmpty());
        assertEquals(dotEnv.get("API_KEY"), AppConfig.apiKey());
    }

    @Test
    public void loggingEnabledMatchesDotEnv() {
        assertEquals(dotEnv.get("ENABLE_LOGS").equalsIgnoreCase("true"), AppConfig.isLoggingEnabled());
    }
}
