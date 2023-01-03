package warehouseproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_urunler")
public class Urunler {

    @Id
    private Long urunId;
    @Column(name ="URUN" ,nullable = false)
    private String urunIsmi;
    @Column(name = "URETICI",nullable = false)
    private String uretici;
    @Column(name="BIRIM",nullable = false)
    private String birim;
    @Column(name="BIRIM",nullable = false)
    private int miktar;
    @Column(name="RAFNO",nullable = false)
    private String rafNo;

    public Urunler() {
    }

    public Urunler(String urunIsmi, String uretici, String birim, int miktar, String rafNo) {
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.birim = birim;
        this.miktar = miktar;
        this.rafNo = rafNo;

    }


    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public void setUrunIsmi(String urunIsmi) {

        this.urunIsmi = urunIsmi;
    }

    public String getUretici() {
        return uretici;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public String getRafNo() {
        return rafNo;
    }

    public void setRafNo(String rafNo) {
        this.rafNo = rafNo;
    }

    @Override
    public String toString() {
        return " Depo'daki urunler: " +
                "urunIsmi=" + urunIsmi +
                ", uretici=" + uretici  +
                ", birim=" + birim   +
                ", miktar=" + miktar +
                ", rafNo=" + rafNo ;
    }


}
