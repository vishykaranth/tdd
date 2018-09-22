
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerTest {

    final static String ANY_NUMBER = "999-888-777";
    final static CellPhone MOBILE_PHONE = new CellPhone(ANY_NUMBER, true);
    final static CellPhone LAND_LINE = new CellPhone(ANY_NUMBER, false);


    Customer customer = new Customer();

    @Test
    void shouldReturnTrue(){
        customer.addPhone(MOBILE_PHONE);
        customer.addPhone(LAND_LINE);

        assertTrue(customer.hasMobile());
    }

    @Test
    void shouldReturnFalse(){
        customer.addPhone(LAND_LINE);

        assertFalse(customer.hasMobile());
    }
}
