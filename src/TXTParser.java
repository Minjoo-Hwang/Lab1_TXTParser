import java.io.*;

class TXTParser {
    private File fin;
    private File fout;
    private Reader reader;
    private Writer writer;

    TXTParser(File fin, File fout) throws FileNotFoundException {
        this.fin = fin;
        this.fout = fout;
        this.reader = new Reader(fin);
        this.writer = new Writer();
    }

    void parse(File fin, File fout) throws IOException {
        String str;
        while ((str = reader.readWord(fin)) != null)
            if (!(str.equals("")))
                writer.insertWord(str);
        writer.writeText(fout);
    }
}

