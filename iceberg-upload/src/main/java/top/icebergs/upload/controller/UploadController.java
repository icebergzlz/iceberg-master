package top.icebergs.upload.controller;

import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.icebergs.upload.utils.MinioUtil;

import java.util.concurrent.TimeUnit;


/**
 * @author iceberg
 * @create 2020-09-28 9:36
 */
@RestController
@RequestMapping("/cloud")
public class UploadController {
    @Value("${minio.endpoint}")
    private String endpoint;

    @Value("${minio.bucketName}")
    private String bucketName;

    @Autowired
    private MinioUtil minioUtil;

    //上传文件到minio服务
    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file )  {
        try {
            String name = file.getOriginalFilename();
            minioUtil.putObject(bucketName,name,file);
            String url = endpoint+"/"+bucketName+"/"+name;
            return ResponseEntity.ok(url);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/hi")
    public String hello() {
        return "hello";
    }
}
