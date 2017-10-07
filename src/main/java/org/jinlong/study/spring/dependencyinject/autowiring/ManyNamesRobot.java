package org.jinlong.study.spring.dependencyinject.autowiring;

import java.util.List;

public class ManyNamesRobot extends Robot {
    private List<String> names;

    public ManyNamesRobot() {

    }

    public ManyNamesRobot(List<String> names) {
        this.names = names;
    }

    public void say() {
        for (String name : names) {
            System.out.println(name);
        }
    }

    public void setNames(List names) {
        this.names = names;
    }

    public List getNames() {
        return names;
    }
}
