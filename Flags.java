 /* Based on the VUW ecs100 template
 *
 */


import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** 
 * Draws different flags
 *
 * @author Heather Harper
 * @version 21/04/2020
 */
public class Flags{
    private final double X = 200.0;
    private final double Y = 200.0; // placement of flag
    private final double WIDTH = 120.0; // width of flag
    private final double PROPORTION = 2/3; // typical ratio of flag height to width
    private final double HEIGHT = WIDTH * PROPORTION;
    
    /**
     * Constructor to initialise GUI 
     */
    public Flags(){
        UI.initialise();
        UI.addButton("Quit", UI::quit);    // Comment out to checkstyle
        // buttons for different flags
        UI.addButton("Vertical Stripes", this::threeStripesVertical);
    }

    /**
     * Set colour to the user input
     * 
     * @param prompt a string to describe the colour the user is choosing
     */
    private void doColour(String prompt){
        boolean valid = true;
        do{
            valid = true;
            // ask user for colour
            String color = UI.askString("Enter colour for " + prompt + ":");
            
            // check against known colors and set GUI colour
            if (color.equalsIgnoreCase("red")) {
                UI.setColor(Color.red);
            } else if (color.equalsIgnoreCase("orange")) {
                UI.setColor(Color.orange);
            } else if (color.equalsIgnoreCase("yellow")) {
                UI.setColor(Color.yellow);
            } else if (color.equalsIgnoreCase("green")) {
                UI.setColor(Color.green);
            } else if (color.equalsIgnoreCase("blue")) {
                UI.setColor(Color.blue);
            } else if (color.equalsIgnoreCase("white")) {
                UI.setColor(Color.white);
            } else if (color.equalsIgnoreCase("grey")) {
                UI.setColor(Color.gray);
            } else if (color.equalsIgnoreCase("black")) {
                UI.setColor(Color.black);
            } else { // or report error and run loop again
                UI.println("Sorry, that is not a valid colour option");
                valid = false;
            }            
        } 
        while (! valid);
    }
    
    /**
     * Draw three stripe flag with vertical stripes, called by button
     */
    private void threeStripesVertical(){
        // clear graphics pane
       
        // get colours
        doColour("rectangle");
        UI.fillRect(100.0, 100.0, 30.0, 70.0);
        // 
        
    }

    /**
     * Main routine
     *
     */
    public static void main(String[] args){
        Flags obj = new Flags();
    }

}

