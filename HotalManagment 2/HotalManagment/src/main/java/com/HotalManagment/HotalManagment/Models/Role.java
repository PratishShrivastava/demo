package com.HotalManagment.HotalManagment.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int customerid;
    private String name;
}