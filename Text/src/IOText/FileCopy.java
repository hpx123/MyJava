package IOText;

import java.io.*;

public class FileCopy {

    public static void fileCopy(String Src, String Dest){
        File src = new File(Src);//源头
        File dest = new File(Dest);//尾巴

        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);

            int len ;
            byte[] data = new byte[1024];
            while((len = is.read(data)) != -1){
                os.write(data,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args){
        fileCopy("abc.txt","dest.txt");
    }
}
