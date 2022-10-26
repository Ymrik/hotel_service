package com.umarbariev.projects.hotel_service.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "clients_additional_services")
public class ClientAdditionalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_additional_service_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "additional_service_id")
    private AdditionalService additionalService;
    @Column(name = "ds")
    private Date ds;
    @Column(name = "de")
    private Date de;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public AdditionalService getAdditionalService() {
        return additionalService;
    }

    public void setAdditionalService(AdditionalService additionalService) {
        this.additionalService = additionalService;
    }

    public Date getDs() {
        return ds;
    }

    public void setDs(Date ds) {
        this.ds = ds;
    }

    public Date getDe() {
        return de;
    }

    public void setDe(Date de) {
        this.de = de;
    }
}
