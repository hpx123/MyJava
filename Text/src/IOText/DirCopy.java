package KaoHe;


import IOText.FileCopy;

import java.io.*;

public class DirCopy {

    public static void main(String[] args) {
        dirCopy("Text", "dirCopy");
    }

    public static void dirCopy(String head, String tail) {
        File file = new File(head);
        if (!new File(head).exists()) {
            new File(head).mkdirs();
        }
        for (File s : file.listFiles()) {
            if (s.isFile()) {
                fileCopy(s.getPath(), tail + "/" + s.getName());
            } else {
                dirCopy(s.getPath(), tail + "/" + s.getName());
            }
        }
    }
    public static void fileCopy(String head, String tail){
        File src = new File(head);
        File dest = new File(tail);

        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);

            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
