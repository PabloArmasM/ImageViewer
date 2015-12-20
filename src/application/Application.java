
package application;

import control.Command;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void createCommands() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
