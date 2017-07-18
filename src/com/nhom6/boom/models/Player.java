package com.nhom6.boom.models;

import javax.swing.*;
import java.awt.*;
import java.util.List;


/**
 * Created by lhhie on 3/24/2017.
 */
public class Player extends Entity {
public int xSearch;
public int ySearch;
/*
    public Image[] imgEffect = {
            new ImageIcon(getClass().getResource("/images/hieuUng_11.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/hieuUng_12.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/hieuUng_13.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/hieuUng_14.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/hieuUng_15.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/hieuUng_16.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/hieuUng_17.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/hieuUng_18.png")).getImage()
    };
    */
    public Image imgLeft[] = {
            new ImageIcon(getClass().getResource("/images/player_left_1.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/player_left_2.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/player_left_3.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/player_left_4.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/player_left_5.png")).getImage()
    };
    public Image imgRight[] = {
            new ImageIcon(getClass().getResource("/images/player_right_1.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/player_right_2.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/player_right_3.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/player_right_4.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/player_right_5.png")).getImage()
    };
    public Image imgUp[] = {
            new ImageIcon(getClass().getResource("/images/player_up_1.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/player_up_2.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/player_up_3.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/player_up_4.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/player_up_5.png")).getImage()
    };
    public Image imgDown[] = {
            new ImageIcon(getClass().getResource("/images/player_down_1.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/player_down_2.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/player_down_3.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/player_down_4.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/player_down_5.png")).getImage()
    };

    public Player(int x, int y) {
        this.x=x;
        this.y=y;
        xSearch=x+SIZE_ITEM/2;
        ySearch=y+SIZE_ITEM/2;
        orient = DOWN;
        arrImage = new Image[][]{imgLeft, imgRight, imgUp, imgDown};
        image = getImage();
    }
    @Override
    public void move(List<Map> arrMap, List<Boom> arrBoom) {
        if (countMove % 10 == 0) {
            image = getImage();
            countMove = 0;
        }
        countMove++;
        speed = 1;
        int xRaw = x;
        int yRaw = y;
        int xRawSearch=xSearch;
        int yRawSearch=ySearch;
        switch (orient) {
            case LEFT:
                x -= speed;
                xSearch-=speed;
                break;
            case RIGHT:
                x += speed;
                xSearch+=speed;
                break;
            case UP:
                y -= speed;
                ySearch-=speed;
                break;
            case DOWN:
                y += speed;
                ySearch+=speed;
                break;
        }
        if (checkMap(arrMap,arrBoom)) {
            x = xRaw;
            y = yRaw;
            xSearch = xRawSearch;
            ySearch=yRawSearch;
        }
        for(int i=arrBoom.size()-1;i>=0;i--){
            if(arrBoom.get(i).checkBoom(this)<0){
                x=xRaw;
                y=yRaw;
                xSearch = xRawSearch;
                ySearch=yRawSearch;
            }
        }

    }

    public Boom fire() {
        int xB = x;
        int yB = y;
        Boom boom = new Boom(xB, yB);
        return boom;
    }

    @Override
    public Rectangle getRect() {
        int xRect = x + SIZE_ITEM/5;
        int yRect = y + SIZE_ITEM/5*2;
        int sizeRect=SIZE_ITEM-(SIZE_ITEM/5*2);
        return new Rectangle(xRect, yRect,sizeRect , sizeRect);
    }
    public boolean checkBoss(List<Boss> arrBoss){
        for (Boss boss : arrBoss) {
            Rectangle rect=boss.getRect().intersection(getRect());
            if(rect.isEmpty()==false){
                return true;
            }
        }
        return false;
    }
}
