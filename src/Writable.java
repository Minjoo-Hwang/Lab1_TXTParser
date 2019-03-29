import java.io.File;
import java.io.IOException;

interface Writable {
    void writeText(File file) throws IOException;
}
