package net.loos.elementsmod.entity.custom;

import java.util.Arrays;
import java.util.Comparator;


public enum ButterflyVariant {
    DEFAULT(0),
    PURPLE(1),
    BLACK(2),
    RED(3),
    GREEN(4),
    PINK(5);

    private static final ButterflyVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ButterflyVariant::getId)).toArray(ButterflyVariant[]::new);
    private final int id;

    ButterflyVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static ButterflyVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }


}
