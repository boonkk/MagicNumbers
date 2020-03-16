import processor.SuffixProcessorInitializer;

import java.io.File;

public class MagicNumbersApp {
    public static void main(String[] args) {
        SuffixProcessorInitializer suffixChecker = new SuffixProcessorInitializer(args);
        suffixChecker.execute();
    }

    public static String[] appendPath(String[] files) {
        String[] result = new String[files.length];

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

        String pathToResources = pathToResourceFolder.toString();

        for(int i=0; i<files.length; i++) {
            result[i] = pathToResources + files[i];
        }

        return result;
    }
}
