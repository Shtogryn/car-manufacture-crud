package com.car.manufacture.controller;
import java.util.logging.Level;
public class AppLogger implements Logger {
    Logger logger;
    @Override
    public void log(Level level, String message, String className) {
        java.util.logging.Logger log = java.util.logging.Logger.getLogger(className);
        log.log(level, message);
    }
}
