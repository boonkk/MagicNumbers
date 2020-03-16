package readers;

public enum FileSuffix {
    //FILETYPE ([POSSIBLE EXTENSIONS][], [FIRST BYTES IN HEXADECIMAL][], [LAST BYTES IN HEXADECIMAL][], OFFSET)
    JPG(new String[]{"JPEG", "JPG", "JPE"}, new String[]{"FFD8"}, new String[]{"FFD9"},0),
    GIF(new String[]{"GIF"}, new String[]{"474946383761", "474946383961"}, new String[]{"003B"},0),
    TXT(new String[]{"TXT"}, new String[]{}, new String[]{}, 0),
    RTF(new String[]{"RTF"}, new String[]{"7B5C727466"}, new String[]{"7D"}, 0),
    AAC(new String[]{"AAC"}, new String[]{"FFF1", "FFF9"}, new String[]{}, 0),
    PNG(new String[]{"PNG"}, new String[]{"89504E470D0A1A0A"}, new String[]{}, 0),
    HLP(new String[]{"HLP"}, new String[]{"0000FFFFFFFF"}, new String[]{}, 6);

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

    public String[] getPossibleExtensions() {
        return possibleExtensions;
    }

    public String[] getPossibleHexadecimalOpenings() {
        return possibleHexadecimalOpenings;
    }

    public String[] getPossibleHexadecimalEndings() {
        return possibleHexadecimalEndings;
    }

    public int getOffset() {
        return offset;
    }
}
