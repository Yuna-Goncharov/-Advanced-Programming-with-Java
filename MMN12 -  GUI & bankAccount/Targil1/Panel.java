import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {

    private JTextField fieldX;
    private JTextField fieldY;
    private JButton buttonAddPoint;

    private Data data;

    public Panel() {
        createPanel();
        this.data = new Data();
    }

    private void createPanel() {
        JLabel labelX = new JLabel("X:");
        labelX.setBounds(150, 400, 100, 22);
        add(labelX);

        fieldX = new JTextField();
        fieldX.setBounds(160, 400, 100, 30);
        fieldX.setSize(40, 20);
        add(fieldX);


        JLabel labelY = new JLabel("Y:");
        labelY.setBounds(200, 400, 100, 22);
        add(labelY);
        fieldY = new JTextField();
        fieldY.setBounds(210, 400, 100, 30);
        fieldY.setSize(40, 20);
        add(fieldY);

        buttonAddPoint = new JButton("Add point");
        buttonAddPoint.setBounds(150, 430, 100, 30);
        buttonAddPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isNewPointValid()) {
                    addNewPoint();
                } else {
                    JOptionPane.showMessageDialog(getParent(), "Each coordinate should be numeric in range between 0 and 400", "Error! Wrong input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(buttonAddPoint);
    }

    private boolean isNewPointValid() {
        try {
            int x = Integer.parseInt(fieldX.getText());
            int y = Integer.parseInt(fieldY.getText());

            return x >= 0 && x <= 400 && y >= 0 && y <= 400;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        data.getLines().forEach(line -> drawLine(g, line));
        repaint();
    }

    private void drawLine(Graphics g, Line line) {
        g.drawString(line.getDistance(), line.getEndX(), line.getEndY());
        g.drawLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
    }

    private void addNewPoint() {
        int x = Integer.parseInt(fieldX.getText());
        int y = Integer.parseInt(fieldY.getText());
        this.data.addPoint(x, y);
    }
}
