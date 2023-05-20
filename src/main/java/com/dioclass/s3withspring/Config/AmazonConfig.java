package com.dioclass.s3withspring.Config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {
    // the information to access the account
    private static final String ACCESS_KEY = "AKIAURJMZJEFEJI2UR2M";
    private static final String SECRET_KEY = "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";

    @Bean
    public static AmazonS3 s3WithCredentials(){
        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.DEFAULT_REGION)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build()
                ;
    }
}