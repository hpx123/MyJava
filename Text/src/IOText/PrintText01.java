package IOText;

import java.io.*;

public class PrintText01 {
    public static void main(String[] args) throws FileNotFoundException {
        //打印流System.out
        PrintStream ps = System.out;
        ps.println("胡瘦子");
        ps.println(true);

        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")),true);
        ps.println("胡瘦子");
        ps.println(true);
        //ps.flush();
        ps.close();

        //重定向输出端
        System.setOut(ps);//直接输出到文件里
        System.out.println("change");
        //重定向回来
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
        System.out.println("change");
    }
}
