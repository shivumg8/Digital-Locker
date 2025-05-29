package com.example.digitallocker.service;

import org.springframework.stereotype.Service;

import com.example.digitallocker.model.Locker;

@Service
public class LockerService {

    private Locker locker;  // Single locker

    public void createLocker(String pin) {
        if (locker != null) {
            throw new IllegalArgumentException("Locker already created.");
        }
        locker = new Locker(pin);
    }

    public void changePin(String oldPin, String newPin) {
        verifyPin(oldPin);
        locker = new Locker(newPin);  // Reset locker with new PIN, documents cleared
    }

    public void addDocument(String pin, String docName, String docContent) {
        verifyPin(pin);
        locker.addDocument(docName, docContent);
    }

    public String getDocument(String pin, String docName) {
        verifyPin(pin);
        String content = locker.getDocument(docName);
        if (content == null) {
            throw new IllegalArgumentException("Document not found.");
        }
        return content;
    }

    private void verifyPin(String pin) {
        if (locker == null) {
            throw new IllegalArgumentException("Locker not created yet.");
        }
        if (!locker.getPin().equals(pin)) {
            throw new IllegalArgumentException("Incorrect PIN.");
        }
    }
}
