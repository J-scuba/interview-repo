package com.example.helloworld;

import android.util.Log;

public final class AppLogger {
    public interface Sink {
        void log(String tag, String message);
    }

    private final boolean enabled;
    private final Sink sink;

    AppLogger(boolean enabled, Sink sink) {
        this.enabled = enabled;
        this.sink = sink;
    }

    public static AppLogger fromConfig() {
        return fromConfig(new Sink() {
            @Override
            public void log(String tag, String message) {
                Log.d(tag, message);
            }
        });
    }

    static AppLogger fromConfig(Sink sink) {
        return new AppLogger(AppConfig.isLoggingEnabled(), sink);
    }

    public void d(String tag, String message) {
        if (enabled) {
            sink.log(tag, message);
        }
    }
}
