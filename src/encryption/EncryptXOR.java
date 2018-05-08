package encryption;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class EncryptXOR {
    public static int encryption(InputStream input, String output, String key) throws IOException {
        try(InputStreamReader reader = new InputStreamReader(input)) {
            try(FileWriter writer = new FileWriter(output)) {
                int sym = reader.read();
                int count = 0;
                while(sym != -1) {
                    writer.write(sym ^ (int) key.charAt(count % (key.length())));
                    count++;
                    sym = reader.read();
                }

                return count;
            }
        }
    }

    public static int encryption(String input, String output, String key) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(input)) {
                return encryption(inputStream, output, key);
        }
    }
}

//jar C:\Users\pharaoh\IdeaProjects\EncrytXOR\out\artifacts\EncrytXOR_jar\EncrytXOR.jar
//input C:\Users\pharaoh\IdeaProjects\EncrytXOR\file\input.txt
//output C:\Users\pharaoh\IdeaProjects\EncrytXOR\file\output.txt