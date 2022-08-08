package com.HotalManagment.HotalManagment.Service;

import com.HotalManagment.HotalManagment.Models.Hotels;
import java.util.List;

public interface HotelService {
    Hotels saveHotel(Hotels hotels);
    List<Hotels> getAllHotels();
    Hotels getHotelsById(int customerid);
    Hotels updateHotels(Hotels hotels,int customerid);
    void deleteHotels(int customerid);
}
