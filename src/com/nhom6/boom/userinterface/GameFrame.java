package com.nhom6.boom.userinterface;

import com.nhom6.boom.models.Constacts;

import javax.swing.*;

/**
 * Created by lhhie on 3/24/2017.
 */
public class GameFrame extends JFrame implements Constacts{
    public static final int WIDTH_FRAME=SIZE_ITEM*17;
    public static final int HEIGHT_FRAME=SIZE_ITEM*15;
    public GamePanel gamePanel;
    public GameFrame(){
        setTitle("Boom AI");
        setSize(WIDTH_FRAME,HEIGHT_FRAME);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        gamePanel=new GamePanel();
        add(gamePanel);
    }
}
