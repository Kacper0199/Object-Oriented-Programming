package agh.ics.oop;

import javax.swing.*;
import java.awt.*;

public class SimulationFrame extends JFrame {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;

    public SimulationFrame(){
        this.setTitle("Animal Simulation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.DARK_GRAY);
    }
}
