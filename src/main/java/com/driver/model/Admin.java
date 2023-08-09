package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "serviceProvider",cascade = CascadeType.ALL)
    private List<ServiceProvider>serviceProviders;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
       serviceProviders=new ArrayList<>();
    }

    public Admin() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ServiceProvider> getProviderList() {
        return serviceProviders;
    }

    public void setProviderList(List<ServiceProvider> providerList) {
        this.serviceProviders = providerList;
    }
}
