package com.nhom6.boom.managers;


import com.nhom6.boom.models.*;
import com.nhom6.boom.userinterface.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhhie on 3/24/2017.
 */
public class GameManager implements Constacts {

    private List<Boss> arrBoss;
    private Player player;
    private Image imageBackGround = new ImageIcon(getClass().getResource("/images/background.jpg")).getImage();
    public List<Map> arrMap;
    private List<Boom> arrBoom;
    public int[][] bits = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 1},
            {1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1},
            {1, 0, 0, 3, 3, 3, 3, 3, 4, 0, 4, 5, 3, 3, 0, 0, 1},
            {1, 0, 5, 0, 0, 0, 0, 2, 4, 0, 4, 0, 0, 3, 0, 0, 1},
            {1, 0, 0, 4, 4, 4, 4, 0, 4, 0, 4, 0, 0, 3, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 4, 3, 0, 0, 1},
            {1, 0, 0, 4, 4, 4, 4, 0, 2, 0, 4, 4, 4, 4, 0, 0, 1},
            {1, 0, 0, 4, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 3, 0, 0, 4, 0, 4, 0, 4, 4, 4, 4, 0, 0, 1},
            {1, 0, 0, 3, 0, 0, 4, 0, 4, 2, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 3, 3, 5, 4, 0, 4, 3, 3, 3, 0, 3, 0, 0, 1},
            {1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1},
            {1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

    public void initGame() {


        arrMap = new ArrayList<Map>();
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 15; j++) {
                int b = bits[j][i];
                int x = i * SIZE_ITEM;
                int y = j * SIZE_ITEM;
                Map map = new Map(x, y, b);
                arrMap.add(map);
            }
        }
        arrBoom = new ArrayList<Boom>();
        player = new Player(10*SIZE_ITEM, 10*SIZE_ITEM);
        arrBoss=new ArrayList<Boss>();
        Boss boss1 = new Boss(3*SIZE_ITEM, SIZE_ITEM,ASTAR);
        Boss boss2 = new Boss(4*SIZE_ITEM, SIZE_ITEM,GREEDY);
        Boss boss3 = new Boss(13*SIZE_ITEM, SIZE_ITEM,BFS);
        Boss boss4 = new Boss(6*SIZE_ITEM, SIZE_ITEM,IDS);

        arrBoss.add(boss1);
        arrBoss.add(boss2);
        arrBoss.add(boss3);
        arrBoss.add(boss4);

    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(imageBackGround, 0, 0, GameFrame.WIDTH_FRAME, GameFrame.HEIGHT_FRAME, null);

        for (Map map : arrMap) {
            map.draw(g2d);
        }

        for (int i = arrBoom.size() - 1; i >= 0; i--) {
            boolean check = arrBoom.get(i).draw(g2d);
            arrBoom.get(i).explosion(arrMap, player,arrBoss);
            if (!check) {
                arrBoom.remove(i);
            }
        }
        player.draw(g2d);
        for (Boss boss:arrBoss
             ) {
            boss.draw(g2d);
        }
    }

    public void playerMove(int newOrient) {
        player.changeOrient(newOrient);
        player.move(arrMap, arrBoom);
    }

    public void playerFire() {
        Boom boom = player.fire();
        arrBoom.add(boom);
    }

    public int aI() {
        for (int i = 0; i < arrBoss.size(); i++) {
            arrBoss.get(i).move(arrMap,arrBoom,player);
        }
        for (int i=arrBoom.size()-1;i>=0;i--) {
            boolean check = arrBoom.get(i).explosion(arrMap, player,arrBoss);
            if (check == true) {
                return -1;
            }
        }
        if(player.checkBoss(arrBoss)){
            return -1;
        }
        if(arrBoss.isEmpty()==true){
            return 1;
        }
        return 0;
    }
}
