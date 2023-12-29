package apps.account;


import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.model.dataformat.JaxbDataFormat;


import java.math.BigDecimal;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class CamelRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {
  // JaxbDataFormat df = new JaxbDataFormat();
   // df.setContextPath("apps.account");

    
    from("direct:accountOpeningService")
        .to("bean:beansCollection?method=prepareClientInsertCaps")
        //.marshal().jaxb()
        //.toD("cxf:{{application.caps.service.scheme}}://{{application.caps.service.host}}:{{application.caps.service.port}}/{{application.caps.service.uri}}?serviceClass=apps.account.soapclient.CAPSWSAPI&dataFormat=PAYLOAD&defaultOperationName=ClientInsertCaps")
       // .unmarshal(df)
        .log("After \n ${body} \n ------------")
      //  .convertBodyTo(ClientInsertCapsResponse.class)
        .log("Response:::::::::: \n ${body} \n -----------");

  }

}