package dambi;

import java.io.File;
import java.io.IOException;

public class karpetaSortu {
    public static void main(String[] args) throws IOException {
        File baseDir = new File("karpeta_berriak");

        File animaliakDir = new File(baseDir, "animaliak");
        File arrainakDir = new File(animaliakDir, "arrainak");
        File ugaztunakDir = new File(animaliakDir, "ugaztunak");

        File elikagaiakDir = new File(baseDir, "elikagaiak");
        File barazkiakDir = new File(elikagaiakDir, "barazkiak");
        File esnekiakDir = new File(elikagaiakDir, "esnekiak");

        baseDir.mkdirs();
        animaliakDir.mkdirs();
        arrainakDir.mkdirs();
        ugaztunakDir.mkdirs();
        elikagaiakDir.mkdirs();
        barazkiakDir.mkdirs();
        esnekiakDir.mkdirs();

        System.out.println("Karpeta egitura sortuta.");
    }
}