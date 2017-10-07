package org.jinlong.study.spring.aop;

public aspect CriticalAspect {
    public CriticalAspect() {}
    pointcut performance() : execution(* perform(..));
    afterReturning() : performance() {
        System.out.println(criticismEngine.getCriticism());
    }
    private CriticismEngine criticismEngine;
    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
