package Reflection;

public class User {
    private int id;
    private int age;
    private String uname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUname() {
        return uname;
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.uname = name;
    }

    public User(){

   }
}
