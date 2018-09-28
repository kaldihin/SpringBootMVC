package com.example.demo.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Справочник по кодам стран
 */
@Entity
@Table(name = "country")
public class Country {

    /**
     * Наименование страны
     */
    @Column(name = "country_name", length = 50, nullable = false)
    private String countryName;

    /**
     * Служебное поле hibernate
     */
    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Код страны
     */
    @Id
    @Column(name = "country_code")
    private Integer countryCode;

    public Country() {

    }

    public Country(String countryName, Integer countryCode) {
        this.countryName = countryName;
        this.countryCode = countryCode;
    }



    @OneToMany(mappedBy = "citizenshipCode", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public String getCountryName() {
        return countryName;
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}