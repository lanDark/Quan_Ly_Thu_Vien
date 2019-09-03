package com.model;
// Generated Aug 24, 2019 11:38:04 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DauSachCtpmId generated by hbm2java
 */
@Embeddable
public class DauSachCtpmId  implements java.io.Serializable {


     private int maCtpm;
     private String barcode;

    public DauSachCtpmId() {
    }

    public DauSachCtpmId(int maCtpm, String barcode) {
       this.maCtpm = maCtpm;
       this.barcode = barcode;
    }
   


    @Column(name="maCTPM", nullable=false)
    public int getMaCtpm() {
        return this.maCtpm;
    }
    
    public void setMaCtpm(int maCtpm) {
        this.maCtpm = maCtpm;
    }


    @Column(name="barcode", nullable=false, length=10)
    public String getBarcode() {
        return this.barcode;
    }
    
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DauSachCtpmId) ) return false;
		 DauSachCtpmId castOther = ( DauSachCtpmId ) other; 
         
		 return (this.getMaCtpm()==castOther.getMaCtpm())
 && ( (this.getBarcode()==castOther.getBarcode()) || ( this.getBarcode()!=null && castOther.getBarcode()!=null && this.getBarcode().equals(castOther.getBarcode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getMaCtpm();
         result = 37 * result + ( getBarcode() == null ? 0 : this.getBarcode().hashCode() );
         return result;
   }   


}

