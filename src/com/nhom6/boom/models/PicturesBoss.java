package com.nhom6.boom.models;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lhhie on 4/7/2017.
 */
public interface PicturesBoss {
    Image imgDinosaursLeft[] = {
            new ImageIcon(PicturesBoss.class.getResource("/images/dinosaurs_left_01.png")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/dinosaurs_left_02.png")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/dinosaurs_left_03.png")).getImage()
    };
    Image imgDinosaursRight[] = {
            new ImageIcon(PicturesBoss.class.getResource("/images/dinosaurs_right_01.png")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/dinosaurs_right_02.png")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/dinosaurs_right_03.png")).getImage()
    };
    Image imgDinosaursUp[] = {
            new ImageIcon(PicturesBoss.class.getResource("/images/dinosaurs_up_01.png")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/dinosaurs_up_02.png")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/dinosaurs_up_03.png")).getImage()
    };
    Image imgDinosaursDown[] = {
            new ImageIcon(PicturesBoss.class.getResource("/images/dinosaurs_down_01.png")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/dinosaurs_down_02.png")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/dinosaurs_down_03.png")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/dinosaurs_down_04.png")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/dinosaurs_down_05.png")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/dinosaurs_down_06.png")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/dinosaurs_down_07.png")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/dinosaurs_down_08.png")).getImage()
    };
    Image imgDinosaursFREZZE[] = imgDinosaursDown;

    Image imgMonsterLeft[]={
            new ImageIcon(PicturesBoss.class.getResource("/images/monster_left.png")).getImage()
    };
    Image imgMonsterRight[]={
            new ImageIcon(PicturesBoss.class.getResource("/images/monster_right.png")).getImage()
    };
    Image imgMonsterUp[]={
            new ImageIcon(PicturesBoss.class.getResource("/images/monster_up.png")).getImage()
    };
    Image imgMonsterDown[]={
            new ImageIcon(PicturesBoss.class.getResource("/images/monster_down.png")).getImage()
    };
    Image imgMonsterFreeze[]=imgMonsterDown;
    Image imgRobotLeft[]={
            new ImageIcon(PicturesBoss.class.getResource("/images/robot_left.png")).getImage()
    };
    Image imgRobotRight[]={
            new ImageIcon(PicturesBoss.class.getResource("/images/robot_right.png")).getImage()
    };
    Image imgRobotUp[]={
            new ImageIcon(PicturesBoss.class.getResource("/images/robot_up.png")).getImage()
    };
    Image imgRobotDown[]={
            new ImageIcon(PicturesBoss.class.getResource("/images/robot_down.png")).getImage()
    };
    Image imgRobotFreeze[]=imgRobotDown;


    Image imgGhostLeft[] = {
            new ImageIcon(PicturesBoss.class.getResource("/images/ghost_left_01.png")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/ghost_left_02.png")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/ghost_left_03.png")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/ghost_left_04.png")).getImage()
    };
    Image imgGhostRight[] = {
            new ImageIcon(PicturesBoss.class.getResource("/images/ghost_right_01.PNG")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/ghost_right_02.PNG")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/ghost_right_03.png")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/ghost_right_04.png")).getImage()
    };
    Image imgGhostUp[] = {
            new ImageIcon(PicturesBoss.class.getResource("/images/ghost_up_01.PNG")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/ghost_up_02.PNG")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/ghost_up_03.PNG")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/ghost_up_04.PNG")).getImage()
    };
    Image imgGhostDown[] = {
            new ImageIcon(PicturesBoss.class.getResource("/images/ghost_down_01.PNG")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/ghost_down_02.PNG")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/ghost_down_03.PNG")).getImage(),
            new ImageIcon(PicturesBoss.class.getResource("/images/ghost_down_04.PNG")).getImage()
    };
    Image imgGhostFREZZE[] = imgGhostDown;
}
