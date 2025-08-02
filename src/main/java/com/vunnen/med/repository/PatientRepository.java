package com.vunnen.med.repository;

import com.vunnen.med.model.Patient;
import com.vunnen.med.util.FakerUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientRepository {
    private final Map<Long, Patient> patients;
    private final FakerUtil faker = FakerUtil.getInstance();
    private long id;

    public PatientRepository() {
        patients = new HashMap<>();
        List<Patient> patients = faker.createFakePatients(100);
        patients.forEach(this::save);
    }

    public void save(Patient patient) {
        id++;
        patient.setId(id);
        patients.put(id, patient);
    }

    public Patient find(long id) {
        return patients.get(id);
    }

    public List<Patient> findAll() {
        return new ArrayList<>(patients.values());
    }

    public void delete(long id) {
        patients.remove(id);
    }

    public void update(long id, Patient patient) {
        patients.put(id, patient);
    }
}
