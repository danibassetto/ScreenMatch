package screenmatch.principal;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import screenmatch.excessao.ErroDeConversaoDeAnoException;
import screenmatch.modelos.Titulo;
import screenmatch.modelos.TituloOMDB;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();

        while(!busca.equalsIgnoreCase("sair")) {

            System.out.println("Informe um filme para busca: ");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("sair"))
                break;

            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=4bb96a85";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);


                Gson gson = new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                        .create();
                TituloOMDB meuTituloOMDB = gson.fromJson(json, TituloOMDB.class);
                System.out.println(meuTituloOMDB);

                Titulo meuTitulo = new Titulo(meuTituloOMDB);
                System.out.println("Título já convertido");
                System.out.println(meuTitulo);

                //FileWriter escrita = new FileWriter("filmes.txt");
                //escrita.write(meuTitulo.toString());
                //escrita.close();

                titulos.add(meuTitulo);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Verifique o endereço: " + e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }

        }
        System.out.println(titulos);
        System.out.println("O programa finalizou corretamente!");
    }
}