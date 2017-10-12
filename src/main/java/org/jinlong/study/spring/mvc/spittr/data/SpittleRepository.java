package org.jinlong.study.spring.mvc.spittr.data;

import org.jinlong.study.spring.mvc.spittr.Spittle;
import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
