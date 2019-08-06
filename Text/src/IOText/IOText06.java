package IOText;

import java.io.*;
import java.net.PortUnreachableException;

public class IOText06 {

    public static void main(String[] args){
        //图片专程字节数组
        byte[] data = fileIntoByteArray("");
    }
    public static byte[] fileIntoByteArray(String filePath){
        //创建源与目的地
        File src = new File(filePath);
        byte[] dest = null;
        //选择流
        InputStream is = null;
        ByteArrayOutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new ByteArrayOutputStream();
            //操作分段读取
            byte[] flush = new byte[1024 * 10];
            int len = -1;
            while((len = is.read(flush)) != -1){
                os.write(flush, 0, len);
            }
            os.flush();
            return os.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void byteArraytoFile(byte[] src, String filePath){
        File dest = new File(filePath);

        InputStream is = null;
        OutputStream os = null;

        try {
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(dest);

            byte[] flush = new byte[5];
            int len = -1;
            while((len = is.read(flush)) != -1){
                os.write(flush, 0, len);//写出到文件
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
