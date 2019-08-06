package Thread_Text01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class WebDownloader {

    public void download(String usl, String name) {
        try {
            FileUtils.copyURLToFile(new URL(usl), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("图片下载失败");
        }
    }
}