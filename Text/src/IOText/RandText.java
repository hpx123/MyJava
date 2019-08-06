package IOText;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class RandText {

    public static void main(String[] args){
        File src = new File("src/IOText/DateText.java");
        //总长度
        long len = src.length();
        //每块大小
        int blockSize = 1024;
        //分多少块
        int size = (int)Math.ceil(len * 1.0 / blockSize);
        System.out.println(size);
    }

    public static void text02(String[] args) throws IOException {
        RandomAccessFile rt = new RandomAccessFile(new File("src/IOText/DateText.java"),"r");
        //起始位置
        int startPos = 2;
        //实际长度
        int actualSize = 1026;
        //随机读取
        rt.seek(startPos);
        byte[] data = new byte[1024];
        int len = -1;
        while((len = rt.read(data))!=-1){
            if (actualSize > len){//获取本次读取的所有内容
                System.out.println(new String(data,0,len));
                actualSize -= len;
            }else {
                System.out.println(new String(data,0,actualSize));
                break;
            }

        }
        rt.close();
    }
}
