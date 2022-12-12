package com.umarbariev.projects.hotel_service.entities.additionalService;

import com.umarbariev.projects.hotel_service.entities.client.Client;

import javax.persistence.*;

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
    @Column(name = "cost")
    private Double cost;

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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setAdditionalService(AdditionalService additionalService) {
        this.additionalService = additionalService;
    }
}
