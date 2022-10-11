package com.usa.doctor.service;

import com.usa.doctor.model.Specialty;
import com.usa.doctor.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {
    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<Specialty> getAll() {
        return specialtyRepository.getAll();
    }

    public Optional<Specialty> getById(int id) {
        return specialtyRepository.getById(id);
    }

    public Specialty save(Specialty specialty) {
        if (specialty.getId()== null) {
            return specialtyRepository.save(specialty);
        } else {
            Optional<Specialty> ct = specialtyRepository.getById(specialty.getId());
            if (ct.isEmpty()) {
                return specialtyRepository.save(specialty);
            } else {
                return specialty;
            }
        }
    }

    public Specialty update(Specialty specialty) {
        if (specialty.getId() != null) {
            Optional<Specialty> g = specialtyRepository.getById(specialty.getId());
            if (!g.isEmpty()) {
                if (specialty.getDescription() != null) {
                    g.get().setDescription(specialty.getDescription());
                }
                if (specialty.getName() != null) {
                    g.get().setName(specialty.getName());
                }
                specialtyRepository.save(g.get());
                return g.get();

            } else {
                return specialty;
            }
        } else{
            return specialty;
        }

    }

    public boolean deleteSpecialty(int id){
        Boolean aBoolean= getById(id).map(specialty -> {
            specialtyRepository.delete(specialty);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
