package com.example.demo.datasource;

public class DynamicContextHolder {

    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal();

    public static String get() {
        return CONTEXT_HOLDER.get();
    }

    public static void set(String value) {
        CONTEXT_HOLDER.set(value);
    }
}
