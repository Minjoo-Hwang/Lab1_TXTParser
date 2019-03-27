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
        int i = -1;
        StringBuilder buff = new StringBuilder();

        try {
            i = reader.read();
            while (((i != -1) && (Character.isLetterOrDigit(i)))) {
                        buff.append((char)i);
                        i = reader.read();
                    }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (i == -1 && buff.toString().equals(""))
            return buff.append(-1);
        return buff;
    }
}