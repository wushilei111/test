package IOTest;

import java.io.*;

public class FileInputStream1 {
    public static void main(String[] args) {
        File f = new File("src/IOTest/FileInputStream1.java");
        File f1 = new File("IOTest/FileInputStream1.java");
        if(f.exists()){
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new FileInputStream(f);
                os = new FileOutputStream(f1);
                int c;
                while((c = is.read()) !=-1){
                    System.out.print((char)c);
                    os.write(c);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (is!=null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (os!=null){
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else {
            new File("IOTest").mkdir();
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
