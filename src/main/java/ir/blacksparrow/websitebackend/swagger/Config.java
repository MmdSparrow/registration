package ir.blacksparrow.websitebackend.swagger;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class Config {
    @Bean
    public Docket DocketSwaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("ir.blacksparrow.websitebackend/view/controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(ApiInfo())
                .tags(new Tag("Category", "Category contain a collection of enums such as role.\n To access to every category they have specific code."), ApiDescriptions());
    }

    private ApiInfo ApiInfo() {
        return new ApiInfoBuilder()
                .title("Digital School Api Documentation")
                .description("Digital School Documentation - For Postman: /postman instead of /docs.")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("Terms of Service")
                .version("1.0.0")
                .contact(new Contact("Digital School", "https://fanap.ir/", "frapod@gmail.com")) //TODO
                .build();
    }

    private Tag[] ApiDescriptions() {
        return new Tag[]{
                new Tag("Category element", "Category elements are items in a enum e.g \"مدیر\" ,\"معلم\" ,\"دانش آموز\", etc for role.\nEvery element has a specific code to access."),
                new Tag("Class", "To understand meaning of \"class\", consider the following examples:\n\"قرآن\" ,\"ریاضی\" ,\"علوم\", etc."),
                new Tag("Classroom", ""),
                new Tag("Educational stage", "Stage means level of education pattern system such as \"بتدایی\" and \"متوسطه\"."),
                new Tag("Educational stage class", "\"Education stage class\" is stage part segments, suppose that stage part \"متوسطه اول\" which includes \"هشتم\" ,\"هفتم\" and \"نهم\"  classes."),
                new Tag("Educational stage part", "To understand meaning of \"stage part\" suppose \"متوسطه\" stage, It is divided into two parts which are called \"متوسطه اول\" and \"متوسطه دوم\"."),
                new Tag("Group", ""),
                new Tag("Person", ""),
                new Tag("Person role", "This service is relation between two entities \"person\" and \"role\". Because every person just have one role, a entity with name \"person role\" created and this service present all required apis.\n For some reason there is no api for edit role therefor you have to delete and create person again with correct role."),
                new Tag("Role", "In school there are some roles and for now roles \"مدیر\" ,\"معلم\" ,\"دانش آموز\" and \"مدیر اصلی\" are implemented."),
                new Tag("School", ""),
                new Tag("SSO", "Authentication service based on single sign one (SSO) with two Apis for login and logout form POD."),
                new Tag("Student", ""),
                new Tag("Teacher", ""),
                new Tag("Term", ""),
                new Tag("Year", "")
        };
    }
}
