package com.example.demo.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Справочник по кодам стран
 */
@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id")
    private Integer countryId;

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


    /**
     * Код страны
     */
    @Column(name = "country_code", unique = true)
    private Integer countryCode;

    public Country() {

    }

    public Country(String countryName, Integer version, Integer countryCode) {
        this.countryName = countryName;
        this.version = version;
        this.countryCode = countryCode;
    }

    @OneToMany(mappedBy = "citizenshipCode", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getCountryName() {
        return countryName;
    }

    public Integer getVersion() {
        return version;
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

}