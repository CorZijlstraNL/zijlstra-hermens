package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.GoToSlideEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * This class contains the operations that need to be executed to navigate to a specific slide.
 * @author Tim
 */
public class GoToSlideActionListener implements ActionListener {
    
    /**
     * The dispatcher used to dispatch the GoToSlideEvent event.
     */
    private BaseEventDispatcher goToSlideEventDispatcher;

    /**
     * Initialize the GoToSlideActionListener class.
     * @param goToSlideEventDispatcher The dispatcher used to dispatch the GoToSlideEvent event.
     */
    public GoToSlideActionListener(BaseEventDispatcher goToSlideEventDispatcher) {
        this.goToSlideEventDispatcher = goToSlideEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String slideNumberString = JOptionPane.showInputDialog("Slide number?");
        
        if(slideNumberString != null) {
            try {
                int slideNumber = Integer.parseInt(slideNumberString);
                if(slideNumber >= 1) {
                    this.goToSlideEventDispatcher.fire(new GoToSlideEvent(this, slideNumber));
                }
            }
            catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, 
                        "The input must be a number.",
                        "Invalid input",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
