package Employee;

public class CounterId {
    public static int COUNTED;
    public int id;

    public int getId() {
        return COUNTED++;
    }
}
