package apps.account;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;

import org.apache.camel.ProducerTemplate;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
public class ServiceRoute {

    @Inject
    ProducerTemplate producerTemplate;

  

    public void accountOpen(String aOFDetailsRequestType,String approver) {
              
           String objClient = producerTemplate.requestBody("direct:clientInsertCaps", aOFDetailsRequestType, String.class);
                   
     
    }
   
   
    public void accountOpenStatus() {
              
      System.out.println("Reached");
                
  
 }
}

