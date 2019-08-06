package IOText;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * 面向对象思想，封装分割
 */
public class SplitFile {
    //源头
    private File src;
    //目的地（文件夹）
    private String destDir;
    //所有分割后的文件存储路径（放到容器里）
    private List<String> destPath;
    //每块大小
    private int blockSize;
    //块数
    private int size;

    public SplitFile(File src,String destDir, int blockSize){
        this.src = src;
        this.destDir = destDir;
        this.blockSize = blockSize;
        this.destPath = new ArrayList<String>();
        //初始化

    }

    //初始化
    public void init(){
        long len = this.src.length();
        //分多少块
        int size = (int)Math.ceil(len * 1.0 / blockSize);
        //路径
        for(int i = 0; i < size; i++){
            this.destPath.add(this.destDir + "i" + "-" + this.src.getName());
        }
        System.out.println(size);
    }

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
