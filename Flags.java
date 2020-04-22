 /* Based on the VUW ecs100 template
 *
 */


import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** 
 * Draws various flags on the graphics pane
 * 
 * @author Heather Harper
 * @version 22/04/2020
 */
public class Flags {
    private final double X = 20.0;
    private final double Y = 20.0; // placement of flag
    private final double WIDTH = 120.0; // width of flag
    private final double PROPORTION = 2.0 / 3.0; // typical ratio of flag height to width
    private final double HEIGHT = WIDTH * PROPORTION;
    
    /**
     * Constructor to initialise GUI 
     */
    public Flags() {
        UI.initialise();
        UI.addButton("Quit", UI::quit);    // Comment out to checkstyle
        // buttons for different flags
        UI.addButton("Vertical Stripes", this::threeStripesVertical);
        UI.addButton("Horizontal Stripes", this::threeStripesHorizontal);
        UI.addButton("Switzerland", this::switzerland);
    }
    
    /**
     * Set colour to the user input
     * 
     * @param prompt a string to describe the colour the user is choosing
     */
    private void doColour(String prompt) {
        boolean valid = true;
        do {
            valid = true;
            // ask user for colour
            String color = UI.askString("Enter colour for " + prompt + ":");
            
            // check against known colors and set GUI colour
            if (color.equalsIgnoreCase("red")) {
                UI.setColor(Color.red);
            } 
            else if (color.equalsIgnoreCase("orange")) {
                UI.setColor(Color.orange);
            } 
            else if (color.equalsIgnoreCase("yellow")) {
                UI.setColor(Color.yellow);
            } 
            else if (color.equalsIgnoreCase("green")) {
                UI.setColor(Color.green);
            } 
            else if (color.equalsIgnoreCase("blue")) {
                UI.setColor(Color.blue);
            } 
            else if (color.equalsIgnoreCase("white")) {
                UI.setColor(Color.white);
            } 
            else if (color.equalsIgnoreCase("grey")) {
                UI.setColor(Color.gray);
            } 
            else if (color.equalsIgnoreCase("black")) {
                UI.setColor(Color.black);
            } 
            else { // or report error and run loop again
                UI.println("Sorry, that is not a valid colour option");
                valid = false;
            }            
        } 
        while (!valid);
    }
    
    /**
     * Draw a three stripe flag with vertical stripes, called by button
     */
    private void threeStripesVertical() {
        UI.clearGraphics();         // clear graphics pane
        UI.setLineWidth(1);
        double stripeWidth = WIDTH / 3.0;
                
        //draw stripes
        doColour("left stripe");
        UI.fillRect(X, Y, stripeWidth, HEIGHT);
        doColour("middle stripe");
        UI.fillRect(X + stripeWidth, Y, stripeWidth, HEIGHT);
        doColour("right stripe");
        UI.fillRect(X + 2 * stripeWidth, Y, stripeWidth, HEIGHT);
    }

    /**
     * Draw a three stripe flag with horizontal stripes, called by button
     */
    private void threeStripesHorizontal() {
        UI.clearGraphics();         // clear graphics pane
        UI.setLineWidth(1);
        double stripeHeight = HEIGHT / 3.0;
        
        //draw stripes
        doColour("top stripe");
        UI.fillRect(X, Y, WIDTH, stripeHeight);
        doColour("middle stripe");
        UI.fillRect(X, Y + stripeHeight, WIDTH, stripeHeight);
        doColour("bottom stripe");
        UI.fillRect(X, Y + 2 * stripeHeight, WIDTH, stripeHeight);
    }
    
    /**
     * Draw the flag of switzerland, called by button
     */
    private void switzerland() {
        UI.clearGraphics();         // clear graphics pane
        UI.setLineWidth(1);
        
        // set variables as aspects of flag for readability
        double proportion = 1.0; //switzerland's flag is a square
        double height = WIDTH * proportion;
        double crossThickness = WIDTH * (6.0 / 32.0);
        double crossFromEdge = WIDTH * (5.0 / 32.0);
        double crossWidth = WIDTH - 2 * crossFromEdge;
        double topToCross = WIDTH * (13.0 / 32.0);
        
        // draw flag
        UI.setColor(Color.red);
        UI.fillRect(X, Y, WIDTH, height);
        UI.setColor(Color.white);
        UI.fillRect(X + crossFromEdge, Y + topToCross, crossWidth, crossThickness);      
        UI.fillRect(X + topToCross, Y + crossFromEdge, crossThickness, crossWidth);
    }
    
    /**
     * Main routine
     */
    public static void main(String[] args) {
        Flags obj = new Flags();
    }

}

