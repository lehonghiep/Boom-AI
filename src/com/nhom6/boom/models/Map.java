package com.nhom6.boom.models;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lhhie on 3/24/2017.
 */
public class Map implements Constacts{
public int x;
public int y;
public int bit;
private Image[]images={
        new ImageIcon(getClass().getResource("/images/cay1.png")).getImage(),
        new ImageIcon(getClass().getResource("/images/da1.png")).getImage(),
        new ImageIcon(getClass().getResource("/images/goccay2.png")).getImage(),
        new ImageIcon(getClass().getResource("/images/namdo1.png")).getImage(),
        new ImageIcon(getClass().getResource("/images/namxanh1.png")).getImage()
};
public Map(int x,int y, int bit){
    this.x=x;
    this.y=y;
    this.bit=bit;
}
public int getBit(){
    return this.bit;
}
public void draw(Graphics2D g2d){
    if(bit==1){
        g2d.drawImage(images[1],x,y,SIZE_ITEM,SIZE_ITEM,null);
    }else if(bit==2){
        g2d.drawImage(images[2],x,y,SIZE_ITEM,SIZE_ITEM,null);
    }else if(bit==3){
        g2d.drawImage(images[3],x,y,SIZE_ITEM,SIZE_ITEM,null);
    }else if(bit==4){
        g2d.drawImage(images[4],x,y,SIZE_ITEM,SIZE_ITEM,null);
    }else if(bit==5){
        g2d.drawImage(images[0],x,y,SIZE_ITEM,SIZE_ITEM,null);
    }
}
public Rectangle getRect(){
    if(bit==0){
        return new Rectangle();
    }
    return new Rectangle(x,y,SIZE_ITEM,SIZE_ITEM);
}
}
