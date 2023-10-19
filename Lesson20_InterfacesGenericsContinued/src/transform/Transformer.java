package transform;

public interface Transformer<T> {
    T transform(T original);
}
