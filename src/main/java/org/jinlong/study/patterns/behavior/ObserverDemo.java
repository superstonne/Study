package org.jinlong.study.patterns.behavior;

import java.util.Observable;
import java.util.Observer;

public class ObserverDemo {

    public static void main(String[] args) {
        AirStation airStation = new AirStation();
        airStation.addObserver(new School());
        StreetStation streetStation = new StreetStation();
        streetStation.addObserver(new School());
        airStation.warning();
        streetStation.warning();
    }
}

class AirStation extends Observable {
    void warning() {
        this.setChanged();
        System.out.println("Bad air warning.");
        this.notifyObservers();
    }
}

class StreetStation extends Observable {
    void warning() {
        this.setChanged();
        System.out.println("Street has been destroyed.");
        this.notifyObservers();
    }
}

class School implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof AirStation) {
            System.out.println("Keep in home for bad air.");
        }

        if (o instanceof StreetStation) {
            System.out.println("Keep in home for destroyed street.");
        }

    }
}
