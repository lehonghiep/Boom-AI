package com.nhom6.boom.models;

/**
 * Created by lhhie on 3/31/2017.
 */
public class Node {
    public int row;
    public int col;
    public int f;
    public int g;
    public int h;
    public Node nodeFather;

    public boolean isWall;
    public int depth;
    public Node(int row,int col){
        this.row=row;
        this.col=col;
    }
    public Node(int row,int col,boolean isWall){
        this.row=row;
        this.col=col;
        this.isWall=isWall;
    }

    public int distance(Node target){
        int distanceX=(this.col>target.col)?(this.col-target.col):(target.col-this.col);
        int distanceY=(this.row>target.row)?(this.row-target.row):(target.row-this.row);
        return distanceX+distanceY;
    }


}
