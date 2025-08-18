package com.vunnen.med.repository;

import com.vunnen.med.model.Appointment;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentRepository extends EntityRepository<Appointment> {
    private Long nextId = 1L;

    @Override
    public Appointment create(Appointment entity) {
        entity.setId(nextId++);
        return super.create(entity);
    }
}
