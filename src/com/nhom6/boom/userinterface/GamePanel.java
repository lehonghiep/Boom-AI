package com.nhom6.boom.userinterface;

import com.nhom6.boom.models.Entity;
import com.nhom6.boom.managers.GameManager;
import com.nhom6.boom.models.MyKeyListener;
import sounds.AudioManager;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.BitSet;

/**
 * Created by lhhie on 3/24/2017.
 */
public class GamePanel extends JPanel {
    Clip clip;
    private GameManager gameManager;
    private BitSet bitSet;
    private Thread thread;

    public GamePanel() {
        setSize(GameFrame.WIDTH_FRAME, GameFrame.HEIGHT_FRAME);
        bitSet = new BitSet(256);
        gameManager = new GameManager();
        gameManager.initGame();
        setFocusable(true);
        addKeyListener(keyListener);
        thread = new Thread(runnable);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        gameManager.draw(g2d);
    }

    MyKeyListener keyListener = new MyKeyListener() {
        @Override
        public void keyPressed(KeyEvent e) {
            bitSet.set(e.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent e) {
            bitSet.clear(e.getKeyCode());
        }
    };

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (clip != null) {
                clip.stop();
            }
            initMusicBackGround();
            long FTS=100;
            long period=1000*1000000/FTS;
            long beginTime;
            long sleepTime;

            beginTime=System.nanoTime();

            int t=400;
            while (true) {
                long deltaTime=System.nanoTime()-beginTime;
                sleepTime=period-deltaTime;
                try {
                    if(sleepTime>0){
                        Thread.sleep(sleepTime/1000000);
                    }else {
                        Thread.sleep(period/2000000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t++;
                if (bitSet.get(KeyEvent.VK_LEFT) == true) {
                    gameManager.playerMove(Entity.LEFT);
                } else if (bitSet.get(KeyEvent.VK_RIGHT) == true) {
                    gameManager.playerMove(Entity.RIGHT);
                } else if (bitSet.get(KeyEvent.VK_UP) == true) {
                    gameManager.playerMove(Entity.UP);
                } else if (bitSet.get(KeyEvent.VK_DOWN) == true) {
                    gameManager.playerMove(Entity.DOWN);
                }
                if (bitSet.get(KeyEvent.VK_SPACE)) {
                    if(t>400){
                        gameManager.playerFire();
                        t=0;
                    }
                }
                int check=gameManager.aI();
                if(check!=0){
                    String musicPath;
                    String thongBao;
                    if(check==1){
                        musicPath="start.wav";
                        thongBao="You Win";
                    }else {
                        musicPath="die.wav";
                        thongBao="Game Over";
                    }clip.close();
                   Clip clipLose= AudioManager.getClip(musicPath);
                   clipLose.start();

                    int result=JOptionPane.showConfirmDialog(null,
                            "\t"+thongBao+"\ndo you want to exit",
                            "thông báo",JOptionPane.YES_NO_OPTION);
                    if(result==JOptionPane.YES_OPTION){
                        System.exit(0);
                    }
                    clipLose.close();
                    initMusicBackGround();
                    bitSet.clear();
                    gameManager.initGame();
                }
                repaint();
            }
        }

        private void initMusicBackGround() {
            clip = AudioManager.getClip("soundMenu.wav");
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
    };
}
