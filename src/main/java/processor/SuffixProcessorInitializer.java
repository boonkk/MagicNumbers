package processor;

import exception.UnsupportedFileTypeException;
import readers.ByteSuffixReader;
import readers.NameSuffixReader;
import readers.TextFileReader;
import utils.OutputHandler;

import java.io.File;

public class SuffixProcessorInitializer {
    private final String[] filePaths;

    public SuffixProcessorInitializer(String[] filePaths) {
        this.filePaths = filePaths;
    }

    public void execute() {
        if( filePaths.length > 0 ) {
            for (String filePath : filePaths) {
                File file = new File(filePath);

                if(!file.exists())
                    OutputHandler.writeMessage(file.getName() + " cannot be found.");

                ByteSuffixReader byteSuffixReader = new ByteSuffixReader(file);
                NameSuffixReader nameSuffixReader = new NameSuffixReader(file);
                TextFileReader textFileReader = new TextFileReader(file);
                try{
                    SuffixProcessor suffixProcessor = new SuffixProcessor(byteSuffixReader, nameSuffixReader, textFileReader);
                    suffixProcessor.processSuffixes();
                } catch (UnsupportedFileTypeException e) {
                    e.printStackTrace();
                }
            }
        } else {
            throw new IllegalArgumentException("Files not specified in arguments. Please start the app with valid arguments(file paths).");
        }
    }

}
