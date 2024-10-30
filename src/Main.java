import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira a moeda que você deseja pesquisar: ");
        var coin = scanner.nextLine();

        String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids=" + coin + "&x_cg_demo_api_key=myAPIKey"; // coloque a sua chave API

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}