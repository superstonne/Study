package org.jinlong.study.patterns.structural;

public class CompositeDemo {
}

abstract class Component {
    void addChild(Component component) throws Exception {
        throw new Exception("Illegal operation.");
    }
    Component children() throws Exception {
        throw new Exception("Illegal operation.");
    };

    abstract void handleEvent();
}

class SubComponent extends Component {

    @Override
    void handleEvent() {

    }
}

class SubComponentContainer extends Component {

    @Override
    void handleEvent() {

    }

    @Override
    void addChild(Component component) throws Exception {
        super.addChild(component);
    }

    @Override
    Component children() throws Exception {
        return super.children();
    }
}