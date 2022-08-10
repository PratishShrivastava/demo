package com.HotalManagment.HotalManagment.Security;

import com.HotalManagment.HotalManagment.Models.Hotels;
import com.HotalManagment.HotalManagment.Repository.HotelRepo;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Component
public class HotelDetails implements UserDetailsService  {
    @Autowired
    private HotelRepo hotelRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hotels hotels = this.hotelRepo.findByEmail(username).orElseThrow();
        return hotels;
    }
}