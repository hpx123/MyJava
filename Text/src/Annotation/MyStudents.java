package Annotation;

@MyTable("tb_student")
public class MyStudents {

    @MyFiled(columnName = "id", type = "int", length = 10)
    private int id;
    @MyFiled(columnName = "sname", type = "varchar", length = 10)
    private String studentName;
    @MyFiled(columnName = "age", type = "int", length = 3)
    private int age;


    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
