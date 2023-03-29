package ec.insuasti.ups.homeworks.camelroute;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamelRouteController {

    @Autowired private ProducerTemplate template;
    @PostMapping(value = "/customer")
    public ResponseEntity<String> inCustomer(@RequestBody Customer customer){
        try {
            template.requestBody("direct:inCustomer", customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        
       
    }
    
}
