package net.loos.elementsmod.entity.custom;



import java.util.Arrays;
import java.util.Comparator;

public enum BirdVariant {
    BROWN(0),
    SANDY(1),
    BLUE(2),
    GREEN(3);

    private static final BirdVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(BirdVariant::getId)).toArray(BirdVariant[]::new);
    private final int id;

    BirdVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static BirdVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}