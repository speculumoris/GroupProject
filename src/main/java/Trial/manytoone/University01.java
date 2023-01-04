package Trial.manytoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class University01 {

    @Id
    private int id;

    @Column(unique = true,nullable = false)
    private String name;


    public University01(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "University01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
