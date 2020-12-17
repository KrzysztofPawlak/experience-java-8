package academy.elqoo.java8.defaultmethods;

import java.util.List;

public interface Shape {

    int getXPos();

    int getYPos();

    void setXPos(int xPOs);

    void setYPos(int yPos);

    default String getName(){
        return "";
    }

    default void move(int x, int y) {
        setXPos(x);
        setYPos(y);
    }

    static void moveXPosWith10(List<AbstractShape> shapes) {
        for (AbstractShape as : shapes) {
            as.setXPos(as.getXPos() + 10);
        }
    }
}
