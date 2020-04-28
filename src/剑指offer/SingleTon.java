package 剑指offer;

/**
 * <p>
 * Created by tianyang on 2020/3/19.
 */
public class SingleTon {
    private volatile static SingleTon singleTon;
    private SingleTon() {}
    public static SingleTon getInstance() {
        if (singleTon != null) {
            synchronized (SingleTon.class) {
                if (singleTon !=null)
                    return singleTon;
            }
        }
        return singleTon;
    }
}
