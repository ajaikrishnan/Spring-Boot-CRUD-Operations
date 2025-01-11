package com.webapp.Registration.Service;


import com.webapp.Registration.Entity.RegistrationModel;
import com.webapp.Registration.Exception.UserNotFoundException;
import com.webapp.Registration.Repository.RegistrationRepository;
import com.webapp.Registration.Service.ServiceRepository.RegistrationService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public RegistrationModel saveData(RegistrationModel registrationModel) {
        // Check if a user with the same email already exists
        if (registrationRepository.existsByEmail(registrationModel.getEmail())) {
            throw new RuntimeException("User already exists with the same email ID.");
        }
        return registrationRepository.save(registrationModel);
    }

    @Override
    public List<RegistrationModel> getAllData() {
        return registrationRepository.findAll();
    }

    @Override
    public String deleteData(int id) {
        if (!registrationRepository.existsById(id)) {
            throw new UserNotFoundException("User with ID " + id + " not found.");
        }
        registrationRepository.deleteById(id);
        return "User with ID " + id + " deleted successfully.";
    }

    @Override
    public RegistrationModel getUserById(int id) {
        return registrationRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found."));
    }

    @Override
    public RegistrationModel updateData(int id, @NotNull RegistrationModel registrationModel) {
        RegistrationModel existingUser = getUserById(id);

        if (registrationModel.getName() != null) {
            existingUser.setName(registrationModel.getName());
        }
        if (registrationModel.getEmail() != null) {
            existingUser.setEmail(registrationModel.getEmail());
        }
        if (registrationModel.getAge() > 0) {
            existingUser.setAge(registrationModel.getAge());
        }

        return registrationRepository.save(existingUser);
    }
    @Override
    public long getCountOfUsers() {
        return registrationRepository.count();
    }

}