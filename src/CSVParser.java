import java.io.*;

class CSVParser {
    private File fin;
    private File fout;
    private Reader reader;
    private Writer writer;

    public CSVParser(File fin, File fout) {
        this.fin = fin;
        this.fout = fout;
        this.reader = new Reader(fin);
        this.writer = new Writer();
    }

    void parse(File fin, File fout) {
        StringBuilder str;
        while (!((str = reader.readWord(fin)).toString().equals("-1")))
            if (!(str.toString().equals("")))
                writer.insertWord(str);
        writer.writeText(fout);
    }
}
