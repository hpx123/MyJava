package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo02 {
    public static void main(String[] args) {

        String path = "Reflection.User";
        try {
            //通过反射API动态调用构造方法，构造对象
            Class<User> clazz = (Class<User>)Class.forName(path);
            User u = clazz.newInstance();//调用了User的无参构造器方法

            Constructor<User> c = clazz.getDeclaredConstructor(int.class, int.class, String.class);
            User u2 = c.newInstance(1001,18, "胡图");
            System.out.println(u2.getUname());

            //通过反射API动态调用普通方法
            User u3 = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("setUname", String.class);
            method.invoke(u3, "huhu");
            System.out.println(u3.getUname());

            //通过反射API操作属性
            User u4 = clazz.newInstance();
            Field f = clazz.getDeclaredField("uname");
            f.setAccessible(true);//该属性不需要做安全检查
            f.set(u4, "胡美丽");//通过反射写属性
            System.out.println(f.getName());
            System.out.println(f.get(u4));//通过反射直接读属性


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
