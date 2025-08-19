package com.vunnen.med.service;

import com.vunnen.med.model.Patient;
import com.vunnen.med.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public Patient create(Patient patient) {
        log.info("Create user");
        return patientRepository.create(patient);
    }
}
