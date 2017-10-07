package org.jinlong.study.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "org.jinlong.study.spring.aop.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
