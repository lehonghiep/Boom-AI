package com.nhom6.boom.models;

import java.awt.*;
import java.util.List;

/**
 * Created by lhhie on 3/24/2017.
 */
public class Entity implements Constacts{
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;
    protected int index = 0;
    protected int countMove = 0;
    public int x;
    public int y;
    protected int orient;
    protected Image image;
    protected Image[][] arrImage;
    protected int speed;



    public Image getImage() {
        if (index >= arrImage[orient].length) {
            index = 1;
        }
        index++;
        return arrImage[orient][index - 1];
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(image, x, y, SIZE_ITEM, SIZE_ITEM, null);
    }

    public void changeOrient(int newOrient) {
        if (orient != newOrient) {
            index = 0;
            countMove = 0;
        }
        orient = newOrient;

    }

    public void move(List<Map> arrMap,List<Boom>arrBoom) {

    }

    public boolean checkMap(List<Map> arrMap,List<Boom>arrBoom) {
        for (int i=arrMap.size()-1;i>=0;i--) {
            Rectangle rect = getRect().intersection(arrMap.get(i).getRect());
            if (rect.isEmpty() == false) {
                return true;
            }
        }
//        for (Boom boom : arrBoom) {
//            Rectangle rect=getRect().intersection(boom.getRectMid());
//            if(boom.timeExplosion<200){
//                if(rect.isEmpty()==false){
//                    return false;
//                }
//            }
//        }
        return false;
    }

    public Rectangle getRect() {
        return null;
    }
}
