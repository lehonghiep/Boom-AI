package com.nhom6.boom.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhhie on 4/9/2017.
 */
public class IDS extends AISearch {

    public final int DEEP=2;

    public IDS() {
        super();
    }


    @Override
    public Node searchNextNode() {
        Node current = new Node(start.row, start.col, start.isWall);
        current.depth = 0;
        openSet.add(current);
        int numberNodeisCheck = 0;
        while (openSet.isEmpty() == false) {
            numberNodeisCheck++;
            closedSet.add(0, openSet.remove(0));
            Node outClosed = closedSet.get(0);

            if (outClosed.row == goal.row && outClosed.col == goal.col) {
                int distance = 0;
                Node nodePathNext = null;
                while (outClosed.nodeFather != null) {
                    distance++;
                    nodePathNext = outClosed;
                    outClosed = outClosed.nodeFather;
                }
                System.out.println("Số đỉnh duyệt IDS: " + numberNodeisCheck + "| quãng đường: " + distance + "| tìm thấy đường");
                System.out.println("________________________________________________");
                return nodePathNext;
            }
            int depthChilNode = (outClosed.depth == DEEP || outClosed.depth == 0) ? 1 : 2;
            List<Node> arrChildNode = createSuccesors(outClosed, depthChilNode);

            if (arrChildNode.isEmpty() == false) {
                if (outClosed.depth == DEEP) {
                    openSet.addAll(arrChildNode);
                } else {
                    openSet.addAll(0, arrChildNode);
                }
            }
        }
        System.out.println("Số đỉnh duyệt IDS: " + numberNodeisCheck + "| không tìm thấy đường");
        System.out.println("________________________________________________");
        return null;
    }


    public List<Node> createSuccesors(Node current, int deep) {
        int r = current.row;
        int c = current.col;

        List<Node> temp = new ArrayList<Node>();

        if (r > 0 && grid[r - 1][c].isWall == false &&
                (isInList(openSet, new Node(r - 1, c)) == -1 &&
                        isInList(closedSet, new Node(r - 1, c)) == -1)) {
            Node node = new Node(r - 1, c);
            node.depth = deep;
            node.nodeFather = current;
            temp.add(node);

        }
        if (c < COLUMNS - 1 && grid[r][c + 1].isWall == false &&
                (isInList(openSet, new Node(r, c + 1)) == -1 &&
                        isInList(closedSet, new Node(r, c + 1)) == -1)) {
            Node node = new Node(r, c + 1);
            node.depth = deep;
            node.nodeFather = current;
            temp.add(node);

        }

        if (r < ROWS - 1 && grid[r + 1][c].isWall == false &&
                (isInList(openSet, new Node(r + 1, c)) == -1 &&
                        isInList(closedSet, new Node(r + 1, c)) == -1)
                ) {
            Node node = new Node(r + 1, c);
            node.depth = deep;
            node.nodeFather = current;
            temp.add(node);
        }
        if (c > 0 && grid[r][c - 1].isWall == false &&
                (isInList(openSet, new Node(r, c - 1)) == -1 &&
                        isInList(closedSet, new Node(r, c - 1)) == -1)) {
            Node node = new Node(r, c - 1);
            node.depth = deep;
            node.nodeFather = current;
            temp.add(node);
        }

        return temp;
    }

    @Override
    public List<Node> createSuccesors(Node current) {
        return null;
    }
}
