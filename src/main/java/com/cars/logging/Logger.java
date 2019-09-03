package com.cars.logging;

import java.io.PrintStream;

public class Logger {
    
    private static PrintStream outputLocation = System.err;
        
    public static void setOutputLocation(PrintStream ps) {
        outputLocation = ps;
    }
    
    public static void log(Exception e) {
        e.printStackTrace(outputLocation);
    }
    
    public static void log(String s, LogLevel level) {
        outputLocation.println(s);
    }
}
