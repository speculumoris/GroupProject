package Trial.onetoone;

import javax.persistence.*;

@Entity
public class Developer01 {

    @Id
    private int  id;

    @Column(name = "dev_Name",nullable = false)
    private String name;

    @OneToOne
    @JoinColumn
    private Laptop01 laptop;

    public Developer01() {
    }

    public Developer01(int id, String name, Laptop01 laptop) {
        this.id = id;
        this.name = name;
        this.laptop = laptop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Laptop01 getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop01 laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Developer01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", laptop=" + laptop +
                '}';
    }

}
