package readers;

import exception.UnsupportedFileTypeException;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ByteSuffixReader extends SuffixReader {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public ByteSuffixReader(File file) {
        super(file);
    }

    public FileSuffix read() throws UnsupportedFileTypeException {
        if( getSuffixFromBeginningBytes() != null && getSuffixFromBeginningBytes() == getSuffixFromEndingBytes() )
            return getSuffixFromBeginningBytes();
        else if( getSuffixFromEndingBytes() != null && getSuffixFromBeginningBytes() != getSuffixFromEndingBytes() )
            throw new UnsupportedFileTypeException("Corrupted file. Opening bytes do not correspond to ending bytes.");

        return getSuffixFromBeginningBytes();
    }

    private FileSuffix getSuffixFromBeginningBytes() {
        for (FileSuffix fileSuffix : FileSuffix.values())
            for (String hexSuffix : fileSuffix.getPossibleHexadecimalOpenings()) {
                int length = hexSuffix.length() / 2;
                if( hexSuffix.equalsIgnoreCase(readBytesFromBeginning(fileSuffix.getOffset(), length)) )
                    return fileSuffix;
            }
        return FileSuffix.UNSUPPORTED;
    }

    private FileSuffix getSuffixFromEndingBytes() {
        FileSuffix temp = getSuffixFromBeginningBytes();
        if( temp != null && temp.getPossibleHexadecimalEndings().length == 0 )
            return getSuffixFromBeginningBytes();
        for (FileSuffix fileSuffix : FileSuffix.values())
            for (String hexSuffix : fileSuffix.getPossibleHexadecimalEndings()) {
                int length = hexSuffix.length() / 2;
                if( hexSuffix.equalsIgnoreCase(readBytesFromEnding(length)) )
                    return fileSuffix;
            }

        return FileSuffix.UNSUPPORTED;
    }

    private String readBytesFromBeginning(int offset, int length) {
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            if( raf.length() <= length + offset )
                return "";
            byte[] bytes = new byte[length];
            raf.seek(offset);
            raf.read(bytes, 0, length);
            return bytesToHexadecimal(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String readBytesFromEnding(int length) {
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            if( raf.length() <= length )
                return "";
            byte[] bytes = new byte[length];

            raf.seek(file.length() - length);

            raf.read(bytes, 0, length);
            return bytesToHexadecimal(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String bytesToHexadecimal(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

}