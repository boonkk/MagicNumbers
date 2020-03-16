import exception.UnsupportedFileTypeException;
import readers.ByteSuffixReader;
import readers.NameSuffixReader;
import readers.TextFileReader;

import java.io.File;

public class SuffixProcessorAndFilesInitializer {
    public static void main(String[] args) throws UnsupportedFileTypeException {
        for(String fileName : args) {
            File file = new File(fileName);
            //throws
            if( !file.exists() )
                System.out.println(file.getName() + " cannot be found.");

            ByteSuffixReader byteSuffixReader = new ByteSuffixReader(file);
            NameSuffixReader nameSuffixReader = new NameSuffixReader(file);
            TextFileReader textFileReader = new TextFileReader(file);

            SuffixProcessor suffixProcessor = new SuffixProcessor(byteSuffixReader, nameSuffixReader, textFileReader);
            suffixProcessor.processSuffixes();
        }
    }

}
