package IOText;

import java.io.File;

public class DirDemon {
    public static void copy(String src, String dest){
        File is = new File(src);
        File[] fs = is.listFiles();
        File io = new File(dest);

        for(File f:fs){
            if(f.isFile()){
                FileCopy.fileCopy(f.getPath(), dest);
            }else if(f.isDirectory()){
                copy(f.getPath(), dest);
            }
        }

    }
    public static void main(String[] args){
        copy("Text", "abc.txt");
    }
}
