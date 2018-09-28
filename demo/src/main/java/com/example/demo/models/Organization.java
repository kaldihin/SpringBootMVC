package com.example.demo.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Организация
 */
@Entity
@Table(name = "organization")
@NamedQuery(name = "Organization.getAll", query = "SELECT c from Organization c")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id", updatable = false)
    private Integer oId;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Служебное поле hibernate
     */
    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    /**
     * Название Организации
     */
    @Column(name = "organization_name", length = 50)
    private String name;

    /**
     * Полное название Организации
     */
    @Column(name = "organization_fullname", length = 50)
    private String fullName;

    /**
     * ИНН Организации
     */
    @Column(name = "organization_inn")
    private Integer inn;

    /**
     * КПП Организации
     */
    @Column(name = "organization_kpp")
    private Integer kpp;

    /**
     * Адрес организации
     */
    @Column(name = "organization_address", length = 70)
    private String address;

    /**
     * Телефон организации
     */
    @Column(name = "organization_phone", length = 20)
    private String phone;

    /**
     * Состояние организации
     */
    @Column(name = "organization_is_active")
    private Boolean isActive;

    public Organization() {

    }

    public Organization(Integer oId, String name, String fullName, Integer inn, Integer version,
                        Integer kpp, String address, String phone, Boolean isActive) {
        this.oId = oId;
        this.name = name;
        this.fullName = fullName;
        this.version = version;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }



    @OneToMany(mappedBy = "orgId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Office> offices;

    public Set<Office> getOffices() {
        return this.offices;
    }

    public Integer getoId() {
        return oId;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getInn() {
        return inn;
    }

    public Integer getKpp() {
        return kpp;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setInn(Integer inn) {
        this.inn = inn;
    }

    public void setKpp(Integer kpp) {
        this.kpp = kpp;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }
}