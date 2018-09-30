package com.example.demo.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Документ
 */
@Entity
@Table(name = "doc")
public class Doc {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "doc_id")
//    private Integer docId;

    @Column(name = "doc_name", length = 50, nullable = false)
    private String name;

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
     * Код документа
     */
    @Id
    @Column(name = "doc_code", unique = true)
    private Integer code;

    public Doc() {

    }

    public Doc(String name, Integer code) {
        this.name = name;
        this.code = code;
    }



    @OneToMany(mappedBy = "docCode", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users;

    public Set<User> getUsers() {
        return this.users;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}