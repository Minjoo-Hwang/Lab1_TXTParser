import java.io.*;

public class Reader implements Readable {
    private InputStreamReader reader = null;

    Reader(File fin) {
        try {
            reader = new InputStreamReader(new FileInputStream(fin));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder readWord(File fin) {
        int letter = -1;
        StringBuilder buff = new StringBuilder();

        try {
            letter = reader.read();
            while (((letter != -1) && (Character.isLetterOrDigit(letter)))) {
                        buff.append((char)letter);
                        letter = reader.read();
                    }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (letter == -1 && buff.toString().equals(""))
            return buff.append(-1);
        return buff;
    }
}