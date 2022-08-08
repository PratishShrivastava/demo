package com.HotalManagment.HotalManagment.Models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.*;
@Data
@Entity
//@Table(name="HotelDetails")
public class Hotels implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerid;
    @Column(nullable = false)
    private String customername;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private int customerprice;
    @Column(nullable = false)
    private String customeraddress;

    @Column(nullable = false)
    private String password;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "Hotels", referencedColumnName = "customerid"), inverseJoinColumns = @JoinColumn(name = "Role", referencedColumnName = "customerid"))
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = this.roles.stream().map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}