import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * Created by Toshiba on 07.12.2016.
 */

class Main {
    private String fileName;
    private final Map<String, LinkedList<Object>> contents = new HashMap<>();


    Main(String fileName) {
        this.fileName = fileName;
    }

    public void read() throws IOException {
        File file = new File(fileName);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file))
        );
        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.isEmpty()) {
                String[] output = line.split(" ");
                if (output.length >= 1) {
                    if (!contents.containsKey(output[0])) {
                        contents.put(output[0], new LinkedList<>());
                    }
                    for (int i = 1; i < output.length; i++) {
                        contents.get(output[0]).add(Integer.valueOf(output[i]));
                    }
                }
            }
        }
    }

    public void print() {
        for (Map.Entry<String, LinkedList<Object>> entry : contents.entrySet()) {
            System.out.println(entry.getKey() + " - " + Arrays.toString(entry.getValue().toArray()));
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main("./resource\\1\\3\\5\\7\\input.txt");
        main.read();
        main.print();
    }

}
