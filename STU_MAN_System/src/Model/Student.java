package Model;

public class Student {
    private Integer id;
    private String stuname;
    private String stupwd;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public void setStupwd(String stupwd) {
        this.stupwd = stupwd;
    }

    public Integer getId() {
        return id;
    }

    public String getStuname() {
        return stuname;
    }

    public String getStupwd() {
        return stupwd;
    }
}
