package dambi;

import java.io.File;
import java.io.IOException;

public class karpetaEdukia {
    public static void main(String[] args) throws IOException {
        File file = new File("karpeta_berriak");
        file.mkdirs();

        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}