package study.designModel.observer;

import org.junit.Assert;

import java.util.Observable;
import java.util.Observer;

/**
 * @author sunjian.
 */
public class YilinReader implements Observer {
    private String name;

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + "收到意林有新版的消息了!!!");
        System.out.println("新版本是:" + arg.toString());
        //todo 还可以增加判断逻辑进行处理选择
        assert "2".equals(arg.toString()):"版本不是2";
        /*if (arg.toString().equals("2")) {
            throw new RuntimeException(name + "不要第二版~");
        }*/
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public YilinReader(String name) {
        this.name = name;
    }
}
