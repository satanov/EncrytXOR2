package encryption;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

import static encryption.EncryptXOR.encryption;
import static org.junit.jupiter.api.Assertions.*;

class EncryptXORTests {
    @Test
    void encryptTest() throws IOException {
        encryption("file/input.txt", "file/output.txt","abc");
        encryption("file/output.txt", "file/decrypt.txt", "abc");
        assertFileContent("file/input.txt", "file/decrypt.txt");
    }


    private void assertFileContent(String nameEncrypt, String nameDecrypt) throws IOException {
        RandomAccessFile readerEncrypt = new RandomAccessFile(nameEncrypt, "r");
        RandomAccessFile readerDecrypt = new RandomAccessFile(nameDecrypt, "r");

        StringBuilder sb1 = new StringBuilder();
        String line = readerEncrypt.readLine();
        int count = 0;
        while(line != null) {
            sb1.append(line);
            count++;
            line = readerEncrypt.readLine();
        }
        StringBuilder sb2 = new StringBuilder();
        line = readerDecrypt.readLine();
        count = 0;
        while(line != null) {
            sb2.append(line);
            count++;
            line = readerDecrypt.readLine();
        }
        assertEquals(sb1.toString(), sb2.toString());
        readerEncrypt.close();
        readerDecrypt.close();
    }

}