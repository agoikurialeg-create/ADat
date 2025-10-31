package IrudienAldaketa;
import java.io.FileOutputStream;
import java.io.IOException;

public class IrudienIdazketa {

	public static void main(String[] args) {
        int width = 1200;
        int height = 900;

        // PPM fitxategi motarako goiburua idazten dugu. (P6)
        String header = "P6\n" + width + " " + height + "\n255\n";

        // Kolore gorriaren berezko zenbakiak (R=255, G=0, B=0)
        byte red = (byte) 50;
        byte green = (byte) 0;
        byte blue = (byte) 0;

        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\2AM3-3\\git\\ADat\\src\\IrudienAldaketa\\irudia.ppm")) {
            // Fitxategiaren goiburua idazten du.
            fos.write(header.getBytes());

            // Pixel bakoitzeko iterazioa.
            for (int y = 0; y < height; y++) {
            	red = (byte) (y);
            	green = (byte) (green+1);
            	blue = (byte) (blue+y);
                for (int x = 0; x < width; x++) {
                    // Kolore gorria irudikatzeko beharrezko hiru byte-ak idazten ditu.
                    fos.write(red);
                    fos.write(green + x);
                    fos.write(blue +20);
                }
            }
            System.out.println("Irudi gorria ondo sortuta: irudi_gorria.ppm");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}