package com.HotalManagment.HotalManagment.Repository;

import com.HotalManagment.HotalManagment.Models.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepo extends JpaRepository<Hotels, Integer> {
    Optional<Hotels> findByEmail(String email);
}