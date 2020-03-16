package readers;

import java.io.File;

public abstract class SuffixReader {
    final File file;
    public SuffixReader(File file) {
        this.file = file;
    }

    public abstract FileSuffix read();

}
