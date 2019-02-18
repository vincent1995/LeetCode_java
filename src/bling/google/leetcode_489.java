package bling.google;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class leetcode_489 {

    class Robot{
        public boolean move(){ return true;};
        public void turnLeft(){};
        public void turnRight(){};
        public void clean(){};
    }
    public static void main(String[] args) {
    }

    Robot robot;
    int x = 0;
    int y = 0;
    Set<Coor> visitedGrid = new HashSet<>();
    void moveAtOnePos(){

        robot.clean();
        visitedGrid.add(new Coor(x,y));

        // move up
        if(!visitedGrid.contains(new Coor(x-1,y)) && robot.move()){
            x--;
            // move at new Pos
            moveAtOnePos();
            // come back
            turnAround();
            robot.move();
            x++;
            turnAround();
        }

        // move right
        robot.turnRight();
        if(!visitedGrid.contains(new Coor(x,y+1)) && robot.move()){
            y++;
            robot.turnLeft();
            moveAtOnePos();
            robot.turnLeft();
            robot.move();
            y--;
            turnAround();
        }

        // move down
        robot.turnRight();
        if(!visitedGrid.contains(new Coor(x+1,y)) && robot.move()){
            x++;
            turnAround();
            moveAtOnePos();
            robot.move();
            x--;
            turnAround();
        }

        // move left
        robot.turnRight();
        if(!visitedGrid.contains(new Coor(x,y-1)) && robot.move()){
            y--;
            robot.turnRight();
            moveAtOnePos();
            robot.turnRight();
            y++;
            turnAround();
        }
        robot.turnRight();
    }
    void turnAround(){
        robot.turnRight();
        robot.turnRight();
    }
}

class Coor {
    int x;
    int y;
    Coor(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coor coor = (Coor) o;
        return x == coor.x &&
                y == coor.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}