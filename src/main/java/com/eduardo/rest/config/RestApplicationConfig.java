package com.datarepublic.dataload.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.athena.AmazonAthena;
import com.amazonaws.services.athena.AmazonAthenaClientBuilder;
import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.AmazonCloudFormationClientBuilder;
import com.amazonaws.services.glue.AWSGlue;
import com.amazonaws.services.glue.AWSGlueClient;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.Errors;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@Configuration
@EnableSwagger2
@EnableJpaRepositories(basePackages = {"com.datarepublic.dataload"})
@EntityScan(basePackages = {"com.datarepublic.dataload"})
@ComponentScan(basePackages = {"com.datarepublic.dataload"})
public class ApplicationConfig {

    @Value("${DR_ACCOUNT_REGION}")
    private String region;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(Errors.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.datarepublic.dataload.controller"))
                .paths(any())
                .build();
    }

    @Bean
    public AmazonSQS sqsClient(@Value("${DR_ACCOUNT_REGION}") final String drAccountRegion) {
        return AmazonSQSClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withRegion(drAccountRegion)
                .build();
    }

    @Bean
    public AmazonSNS snsClient(@Value("${DR_ACCOUNT_REGION}") final String drAccountRegion) {
        return AmazonSNSClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withRegion(drAccountRegion)
                .build();
    }

    @Bean
    public AWSGlue glueClient(@Value("${DR_ACCOUNT_REGION}") final String drAccountRegion) {
        return AWSGlueClient.builder()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withRegion(drAccountRegion)
                .build();
    }

    @Bean
    public AmazonAthena athenaClient(@Value("${DR_ACCOUNT_REGION}") final String drAccountRegion) {
        return AmazonAthenaClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withRegion(drAccountRegion)
                .build();
    }

    @Bean
    public AmazonS3 s3Client(@Value("${DR_ACCOUNT_REGION}") final String drAccountRegion) {
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withRegion(drAccountRegion)
                .build();
    }

    @Bean
    public AmazonCloudFormation cloudFormation() {
        return AmazonCloudFormationClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withRegion(Regions.fromName(region))
                .build();
    }

    @Bean("generate")
    public TemplateEngine getResource() {

        SpringTemplateEngine engine = new SpringTemplateEngine();
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".json");
        templateResolver.setTemplateMode(TemplateMode.RAW);
        templateResolver.setCharacterEncoding("UTF-8");
        engine.setTemplateResolver(templateResolver);

        return engine;
    }
}
