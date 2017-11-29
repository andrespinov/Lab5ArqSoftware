package com.udea.microserviceclient;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Client implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String clientName;
    private String email;
    private String cellNumber;

    @Override
    public String toString() {
        return "A client{"
                + "id:" + id
                + ", clientName='" + clientName
                + ", email='" + email
                + ", cellNumber='" + cellNumber + '\''
                + '}';
    }

    public Client() {
    }

    public Client(String clientName, String email, String cellNumber) {
        this.clientName = clientName;
        this.email = email;
        this.cellNumber = cellNumber;
    }

    public Long getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public String getEmail() {
        return email;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }
    
}
