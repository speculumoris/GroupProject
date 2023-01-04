package Trial.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Laptop01 {

    @Id
    private int id;
    @Column(name = "name",nullable = false)
    private String serialNo;

    private String brand;

    @OneToOne(mappedBy = "laptop")
    private Developer01 developer;

    public Laptop01() {
    }

    public Laptop01(int id, String name, String mark) {
        this.id = id;
        this.serialNo = name;
        this.brand = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    @Override
    public String toString() {
        return "Laptop01{" +
                "id=" + id +
                ", name='" + serialNo + '\'' +
                ", mark='" + brand + '\'' +
                '}';
    }
}
