package ec.insuasti.ups.homeworks.camelroute;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CustomerProcessor implements Processor{
    private Logger log = LoggerFactory.getLogger(CustomerProcessor.class);
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void process(Exchange exchange) throws Exception {
        Customer newCustomer = modelMapper.map(exchange.getMessage().getBody(), Customer.class);
        exchange.getIn().setHeader(Exchange.CONTENT_TYPE, "application/json");
        log.info(newCustomer.getCustomer_channel());
        if ("Digital".equals(newCustomer.getCustomer_channel()) ){
            
            exchange.getIn().setHeader("ruta", "1");
        }
        else {
            exchange.getIn().setHeader("ruta", "2");
        }
        exchange.getIn().setBody(newCustomer);
        log.info("Customer process {}", newCustomer); 
    }
}
