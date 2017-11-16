package main;

import controller.MainController;
import factories.MVCFactory;

/** JabberPoint Main Programma
 * <p>This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class JabberPoint {
    
    private static String DEMO_PRESENTATION = "demo.xml";
    
    /** Het Main Programma */
    public static void main(String argv[]) {
        // Create the MainController object.
        MVCFactory factory = MVCFactory.getDefaultFactory();
        MainController controller = (MainController) factory.createController(factory);
        
        // If there are no arguments, load the demo presentation.
        if(argv.length == 0) {
            controller.loadPresentation(DEMO_PRESENTATION);
        }
        // Otherwise load the presentation provided in the first argument.
        else {
            controller.loadPresentation(argv[0]);
        }
    }
}
