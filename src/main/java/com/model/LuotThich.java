package com.model;
// Generated Aug 24, 2019 11:38:04 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * LuotThich generated by hbm2java
 */
@Entity
@Table(name="luotThich"
    ,schema="dbo"
    ,catalog="Libary"
)
public class LuotThich  implements java.io.Serializable {


     private int id;
     private NguoiDung nguoiDung;
     private Sach sach;

    public LuotThich() {
    }

	
    public LuotThich(int id) {
        this.id = id;
    }
    public LuotThich(int id, NguoiDung nguoiDung, Sach sach) {
       this.id = id;
       this.nguoiDung = nguoiDung;
       this.sach = sach;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="maNguoiDung")
    public NguoiDung getNguoiDung() {
        return this.nguoiDung;
    }
    
    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="maSach")
    public Sach getSach() {
        return this.sach;
    }
    
    public void setSach(Sach sach) {
        this.sach = sach;
    }




}


