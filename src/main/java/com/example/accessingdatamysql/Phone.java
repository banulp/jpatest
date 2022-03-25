package com.example.accessingdatamysql;

//import javax.persistence.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;

//@Entity
public class Phone {

    @Id
//    @Column(name="seq")
    @Column("seq")
//    @GeneratedValue(strategy=GenerationType.AUTO)
    private int seq;

    @Column("member_id")
//    @Column(name="member_id")
    private long memberId;

    @Column("no")
//    @Column(name="no")
    private String no;

//    @Transient
//    private Member member;
//
//    public Member getMember() {
//        return member;
//    }
//
//    public void setMember(Member member) {
//        this.member = member;
//    }

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

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
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