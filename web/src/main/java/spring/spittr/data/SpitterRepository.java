package spring.spittr.data;

import spring.spittr.Spitter;

public interface SpitterRepository {

    Spitter save(Spitter unsaved);

    Spitter findByUserName(String username);
}
