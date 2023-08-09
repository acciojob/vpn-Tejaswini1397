package com.driver.services.impl;

import com.driver.model.Admin;
import com.driver.model.ServiceProvider;
import com.driver.repository.AdminRepository;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository1;

    @Autowired
    ServiceProviderRepository serviceProviderRepository1;

    @Autowired
    CountryRepository countryRepository1;

    @Override
    public Admin register(String username, String password) {
       Admin admin=new Admin();
       admin.setUsername(username);
       admin.setPassword(password);
       Admin savedAdmin=adminRepository1.save(admin);
       return savedAdmin;
    }

    @Override
    public Admin addServiceProvider(int adminId, String providerName) {
        Admin admin=adminRepository1.findById(adminId).get();
        if(admin!=null){
            ServiceProvider serviceProvider=new ServiceProvider();
            serviceProvider.setName(providerName);
            List<ServiceProvider> serviceProviderList = admin.getServiceProviders();
            serviceProviderList.add(serviceProvider); // Add the new ServiceProvider to the list

            admin.setServiceProviders(serviceProviderList); // Update the list in the Admin entity
            adminRepository1.save(admin);
        }
        return admin;
    }

    @Override
    public ServiceProvider addCountry(int serviceProviderId, String countryName) throws Exception{
        return null;
    }
}
