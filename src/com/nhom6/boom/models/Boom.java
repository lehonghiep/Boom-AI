package com.nhom6.boom.models;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.List;

/**
 * Created by lhhie on 3/26/2017.
 */
public class Boom implements Constacts{
    private double sRectIntersecWithPlayer =BOOM_INTERSECT_PLAYER;
    private int x;
    private int y;
    int xSearchBoom;
    int ySearchBoom;
    public int timeExplosion = 400;
    private int index;
    private int countDraw;
    private Image image;

    private Image imgMid = new ImageIcon(getClass().getResource("/images/boom_bang_mid_01.PNG")).getImage();
    private Image imgLeft = new ImageIcon(getClass().getResource("/images/boom_bang_left.PNG")).getImage();
    private Image imgRight = new ImageIcon(getClass().getResource("/images/boom_bang_right.PNG")).getImage();
    private Image imgUp = new ImageIcon(getClass().getResource("/images/boom_bang_up.PNG")).getImage();
    private Image imgDown = new ImageIcon(getClass().getResource("/images/boom_bang_down.PNG")).getImage();
    private Image arrImg[] = {
            new ImageIcon(getClass().getResource("/images/boom_01.PNG")).getImage(),
            new ImageIcon(getClass().getResource("/images/boom_02.PNG")).getImage(),
            new ImageIcon(getClass().getResource("/images/boom_03.PNG")).getImage(),
            new ImageIcon(getClass().getResource("/images/boom_04.PNG")).getImage(),
            new ImageIcon(getClass().getResource("/images/boom_05.PNG")).getImage(),
            new ImageIcon(getClass().getResource("/images/boom_06.PNG")).getImage(),
            new ImageIcon(getClass().getResource("/images/boom_07.PNG")).getImage(),
            new ImageIcon(getClass().getResource("/images/boom_08.PNG")).getImage()
    };

    public Boom(int x, int y) {
        this.x = x ;
        this.y = y + SIZE_ITEM/10;
        this.xSearchBoom=this.x+SIZE_ITEM/2;
        this.ySearchBoom=this.y+SIZE_ITEM/2;
    }

    public Image getImage() {
        if (countDraw > 10) {
            index++;
            if (index >= arrImg.length) {
                index = 0;
            }
            countDraw = 0;
        }
        return arrImg[index];
    }

    public boolean draw(Graphics2D g2d) {
        timeExplosion--;
        if (timeExplosion > 0) {
            countDraw++;
            image = getImage();
            g2d.drawImage(image, x, y,SIZE_ITEM,SIZE_ITEM, null);
        } else if (timeExplosion > -30) {
            g2d.drawImage(imgMid, x, y, null);
            g2d.drawImage(imgLeft, x - SIZE_ITEM, y,SIZE_ITEM,SIZE_ITEM, null);
            g2d.drawImage(imgRight, x + SIZE_ITEM, y,SIZE_ITEM,SIZE_ITEM, null);
            g2d.drawImage(imgUp, x, y - SIZE_ITEM,SIZE_ITEM,SIZE_ITEM, null);
            g2d.drawImage(imgDown, x, y + SIZE_ITEM,SIZE_ITEM,SIZE_ITEM, null);
        } else {
            return false;
        }
        return true;
    }

    public Rectangle getRectMid() {
        int xRect = x;
        int yRect = y;
        return new Rectangle(xRect, yRect, SIZE_ITEM, SIZE_ITEM);
    }

    public Rectangle getRectLeft() {
        int xRect = x - SIZE_ITEM;
        int yRect = y;
        return new Rectangle(xRect, yRect, SIZE_ITEM, SIZE_ITEM);
    }

    public Rectangle getRectRight() {
        int xRect = x + SIZE_ITEM;
        int yRect = y;
        return new Rectangle(xRect, yRect, SIZE_ITEM, SIZE_ITEM);
    }

    public Rectangle getRectUp() {
        int xRect = x;
        int yRect = y - SIZE_ITEM;
        return new Rectangle(xRect, yRect, SIZE_ITEM, SIZE_ITEM);
    }

    public Rectangle getRectDown() {
        int xRect = x;
        int yRect = y + SIZE_ITEM;
        return new Rectangle(xRect, yRect, SIZE_ITEM, SIZE_ITEM);
    }

    public boolean checkGetRect(Rectangle rect) {
        Rectangle rM = getRectMid().intersection(rect);
        Rectangle rL = getRectLeft().intersection(rect);
        Rectangle rR = getRectRight().intersection(rect);
        Rectangle rU = getRectUp().intersection(rect);
        Rectangle rD = getRectDown().intersection(rect);
        if (rM.isEmpty() == false
                || rL.isEmpty() == false
                || rR.isEmpty() == false
                || rU.isEmpty() == false
                || rD.isEmpty() == false) {
            return true;
        }
        return false;
    }

    public boolean explosion(List<Map> arrMap, Player player, List<Boss> arrBoss) {
        if (timeExplosion < 0) {
            for (int i = arrMap.size() - 1; i >= 0; i--) {
                if (checkGetRect(arrMap.get(i).getRect()) && arrMap.get(i).getBit() != 1 && arrMap.get(i).getBit() != 2) {
                    arrMap.get(i).bit = 0;
                }
            }
            for (int i = arrBoss.size() - 1; i >= 0; i--) {
                if (checkGetRect(arrBoss.get(i).getRect())) {
                 arrBoss.remove(i);
                }
            }
            return checkGetRect(player.getRect());
        }
        return false;
    }
    public int checkBoom(Player player){
            Rectangle rect=getRectMid().intersection(player.getRect());
            double xRect=rect.getWidth();
            double yRect=rect.getHeight();
            if(rect.isEmpty()==false){
                if(sRectIntersecWithPlayer >=(xRect*yRect)){
                    sRectIntersecWithPlayer =xRect*yRect;
                    return 1;
                }
                if(sRectIntersecWithPlayer <(xRect*yRect)){
                    return -1;
                }
            }
        return 0;
    }
}
