package com.nhom6.boom.models;

import java.util.*;

/**
 * Created by lhhie on 4/2/2017.
 */
public class AStar extends AISearch {

    private NodeComparatorByF comparatorByF;

    public AStar() {
        super();
        comparatorByF = new NodeComparatorByF();
    }

    @Override
    public Node searchNextNode() {
        Node current = new Node(start.row, start.col, start.isWall);
        openSet.add(current);
        int numberNodeisCheck = 0;
        while (openSet.isEmpty() == false) {
            numberNodeisCheck++;
            Collections.sort(openSet, comparatorByF);
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
                System.out.println("Số đỉnh duyệt A*: " + numberNodeisCheck + "| quãng đường: " + distance + "| tìm thấy đường");
                return nodePathNext;
            }
            List<Node> arrChildNode = createSuccesors(outClosed);
            if (arrChildNode.isEmpty() == false) {
                openSet.addAll(arrChildNode);
            }
        }
        System.out.println("Số đỉnh duyệt A*: " + numberNodeisCheck + "| không tìm thấy đường");
        return null;
    }

    private class NodeComparatorByF implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            return node1.f - node2.f;
        }
    }

    @Override
    public List<Node> createSuccesors(Node current) {
        int r = current.row;
        int c = current.col;

        List<Node> temp = new ArrayList<Node>();

        if (r > 0 && grid[r - 1][c].isWall == false &&
                (isInList(openSet, new Node(r - 1, c)) == -1 &&
                        isInList(closedSet, new Node(r - 1, c)) == -1)) {
            Node node = new Node(r - 1, c);

            node.nodeFather = current;
            node.g = 1 + current.g;
            node.h = node.distance(goal);
            node.f = node.g + node.h;

            temp.add(node);

        }
        if (c < COLUMNS - 1 && grid[r][c + 1].isWall == false &&
                (isInList(openSet, new Node(r, c + 1)) == -1 &&
                        isInList(closedSet, new Node(r, c + 1)) == -1)) {
            Node node = new Node(r, c + 1);

            node.nodeFather = current;
            node.g = 1 + current.g;
            node.h = node.distance(goal);
            node.f = node.g + node.h;
            temp.add(node);

        }

        if (r < ROWS - 1 && grid[r + 1][c].isWall == false &&
                (isInList(openSet, new Node(r + 1, c)) == -1 &&
                        isInList(closedSet, new Node(r + 1, c)) == -1)) {
            Node node = new Node(r + 1, c);
            node.nodeFather = current;
            node.g = 1 + current.g;
            node.h = node.distance(goal);
            node.f = node.g + node.h;
            temp.add(node);
        }
        if (c > 0 && grid[r][c - 1].isWall == false &&
                (isInList(openSet, new Node(r, c - 1)) == -1 &&
                        isInList(closedSet, new Node(r, c - 1)) == -1)) {
            Node node = new Node(r, c - 1);
            node.nodeFather = current;
            node.g = 1 + current.g;
            node.h = node.distance(goal);
            node.f = node.g + node.h;
            temp.add(node);
        }
        return temp;
    }


}
