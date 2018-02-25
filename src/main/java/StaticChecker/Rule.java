package StaticChecker;

public interface Rule<T> {
    void apply(T item, String fileName);
}
