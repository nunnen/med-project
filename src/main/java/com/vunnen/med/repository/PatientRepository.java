package com.vunnen.med.repository;

import com.vunnen.med.model.Patient;
import org.springframework.stereotype.Repository;

@Repository
public class PatientRepository extends EntityRepository<Patient> {
    private Long nextId = 1L;
    @Override
    public Patient create(Patient patient) {
        patient.setId(nextId++);
        return super.create(patient);
    }
}
