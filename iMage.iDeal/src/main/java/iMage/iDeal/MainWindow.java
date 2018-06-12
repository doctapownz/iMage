package iMage.iDeal;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.NumberFormat;

/**
 * This class is the main window for the GUI of iMage
 *
 * @author Oswald
 */
public class MainWindow extends JFrame {
    private static final long serialVersionUID = 4424146395462393900L;

    private JPanel createInputPanel() throws IOException {
        BufferedImage image = Utils.getImage("Input", 200, 150);
        JButton button = new JButton(new ImageIcon(image));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);
        button.setVisible(true);

        JLabel text = new JLabel("Original");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(text);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0,26)));

        return panel;
    }

    private JPanel createWatermarkPanel() throws IOException {
        BufferedImage image = Utils.getImage("Watermark", 200, 150);
        JButton button = new JButton(new ImageIcon(image));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);
        button.setVisible(true);

        JLabel text = new JLabel("Watermark");

        JButton init = new JButton("Init");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(text);
        panel.add(button);
        panel.add(new JPanel().add(init));


        return panel;
    }

    private JPanel createOutputPanel() throws IOException {
        BufferedImage image = Utils.getImage("Output", 200, 150);
        JButton button = new JButton(new ImageIcon(image));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);
        button.setVisible(true);

        JLabel text = new JLabel("Output");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(text);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0,26)));


        return panel;
    }

    /**
     * Main method of the GUI: sets up the main window
     *
     * @param args arguements
     */
    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
        mw.setUp();
    }

    private void setUp() {
        setSize(700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("iDeal");

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        this.add(main);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        try {
            topPanel.add(createInputPanel());
            topPanel.add(Box.createRigidArea(new Dimension(5,0)));
            topPanel.add(createWatermarkPanel());
            topPanel.add(Box.createRigidArea(new Dimension(5,0)));
            topPanel.add(createOutputPanel());
        } catch (IOException e) {
            e.printStackTrace();
        }

        main.add(topPanel);
        main.add(setUpWMField());

        this.setVisible(true);

    }

    private JPanel setUpWMField() {
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        JFormattedTextField field = new JFormattedTextField(formatter);

        field.setMaximumSize(new Dimension(40,25));

        JLabel text = new JLabel("WM per Row");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        panel.add(text);
        panel.add(Box.createRigidArea(new Dimension(5,0)));
        panel.add(field);
        panel.setVisible(true);

        return panel;
    }



}
