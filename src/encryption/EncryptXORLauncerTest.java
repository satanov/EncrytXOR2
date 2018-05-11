package encryption;

import org.junit.Test;


import java.io.IOException;
import java.io.RandomAccessFile;

import static encryption.EncryptXOR.encryption;
import static org.junit.jupiter.api.Assertions.*;

class EncryptXORLauncerTest {
    @Test
    void encryptTest() throws IOException {
        encryption("file/input.txt", "file/output.txt","abc");
        encryption("file/output.txt", "file/decrypt.txt", "abc");
        assertFileContent("files/input.txt", "files/decrypt.txt");
    }

    private void assertFileContent(String nameEncrypt, String nameDecrypt) throws IOException {
        RandomAccessFile readerEncrypt = new RandomAccessFile(nameEncrypt, "r");
        RandomAccessFile readerDecrypt = new RandomAccessFile(nameDecrypt, "r");
        String actualContentEncrypt = readerEncrypt.readLine();
        String actualContentDecrypt = readerDecrypt.readLine();
        assertEquals(actualContentEncrypt, actualContentDecrypt);
        readerEncrypt.close();
        readerDecrypt.close();
    }
}