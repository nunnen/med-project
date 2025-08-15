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

    public void addNewPatient(Patient patient) {
        log.info("Add new patient {}", patient);
        patientRepository.create(patient);
    }
}
