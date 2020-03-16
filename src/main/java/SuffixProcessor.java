import exception.UnsupportedFileTypeException;
import readers.*;

import java.io.File;

public class SuffixProcessor {
    private final SuffixReader byteSuffixReader;
    private final SuffixReader nameSuffixReader;
    private final SuffixReader textFileReader;
    private final FileSuffix fileSuffix;
    private final File file;

    public SuffixProcessor(ByteSuffixReader byteSuffixReader,
                           NameSuffixReader nameSuffixReader,
                           TextFileReader textFileReader) throws UnsupportedFileTypeException {

        this.textFileReader = textFileReader;
        this.byteSuffixReader = byteSuffixReader;
        this.nameSuffixReader = nameSuffixReader;
        this.fileSuffix = getNameSuffix();
        this.file = nameSuffixReader.getFile();
    }

    public void processSuffixes() {
        //todo implement logic to check if suffixes are compatible
    }

    private FileSuffix getNameSuffix() throws UnsupportedFileTypeException {
        return nameSuffixReader.read();
    }

    private FileSuffix getByteSuffix() throws UnsupportedFileTypeException {
        return byteSuffixReader.read();
    }

    private boolean processTextFile() throws UnsupportedFileTypeException {
        return this.textFileReader.read() == FileSuffix.TXT;
    }
}
