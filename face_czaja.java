/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

class FacePanel extends JPanel
{
    //Declare an arraylist of object face
    private ArrayList<Face> face;
      
    //Default constructor
    public FacePanel()
    {
        this.face = null;
    }
    
    //Non default constructor with an arraylist as the input
    public FacePanel(ArrayList<Face> face)
    {
        this.face = face;
    }
    
    //Overridden method to paint the objects
    public void paintComponent(Graphics g)
    {
        //Call the super class constructor to paint all objects
        super.paintComponent(g);
        //Check if face is not null
        if(face != null)
        {
            //Loop through the arraylist 
            for(Face f : face)
            {
                //Draw the face
                g.drawOval(f.getX(), f.getY(), f.getHeight(), f.getWidth()); 
                
                //Draw an eye
                g.drawOval(f.getX()*(1/2) + f.getX(), f.getY()*(1/2) + f.getY(), 10, 10);
                //Draw another eye
                g.drawOval(f.getX()*(1/4) + 10, f.getY()*(3/4), 10, 10);
                //Draw a mouth
                g.drawArc(f.getX() + 50, f.getY() + 50, 10, 10, 0, 180);
            } 
        } 
    }     
}

//The view class
class FaceFrame extends JFrame
{
    private FacePanel fp;
    private JPanel btnPanel;
    private JButton btn;
    
    public FaceFrame()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,300,300);
    }
    
    public FaceFrame(ArrayList<Face> face)
    {
        //Set the close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set the bounds of the panel
        setBounds(100,100,300,300);
        //Get the container to put all of the objects
        Container container = getContentPane();
        //Set to the border layout type
        container.setLayout(new BorderLayout());        
        //Create a new face panel and use the non default constructor
        fp = new FacePanel(face);        
       //Add the new face panel to the container and set the 
       //layout to the center
       container.add(fp, BorderLayout.CENTER);       
       //Create a panel for the button
       btnPanel = new JPanel();       
       //Create ne button object with text
       btn = new JButton("Add face");       
       //Set the layout of the button
       btn.setLayout(new GridLayout());
       //Add the button to the panel
       btnPanel.add(btn);
       //Add the panel to the container
       container.add(btnPanel, BorderLayout.SOUTH);
    } 
}

class Face
{
    private Random r;
    private int x;
    private int y;
    private int width;
    private int height;
    private int mood;
    
    public Face()
    {
        r = new Random();
        
        x = r.nextInt(200);
        y = r.nextInt(200);
        width = r.nextInt(60) + 20;
        height = r.nextInt(60) + 30;
        mood = r.nextInt(3);
    }
    
    public Face(int x, int y, int width, int height, int mood)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.mood = mood;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public int getWidth()
    {
        return width;
    }
        
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getMood()
    {
        return mood;
    }
    
    public void setHeight(int height)
    {
        this.height = height;
    }
    
    public void setWidth(int width)
    {
        this.width = width;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
    
    public void setMood(int mood)
    {
        this.mood = mood;
    }
    
    public String toString()
    {
        return java.lang.String.format("H = %d, W = %d, X = %d, Y = %d, S = %d", getHeight(), getWidth(), getX(), getY(), getMood());	  
    }
}

/**
 *
 * @author Bryon
 */
public class Face_Bryon {
    
     public static void printToConsole(ArrayList<Face> face) 
     {
            for (Face f : face) 
            {
                System.out.println(f);
            }
    }

   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Random random = new Random();
        
             
        ArrayList<Face> face = new ArrayList<Face>();
       
       // for(int i = 0; i <( ( random.nextInt(4)) + 3 ); i++)
        {
            face.add(new Face());
        }
        
        
        printToConsole(face);
        FaceFrame ff = new FaceFrame(face);
        ff.setVisible(true);   
    }
}

