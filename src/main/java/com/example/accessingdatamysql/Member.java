package com.example.accessingdatamysql;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//import javax.persistence.*;

//@Entity
public class Member {

    @Id
    @Column("seq")
//    @Column(name="seq")
//    @GeneratedValue(strategy=GenerationType.AUTO)
    private long seq;

    @Column("name")
//    @Column(name="name")
    private String name;

    // r2dbc 는 ORM 안됨
//    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL) // (1)
//    @JoinColumn(name="member_id")
//    private Collection<Phone> phone;
    @Transient
    private List<Phone> phones;

    public Member(){}

    public Member(String name){
        this.name = name;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long id) {
        this.seq = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public void addPhone(Phone p){
        if( phones == null ){
            phones = new ArrayList<Phone>();
        }
        phones.add(p);
    }

    public Member update(List<Phone> phones) {
        this.phones = phones;
        return this;
    }

    @Override
    public String toString() {
        String result = "["+seq+"] " + name;
        for( Phone p : phones ){
            result += "\n" + p.toString();
        }
        return result;
    }
}