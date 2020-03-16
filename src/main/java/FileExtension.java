public class FileExtension {
    //describes file extension

    //fields needed possible extensions array (i.e. jpg can be .jpeg, .jpg, .jpe etc.
    //possible opening bytes (at start of file)
    //possible ending bytes (some file types has also magic numbers at end of file (i.e gif)
    //offset - some magic numbers are placed further in the file (i.e starts from 6 byte)
    private final String[] possibleExtensions;
    private final String[] possibleHexadecimalOpenings;
    private final String[] possibleHexadecimalEndings;
    private int offset;
}
