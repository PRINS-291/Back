package prins.idea;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileWriter;
import java.io.IOException;

public class SimpleOkHttpExample {
    // 将响应内容保存到文件
    private static void saveToFile(String data, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(data);  // 将数据写入到文件
            System.out.println("内容已保存到 " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 创建 OkHttpClient 实例
        OkHttpClient client = new OkHttpClient();

        // 设置请求 URL
//        String url = "https://github.com/PRINS-291/resource/raw/main/a.json";
        String url = "https://raw.githubusercontent.com/PRINS-291/resource/main/a.json";
//        String url = "https://raw.githubusercontent.com/PRINS-291/javaResourc/refs/heads/main/README.md";

        // 创建请求对象
        Request request = new Request.Builder()
                .url(url)
                .build();

        // 执行同步请求
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                // 获取响应数据并打印
                String responseData = null;
                if (response.body() != null) {
                    responseData = response.body().string();
                }

                // 打印响应内容（调试）
                System.out.println("响应内容：\n" + responseData);

                // 保存内容到文件
                saveToFile(responseData, "output.json"); // 文件名可以根据需要修改
            } else {
                System.err.println("请求失败，状态码：" + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();  // 处理网络异常
        }
    }
}

