package apps.account;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.apache.camel.Exchange;

import io.quarkus.runtime.annotations.RegisterForReflection;

@ApplicationScoped
@Named("beansCollection")
@RegisterForReflection
public class ServiceBean {

    void prepareClientInsertCaps(Exchange exchange) throws Exception {


        exchange.getIn().setBody(null, String.class);
    }
   
    public void prepareServiceResponse(Exchange exchange)
    {
   

        exchange.getIn().setBody(null, String.class);
    }
}
