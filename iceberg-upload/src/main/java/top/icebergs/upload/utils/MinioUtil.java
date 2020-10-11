package top.icebergs.upload.utils;


import io.minio.*;
import io.minio.messages.Bucket;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author iceberg
 * @create 2020-09-29 20:30
 */
@Component
public class MinioUtil {
    @Autowired
    private MinioClient minioClient;

    private static final int DEFAULT_EXPIRY_TIME=7*24*3600;

    /**
     * ======================= Bucket operations ===================================
     * makeBucket   创建一个存储桶
     * listBuckets  查询所有的存储桶
     * bucketExists 检查存储桶是否存在
     * removeBucket 删除一个存储桶
     * listObjects  获取某个桶中所有的对象
     * listIncompleteUploads   获取桶中被部分上传的对象
     */
    /**
     * 判断桶是否存在
     * @param bucketName
     * @return
     * @throws Exception
     */
    @SneakyThrows
    public boolean bucketExists(String bucketName){
        boolean isExists = minioClient.bucketExists(
                BucketExistsArgs
                        .builder()
                        .bucket(bucketName)
                        .build()
        );
        return isExists;
    }
    /**
     * 获取指定 bucket 的信息
     * @param bucketName
     * @return
     */
    @SneakyThrows
    public Bucket getBucket(String bucketName) {
        return minioClient.listBuckets().stream().filter(b -> b.name().equals(bucketName)).findFirst().get();
    }

    /**
     * ======================= Bucket Policy Operations ===================================
     * getBucketPolicy  获得存储桶策略
     * setBucketPolicy  设置存储桶策略
     */


    /**
     * ======================= Object operations ===================================
     * getObject   获得一个对象
     * putObject   上传对象
     * copyObject  copy对象，从对象到对象
     * statObject  获取对象的元数据
     * removeObject 删除对象
     * removeIncompleteUpload  删除一个未完整上传的对象
     */

    /**
     * 上传文件
     * @param bucketName
     * @param objectName
     * @param file
     */
    @SneakyThrows
    public void putObject(String bucketName, String objectName, MultipartFile file) {
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .stream(file.getInputStream(),file.getSize(),-1)
                .contentType(file.getContentType())
                .build());
    }
    /**
     * 获取文件
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @return 二进制流
     */
    @SneakyThrows
    public InputStream getObject(String bucketName, String objectName) {
        return minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }
    /**
     * 删除文件
     * @param bucketName bucket名称
     * @param objectName 文件名称
     */
    @SneakyThrows
    public void removeObject(String bucketName, String objectName) {
        minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }

    /**
     * ======================= Presigned Operations ===================================
     * getPresignedObjectUrl 生成预签名url
     * presignedGetObject   生成一个给HTTP GET请求用的presigned URL
     * presignedPutObject   生成一个给HTTP PUT请求用的presigned URL
     * presignedPostPolicy  生成一个给HTTP POST请求用的presigned URL
     */

}

