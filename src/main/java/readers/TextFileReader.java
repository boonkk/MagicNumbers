package readers;

import exception.UnsupportedFileTypeException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class TextFileReader extends SuffixReader {
    public TextFileReader(File file) {
        super(file);
    }

    public FileSuffix read() {
        if( isTextFile() )
            return FileSuffix.TXT;
        else
            return null;
    }

    private boolean isTextFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append(reader.readLine());
            }
            reader.close();
            return isASCIIEncodable(sb.toString()) && isUTF8Encodable(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isASCIIEncodable(String s) {
        return Charset.forName("US-ASCII").newEncoder().canEncode(s);
    }

    private boolean isUTF8Encodable(String s) {
        return Charset.forName("UTF-8").newEncoder().canEncode(s);
    }
}
