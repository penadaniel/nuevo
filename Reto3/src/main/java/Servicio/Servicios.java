/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Repositirios.Repositorio;
import Modelo.Doctor;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class Servicios implements Serializable{
    @Autowired
    private Repositorio metodosCrud;
    
    public List<Doctor> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Doctor> getDoctor(int id){
        return metodosCrud.getDoctor(id);
    }
    public Doctor save(Doctor doctor){
        if(doctor.getId()==null){
            return metodosCrud.save(doctor);
        }else{
            Optional<Doctor> evt=metodosCrud.getDoctor(doctor.getId());
            if(!evt.isPresent()){
                return metodosCrud.save(doctor);
            }else{
            return doctor;
            }
        }
    }
    public Doctor update(Doctor doctor){
        if(doctor.getId()!=null){
            Optional<Doctor> evt=metodosCrud.getDoctor(doctor.getId());
            if(evt.isPresent()){
                if(doctor.getName()!=null){
                    evt.get().setName(doctor.getName());
                }
                if(doctor.getDepartment()!=null){
                    evt.get().setDepartment(doctor.getDepartment());
                }
                if(doctor.getYear()!=null){
                    evt.get().setYear(doctor.getYear());
                }
                if(doctor.getDescription()!=null){
                    evt.get().setDescription(doctor.getDescription());
                }
                if(doctor.getSpecialty()!=null){
                    evt.get().setSpecialty(doctor.getSpecialty());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return doctor;
            }
        }else{
            return doctor;
        }
    }


    public boolean deleteDoctor(int Id) {
        Boolean aBoolean = getDoctor(Id).map(doctor -> {
            metodosCrud.delete(doctor);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
