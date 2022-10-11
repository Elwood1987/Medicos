package com.usa.doctor.repository.crudrepository;

import com.usa.doctor.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorCrudRepository extends CrudRepository<Doctor,Integer> {
}
