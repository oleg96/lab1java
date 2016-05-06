package lab1java;
/**
 * Interface for classes which return the reports by some parameter
 * @param <T1>
 * @param <T2>
 * @author Oleg Fedorov
 */
public interface Reporter<T1, T2> {
    /**
     * Returns generic T report
     * @param t0 input parameter for report
     */
    T1 reporter(T2 t0);
}
