import processor.SuffixProcessorInitializer;

import java.io.File;

public class MagicNumbersApp {
    public static void main(String[] args) {
        SuffixProcessorInitializer suffixChecker = new SuffixProcessorInitializer(args);
        suffixChecker.execute();
    }
}
