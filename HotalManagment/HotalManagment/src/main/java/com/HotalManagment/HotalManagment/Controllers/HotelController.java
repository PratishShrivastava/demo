package com.HotalManagment.HotalManagment.Controllers;

import com.HotalManagment.HotalManagment.Models.Hotels;
import com.HotalManagment.HotalManagment.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/hotels")

public class HotelController {
    @Autowired
    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @PostMapping
    public ResponseEntity<Hotels> saveHotel(@RequestBody Hotels hotels)
    {
        return new ResponseEntity<Hotels>(hotelService.saveHotel(hotels), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Hotels> getAllHotels()
    {
        return hotelService.getAllHotels();
    }
    @GetMapping("{customerid}")
    public ResponseEntity<Hotels> getHotelsById(@PathVariable("customerid")int customerid)
    {
        return new ResponseEntity<Hotels>(hotelService.getHotelsById(customerid),HttpStatus.OK);
    }
    @PutMapping("{customerid}")
    public ResponseEntity<Hotels> updateHotels(@PathVariable("customerid")int customerid,@RequestBody Hotels hotels)
    {
        return new ResponseEntity<Hotels>(hotelService.updateHotels(hotels,customerid), HttpStatus.OK);
    }
    @DeleteMapping("{customerid}")
    public ResponseEntity<String> deleteHotels(@PathVariable("customerid")int customerid)
    {
        hotelService.deleteHotels(customerid);
        return new ResponseEntity<String>("Books deleted successfully",HttpStatus.OK);
    }
}


