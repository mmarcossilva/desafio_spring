package commons.interfaceDB;

public interface DatabaseMethods<T> {
    T findById(int id);
    void save(T item);
}
