<table>
<thead>
<tr>
<th align="center">Description</th>
</tr>
<br></br>
<tr><td align="left">This project usually is a simple combination of existing technologies. The following sample applications expose Api RestFull by (Spring-boot (data-jpa/web/test),cxf JAXRS, /swagger2) with memory database H2:</td>
</tr>
</thead>
<tbody>
<tr>
<td colspan="2"><strong>Java</strong></td>
</tr>
<br></br>
<tr>
<td><b>REST Api with , spring-boot(web/test/data-jpa) , cxf-jaxrs with (swagger2 feature, jackson provider ) , H2 </b>
<br></br>
 <br>* config programmatically cxf JAXRSServer ( endpoint REST) 
 <br>* with Jackson provider (need dependency , jackson-jaxrs-json-provider)
 <br>* with swagger2 feature , for documentation api (need dependencies , cxf-rt-rs-service-description-swagger , org.webjars.swagger-ui)
 <br>* config H2 with auto create ddl with hbm2ddl 
 <br></br>
 <br>* Endpoint address:</br>
  <a href=" http://localhost:8080/services/services"> http://localhost:8080/services/services</a>  
 <br>* Swagger :</br>
  <a href="http://localhost:8080/services/api-docs?url=/services/swagger.json">  http://localhost:8080/services/api-docs?url=/services/swagger.json</a>
 <br>* console h2 :</br>
   <a href="http://localhost:8080/h2-console">http://localhost:8080/h2-console </a> 
    <br>* NB :(JDBC URL=jdbc:h2:mem:spring-boot-cxf)</br>
</td>
</tr>

<tr>
<td><br>* refer to :</br>
 <a href="https://cxf.apache.org/docs/springboot.html">https://cxf.apache.org/docs/springboot.html</a></td>  
</tr>
<tr>
<td><a href="https://cxf.apache.org/docs/springboot.html">http://cxf.apache.org/docs/jaxrs-services-configuration.html</a></td>  
</tr>
<tr>
<td><a href="https://cxf.apache.org/docs/springboot.html">http://cxf.apache.org/docs/swagger2feature.html</a></td>  
</tr>

</tbody>
</table>