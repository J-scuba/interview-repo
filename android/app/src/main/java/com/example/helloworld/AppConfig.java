package com.example.helloworld;

// Env is generated at build time by the dotenv-android plugin from android/.env.
// The plugin only generates fields that are referenced in src/main/java.
public final class AppConfig {
    private AppConfig() {
    }

    public static boolean isLoggingEnabled() {
        return parseFlag(Env.enableLogs);
    }

    public static String apiKey() {
        return Env.apiKey;
    }

    static boolean parseFlag(String value) {
        return value != null && value.trim().equalsIgnoreCase("true");
    }
}
