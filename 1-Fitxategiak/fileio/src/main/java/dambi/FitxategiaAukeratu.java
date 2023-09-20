package dambi;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FitxategiaAukeratu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Fitxategi/Direktorio baten path absolutua jarri: ");
        String fitxategia = sc.next();

        Path path = Paths.get(fitxategia);
        Path absolutua = path.toAbsolutePath();
        System.out.println(absolutua);
        
    }
    


}
