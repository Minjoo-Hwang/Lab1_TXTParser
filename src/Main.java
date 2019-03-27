import java.io.File;

public class Main {
    public static void main(String[] args) {
        File fin = new File(args[0]);
        File fout = new File(args[1]);

        CSVParser csvParser = new CSVParser(fin, fout);
        csvParser.parse(fin, fout);

        
    }
}