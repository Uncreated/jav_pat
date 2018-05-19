import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class Db implements Observable {

    private static Db ourInstance = new Db();

    public static Db getInstance() {
        return ourInstance;
    }

    private Set<InvalidationListener> listeners;

    private int data = 0;

    private Db() {
        listeners = new HashSet<>();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                data++;
                dataChanged();
            }
        }, 0, 1000);
    }

    @Override
    public synchronized void addListener(InvalidationListener listener) {
        listeners.add(listener);
    }

    @Override
    public synchronized void removeListener(InvalidationListener listener) {
        listeners.remove(listener);
    }

    private synchronized void dataChanged() {
        for (InvalidationListener listener : listeners) {
            listener.invalidated(this);
        }
    }

    public int getData() {
        return data;
    }
}