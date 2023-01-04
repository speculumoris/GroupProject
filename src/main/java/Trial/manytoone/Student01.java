package Trial.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Student01 {

    @Id
    private int id;

    @Column(name="Student_name",nullable = false)
    private String name;


    private int grade;

    private LocalDateTime createOn;

    @ManyToOne
    @JoinColumn(name = "University_id")
    private University01 university;

    public Student01(int id, String name, int grade, University01 university) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.university = university;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

   // public void setCreateOn(LocalDateTime createOn) {
   //     this.createOn = createOn;
   // }

    public University01 getUniversity() {
        return university;
    }

    public void setUniversity(University01 university) {
        this.university = university;
    }
    @PrePersist //Tarihini ve zamanın kalıcı olabilmesi icin
    public void dateTime(){
        createOn=LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", university=" + university +
                '}';
    }
}
