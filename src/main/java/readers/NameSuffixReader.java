package readers;

import exception.UnsupportedFileTypeException;

import java.io.File;

public class NameSuffixReader extends SuffixReader {

    public NameSuffixReader(File file) {
        super(file);
    }

    private String getExtension() {
        String fileName = file.getName();
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public FileSuffix read() throws UnsupportedFileTypeException {
        for (FileSuffix suffix : FileSuffix.values()) {
            for (String possibleSuffix : suffix.getPossibleExtensions()) {
                if( getExtension().equalsIgnoreCase(possibleSuffix) )
                    return suffix;
            }
        }
        throw new UnsupportedFileTypeException("Extension: " + getExtension());
    }

}
