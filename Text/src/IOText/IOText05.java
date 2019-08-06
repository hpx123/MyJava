package IOText;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 字节数组输出流：
 * 1.创建源：内部维护
 * 2.选择流：不关联源
 */
public class IOText05 {
    public static void main(String[] args){
        byte[] dest = null;
        ByteArrayOutputStream  os = new ByteArrayOutputStream();

        byte[] data = "Hu Shou zi".getBytes();
        os.write(data, 0, data.length);
        try {
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取数据
        dest = os.toByteArray();
        System.out.println(new String(dest, 0, dest.length));
    }
}
