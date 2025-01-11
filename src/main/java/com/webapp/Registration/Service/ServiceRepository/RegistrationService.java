package com.webapp.Registration.Service.ServiceRepository;

import com.webapp.Registration.Entity.RegistrationModel;

import java.util.List;

public interface RegistrationService {
    RegistrationModel saveData(RegistrationModel registrationModel);
    List<RegistrationModel> getAllData();
    String deleteData(int id);
    RegistrationModel getUserById(int id);
    RegistrationModel updateData(int id, RegistrationModel registrationModel);
    long getCountOfUsers();

}