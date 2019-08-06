package IOText;

/*字节数组输入流*/

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOText04 {

    public static void main(String[] args) throws IOException {
        byte[] src = "Hu Cheng is a smart girl".getBytes();

        InputStream is = null;
        is = new ByteArrayInputStream(src);

        byte[] flush = new byte[10];
        int len = -1;
        while((len = is.read(flush)) != -1){
            String str = new String(flush, 0, flush.length);
            System.out.println(str);
        }

    }
}
