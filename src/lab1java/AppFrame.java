package lab1java;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class AppFrame extends JFrame {

    static final String appTitle = "USA map";
    List<State> states = new ArrayList<State>();

    public static void main(String[] args) {
        AppFrame fr = new AppFrame(null);
    }

    public AppFrame(List<State> states) {
        super(appTitle);
        // цвет фона:
        setBackground(Color.LIGHT_GRAY);
        // устанавливается размер окна. Желательно!
        setSize(new Dimension(1200, 800));
        // заголовок
        setTitle(appTitle);
        // установка видимости. Обязательно!
        setVisible(true);
        this.states = states;
        // перерисовка - вызов paint()
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gr = (Graphics2D)getGraphics();
        for (int i = 0; i < states.size(); i++) {
            Path2D state = new Path2D.Double();
            boolean isFirst = true;
            List<Point2D.Double> listOfCoord = new ArrayList<>();
            for (int j = 0; j < states.get(i).getCollection().size(); j++) {
                for (int k = 0; k < states.get(i).getCollection().get(j).size(); k++) {
                    listOfCoord.add(states.get(i).getCollection().get(j).get(k).getPoint());
                }
            }
            for (int j = 0; j < listOfCoord.size(); j++) {
                double x = listOfCoord.get(j).getX()*1000000 / 100000 +1700;
                double y = -1 * (listOfCoord.get(j).getY()*1000000 / 100000 -700);

                if (isFirst) {
                    state.moveTo(x, y);
                    isFirst = false;
                } else {
                    state.lineTo(x, y);
                }
            }
            state.closePath();
            Random rand = new Random(listOfCoord.size());
            // Java 'Color' class takes 3 floats, from 0 to 1.
            float red = rand.nextFloat();
            float green = rand.nextFloat();
            float blue = rand.nextFloat();
            Color randomColor = new Color(red, green, blue);
            gr.setColor(randomColor);
            gr.fill(state);
        }
    }
}