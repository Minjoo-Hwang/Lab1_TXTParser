import java.io.*;

public class Main {

    public static void main(String[] args) {
        File fin = new File(args[0]);
        File fout = new File(args[1]);

        CSVParser a = new CSVParser();
        a.readWord(fin);
        a.printMap(fout);


    }

}
