package mockito;

public class CellPhone {
    private final boolean mobile;
    private final String number;

    public CellPhone(String number, boolean mobile){

        this.number = number;
        this.mobile = mobile;
    }

    public boolean isMobile() {
        return mobile;
    }
}
