package zhj.viewgroupdemo;

/**
 * Created by HongJay on 2016/9/17.
 */
public class RecycleViewItemData<T> {
    //用来装载不同类型的item数据bean
    T t;
    //item数据bean的类型
    int dataType;

    public RecycleViewItemData () {
    }

    public RecycleViewItemData (T t, int dataType) {
        this.t = t;
        this.dataType = dataType;
    }

    public T getT () {
        return t;
    }

    public void setT (T t) {
        this.t = t;
    }

    public int getDataType () {
        return dataType;
    }

    public void setDataType (int dataType) {
        this.dataType = dataType;
    }
}
