package IOTest;

import org.junit.Test;

import java.io.*;
//啊是嗲来看发你是顶分厘卡士大夫你哦啊是a的覅哦啊是哦啊撒旦解放i哦阿姐阿斯顿
public class FileInputStream2 {
    public static void main(String[] args) {
        File f = new File ("src/IOTest/FileInputStream2.java");
        File f2 = new File ("IOTest/FileInputStream2.java");
        if(!f2.exists()){
            try {
                f2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        InputStream fis = null;
        OutputStream os = null;
        try {
            fis = new FileInputStream(f);
            os = new FileOutputStream(f2);
            byte[] buffer = new byte[100];
            int len;
            while((len = fis.read(buffer))!=-1){
                System.out.print(new String(buffer,0,len));
                os.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test(){
        File f = new File("IOTest/FileInputStream2.java");
        InputStream is = null;
        try {
            is = new FileInputStream(f);
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
            char[] buffer = new char[100];
            int len;
            while((len = br.read(buffer))!=-1){
                System.out.print(new String(buffer,0,len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2(){
        File f = new File ("src/IOTest/FileInputStream2.java");
        File f2 = new File ("IOTest/FileInputStream2.java");
        if(!f2.exists()){
            try {
                f2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        InputStream fis = null;
        OutputStream os = null;
        try {
            fis = new FileInputStream(f);
            os = new FileOutputStream(f2);
            byte[] buffer = new byte[100];
            int len;
            while((len = fis.read(buffer))!=-1){
                System.out.print(new String(buffer,0,len));
                byte[] buffer2 = new String(buffer,0,len).getBytes();
                os.write(buffer2,0,buffer2.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
