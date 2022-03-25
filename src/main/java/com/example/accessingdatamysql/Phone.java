package com.example.accessingdatamysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phone {

    @Id
    @Column(name="seq")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int seq;

    @Column(name="member_id")
    private int memberId;

    @Column(name="no")
    private String no;

    public Phone() {}
    public Phone(String no){
        this.no = no;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public String toString() {
        String result = "[phone_"+seq+"] " + no;
        return result;
    }
}