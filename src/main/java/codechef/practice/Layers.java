package main.java.codechef.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Box {

    int l, b, c, firstQuadX, firstQuadY, secondQuadX, secondQuadY, thirdQuadX, thirdQuadY, forthQuadX, forthQuadY;
    boolean active;

    Box (int l, int b, int c, boolean active) {
        this.l = l;
        this.b = b;
        this.c = c;
        this.active = active;
    }

}
public class Layers {

    public List<Integer> getAreaOfColoredRectangle(List<Box> rectangles) {

        List<Integer> area = new ArrayList<>();
        Map<Integer, Integer> areaOfColor = new HashMap<>();
        int prevL, prevB, prevC, currL, currB, currC;
        int prevFirstQuadX, prevFirstQuadY,
                prevSecondQuadX, prevSecondQuadY, prevThirdQuadX, prevThirdQuadY, prevForthQuadX, prevForthQuadY;
        int currFirstQuadX, currFirstQuadY,
                currSecondQuadX, currSecondQuadY, currThirdQuadX, currThirdQuadY, currForthQuadX, currForthQuadY;
        boolean prevActive, currActive;
        prevL = rectangles.get(0).l;
        prevB = rectangles.get(0).b;
        prevC = rectangles.get(0).c;
        prevActive = true;
        currL = 0; currB = 0; currC = 0; currActive = false;
        areaOfColor.put(prevC, prevL * prevB);

        for (int i = 1; i < rectangles.size(); ++i) {

            currL = rectangles.get(i).l;
            currB = rectangles.get(i).b;
            currC = rectangles.get(i).c;
            currActive = true;
            int tmp = 0;
            if (prevL > currL && prevB > currB) {

                tmp = areaOfColor.get(prevC);
                tmp -= currL * currB;
                areaOfColor.put(prevC, tmp);

            }

            else if (prevL > currL && prevB < currB) {

                

            }

            else if (prevL < currL && prevB > currB) {

            }

            else if (prevL <= currL && prevB <= currB) {

            }

        }


        return area;

    }

    public static void main(String[] args) {



    }

}
