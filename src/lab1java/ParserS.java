package lab1java;

public interface ParserS<T1, T2, T3> {
    T1 parser(T2 line, T3 state);
}