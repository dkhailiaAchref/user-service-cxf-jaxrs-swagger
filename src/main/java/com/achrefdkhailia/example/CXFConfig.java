package com.achrefdkhailia.example;

import com.achrefdkhailia.example.controller.UsersController;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;



/**
 * The default address of CXF RESTfull API is /services,
 * to connect base url providing ( All Availables RESTful services )
 * http://localhost:8080/services/services => ceci affiche l'url de base de endpoint + le lien de redirection vers l'interface swagger2
 * Endpoint address: http://localhost:8080/services/
 * Swagger : http://localhost:8080/services/api-docs?url=/services/swagger.json
 * possibilité de tester les requettes GET , directement sur le navigateur (/users , /users/{id} )
 * http://localhost:8080/services/users
 * http://localhost:8080/services/users{id}
 */

/**
 * docs technique :
 * config programmatically cxf server RestFull :
 * with Jackson provider (need dependency , jackson-jaxrs-json-provider)
 * with swahgger2 feature , for documentation api (need dependencies , cxf-rt-rs-service-description-swagger , org.webjars.swagger-ui)
 * refer to : https://cxf.apache.org/docs/springboot.html
 *  refer to http://cxf.apache.org/docs/jaxrs-services-configuration.html
 * refer to : http://cxf.apache.org/docs/swagger2feature.html
 *
 * NB : spring boot  permet la config par fichier de properties (application.properties ) , like this
 * cxf.path=/services/helloservice
 * cxf.jaxrs.client.address=http://localhost:8080/services/helloservice
 * cxf.jaxrs.client.headers.accept=text/plain
 * cxf.jaxrs.client.classes-scan-packages=com.achrefdkhailia.example.controller
 */
@Configuration
public class CXFConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Server rsServer() {
        final JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setProvider(new JacksonJsonProvider());
        endpoint.setBus(bus);
        endpoint.setAddress("/");
        endpoint.setServiceBeans(Arrays.<Object>asList(userController()));
        endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
        return endpoint.create();
    }

    @Bean
    public UsersController userController() {
        return new UsersController();
    }

    //	 The default address of CXF RESTfull API is /services to change the API
    // sub-directory from /services with /api or anything that you like
//    @Bean
//    public ServletRegistrationBean cxfServlet() {
//        final ServletRegistrationBean servletRegistrationBean =
//                new ServletRegistrationBean(new CXFServlet(), "/api/*");
//        servletRegistrationBean.setLoadOnStartup(1);
//        return servletRegistrationBean;
//    }
}
