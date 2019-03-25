import java.io.*;
import java.util.*;

public class CSVParser {

    File fin = new File("C:\\Users\\A\\IdeaProjects\\Lab1_SCVParser\\in.txt");

    Readers readers = new Readers(fin);
    StringBuilder buff = new StringBuilder();
    Writer b = new Writer();
    StringBuilder str = new StringBuilder();

    void parse(File fin, File fout) {
        while (!((str = readers.readWord(fin)).toString().equals("-1")))
            b.insertWord(str);
        b.printMap(fout);
    }
}

