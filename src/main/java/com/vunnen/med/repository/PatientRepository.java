package com.vunnen.med.repository;

import com.vunnen.med.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PatientRepository extends JpaRepository<Patient, Integer> {

}
