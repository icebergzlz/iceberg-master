package top.icebergs.test;

import io.minio.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author iceberg
 * @create 2020-09-30 10:22
 */
@SpringBootTest
public class MinioTest {
    @Test
    public void getBucket() throws Exception {
        MinioClient client = MinioClient.builder()
                .endpoint("http://192.168.11.130:9000")
                .credentials("iceberg", "iceberg128")
                .build();

        String url = client.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                .bucket("iceberg-image")
                .object("9.jpg")
                .expiry(20,TimeUnit.SECONDS)
                .method(Method.GET)
                .build()
        );
        System.out.println(url);
    }
}
