/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Modelo.Reservation;
import Repositirios.RepositorioReservation;
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
public class ServiciosReservation implements Serializable{
    @Autowired
    private RepositorioReservation metodosCrud;
    
    public List<Reservation> getAll(){
         return metodosCrud.getAll();
    }
    
    public Optional<Reservation> getReservation(int idReservation){
        return metodosCrud.getReservation(idReservation);
    }
    
    
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservation> evt=metodosCrud.getReservation(reservation.getIdReservation());
            if(!evt.isPresent()){
            return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        
        
        }
    }
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> evt= metodosCrud.getReservation(reservation.getIdReservation());
            if(evt.isPresent()){

                if(reservation.getStartDate()!=null){
                    evt.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    evt.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    evt.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int idReservation) {
        Boolean aBoolean = getReservation(idReservation).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
