package Annotation;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注释的信息,模拟处理信息的流程
 */
public class Demo01 {

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("Annotation.MyStudents");
            Annotation[] annotations = clazz.getAnnotations();
            //获得类的所有注解
            for(Annotation a : annotations){
                System.out.println(a);
            }
            //获得类的指定注解
            //MyTable myTable = (MyTable) clazz.getAnnotations(MyTable.class);
            //获得类的属性注解
            Field f = clazz.getDeclaredField("studentName");
            //MyFiled myFiled = f.getAnnotations(MyFiled.class);


        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}
