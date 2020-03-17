package readers;

import exception.UnsupportedFileTypeException;

import java.io.File;

public class NameSuffixReader extends SuffixReader {

    public NameSuffixReader(File file) {
        super(file);
    }

    private String getExtension() {
        String fileName = file.getName();
        if(fileName.contains("."))
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }

    public FileSuffix read(){
        if(getExtension().equals(""))
            return null;
        for (FileSuffix suffix : FileSuffix.values()) {
            for (String possibleSuffix : suffix.getPossibleExtensions()) {
                if( getExtension().equalsIgnoreCase(possibleSuffix) )
                    return suffix;
            }
        }
        return FileSuffix.UNSUPPORTED;
    }

}
