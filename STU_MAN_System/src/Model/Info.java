package Model;

public class Info {
    private Integer id;
    private String StuID;
    private String StuName;
    private Integer StuGrade;
    private Integer StuAge;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStuID(String stuID) {
        StuID = stuID;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public void setStuGrade(Integer stuGrade) {
        StuGrade = stuGrade;
    }

    public void setStuAge(Integer stuAge) {
        StuAge = stuAge;
    }

    public Integer getId() {
        return id;
    }

    public String getStuID() {
        return StuID;
    }

    public String getStuName() {
        return StuName;
    }

    public Integer getStuGrade() {
        return StuGrade;
    }

    public Integer getStuAge() {
        return StuAge;
    }

}
