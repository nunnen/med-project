package com.vunnen.med.repository;

import com.vunnen.med.model.Appointment;
import com.vunnen.med.util.FakerUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentRepository {
    private final Map<Long, Appointment> appointments;
    private final FakerUtil faker = FakerUtil.getInstance();
    private final static AppointmentRepository INSTANCE = new AppointmentRepository();
    private long id;

    private AppointmentRepository() {
        appointments = new HashMap<>();
    }

    public static AppointmentRepository getInstance() {
        return INSTANCE;
    }

    public void save(Appointment appointment) {
        id++;
        appointment.setId(id);
        appointments.put(id, appointment);
    }

    public Appointment find(long id) {
        return appointments.get(id);
    }

    public List<Appointment> findAll() {
        return new ArrayList<>(appointments.values());
    }

    public void delete(long id) {
        appointments.remove(id);
    }

    public void update(long id, Appointment appointment) {
        appointments.put(id, appointment);
    }
}
