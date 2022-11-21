package agh.ics.oop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulationEngine implements IEngine{
    private List<MoveDirection> directions;
    public List<Animal> animals = new ArrayList<>();
    private IWorldMap map;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] initialCoords){
        this.directions = new ArrayList<>(Arrays.asList(directions));
        this.map = map;

        for(Vector2d cord : initialCoords){
            Animal animal = new Animal(map, cord);
            animals.add(animal);
            map.place(animal);
        }
    }

    private void generateText(JLabel label){
        label.setText("<html>" + map.toString().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
    }

    private JLabel generateLabel(){
        JLabel label = new JLabel();
        label.setFont(new Font("Lucida Grande", Font.BOLD, 25));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        return label;
    }

    @Override
    public void run() throws InterruptedException {
        JLabel label = generateLabel();
        SimulationFrame frame = new SimulationFrame();
        frame.add(label);

        generateText(label);
        for(int i = 0; i < directions.size(); i++){
            animals.get(i%animals.size()).move(directions.get(i));
            Thread.sleep(250);
            generateText(label);
        }
    }
}
