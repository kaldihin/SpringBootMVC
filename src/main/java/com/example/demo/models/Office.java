package com.example.demo.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Офис
 */
@Entity
@Table(name = "office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "office_id", updatable = false)
    private Integer ofId;

    /**
     * Служебное поле hibernate
     */
    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    /**
     * Идентификатор организации офиса
     */
    @Column(name = "office_org_id")
    private Integer orgId;

    /**
     * Наименование офиса
     */
    @Column(name = "office_name", length = 50)
    private String name;

    /**
     * Адрес офиса
     */
    @Column(name = "office_address", length = 70)
    private String address;

    /**
     * Телефон офиса
     */
    @Column(name = "office_phone", length = 20)
    private String phone;

    /**
     * Состояние офиса
     */
    @Column(name = "office_is_active")
    private Boolean isActive;

    public Office() {

    }

    public Office(Integer ofId, Integer version, Integer orgId, String name,
                  String address, String phone, Boolean isActive) {
        this.ofId = ofId;
        this.version = version;
        this.orgId = orgId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    @ManyToOne
    @JoinColumn(name="oId")
    private Organization organizations;

    public Organization getOrganizations() {
        if (organizations == null) {
            organizations = new Organization();
        }
        return organizations;
    }

    public void setOrganizations(Organization organizations) {
        this.organizations = organizations;
    }

    @OneToMany(mappedBy = "officeId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users;

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Integer getOfId() {
        return ofId;
    }

    public Integer getVersion() {
        return version;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public String getName() {
        return name;
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

    public void setOfId(Integer ofId) {
        this.ofId = ofId;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public void setName(String name) {
        this.name = name;
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

}