package org.jinlong.study.patterns.behavior;

public class CommandDemo {
    public static void main(String[] args) {
        ButtonFunction function = new ButtonFunction(new ShowDialogCommand());
        function.execute();
    }
}

abstract class Command {
    abstract void execute();
}

class ShowWindowCommand extends Command {
    @Override
    void execute() {
        new Window().display();
    }
}

class ShowDialogCommand extends Command {
    @Override
    void execute() {
        new Dialog().display();
    }
}

class ButtonFunction {
    private Command command;

    public ButtonFunction(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }
}

class Component {
    void display() {
        throw new RuntimeException("No this operation.");
    }
}

class Window extends Component {
    @Override
    void display() {
        System.out.println("Show window.");
    }
}

class Dialog extends Component {
    @Override
    void display() {
        System.out.println("Show dialog.");
    }
}
