import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class MonoT {

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Phroton.getPhrotonInstance());
            try{
                Thread.sleep(1000);
            }catch (Exception e){}
        }).start();

        new Thread(()->{
            System.out.println(Phroton.getPhrotonInstance());
            try{
                Thread.sleep(1000);
            }catch (Exception e){}
        }).start();
    }


}

class Gluon{
    private static Gluon gluon;

    public static Gluon getInstance(){
        if (gluon == null){
            synchronized (Gluon.class){
                if (gluon == null)
                    gluon = new Gluon();
                }
            }
        return gluon;
    }
}

class Phroton{
    private  static Stack<Phroton> instance = new Stack<>();
    private  static List<Phroton> photon = new Vector<>();

    public static Phroton getInstance(){
        if (instance == null || instance.empty()){
            synchronized (Phroton.class) {
                if (instance.empty())
                   System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                    System.out.println("instance = " + instance);
                    instance.push(new Phroton());
            }
        }
        return instance.peek();
    }
    public static Phroton getPhrotonInstance(){
        if (photon == null || photon.isEmpty()){
            synchronized (Phroton.class) {
                if (photon.isEmpty())
                    System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                System.out.println("instance = " + photon);
                photon.add(new Phroton());
            }
        }
        return photon.get(photon.size()-1);
    }
}
