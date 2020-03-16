package utils;

import readers.FileSuffix;

import java.io.File;

public final class OutputHandler {
    private OutputHandler() {
        throw new AssertionError();
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static void writeMessageValid(File file, FileSuffix fileSuffix) {
        writeMessage(String.format("%s: Extension %s is valid.",file.getName(), fileSuffix));
    }

    public static void writeMessageInvalid(File file, FileSuffix fileSuffixA, FileSuffix fileSuffixB ) {
        writeMessage(String.format("%s: Extension is %s, while actually it's a %s.",file.getName(), fileSuffixA, fileSuffixB));
    }

}

