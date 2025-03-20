package com.wellsfargo.counselor.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
public class Portfolio {

    @Id
    @GeneratedValue
    private long portfolio_id;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false, unique = true)
    private Client client;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities;
    protected  Portfolio(){
        this.createdDate = LocalDateTime.now();
    }

    public Portfolio(Client client) {
        this.client = client;
        this.createdDate = LocalDateTime.now();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public long getPortfolio_id() {
        return portfolio_id;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
