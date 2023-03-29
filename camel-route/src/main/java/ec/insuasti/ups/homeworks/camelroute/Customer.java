package ec.insuasti.ups.homeworks.camelroute;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Customer {
    private int id;
    private String name;
    private String gender;
    private String customer_dni;
    private String customer_channel;

}
