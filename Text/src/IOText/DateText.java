package IOText;
/*
* 1.先写出后读取
* 2.读取的顺序要和写出的顺序一样*/

import java.io.*;

public class DateText {
    public static void main(String[] args) throws IOException {
        //写出
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(boas));
        //操作数据类型+数据
        dos.writeInt(123);
        dos.writeBoolean(true);
        dos.writeChar('h');
        dos.writeUTF("胡");
        dos.flush();
        byte[] data = boas.toByteArray();
        //读取
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(data)));
        int a = dis.readInt();
        System.out.println(a);

    }
}
