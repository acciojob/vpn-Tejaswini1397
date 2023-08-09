package com.driver.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

// Note: Do not write @Enumerated annotation above CountryName in this model.
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Country{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
     CountryName countryName;
    String codes;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
     User user;
    @ManyToOne
    @JoinColumn(name = "serviceProvider")
     ServiceProvider serviceProvider;
}