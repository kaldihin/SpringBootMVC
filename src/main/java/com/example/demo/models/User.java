package com.example.demo.models;


import javax.persistence.*;
import java.sql.Date;

/**
 * Сотрудник
 */
@Entity
@Table(name = "user")
public class User {

    /**
     * Идентификатор сотрудника
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer uId;

    /**
     * Идентификатор офиса сотрудника
     */
    @Column(name = "user_office_id")
    private Integer officeId;

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
     * Имя сотрудника
     */
    @Column(name = "user_firstname", length = 50)
    private String firstName;

    /**
     * Фамилия сотрудника
     */
    @Column(name = "user_secondname", length = 50)
    private String secondName;

    /**
     * Полуимя сотрудника
     */
    @Column(name = "user_middlename", length = 50)
    private String middleName;

    /**
     * Кличка сотрудника
     */
    @Column(name = "user_lastname", length = 50)
    private String lastName;

    /**
     * Должность сотрудника
     */
    @Column(name = "user_position", length = 50)
    private String position;

    /**
     * Документальный код сотрудника
     */
    @Column(name = "user_doc_code")
    private Integer docCode;

    /**
     * Документальное имя сотрудника
     */
    @Column(name = "user_doc_name", length = 50)
    private String docName;

    /**
     * Документальный номер сотрудника
     */
    @Column(name = "user_doc_number")
    private Integer docNumber;

    /**
     * Документальная дата сотрудника
     */
    @Column(name = "user_doc_date")
    private Date docDate;

    /**
     * Гражданство сотрудника
     */
    @Column(name = "user_citizenship_name", length = 50)
    private String citizenshipName;

    /**
     * Код гражданства сотрудника
     */
    @Column(name = "user_citizenship_code")
    private Integer citizenshipCode;

    /**
     * Телефон сотрудника
     */
    @Column(name = "user_phone", length = 20)
    private String phone;

    /**
     * Идентификация сотрудника
     */
    @Column(name = "user_is_identified")
    private Boolean isIdentified;

    public User() {

    }

    public User(Integer uId, Integer officeId, Integer version, String firstName, String secondName,
                String middleName, String lastName, String position, Integer docCode,
                String docName, Integer docNumber, Date docDate, String citizenshipName,
                Integer citizenshipCode, String phone, Boolean isIdentified) {

        this.uId = uId;
        this.officeId = officeId;
        this.version = version;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.position = position;
        this.docCode = docCode;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipName = citizenshipName;
        this.citizenshipCode = citizenshipCode;
        this.phone = phone;
        this.isIdentified = isIdentified;
    }



    @ManyToOne
    @JoinColumn(name="ofId")
    private Office offices;

    public Office getOffices() {
        if (offices == null) {
            offices = new Office();
        }
        return offices;
    }



    @ManyToOne
    @JoinColumn(name="code")
    private Doc docs;

    public Doc getDocs() {
        if (docs == null) {
            docs = new Doc();
        }
        return docs;
    }

    @ManyToOne
    @JoinColumn(name="countryCode")
    private Country countries;

    public Country getCountries() {
        if (countries == null) {
            countries = new Country();
        }
        return countries;
    }

    public Integer getId() {
        return uId;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public Integer getDocCode() {
        return docs.getCode();
    }

    public String getDocName() {
        return docName;
    }

    public Integer getDocNumber() {
        return docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public Integer getCitizenshipCode() {
        return countries.getCountryCode();
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getIsIdentified() {
        return isIdentified;
    }

    public void setId(Integer id) {
        this.uId = id;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDocCode() {
        this.docCode = docs.getCode();
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public void setDocNumber(Integer docNumber) {
        this.docNumber = docNumber;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public void setCitizenshipCode() {
        this.citizenshipCode = countries.getCountryCode();
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

    public void setOffices(Office offices) {
        this.offices = offices;
    }

    public void setDocs(Doc docs) {
        this.docs = docs;
    }

    public void setCountries(Country countries) {
        this.countries = countries;
    }

}