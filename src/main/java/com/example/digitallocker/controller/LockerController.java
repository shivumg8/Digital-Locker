package com.example.digitallocker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.digitallocker.service.LockerService;

import java.util.Map;

@RestController
@RequestMapping("/locker")
public class LockerController {

    private final LockerService lockerService;

    public LockerController(LockerService lockerService) {
        this.lockerService = lockerService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createLocker(@RequestBody Map<String, String> request) {
        String pin = request.get("pin");
        try {
            lockerService.createLocker(pin);
            return ResponseEntity.ok("Locker created successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/change-pin")
    public ResponseEntity<String> changePin(@RequestBody Map<String, String> request) {
        String oldPin = request.get("oldPin");
        String newPin = request.get("newPin");
        try {
            lockerService.changePin(oldPin, newPin);
            return ResponseEntity.ok("PIN changed successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("/store")
    public ResponseEntity<String> addDocument(@RequestBody Map<String, String> request) {
        String pin = request.get("pin");
        String docName = request.get("docName");
        String docContent = request.get("docContent");

        try {
            lockerService.addDocument(pin, docName, docContent);
            return ResponseEntity.ok("Document added successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @GetMapping("/document")
    public ResponseEntity<?> getDocument(@RequestParam String pin, @RequestParam String docName) {
        try {
            String content = lockerService.getDocument(pin, docName);
            return ResponseEntity.ok(content);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
