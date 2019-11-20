package com.model;
// Generated Aug 24, 2019 11:38:04 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CtPhieumuon generated by hbm2java
 */
@Entity
@Table(name="CT_PHIEUMUON"
    ,schema="dbo"
    ,catalog="ThuVien"
)
public class CtPhieumuon  implements java.io.Serializable {


    private int maCtpm;
    private PhieuMuon phieuMuon;
    private Sach sach;
    private Integer soLuong;
    private Set<DauSachCtpm> dauSachCtpm =  new HashSet<DauSachCtpm>(0);
    public CtPhieumuon() {
    }

	
    public CtPhieumuon(int maCtpm) {
        this.maCtpm = maCtpm;
    }
    public CtPhieumuon(int maCtpm, PhieuMuon phieuMuon, Sach sach, Integer soLuong, Set<CtLoi> ctLois) {
       this.maCtpm = maCtpm;
       this.phieuMuon = phieuMuon;
       this.sach = sach;
       this.soLuong = soLuong;
    }
   
     @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="maCTPM", unique=true, nullable=false)
    public int getMaCtpm() {
        return this.maCtpm;
    }
    
    public void setMaCtpm(int maCtpm) {
        this.maCtpm = maCtpm;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="maPM")
    public PhieuMuon getPhieuMuon() {
        return this.phieuMuon;
    }
    
    public void setPhieuMuon(PhieuMuon phieuMuon) {
        this.phieuMuon = phieuMuon;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="maSach")
    public Sach getSach() {
        return this.sach;
    }
    
    public void setSach(Sach sach) {
        this.sach = sach;
    }

    
    @Column(name="soLuong")
    public Integer getSoLuong() {
        return this.soLuong;
    }
    
    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }


    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="cTPhieuMuon")
    public Set<DauSachCtpm> getDauSachCtpm() {
        return dauSachCtpm;
    }

    public void setDauSachCtpm(Set<DauSachCtpm> dauSachCtpm) {
        this.dauSachCtpm = dauSachCtpm;
    }




}


