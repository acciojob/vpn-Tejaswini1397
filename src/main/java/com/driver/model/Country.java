package com.driver.model;

import javax.persistence.*;

// Note: Do not write @Enumerated annotation above CountryName in this model.
public class Country{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private CountryName countryName;
    private String codes;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private User user;
    @ManyToOne
    @JoinColumn(name = "serviceProvider")
    private ServiceProvider serviceProvider;

    public Country() {
    }

    public Country(String codes, User user, ServiceProvider serviceProvider) {
        this.codes = codes;
        this.user = user;
        this.serviceProvider = serviceProvider;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CountryName getCountryName() {
        return countryName;
    }

    public void setCountryName(CountryName countryName) {
        this.countryName = countryName;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
}