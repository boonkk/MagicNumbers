package readers;

import java.io.File;

public class FileNameExtensionReader extends ExtensionReader {
    private final File file;
    //not extends reader at start
    //change method and fields names
    public FileNameExtensionReader(File file) {
        this.file = file;
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
