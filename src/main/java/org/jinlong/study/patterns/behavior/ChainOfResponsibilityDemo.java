package org.jinlong.study.patterns.behavior;

import org.apache.kafka.common.protocol.types.Field;

public class ChainOfResponsibilityDemo {

    public static void main(String[] args) {
        ProcessRequest small = new ProcessRequest("Small");
        small.setSmall(true);
        ProcessRequest big = new ProcessRequest("Big");
        big.setBig(true);
        ProcessRequest superBig = new ProcessRequest("SuperBig");
        superBig.setSuperBig(true);

        Approver firstLine = new FirstLine("First Line");
        Approver secondLine = new SecondLine("Second Line");
        Approver thirdLine = new ThirdLine("Third Line");
        firstLine.setSuccessor(secondLine);
        secondLine.setSuccessor(thirdLine);

        firstLine.handleRequest(small);
        firstLine.handleRequest(big);
        firstLine.handleRequest(superBig);
    }
}

class ProcessRequest {
    private String name;
    private boolean isSmall;
    private boolean isBig;
    private boolean isSuperBig;

    public ProcessRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSmall() {
        return isSmall;
    }

    public void setSmall(boolean small) {
        isSmall = small;
    }

    public boolean isBig() {
        return isBig;
    }

    public void setBig(boolean big) {
        isBig = big;
    }

    public boolean isSuperBig() {
        return isSuperBig;
    }

    public void setSuperBig(boolean superBig) {
        isSuperBig = superBig;
    }
}

abstract class Approver {
    protected String name;
    protected Approver successor;

    public Approver(String name) {
        this.name = name;
    }

    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }

    abstract void handleRequest(ProcessRequest request);
}

class FirstLine extends Approver {


    public FirstLine(String name) {
        super(name);
    }

    @Override
    void handleRequest(ProcessRequest request) {
        if (request.isSmall()) {
            System.out.println(name + " approved " + request.getName());
        } else if (this.successor != null) {
            this.successor.handleRequest(request);
        }
    }
}

class SecondLine extends Approver {


    public SecondLine(String name) {
        super(name);
    }

    @Override
    void handleRequest(ProcessRequest request) {
        if (request.isBig()) {
            System.out.println(name + " approved " + request.getName());
        } else if (this.successor != null) {
            this.successor.handleRequest(request);
        }
    }
}

class ThirdLine extends Approver {


    public ThirdLine(String name) {
        super(name);
    }

    @Override
    void handleRequest(ProcessRequest request) {
        if (request.isSuperBig()) {
            System.out.println(name + " approved " + request.getName());
        } else if (this.successor != null) {
            this.successor.handleRequest(request);
        }
    }
}