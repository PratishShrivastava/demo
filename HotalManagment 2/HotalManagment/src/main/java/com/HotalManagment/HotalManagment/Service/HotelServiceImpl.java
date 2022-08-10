package com.HotalManagment.HotalManagment.Service;

import com.HotalManagment.HotalManagment.Models.Hotels;
import com.HotalManagment.HotalManagment.Repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepo hotelRepo;

    public HotelServiceImpl(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @Override
    public Hotels saveHotel(Hotels hotels)
    {
        return hotelRepo.save(hotels);
    }
    @Override
    public List<Hotels> getAllHotels()
    {
        return hotelRepo.findAll();
    }
    @Override
    public Hotels getHotelsById(int customerid)
    {
        return hotelRepo.findById(customerid).orElseThrow();
    }
    @Override
    public Hotels updateHotels(Hotels hotels,int customerid)
    {
        Hotels existingHotels=hotelRepo.findById(customerid).orElseThrow();
        existingHotels.setCustomername(hotels.getCustomername());
        existingHotels.setCustomerprice(hotels.getCustomerprice());
        existingHotels.setCustomeraddress(hotels.getCustomeraddress());
        existingHotels.setEmail(hotels.getEmail());
        hotelRepo.save(existingHotels);
        return existingHotels;
    }
    @Override
    public void deleteHotels(int customerid)
    {
        hotelRepo.findById(customerid).orElseThrow();
        hotelRepo.deleteById(customerid);
    }
}
