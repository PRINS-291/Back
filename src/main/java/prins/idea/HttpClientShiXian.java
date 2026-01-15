package prins.idea;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

// 总算可以了  为什么那几个那么慢
public class HttpClientShiXian {
    public static void main(String[] args) {
        String url = "https://github.com/PRINS-291/resource/raw/main/a.json";
//        String url = "https://raw.githubusercontent.com/PRINS-291/resource/main/a.json";
//        String url = "https://raw.githubusercontent.com/PRINS-291/javaResourc/refs/heads/main/README.md";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String jsonData = response.body();
                System.out.println("下载的 JSON 数据：");
                System.out.println(jsonData);
            } else {
                System.err.println("请求失败，状态码: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("请求失败: " + e.getMessage());
        }
    }
}