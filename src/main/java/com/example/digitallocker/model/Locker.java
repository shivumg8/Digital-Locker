package com.example.digitallocker.model;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private String pin;
    private Map<String, String> documents;

    public Locker(String pin) {
        this.pin = pin;
        this.documents = new HashMap<>();
    }

    public String getPin() {
        return pin;
    }

    public void addDocument(String name, String content) {
        documents.put(name, content);
    }

    public String getDocument(String name) {
        return documents.get(name);
    }
}
