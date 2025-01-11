package com.webapp.Registration.Repository;

import com.webapp.Registration.Entity.RegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<RegistrationModel ,Integer> {
    boolean existsByEmail(String email);
}
