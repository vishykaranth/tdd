import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomerTestWithDoubles {

    final static CellPhone MOBILE_PHONE = mock(CellPhone.class);
    final static CellPhone LAND_LINE = mock(CellPhone.class);


    Customer customer = new Customer();

    @Test
    void shouldReturnTrue() {
        when(MOBILE_PHONE.isMobile()).thenReturn(true);

        customer.addPhone(MOBILE_PHONE);
        customer.addPhone(LAND_LINE);

        assertTrue(customer.hasMobile());
    }

    @Test
    void shouldReturnFalse() {
        customer.addPhone(LAND_LINE);

        assertFalse(customer.hasMobile());
    }
}
