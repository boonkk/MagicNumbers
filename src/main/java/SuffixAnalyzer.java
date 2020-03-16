import exception.UnsupportedFileTypeException;
import readers.FileSuffix;
import readers.SuffixReader;

public class SuffixAnalyzer {
    private final SuffixReader byteSuffixReader;
    private final SuffixReader nameSuffixReader;

    public SuffixAnalyzer(SuffixReader byteSuffixReader, SuffixReader nameSuffixReader) {
        this.byteSuffixReader = byteSuffixReader;
        this.nameSuffixReader = nameSuffixReader;
    }

    private FileSuffix getNameSuffix() throws UnsupportedFileTypeException {
        return nameSuffixReader.read();

    }

    private FileSuffix getByteSuffix() throws UnsupportedFileTypeException {
        return byteSuffixReader.read();
    }
}
