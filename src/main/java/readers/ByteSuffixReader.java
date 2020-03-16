package readers;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ByteSuffixReader extends SuffixReader {

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public ByteSuffixReader(File file) {
        super(file);

    }

    public FileSuffix read() {

        //read byte[] from file -> to Hexadecimal string -> compare with corresponding FileSuffix enum fields
        return null;
    }

    private String readFromBeginning(int offset, int length) {
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            if( raf.length() <= length + offset )
                return "";

            byte[] bytes = new byte[length];
            raf.seek(offset);
            raf.read(bytes,0, length);

            return byteToHexadecimal(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String readFromEnding(int length) {
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            if( raf.length() <= length )
                return "";
            byte[] bytes = new byte[length];
            raf.seek(file.length() - length);
            raf.read(bytes, 0, length);
            return byteToHexadecimal(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
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
