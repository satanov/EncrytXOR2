package encryption;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;

import static encryption.EncryptXOR.encryption;

public class EncryptXORLauncer {
    @Option(name = "-c", usage = "file encrypting")
        private String inputKey;

    @Option(name = "-d", forbids = "-c", usage = "file decryption")//forbids
        private String outputKey;

    @Option(name = "-o", usage = "output file name")
        private String outputName;

    @Argument(required = true, usage = "input file name")
        private String inputName;


    public static void main(String[] args) {
        new EncryptXORLauncer().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch(CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar EncrytXOR.jar [-c|-d] input.txt -o output.txt");
            parser.printUsage(System.err);
            return;
        }

        if (inputKey == null && outputKey == null) {
            System.err.println("invalid key");
            return;
        }

        String key;
        if (inputKey != null) {
            key = inputKey;
        } else {
            key = outputKey;
        }

        boolean f = false;
        for(int i = 0; i < key.length(); i++) {
            if(!"0123456789abcdef".contains(key.substring(i, i + 1))) {
                f = true;
                break;
            }
        }

        if(f) {
           System.err.println("only 0123456789abcdef");
           return;
        }

        if(outputName == null) {
            outputName = inputName + "result";
        }

        try {
            encryption(inputName, outputName, key);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }


}
