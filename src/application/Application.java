
package application;

import control.Command;
import control.NextImageCommand;
import control.PrevImageCommand;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Image;
import view.ImageDisplay;

public class Application extends JFrame{
    private final Map<String, Command> commands = new HashMap<>();
    private ImageDisplay imageDisplay;
    
    public static void main(String[] args) {
        new Application().setVisible(true);
    }

    public Application() {
        this.deployUI();
        this.createCommands();
    }

    private void deployUI() {
        this.setTitle("ImageViewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imagePanel());
        this.getContentPane().add(toolbar(), BorderLayout.SOUTH);
    }

    private void createCommands() {
        commands.put("next", new NextImageCommand(imageDisplay));
        commands.put("prev", new PrevImageCommand(imageDisplay));
    }

    private PopupMenu imagePanel() {
        ImagePanel imagePanel = new ImagePanel(getImage());
        imageDisplay = imagePanel;
        return imagePanel; 
    }

    private Component toolbar() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        panel.add(prevButton());
        panel.add(nextButton()); 
        return panel;
    }

    private Image getImage() {
        return new FileImageReader("/Users/Loedded/Documents").read();
    }

    private JButton nextButton() {
        JButton nextButton = new JButton(">>");
        nextButton.addActionListener(doCommand("next"));
        return nextButton;
    }

    private JButton prevButton() {
        JButton prevButton = new JButton("<<");
        prevButton.addActionListener(doCommand("prev"));
        return prevButton;
    }

    private ActionListener doCommand(final String operation) {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(operation).execute();
            }
        };
    }


    
}
