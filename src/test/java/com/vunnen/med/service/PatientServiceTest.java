package com.vunnen.med.service;

import com.vunnen.med.model.Patient;
import com.vunnen.med.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {
    private final static Patient PATIENT = Patient.builder()
            .name("patient")
            .build();
    @Mock
    private PatientRepository patientRepository;
    @InjectMocks
    private PatientService patientService;

    @Test
    void create() {
        doReturn(PATIENT).when(patientRepository).create(PATIENT);

        patientService.create(PATIENT);

        assertThat(PATIENT.getName()).isEqualTo("patient");
    }
}