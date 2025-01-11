package com.webapp.Registration.Controller;

import com.webapp.Registration.Entity.RegistrationModel;
import com.webapp.Registration.Service.ServiceRepository.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api")
//@CrossOrigin("http://localhost:3000")
public class RegistrationController{

    @Autowired
    private RegistrationService registrationService;

    /**
     * Create a new registration record.
     */
    @PostMapping("/add")
    public ResponseEntity<RegistrationModel> createRegistration(@Valid @RequestBody RegistrationModel registrationModel) {
        RegistrationModel savedData = registrationService.saveData(registrationModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedData);
    }
    /**
     * Retrieve all registration records.
     */
    @GetMapping("get_all")
    public ResponseEntity<List<RegistrationModel>> getAllRegistrations() {
        List<RegistrationModel> data = registrationService.getAllData();
        return ResponseEntity.ok(data);
    }

    /**
     * Retrieve a specific registration by ID.

     */
    @GetMapping("get/{id}")
    public ResponseEntity<RegistrationModel> getRegistrationById(@PathVariable int id) {
        RegistrationModel user = registrationService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * Delete a specific registration by ID.

     */
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteRegistration(@PathVariable int id) {
        String message = registrationService.deleteData(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(message);
    }

    /**
     * Update an existing registration.

     */
    @PutMapping("update/{id}")
    public ResponseEntity<RegistrationModel> updateRegistration(
            @PathVariable int id,
            @Valid @RequestBody RegistrationModel registrationModel) {
        RegistrationModel updatedUser = registrationService.updateData(id, registrationModel);
        return ResponseEntity.ok(updatedUser);
    }
    @GetMapping("/count")
    public ResponseEntity<String> getUserCount() {
        long userCount = registrationService.getCountOfUsers();

        if (userCount == 0) {
            return ResponseEntity.status(HttpStatus.OK).body("No registered users found.");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Total registered users: " + userCount);
        }
    }
}