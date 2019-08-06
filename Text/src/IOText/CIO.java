package IOText;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CIO {

    public static void main(String[] args) throws IOException {
        //文件大小
        //long len = FileUtils.sizeOf(new File("src/IOText/CIO.java"));
        //System.out.println(len);
        //目录大小
        //len = FileUtils.sizeOf(new File("C:\\Users\\lenovo\\IdeaProjects\\Text\\src\\IOText"));
        //System.out.println(len);
        //列出子孙级目录
        //FileUtils.listFiles(new File());
        //文件过滤
       // FileFilterUtils.or(new SuffixFileFilter("java"), new SuffixFileFilter("common") )
        //读取文件
//        String msg = FileUtils.readFileToString(new File("lib.txt"), "UTF-8");
//        System.out.println(msg);
//        byte[] data = FileUtils.readFileToByteArray(new File("lib.txt"));
//        System.out.println(data.length);
//        //逐行读取(每一行丢到容器里）
//        List<String> msj = FileUtils.readLines(new File("lib.txt"), "UTF-8");
//        for (String string:msj) {
//            System.out.println(string);
//        }
        /**
         * 写出文件
         */
        //FileUtils.write(new File("lixian.txt"), "李现和胡程的儿子叫李程","UTF-8", true);
        //FileUtils.writeStringToFile();同理
       // FileUtils.writeByteArrayToFile();
        /**
         * 拷贝
         */
        FileUtils.copyFile(new File("C:\\Users\\lenovo\\IdeaProjects\\Text\\Text\\p.jpg"), new File("p-copy.png"));


    }
}
