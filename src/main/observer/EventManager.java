package main.observer;

public class EventManager {
    private EventListener listener;

    public EventManager() {}

    public void setListener(EventListener listener){
        this.listener = listener;
    }

    public void notify(String eventType, double attribute) {
        listener.update(eventType, attribute);
    }
}
