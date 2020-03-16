import processor.SuffixProcessorInitializer;

public class Main {
    public static void main(String[] args) {
        SuffixProcessorInitializer suffixChecker = new SuffixProcessorInitializer(args);
        suffixChecker.execute();
    }
}
