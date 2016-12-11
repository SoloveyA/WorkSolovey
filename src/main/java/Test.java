import java.io.*;

/**
 * Created by Toshiba on 07.12.2016.
 */

public class Test {
    static boolean search;

    public static void func(String path, String find) {
        File f = new File(path);
        String[] list = f.list();
        for (String file : list) {
            if (find.equals(file)) {
                search=true;
                String s = path + "\\" + file;
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
        func(".", "input.txt");
    }

}