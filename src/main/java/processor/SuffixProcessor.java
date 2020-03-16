package processor;

import exception.UnsupportedFileTypeException;
import readers.*;
import utils.OutputHandler;

import java.io.File;

class SuffixProcessor {
    private final SuffixReader byteSuffixReader;
    private final SuffixReader nameSuffixReader;
    private final SuffixReader textFileReader;
    private final FileSuffix fileSuffix;
    private final File file;

    SuffixProcessor(ByteSuffixReader byteSuffixReader,
                           NameSuffixReader nameSuffixReader,
                           TextFileReader textFileReader) throws UnsupportedFileTypeException {

        this.textFileReader = textFileReader;
        this.byteSuffixReader = byteSuffixReader;
        this.nameSuffixReader = nameSuffixReader;
        this.fileSuffix = getNameSuffix();
        this.file = nameSuffixReader.getFile();
    }

    void processSuffixes() throws UnsupportedFileTypeException {
        FileSuffix byteSuffix = byteSuffixReader.read();
        if( fileSuffix.toString().equalsIgnoreCase("TXT") )
            if( processTextFile() ) {
                OutputHandler.writeMessageValid(file, fileSuffix);
                return;
            } else {
                OutputHandler.writeMessageInvalid(file, fileSuffix, byteSuffix);
                return;
            }

        if( fileSuffix == byteSuffix )
            OutputHandler.writeMessageValid(file, fileSuffix);
        else if( byteSuffix != null )
            OutputHandler.writeMessageInvalid(file, fileSuffix, byteSuffix);
        else if( processTextFile() )
            OutputHandler.writeMessageInvalid(file, fileSuffix, FileSuffix.TXT);
        else
            throw new UnsupportedFileTypeException(String.format("Extension is %s, while actually it's not supported.", fileSuffix));

    }

    private FileSuffix getNameSuffix() throws UnsupportedFileTypeException {
        return nameSuffixReader.read();
    }

    private boolean processTextFile() throws UnsupportedFileTypeException {
        return this.textFileReader.read() == FileSuffix.TXT;
    }
}
