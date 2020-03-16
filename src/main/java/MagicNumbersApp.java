import processor.SuffixProcessorInitializer;

import java.io.File;

public class MagicNumbersApp {
    public static void main(String[] args) {
        String slashOrBackSlash = File.separator;
        StringBuilder pathToResourceFolder = new StringBuilder();
        pathToResourceFolder.append(System.getProperty("user.dir"))
                .append(File.separator)
                .append("src")
                .append(File.separator)
                .append("main")
                .append(File.separator)
                .append("resources")
                .append(File.separator);

///
        SuffixProcessorInitializer suffixChecker = new SuffixProcessorInitializer(args);
        suffixChecker.execute();
    }
}
