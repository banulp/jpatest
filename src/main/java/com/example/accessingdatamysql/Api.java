package com.example.accessingdatamysql;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.Collection;
import java.util.List;

//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;

//@Entity
public class Api {
    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String code;
    private String summary;
    private String gateMethod;
    private String gateUri;
    private String targetUri;
    private String authnType;
    private Integer seq;

//    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL) // (1)
//    @JoinColumn(name="api_id")
    @Transient
    private List<Variable> variableList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getGateMethod() {
        return gateMethod;
    }

    public void setGateMethod(String gateMethod) {
        this.gateMethod = gateMethod;
    }

    public String getGateUri() {
        return gateUri;
    }

    public void setGateUri(String gateUri) {
        this.gateUri = gateUri;
    }

    public String getTargetUri() {
        return targetUri;
    }

    public void setTargetUri(String targetUri) {
        this.targetUri = targetUri;
    }

    public String getAuthnType() {
        return authnType;
    }

    public void setAuthnType(String authnType) {
        this.authnType = authnType;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public List<Variable> getVariableList() {
        return variableList;
    }

    public Api update(List<Variable> variableList) {
        this.variableList = variableList;
        return this;
    }

    public void setVariableList(List<Variable> variableList) {
        this.variableList = variableList;
    }
}
