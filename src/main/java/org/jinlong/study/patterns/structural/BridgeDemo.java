package org.jinlong.study.patterns.structural;

public class BridgeDemo {

}

class Matrix {

}

abstract class Image {
    Painter painter;

    public Image() {
    }

    public Image(Painter painter) {
        this.painter = painter;
    }

    abstract void pareseFile(String file);
}

class GIF extends Image {

    @Override
    void pareseFile(String file) {
        painter.paint(new Matrix());
    }
}

interface Painter {
    void paint(Matrix matrix);
}

class WindowsPainter implements Painter {

    @Override
    public void paint(Matrix matrix) {
        System.out.println("Painting on windows.");
    }
}

class LinuxPainter implements Painter {

    @Override
    public void paint(Matrix matrix) {
        System.out.println("Painting on linux.");
    }
}
