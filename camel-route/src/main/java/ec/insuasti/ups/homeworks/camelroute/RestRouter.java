package ec.insuasti.ups.homeworks.camelroute;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class RestRouter extends RouteBuilder {

    JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Customer.class);

    @Override
    public void configure() throws Exception {
        restConfiguration()
           .enableCORS(false);
            

        from("direct:inCustomer")
        .routeId("RouteCustomer")
        .process(new CustomerProcessor())
        .choice()
            .when(header("ruta").contains("1"))
                .marshal(jsonDataFormat)
                .to("rest:post:/customer?host=localhost:3000")
            .otherwise()
                .marshal(jsonDataFormat)
                .to("rest:post:/customer?host=localhost:5000")
        .end();

    }
    
}
