package org.jinlong.study.patterns.structural;

public class Decorator {
    public static void main(String[] args) {
        Room room = new Room();
        room = new Flower(room);
        System.out.println(room);

        room = new FlowerSunshine((Flower) room);
        System.out.println(room);

        room = new Sunshine(room);
        System.out.println(room);
    }
}

class Room {
    @Override
    public String toString() {
        return "It's a room";
    }
}

class Flower extends Room {
    Room room;

    public Flower(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + " with flowers";
    }
}

class Sunshine extends Room {

    Room room;

    public Sunshine(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + " with sunshine";
    }
}

class FlowerSunshine extends Room {
    Flower room;

    public FlowerSunshine(Flower room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "with sunshine";
    }
}
