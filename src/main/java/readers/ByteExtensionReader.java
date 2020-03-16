package readers;

public class ByteExtensionReader extends ExtensionReader {

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public FileSuffix read() {

        //read byte[] from file -> to Hexadecimal string -> compare with corresponding FileSuffix enum fields
        return null;
    }

    private String byteToHexadecimal(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }

        return new String(hexChars);
    }
}
