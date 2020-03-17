package processor;

import exception.UnsupportedFileTypeException;
import readers.*;
import utils.OutputHandler;

import java.io.File;

class SuffixProcessor {
    private final SuffixReader byteSuffixReader;
    private final SuffixReader nameSuffixReader;
    private final SuffixReader textFileReader;
    private final FileSuffix nameSuffix;
    private final File file;

    SuffixProcessor(ByteSuffixReader byteSuffixReader,
                           NameSuffixReader nameSuffixReader,
                           TextFileReader textFileReader) throws UnsupportedFileTypeException {

        this.textFileReader = textFileReader;
        this.byteSuffixReader = byteSuffixReader;
        this.nameSuffixReader = nameSuffixReader;
        this.nameSuffix = getNameSuffix();
        this.file = nameSuffixReader.getFile();
    }

    void processSuffixes() throws UnsupportedFileTypeException {
        FileSuffix byteSuffix = byteSuffixReader.read();
        if( nameSuffix == null){
            if(processTextFile())
                OutputHandler.writeMessageValid(file,FileSuffix.TXT);
            else if(byteSuffix == null)
                throw new UnsupportedFileTypeException();
            else
                OutputHandler.writeMessageValid(file,byteSuffix);

            return;
        }
        if( nameSuffix.toString().equalsIgnoreCase("TXT") )
            if( processTextFile() ) {
                OutputHandler.writeMessageValid(file, nameSuffix);
                return;
            } else {
                OutputHandler.writeMessageInvalid(file, nameSuffix, byteSuffix);
                return;
            }



        if( nameSuffix == byteSuffix )
            OutputHandler.writeMessageValid(file, nameSuffix);
        else if( byteSuffix != null )
            OutputHandler.writeMessageInvalid(file, nameSuffix, byteSuffix);
        else if( processTextFile() )
            OutputHandler.writeMessageInvalid(file, nameSuffix, FileSuffix.TXT);
        else
            throw new UnsupportedFileTypeException(String.format("Extension is %s, while actually it's not supported.", nameSuffix));

    }

    private FileSuffix getNameSuffix() throws UnsupportedFileTypeException {
        return nameSuffixReader.read();
    }

    private boolean processTextFile() throws UnsupportedFileTypeException {
        return this.textFileReader.read() == FileSuffix.TXT;
    }
}
