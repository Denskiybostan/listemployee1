package Employee;

public class CointerId {
    public static int COUNTED;
    public int id;

    public int getId() {
        return COUNTED++;
    }
}
