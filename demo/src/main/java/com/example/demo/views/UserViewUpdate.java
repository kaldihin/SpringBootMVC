package com.example.demo.views;

import io.swagger.annotations.ApiModelProperty;
import com.example.demo.models.User;

import javax.validation.constraints.NotNull;
import java.sql.Date;

public class UserViewUpdate {

    @ApiModelProperty(hidden = true)

    @NotNull(message = "id обязательный параметр")
    private Integer id;

    private Integer officeId;

    @NotNull(message = "firstName обязательный параметр")
    private String firstName;

    private String secondName;

    private String middleName;

    private String lastName;

    @NotNull(message = "position обязательный параметр")
    private String position;

    private Integer docCode;

    private String docName;

    private Integer docNumber;

    private Date docDate;

    private String citizenshipName;

    private Integer citizenshipCode;

    private String phone;

    private Boolean isIdentified;

    public UserViewUpdate() {}

    public UserViewUpdate(User user) {
        this.id = user.getId();
        this.officeId = user.getOfficeId();
        this.firstName = user.getFirstName();
        this.secondName = user.getSecondName();
        this.middleName = user.getMiddleName();
        this.lastName = user.getLastName();
        this.position = user.getPosition();
        this.docCode = user.getDocCode();
        this.docNumber = user.getDocNumber();
        this.docName = user.getDocName();
        this.docDate = user.getDocDate();
        this.citizenshipName = user.getCitizenshipName();
        this.citizenshipCode = user.getCitizenshipCode();
        this.phone = user.getPhone();
        this.isIdentified = user.getIsIdentified();
    }

    @Override
    public String toString() {
        return "{user_id:" + id + ";user_office_id:" + officeId + ";user_firstname:" +
                firstName + ";user_secondname:" + secondName + ";user_middlename:" +
                middleName + ";user_lastname:" + lastName + ";user_position:" +
                position + ";user_doc_code:" + docCode + ";user_doc_name:" + docName +
                ";user_doc_number:" + docNumber + ";user_doc_date:" + docDate +
                ";user_citizenship_name:" + citizenshipName + ";user_citizenship_code:" +
                citizenshipCode + ";user_phone:" + phone + ";user_is_identified:" + isIdentified + "}";
    }

    @NotNull
    public Integer getId() {
        return id;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    @NotNull
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

    @NotNull
    public String getPosition() {
        return position;
    }

    public Integer getDocCode() {
        return docCode;
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
        return citizenshipCode;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getIsIdentified() {
        return isIdentified;
    }

    public void setId(@NotNull Integer id) {
        this.id = id;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public void setFirstName(@NotNull String firstName) {
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

    public void setPosition(@NotNull String position) {
        this.position = position;
    }

    public void setDocCode(Integer docCode) {
        this.docCode = docCode;
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

    public void setCitizenshipCode(Integer citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

}