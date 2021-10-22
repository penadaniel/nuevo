/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositirios;

import Modelo.Reservation;
import Interfaces.interfaceReservation;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public class RepositorioReservation implements Serializable{
    @Autowired
    private interfaceReservation crud3;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) crud3.findAll();
    }
    public Optional <Reservation> getReservation(int id){
        return crud3.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return crud3.save(reservation);
    }
    public void delete(Reservation reservation){
        crud3.delete(reservation);
    }
}
