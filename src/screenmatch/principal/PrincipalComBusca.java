package screenmatch.principal;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import screenmatch.modelos.Titulo;
import screenmatch.modelos.TituloOMDB;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Informe um filme para busca: ");
        var busca = leitura.nextLine();

        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=4bb96a85";
    try{
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

        //try{
            Titulo meuTitulo = new Titulo(meuTituloOMDB);
            System.out.println("Título já convertido");
            System.out.println(meuTitulo);
        }catch (NumberFormatException e){
            System.out.println("Aconteceu um erro: " + e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Verifique o endereço: " + e.getMessage());
        }catch (Exception e){
            System.out.println("Erro genérico");
        }

        System.out.println("O programa finalizou corretamente!");
    }
}