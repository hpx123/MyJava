package IOText;

import java.io.*;

public class IOText01 {

       public static void main(String[] args){
               //1.创建源
               File src = new File("abc.txt");
               InputStream is = null;
        try {
            //2.选择流
            is = new FileInputStream(src);
            //3.操作
            int temp;
            while((temp = is.read()) != -1){
                System.out.println((char)temp);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
