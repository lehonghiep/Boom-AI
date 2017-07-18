package com.nhom6.boom.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhhie on 4/8/2017.
 */
public abstract class AISearch implements Constacts{
    public final int COLUMNS = 17;
    public final int ROWS = 15;
    protected Node[][] grid;
    protected Node start;
    protected Node goal;
    protected List<Node> openSet;
    protected List<Node> closedSet;
    public AISearch(){
        grid = new Node[15][17];
        openSet = new ArrayList<Node>();
        closedSet = new ArrayList<Node>();
    }
    public void init(List<Map> arrMap, List<Boom> arrBoom, Player player, Node start, Node goal) {
        closedSet.clear();
        openSet.clear();
/*
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Node(i, j, false);
            }
        }
*/
        for (Map map : arrMap) {
            int row = map.y / SIZE_ITEM;
            int col = map.x / SIZE_ITEM;
            boolean isWall = (map.bit != 0);
            grid[row][col] = new Node(row, col, isWall);
//            grid[row][col].isWall = isWall;
        }
        for (int i = arrBoom.size() - 1; i >= 0; i--) {
            int row = arrBoom.get(i).ySearchBoom / SIZE_ITEM;
            int col = arrBoom.get(i).xSearchBoom / SIZE_ITEM;
            grid[row][col].isWall = true;
        }
        int rowPlayer = player.ySearch / SIZE_ITEM;
        int colPlayer = player.xSearch / SIZE_ITEM;
        grid[rowPlayer][colPlayer].isWall = false;
        this.start = start;
        this.goal = goal;
    }
    public int isInList(List<Node> list, Node current) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (current.row == list.get(i).row && current.col == list.get(i).col) {
                index = i;
                break;
            }
        }
        return index;
    }
    public abstract List<Node>createSuccesors(Node current);
    public abstract Node searchNextNode();
}
