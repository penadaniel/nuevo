/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Doctor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "messages")
public class Message implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties({"message", "client", "reservations"})
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"message","reservations", "client"})
    private IntegrationProperties.RSocket.Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public IntegrationProperties.RSocket.Client getClient() {
        return client;
    }

    public void setClient(IntegrationProperties.RSocket.Client client) {
        this.client = client;
    }

   
    
    
}
