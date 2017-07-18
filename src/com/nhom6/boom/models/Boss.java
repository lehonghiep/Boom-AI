package com.nhom6.boom.models;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by lhhie on 4/2/2017.
 */
public class Boss extends Entity implements PicturesBoss{
    private int idAI;
    private AISearch ai;
    public int indexMove;
    public static final int FREEZE = 4;

    public Boss(int x, int y,int idAI) {
        int xRaw = (x / SIZE_ITEM) * SIZE_ITEM;
        int yRaw = (y / SIZE_ITEM) * SIZE_ITEM;
        this.x = xRaw;
        this.y = yRaw;
        orient=FREEZE;

        this.idAI=idAI;
        if(this.idAI==ASTAR){
            arrImage = new Image[][]{imgRobotLeft, imgRobotRight, imgRobotUp, imgRobotDown,imgRobotFreeze};
            ai=new AStar();
        } else if(this.idAI==GREEDY){
            arrImage=new Image[][]{imgMonsterLeft,imgMonsterRight,imgMonsterUp,imgMonsterDown,imgMonsterFreeze};
            ai=new Greedy();
        }else if(this.idAI==BFS){
            arrImage = new Image[][]{imgDinosaursLeft, imgDinosaursRight, imgDinosaursUp, imgDinosaursDown,imgDinosaursFREZZE};
            ai=new BFS();
        }
        else if(this.idAI==IDS){
            arrImage = new Image[][]{imgGhostLeft, imgGhostRight, imgGhostUp, imgGhostDown,imgGhostFREZZE};
            ai=new IDS();
        }
        image = getImage();
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(image, x, y, SIZE_ITEM, SIZE_ITEM, null);
    }




    public void move(List<Map> arrMap, List<Boom> arrBoom, Player player) {
        changeOrient(createOrient(arrMap,arrBoom, player));
        if (countMove % 10 == 0) {
            image = getImage();
            countMove = 0;
        }
        countMove++;
        switch (orient) {
            case LEFT:
                x -= 1;
                break;
            case RIGHT:
                x += 1;
                break;
            case UP:
                y -= 1;
                break;
            case DOWN:
                y += 1;
                break;
            case FREEZE:
                break;
        }
    }

    public int createOrient(List<Map>arrMap,List<Boom>arrBoom, Player player) {
        int oldOrient=orient;
        if(orient!=FREEZE){
            indexMove++;
        }
        if(indexMove%SIZE_ITEM==0){
            Node startBoss=new Node(y/SIZE_ITEM,x/SIZE_ITEM);
            Node targetPlayer=new Node(player.ySearch/SIZE_ITEM,player.xSearch/SIZE_ITEM);

            ai.init(arrMap,arrBoom,player,startBoss,targetPlayer);
            Node next=ai.searchNextNode();

            if(next!=null){
                indexMove=0;
                int xNext=next.col*SIZE_ITEM;
                int yNext=next.row*SIZE_ITEM;
                if(xNext<x){
                    return LEFT;
                }else if(xNext>x){
                    return RIGHT;
                }else if(yNext<y){
                    return UP;
                }else if(yNext>y){
                    return DOWN;
                }
            }else {
                return FREEZE;
            }
        }
        return oldOrient;
    }

    @Override
    public Image getImage() {
        index++;
        if (index >= arrImage[orient].length) {
            index = 0;
        }
        return arrImage[orient][index];
    }

    @Override
    public Rectangle getRect() {
        return new Rectangle(x,y,SIZE_ITEM,SIZE_ITEM);
    }
}
