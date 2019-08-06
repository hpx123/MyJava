package JDBC_Test;

public class Emp {

    private Integer id;
    private String empName;
    private Integer salary;
    private Integer age;

    public Emp(String empName, Integer salary, Integer age) {
        this.empName = empName;
        this.salary = salary;
        this.age = age;
    }

    public Emp(Integer id, String empName, Integer salary, Integer age) {
        this.id = id;
        this.empName = empName;
        this.salary = salary;
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setempName(String empName) {
        this.empName = empName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getempName() {
        return empName;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getAge() {
        return age;
    }



    public Emp(String string, Object object, Object rsObject){

    }
}
