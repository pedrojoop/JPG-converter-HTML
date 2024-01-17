import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.nio.file.StandardOpenOption;


public class JPGtoHTMLConverter {

    public static void main(String[] args) {
        String caminhoImagem = "E-MAIL (LEADS UNOPAR).jpg";

        byte[] imagemBytes;
        try {
            imagemBytes = Files.readAllBytes(Paths.get(caminhoImagem));

            String imagemBase64 = Base64.getEncoder().encodeToString(imagemBytes);

            String conteudoHTML = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<body>\n" +
                    "    <img src=\"data:image/jpeg;base64," + imagemBase64 + "\" alt=\"Imagem JPG\">\n" +
                    "</body>\n" +
                    "</html>";

            String caminhoHTML = "arquivo.html";

            Path pathHTML = Paths.get(caminhoHTML);
            try {
                Files.write(pathHTML, conteudoHTML.getBytes(), StandardOpenOption.CREATE);
                System.out.println("Arquivo HTML gerado com sucesso em: " + caminhoHTML);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
