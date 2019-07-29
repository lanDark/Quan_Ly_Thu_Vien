package com.model;
// Generated Jul 20, 2019 1:55:41 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Rules generated by hbm2java
 */
@Entity
@Table(name="rules"
    ,schema="dbo"
    ,catalog="Libary"
)
public class Rules  implements java.io.Serializable {


     private int id;
     private String nameRules;
     private Set<NguoiDung> nguoiDungs = new HashSet<NguoiDung>(0);

    public Rules() {
    }

	
    public Rules(int id) {
        this.id = id;
    }
    public Rules(int id, String nameRules, Set<NguoiDung> nguoiDungs) {
       this.id = id;
       this.nameRules = nameRules;
       this.nguoiDungs = nguoiDungs;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="nameRules", length=30)
    public String getNameRules() {
        return this.nameRules;
    }
    
    public void setNameRules(String nameRules) {
        this.nameRules = nameRules;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="rules")
    public Set<NguoiDung> getNguoiDungs() {
        return this.nguoiDungs;
    }
    
    public void setNguoiDungs(Set<NguoiDung> nguoiDungs) {
        this.nguoiDungs = nguoiDungs;
    }




}


