import java.io.*;

public class Readers implements Readable {

    public InputStreamReader reader = null;

    public Readers(File file) {
        try {
            reader = new InputStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder readWord(File file) {
//        InputStreamReader reader = null;
        int i = -1;
        StringBuilder buff = new StringBuilder();

        try {
//            reader = new InputStreamReader(new FileInputStream(file));
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
