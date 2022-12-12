package SchoolProject;

public class Teacher {
    private String teacherName;
    private String tTelNo;
    private String branch;

    public Teacher(String teacherName, String tTelNo, String branch) {
        this.teacherName = teacherName;
        this.tTelNo = tTelNo;
        this.branch = branch;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String gettTelNo() {
        return tTelNo;
    }

    public void settTelNo(String tTelNo) {
        this.tTelNo = tTelNo;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherName='" + teacherName + '\'' +
                ", tTelNo='" + tTelNo + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
