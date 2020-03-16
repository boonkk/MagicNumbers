package readers;

import java.io.File;

public class NameSuffixReader extends SuffixReader {
    //not extends reader at start
    //change method and fields names
    public NameSuffixReader(File file) {
        super(file);
    }

    public String getExtension() {
        String fileName = file.getName();
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public FileSuffix read(){
        for (FileSuffix suffix : FileSuffix.values()) {
            for (String possibleSuffix : suffix.getPossibleExtensions()) {
                if( getExtension().equalsIgnoreCase(possibleSuffix) )
                    return suffix;
            }
        }
        return null;
        //todo not return null
    }

}
