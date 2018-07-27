package per.johnson.concurrent.thread;

/**
 * Created by Johnson on 2018/7/26.
 */
public class Data {
    public Data(String data){
        this.data = data;
    }
    public synchronized String getData(){
        return data;
    }
    String data;
}
