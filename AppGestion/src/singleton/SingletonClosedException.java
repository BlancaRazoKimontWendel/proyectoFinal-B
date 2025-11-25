package singleton;

public class SingletonClosedException extends Exception {
    public SingletonClosedException() {
        super("El singleton ya ha sido cerrado");
    }
}
