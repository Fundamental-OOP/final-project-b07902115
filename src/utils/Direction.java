package utils;

import java.awt.*;
import java.lang.RuntimeException;

public enum Direction {
    UP, DOWN, LEFT, RIGHT, NONE, HOLD;;

    public Dimension translate() {
        switch (this) {
            case UP:
                return new Dimension(0, -1);
            case DOWN:
                return new Dimension(0, 1);
            case LEFT:
                return new Dimension(-1, 0);
            case RIGHT:
                return new Dimension(1, 0);
            case NONE:
                return new Dimension(0, 0);
        }
		throw new RuntimeException("Unknown direction");
    }

}
