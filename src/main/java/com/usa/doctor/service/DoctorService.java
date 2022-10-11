package com.usa.doctor.service;

import com.usa.doctor.model.Doctor;
import com.usa.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAll(){
        return doctorRepository.getAll();
    }

    public Optional<Doctor> getById(int id) {
        return doctorRepository.getById(id);
    }

    public Doctor save(Doctor doctor){
        if(doctor.getId()==null){
            return doctorRepository.save(doctor);
        }else{
            Optional<Doctor> e= doctorRepository.getById(doctor.getId());
            if(e.isEmpty()){
                return doctorRepository.save(doctor);
            }else{
                return doctor;
            }
        }
    }

    public Doctor update(Doctor doctor){
        if(doctor.getId()!=null){
            Optional<Doctor> e= doctorRepository.getById(doctor.getId());
            if(!e.isEmpty()){
                if(doctor.getName()!=null){
                    e.get().setName(doctor.getName());
                }
                if(doctor.getDepartment()!=null){
                    e.get().setDepartment(doctor.getDepartment()) ;
                }
                if(doctor.getYear() !=null){
                    e.get().setYear(doctor.getYear());
                }
                if(doctor.getDescription()!=null){
                    e.get().setDescription(doctor.getDescription());
                }
                if(doctor.getSpecialty()!=null){
                    e.get().setSpecialty(doctor.getSpecialty());
                }
                doctorRepository.save(e.get());
                return e.get();
            }else{
                return doctor;
            }
        }else{
            return doctor;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getById(id).map(doctor -> {
            doctorRepository.delete(doctor);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
