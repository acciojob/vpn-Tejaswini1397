package com.driver.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String username;
    String password;
    String originalIp;
    String maskedIp;
    boolean connected;
    @ManyToOne
    @JoinColumn(name = "serviceProvider")
    List<ServiceProvider>serviceProviderList;
    @OneToMany(mappedBy = "connection", cascade = CascadeType.ALL)
    List<Connection>connectionList;
    @OneToOne
    @JoinColumn(name = "country")
     Country country;
}
