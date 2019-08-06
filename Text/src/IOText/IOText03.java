package IOText;

import java.io.*;

public class IOText03 {

    public static void main(String[] args) throws IOException {

        File dest = new File("dest.txt");

        OutputStream os = null;
        os = new FileOutputStream(dest,true);

        String name = "Hc is beautiful\t";
        byte[] data = name.getBytes();
        os.write(data,0,data.length);
        os.flush();

        if(os != null){
            os.close();
        }

    }
}
