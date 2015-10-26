package BlackJack.model.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by otto on 2015-10-25.
 */
public class Observable {

    protected List<Observer> m_observers = new ArrayList<Observer>() {
    };

    public void AddObserver(Observer a_observer) {
        m_observers.add(a_observer);
    }

    protected void Notify() {
        m_observers.forEach(Observer::Update);
    }
}
