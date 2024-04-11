package com.rtofinalproject.registrations.services;


import org.springframework.stereotype.Service;

import com.rtofinalproject.registrations.model.LicenseRegisterModel;

@Service
public class LicenseDetailsService {
	
	

	public static String generateLicenseNumber(LicenseRegisterModel licenseDetails) {
        // Example: State-Age-Initials-RandomString
		System.out.println(licenseDetails);
        String randomString = licenseDetails.generateRandomString(6); // Generate a random alphanumeric string
        return licenseDetails.getState() + "-" + licenseDetails.getAge() +
               "-" + licenseDetails.getFullName().substring(0, 2).toUpperCase() +
               "-" + randomString;
    }

	}
