package com.util.image.upload.implementation;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.util.image.upload.Uploader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;

@Component
public class AmazonConcept implements Uploader {

    private AmazonS3 amazonS3;

    public AmazonConcept(@Value("${amazon.access-key}")String accessKey,
                         @Value("${amazon.secret-key}")String secretKey
    ){
        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey,secretKey);
        amazonS3 = AmazonS3ClientBuilder.standard().withRegion(Regions.AP_NORTHEAST_2).withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
//        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey,secretKey);
//
//        amazonS3 = AmazonS3ClientBuilder.standard()
//                .withRegion(Regions.AP_NORTHEAST_2)
//                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
//                .build();
    }

    @Override
    public void upload(String path, File file) {
        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(path, file.getName(), file);
            putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead);
            amazonS3.putObject(putObjectRequest);
            URL url = amazonS3.getUrl(path, file.getName());
            System.out.println(url);
        }catch (AmazonServiceException e){
            e.printStackTrace();
        }finally {
            amazonS3 = null;
        }
    }
}
