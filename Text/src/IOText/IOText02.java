package IOText;

import java.io.*;

public class IOText02 {
    public static void main(String[] args){
        //1.创建源
        File src = new File("abc.txt");
        InputStream is = null;
        try {
            //2.选择流
            is = new FileInputStream(src);
            //3.操作
            byte[] flush = new byte[20];
            int len = -1;
            while((len = is.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
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
