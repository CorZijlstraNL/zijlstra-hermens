package controller.menulisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * This class contains the operations that need to be executed to show the About information.
 * @author Tim
 */
public class AboutActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,
				"JabberPoint is a primitive slide-show program in Java(tm). It\n" +
				"is freely copyable as long as you keep this notice and\n" +
				"the splash screen intact.\n" +
				"Copyright (c) 1995-1997 by Ian F. Darwin, ian@darwinsys.com.\n" +
				"Adapted by Gert Florijn (version 1.1) and " +
				"Sylvia Stuurman (version 1.2 and higher) for the Open" +
				"University of the Netherlands, 2002 -- now." +
				"Author's version available from http://www.darwinsys.com/",
				"About JabberPoint",
				JOptionPane.INFORMATION_MESSAGE
		);
    }
    
}
