package lab1java;

public interface Parser<T1, T2> {
    T1 parser(T2 line);
}
