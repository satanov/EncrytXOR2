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
    }

    private void assertFileContent(String name, String expectedContent) throws IOException {
        RandomAccessFile reader = new RandomAccessFile(name, "r");
        String actualContent = reader.readLine();
        assertEquals(expectedContent, actualContent);
        reader.close();
    }
}