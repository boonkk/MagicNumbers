import exception.UnsupportedFileTypeException;
import readers.*;
import utils.ConsoleHelper;

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

    public void processSuffixes() throws UnsupportedFileTypeException {
        FileSuffix byteSuffix = byteSuffixReader.read();
        if( fileSuffix.toString().equalsIgnoreCase("TXT") )
            if( processTextFile() ) {
                ConsoleHelper.messageValid(file, fileSuffix);
                return;
            } else {
                ConsoleHelper.messageInvalid(file, fileSuffix, byteSuffix);
                return;
            }

        if( fileSuffix == byteSuffix )
            ConsoleHelper.messageValid(file, fileSuffix);
        else if( byteSuffix != null )
            ConsoleHelper.messageInvalid(file, fileSuffix, byteSuffix);
        else if( processTextFile() )
            ConsoleHelper.messageInvalid(file, fileSuffix, FileSuffix.TXT);
        else
            throw new UnsupportedFileTypeException(String.format("Extension is %s, while actually it's not supported.", fileSuffix));

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
