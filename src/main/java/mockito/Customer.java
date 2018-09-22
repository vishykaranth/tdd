package mockito;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final List<CellPhone> cellPhones = new ArrayList<CellPhone>();

    public void addPhone(CellPhone phone){
        cellPhones.add(phone);
    }

    public boolean hasMobile(){
        for(CellPhone cellPhone : cellPhones){
            if(cellPhone.isMobile()){
                return true;
            }
                    }

                    return false;
                    }
                    }
