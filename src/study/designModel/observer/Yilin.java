package study.designModel.observer;

import java.util.Observable;

/**
 * Created by sunjian on 2017/5/31.
 */
public class Yilin extends Observable {

    private String version = "1";

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        if(!this.version.equals(version)){
            this.version = version;
            setChanged();
        }
        notifyObservers(this.version);
    }
}
