import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.*;


/**
 * Created by Toshiba on 07.12.2016.
 */

public class Test {
    public static String m;
    static boolean search;
    private final static Logger LL = LoggerFactory.getLogger(Main.class);


    public static void func(String path, String find) {
        File f = new File(path);
        String[] list = f.list();
        for (String file : list) {
            if (find.equals(file)) {
                search=true;
                String s = new String(path + "\\" + file);
                m=s;
                System.out.println(s + " ! this file");
                return;
            }
            if (!path.endsWith("\\")) {
                path += "\\";
            }
            File thisfile = new File(path, file);

            if (!file.equals(".") && !file.equals("..")) {
                if (thisfile.isDirectory()) {
                    func(path + file, find);
                    if(search) return;
                }
            }
        }

}


    public static void main(String[] args) throws IOException {
        LL.debug("hello");
        func(".", "input.txt");
        Main file = new Main(m);
        file.read();
        file.print();
    }


}

