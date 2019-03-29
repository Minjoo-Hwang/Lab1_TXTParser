import java.io.*;

public class Reader implements Readable {
    private InputStreamReader reader = null;

    Reader(File fin) throws FileNotFoundException {
            reader = new InputStreamReader(new FileInputStream(fin));
    }

    public String readWord(File fin) throws IOException {
        int letter = -1;
        StringBuilder buff = new StringBuilder();

            letter = reader.read();
            while (((letter != -1) && (Character.isLetterOrDigit(letter)))) {
                        buff.append((char)letter);
                        letter = reader.read();
                    }
        if (letter == -1 && buff.toString().equals("")) {
            return  null;
        }

        return buff.toString();
    }
}