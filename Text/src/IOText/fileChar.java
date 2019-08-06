package IOText;

import java.io.*;

public class fileChar {

    public static void main(String[] args){
        File src = new File("abc.txt");

        Reader reader = null;//Writer writer = null;
        try {
            reader = new FileReader(src);//
            char[] flush = new char[2];//缓冲容器
            int len ;
            while((len = reader.read(flush)) != -1){
                //字符数组->字符串
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
