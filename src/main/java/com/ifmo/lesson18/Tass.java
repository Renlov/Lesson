package com.ifmo.lesson18;
import java.util.ArrayList;
import java.util.List;


public class Tass {
    public List<Listener> listeners = new ArrayList<>();
    public void subscribe(Listener listener) {
        listeners.add(listener);
    }
    public void notifyListeners(Integer tempera) {
        for (Listener listener : listeners)
            listener.publish(tempera);
    }
}
