import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File fin = new File(args[0]);
        File fout = new File(args[1]);

        TXTParser txtParser = null;

        try {
            txtParser = new TXTParser(fin, fout);
            txtParser.parse(fin, fout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}