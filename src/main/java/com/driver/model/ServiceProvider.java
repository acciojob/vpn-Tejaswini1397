package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany
    @JoinColumn(name="admin")
    private Admin admin;
    @ManyToMany(mappedBy = "serviceProvider",cascade = CascadeType.ALL)
    private List<User> users;
    @OneToMany(mappedBy = "serviceProvider",cascade = CascadeType.ALL)
    private List<Connection>connectionList;
    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL)
    private List<Country>countryList;

    public ServiceProvider(Admin admin, List<User> users) {
        this.admin = admin;
        this.users = users;
        this.connectionList = new ArrayList<>();
        this.countryList = new ArrayList<>();
    }

    public ServiceProvider() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
}