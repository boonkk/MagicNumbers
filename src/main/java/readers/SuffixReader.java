package readers;

import exception.UnsupportedFileTypeException;

import java.io.File;

public abstract class SuffixReader {
    final File file;

    SuffixReader(File file) {
            this.file = file;
    }

    public File getFile() {
        return this.file;
    }

    public abstract FileSuffix read() throws UnsupportedFileTypeException;
}
