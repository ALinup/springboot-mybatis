package com.xncoding.pos.config;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .produces(Sets.newHashSet("application/json"))
                .consumes(Sets.newHashSet("application/json"))
                .protocols(Sets.newHashSet("http", "https"))
                .apiInfo(apiInfo())
                .forCodeGeneration(true)
                .useDefaultResponseMessages(false)
                .select()
                // 指定controller存放的目录路径
                .apis(RequestHandlerSelectors.basePackage("com.xncoding.modules.traffic.controller"))
//                .paths(PathSelectors.ant("/api/v1/*"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 文档标题
                .title("XX系统API服务")
                // 文档描述
                .description("XX系统API接口文档简要描述")
                // .termsOfServiceUrl("https://github.com/yidao620c")
                .version("v1")
                .license("MIT 协议")
                .licenseUrl("http://www.opensource.org/licenses/MIT")
                .contact(new Contact("熊能", "https://github.com/yidao620c", "yidao620@gmail.com"))
                .build();
    }
}
