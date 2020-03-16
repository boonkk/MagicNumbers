public enum FileSuffix {
    //describes file extension

    //fields needed possible extensions array (i.e. jpg can be .jpeg, .jpg, .jpe etc.
    //possible opening bytes (at start of file)
    //possible ending bytes (some file types has also magic numbers at end of file (i.e gif)
    //offset - some magic numbers are placed further in the file (i.e starts from 6 byte)


    //a bit of hard coding
    //FILETYPE ([POSSIBLE EXTENSIONS][], [FIRST BYTES IN HEXADECIMAL][], [LAST BYTES IN HEXADECIMAL][], OFFSET)
    JPG(new String[]{"JPEG", "JPG", "JPE"}, new String[]{"FFD8"}, new String[]{"FFD9"},0),
    GIF(new String[]{"GIF"}, new String[]{"474946383761", "474946383961"}, new String[]{"003B"},0),
    TXT(new String[]{"TXT"}, new String[]{}, new String[]{}, 0);

    //todo add more types



    private final String[] possibleExtensions;
    private final String[] possibleHexadecimalOpenings;
    private final String[] possibleHexadecimalEndings;
    private int offset;


    FileSuffix(String[] possibleExtensions, String[] possibleByteToHexOpenings, String[] possibleByteToHexEndings, int offset) {

        this.possibleExtensions = possibleExtensions;
            this.possibleHexadecimalOpenings = possibleByteToHexOpenings;
        this.possibleHexadecimalEndings = possibleByteToHexEndings;
        this.offset = offset;
    }



}
