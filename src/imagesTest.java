import java.io.File;

public class imagesTest {
    public static void main(String[] args) {
        String path = "images/icon.ico";
        File file = new File(path);

        if (file.exists()) {
            System.out.println("O arquivo ICO existe.");
        } else {
            System.out.println("O arquivo ICO não foi encontrado.");
        }
    }
}