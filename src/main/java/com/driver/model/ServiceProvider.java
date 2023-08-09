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
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false, unique = true)
     String name;

    @OneToMany
    @JoinColumn(name="admin")
    Admin admin;
    @ManyToMany(mappedBy = "serviceProvider",cascade = CascadeType.ALL)
    List<User> users;
    @OneToMany(mappedBy = "serviceProvider",cascade = CascadeType.ALL)
     List<Connection>connectionList;
    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL)
     List<Country>countryList;
}
