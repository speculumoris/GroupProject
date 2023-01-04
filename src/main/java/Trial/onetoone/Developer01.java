package Trial.onetoone;

import javax.persistence.*;

@Entity
public class Developer01 {

    @Id
    private int  id;

    @Column(name = "dev_Name",nullable = false)
    private String name;

    private String eMail;

    private String branch;




    @OneToOne
    @JoinColumn(name="laptop_id")
    private Laptop01 laptop;

    public Developer01() {
    }

    public Developer01(int id, String name, Laptop01 laptop) {
        this.id = id;
        this.name = name;
        this.laptop = laptop;
    }

    public Developer01(int id, String name, String eMail, String branch, Laptop01 laptop) {
        this.id = id;
        this.name = name;
        this.eMail = eMail;
        this.branch = branch;
        this.laptop = laptop;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
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
