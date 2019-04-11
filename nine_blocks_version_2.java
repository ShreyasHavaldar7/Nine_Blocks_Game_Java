import java.io.*;
//import java.lang.*;
//import java.awt.Graphics;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
//import java.lang.String;
import javax.swing.*;
// Applet height=600 and width=600
//Use jdk 1.7 or higher so that no deprecation occurs
public class nine_blocks_version_2 extends JApplet implements ActionListener, KeyListener
{   
    
    private MyButton[] button;
    private JLabel label1,label2,label3;
    private JTextField textf1,textf2;
    String[] Strbutton;
    String[] Strbutton1;
    int rnd=0;  
    
    
    private int click_count;// Counts the number of clicks by the player. 
    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints gbc1 = new GridBagConstraints();   
    JPanel pan1,pa4;
    String str1="";
    String s;
    String s2="~<7S>~ GAMES \n presentsssssss....... \n 9~BLOCKS";
    String s3="1.Enter Your Name \n 2.Press Start Button \n 3.Click On Blank Button And Then Click on Adjacent Button(Not Diagonal) \n 4.OBJECTIVE: The Buttons Must Be Arranged In Ascending Order With Blank Button AtLast \n 5. Press blank button to finish \n 6. Compare Your Clicks to the Highscore after pressing blank button ";
    String s4="GAME DEVELOPED BY : SHREYAS HAVALDAR";
    String s5="Please, Enter Your Name";
    String s6="Thank You! For Playing The Game";
    int min;
    public void init()// To initialise different variables.
    {   
        
        label1 = new JLabel(" ~<7S>~ GAMES  9~BLOCKS  ");  //Initialising the labels.
        label1.setFont(new Font("Jokerman" , Font.BOLD,20));
        label1.setForeground(Color.red);
        label2=new JLabel("Name of the Player");
        label2.setFont(new Font("French Script MT" ,Font.BOLD,24));
        label2.setForeground(Color.red);
        label3=new JLabel("No. of Clicks");
        label3.setFont(new Font("French Script MT",Font.BOLD,24));
        label3.setForeground(Color.red);
        
        button =new MyButton[14];
        Strbutton=new String[]{"7","8","4","3","6","1","2","5"," ","Start","NEW GAME","Give Up?", "Rules","Credits"};
        ran();
         Strbutton1=new String[]{
        "1","2","3","4","5","6","7","8"," "};
        for(int i=0;i<14;i++)
        {
            button[i]= new MyButton ( Strbutton[i],Color.blue);
            button[i].addActionListener(this);
        }   
        textf1=new JTextField(20);
        textf2=new JTextField(20);
        textf1.setFont(new Font("Times Roman",Font.BOLD,12));
        textf2.setFont(new Font("Times Roman",Font.BOLD,12));
        textf1.setText(" ");
        textf1.addKeyListener(this);
        textf2.setText("");
        click_count=0;//Initialise the clicks to zero.
        JOptionPane.showMessageDialog(null,s2);
     
        displayPanel();// Method displayPanel() //is invoked. 
    } //End of init() method.
    public void ran()//to create random value of rnd. 
    {
         rnd=(int)(Math.random()*7);
    if(rnd==1)
     {
    Strbutton=new String[]{"7","8","4","3","6","1","2","5"," ","Start","NEW GAME","Give Up?", "Rules","Credits"};
   } 
   
    else if(rnd==2)
    {
    String[] Strbutton=new String[]{
    "4","6","1"," ","2","5","8","7","3","Start","NEW GAME","Give Up?", "Rules","Credits"};
    }
     else if(rnd==3)
    {
     Strbutton=new String[]{
    " ","3","7","1","5","6","8","2","4","Start","NEW GAME","Give Up?", "Rules","Credits"};
    }  
    else if(rnd==4)
    {
    Strbutton=new String[]{
    "3","5","7","2","1"," ","4","6","8","Start","NEW GAME","Give Up?", "Rules","Credits"};
    } 
    else if(rnd==5)
    {
     Strbutton=new String[]{
    "4","8","1","3","5","2","7"," ","6","Start","NEW GAME","Give Up?", "Rules","Credits"};
     } 
     else if(rnd==6)
    {
        Strbutton=new String[]{
    "4","1","3","7","8"," ","6","5","2","Start","NEW GAME","Give Up?", "Rules","Credits"};
    }  
    else if(rnd==7)
    {
        Strbutton=new String[]{
    "2","5","6"," ","8","7","3","4","1","Start","NEW GAME","Give Up?", "Rules","Credits"};
    }
    else 
    {
        Strbutton=new String[]{
    "1","4","7","3"," ","8","5","6","2","Start","NEW GAME","Give Up?", "Rules","Credits"};
    }    
    
    }

    class MyButton extends JButton
    {
        public MyButton(String name, Color xyz) 
        {
            this.setLabel(name);
            this.setForeground(xyz);
        }
        
        class MouseCalcButtonAdapter extends MouseAdapter
        {
            public void mouseEntered(MouseEvent me){}

            public void mouseExited(MouseEvent me){}
        }
    }
    public void keyTyped(KeyEvent e)//Denotes a key press followed by a key release.
    {
        char ch;
        ch=e.getKeyChar();
        str1 = str1 + ch;
            
    }
    public void keyPressed(KeyEvent e)//Indicates  a key is pushed down.
    {
    }
    public void keyReleased(KeyEvent e)//Indicates  a key is Released.
    {
    }
        
    public void actionPerformed(ActionEvent ae) //Provide the functioning to the game.
    {
        int index=0,i;
        String str,count;
        boolean check;
         
        
        for(i=0;i<9;i++)
        { 
            if(button[i].getLabel()==" ")
                index=i;// For checking which button contains the blank  label. 
        }       
        if(ae.getSource()==button[9])// For enabling the button after the button start is clicked.
        {
            for(int j=0;j<=8;j++)
                button[j].setEnabled(true);
                button[9].setEnabled(false);colour();color();
                //Disable the start button.    
        }
        if(str1=="")
        {
            JOptionPane.showMessageDialog(null,s5);
            for(int j=0;j<9;j++)
                button[j].setEnabled(false);//Disable the boxes 
                button[9].setEnabled(true);
                colour();color();
               //enable the start button 
        }
        
        if(ae.getSource()==button[10])
                //NEW GAME button.
        {  
            JOptionPane.showMessageDialog(null,"WARNING! ALL PROGRESS WILL BE LOST!");
            check=false;

                click_count=0;  
                textf2.setText("0");
                Strbutton=new String[]{"7","8","4","3","6","1","2","5"," ","Start","NEW GAME","Give Up?", "Rules","Credits"};
                for(int j=0;j<9;j++)
                button[j].setEnabled(true);
                ran();
               
        colour();color();
         }
      
    if(ae.getSource()==button[12])//Rules button.
    {
        JOptionPane.showMessageDialog(null,s3);colour();color();
        
    }
    if(ae.getSource()==button[13])//Credits button.
    {
        JOptionPane.showMessageDialog(null,s4);colour();color();
    }
     
        if((ae.getSource() != button[9]) || (ae.getSource() != button[10]) || (ae.getSource() != button[11]) || (ae.getSource() != button[12]) || (ae.getSource() != button[13]) )
        {
            check=checkStatus();
            colour();color();
                
        if(check==false)// Check whether the number is arranged in the correct order.
        {
            if (ae.getSource() == button[0])
            {
                count=Integer.toString(countClicks());
                textf2.setText(count);
                if (index==1||index==3)
                {
                    str=button[0].getLabel();           
                    button[0].setLabel(" ");    
                    button[index].setLabel (str);
                }
                colour();color();
            }       
            if (ae.getSource()== button[1])
            {
                count=Integer.toString(countClicks());
                textf2.setText(count);
                if (index==0|| index==4 ||index==2)
                {
                    str=button[1].getLabel();
                    button[1].setLabel (" ");   
                    button[index]. setLabel(str);
                }
                colour();color();
            }
            if (ae.getSource()== button[2])
            {
                count=Integer.toString(countClicks());
                textf2.setText(count);
                if (index==1||index==5)
                {
                    str=button[2]. getLabel();      
                    button[2].setLabel(" ");    
                    button[index]. setLabel(str);
                }
               colour();color();
            }       
            if (ae.getSource()== button[3])
            {
                count=Integer.toString(countClicks());
                textf2.setText(count);
                if (index==0||index==4 ||index==6)
                {
                    str=button[3].getLabel();           
                    button[3].setLabel(" ");    
                    button[index].setLabel(str);
                }
                colour();color();
            }   
            if (ae.getSource()==button[4])
            {
                count=Integer.toString(countClicks());
                textf2.setText(count);              
                if (index==1||index==3 ||index==5||index==7)
                {
                    str=button[4]. getLabel();      
                    button[4].setLabel(" ");    
                    button[index].setLabel(str);
                }colour();color();
            }   
            if (ae.getSource()==button[5])
            {
                count=Integer.toString(countClicks());
                textf2.setText(count);
                if (index==2||index==4 ||index==8)
                {
                    str=button[5]. getLabel();      
                    button[5].setLabel(" ");    
                    button[index].setLabel(str);
                }colour();color();
            }   
            if (ae.getSource()==button[6])
            {
                count=Integer.toString(countClicks());
                textf2.setText(count);
                if (index==3||index==7)
                {
                    str=button[6].getLabel();       
                    button[6].setLabel(" ");    
                    button[index].setLabel(str);
                }
                colour();color();
            }   
            if (ae.getSource()==button[7])
            {
                count=Integer.toString(countClicks());
                textf2.setText(count);
                if (index==6||index==4 ||index==8)
                {   
                    str=button[7]. getLabel();      
                    button[7].setLabel(" ");    
                    button[index].setLabel(str);
                }
                colour();color();
            }   
            if (ae.getSource()==button[8])
            {
                count=Integer.toString(countClicks());
                textf2.setText(count);
                if (index==5||index==7)
                {
                    str=button[8]. getLabel();      
                    button[8].setLabel(" ");    
                    button[index]. setLabel(str);
                }
                colour();color();
            }
                if(ae.getSource()==button[10])
                //Restart button.
            {  JOptionPane.showMessageDialog(null,"NEW GAME STARTED..... \n BACK TO SQUARE ONE");
                for(i=0;i<9;i++)
                {
                    button[i].setEnabled(true);
                    button[i].setLabel(Strbutton[i]);
                }
                click_count=0;  
                textf2.setText("0");colour();color();
            }   
            if (ae.getSource()==button[11])
            //Give up? button.
            {
                for(i=0;i<=8;i++)
                {
                    button[i].setLabel (Strbutton1[i]);
                    button[i].setEnabled(false);
                }
                click_count=0;
                textf2.setText("0");        
                button[11].setEnabled(false);
                button[10].setEnabled(false);
                button[9].setEnabled(false);
                button[12].setEnabled(false);
                button[13].setEnabled(false);
                colour();color();
            }   
        }
        if(check==true)//If the game is completed.
        {
            if(click_count<= min)
            {
            String s = str1;
            int min=click_count;
             
            }
           
            String st = str1 + ", You Have Won The Game in  " + click_count + "  clicks \n " + " Least Clicks Taken = " + min + " \n by " + s ;
            String st77= " DO YOU WANT TO PLAY AGAIN????? PRESS NEW GAME BUTTON...";
            for (int j=0;j<=8;j++)
                button[j].setEnabled(false);
                JOptionPane.showMessageDialog(null,st);
                button[11].setEnabled(false);
                button[9].setEnabled(false);
                JOptionPane.showMessageDialog(null,st77);
                JOptionPane.showMessageDialog(null,s6);
                
            }
       
    }
}//End of actionPerformed() method.
   
    void displayPanel()// Designing the layout.
    {
        pa4 = new JPanel(); 
        pan1 = new JPanel(); // Creating the main panel on which all the component will be  placed.
        
        
        
        pan1.setLayout(grid); // Setting the layout as grid bag layout.      
        
           
    
        gbc1.weightx = 100;    
        gbc1.weighty = 100;   
        gbc1.ipady = 0;               
        gbc1.ipadx = 0; 
        gbc1.gridwidth =1;              
        gbc1.gridheight=1;
         gbc1.gridx = 0;
         gbc1.gridy = 0;            
         grid.setConstraints(label1, gbc1);
        pan1.add(label1);// Attaching label1 on the panel pan1. 

        gbc1.weightx=100;           
        gbc1.weighty = 100;         
        gbc1.ipady = 10;//Height of Component.
        gbc1.ipadx = 10;  //Width of Component.
        gbc1.gridwidth =1;        
        gbc1.gridheight=1;
        gbc1.gridx = 1;           
        gbc1.gridy = 0;           
        grid.setConstraints(button[9], gbc1);
        pan1.add(button[9]);
    
        gbc1.weightx=100;   //Horizontal Space        
        gbc1.weighty = 100;//Vertical Space.    
        gbc1.ipady = 0; 
        gbc1.ipadx = 0;           
        gbc1.gridwidth =1;        
        gbc1.gridheight=2;
        gbc1.gridx = 0;           
        gbc1.gridy = 1;           
        grid.setConstraints(label2, gbc1);
        pan1.add(label2);
            
        gbc1.weightx=100;           
        gbc1.weighty = 100;     
        gbc1.ipady = 0;                     
        gbc1.ipadx = 0;           
        gbc1.gridwidth =1;        
        gbc1.gridheight=2;
        gbc1.gridx = 0;    //X-coordinate
        gbc1.gridy = 3;    //Y-coordinate             
        grid.setConstraints(textf1, gbc1);
        pan1.add(textf1);
        
        gbc1.weightx = 100;    
        gbc1.weighty = 100;   
        gbc1.ipady = 0;                     
        gbc1.ipadx = 0;                             
        gbc1.gridwidth =1 ;                         
        gbc1.gridheight=2;
        gbc1.gridx = 0;                  
        gbc1.gridy = 5;   
        
       colour();
 //setting background colour
        pa4.setLayout(new GridLayout(3,3,10,10));
        for(int i=0;i<9;i++)
        {
            pa4.add(button[i]); 
            button[i].setEnabled(false);
        }   
        grid.setConstraints(pa4, gbc1);     
        pan1.add(pa4);
        
        gbc1.ipady = 10;                     
        gbc1.ipadx = 10;                     
        gbc1.weighty = 100;
        gbc1.weightx = 100;                 
        gbc1.gridwidth =1;
        gbc1.gridheight=1;                  
        gbc1.gridx = 1;                     
        gbc1.gridy = 5;                     
        grid.setConstraints(button[12], gbc1);
        pan1.add(button[12]);
    
        
        gbc1.ipady = 10;                     
        gbc1.ipadx = 10;                     
        gbc1.weighty = 100;
        gbc1.weightx = 100;                 
        gbc1.gridwidth =1;
        gbc1.gridheight=1;                  
        gbc1.gridx = 1;                     
        gbc1.gridy = 6;                     
        grid.setConstraints(button[13], gbc1);
        pan1.add(button[13]);
        
        gbc1.weightx=100;           
        gbc1.weighty=100;         
        gbc1.ipady = 0;           
        gbc1.ipadx = 0;           
        gbc1.gridwidth =1;
        gbc1.gridheight=1;
        gbc1.gridx = 0;   
        gbc1.gridy = 7;     
        grid.setConstraints(label3, gbc1);
        pan1.add(label3);
        
        gbc1.ipady = 0;                     
        gbc1.ipadx = 0;                     
        gbc1.weightx = 100;
        gbc1.weighty = 100;                 
        gbc1.gridwidth =1 ;
        gbc1.gridheight=1;                  
        gbc1.gridx = 0;                     
        gbc1.gridy = 8;                             
        grid.setConstraints(textf2, gbc1);
        pan1.add(textf2);       
                        
        gbc1.ipady = 10;                     
        gbc1.ipadx = 10;                     
        gbc1.weighty = 100;
        gbc1.weightx = 100;                 
        gbc1.gridwidth =1;
        gbc1.gridheight=1;                          
        gbc1.gridx = 0;                     
        gbc1.gridy = 9;                     
        grid.setConstraints(button[10], gbc1);
        pan1.add(button[10]);
        
        gbc1.ipady = 10;                     
        gbc1.ipadx = 10;                     
        gbc1.weighty = 100;
        gbc1.weightx = 100;                 
        gbc1.gridwidth =1;
        gbc1.gridheight=1;                  
        gbc1.gridx = 1;                     
        gbc1.gridy = 9;                     
        grid.setConstraints(button[11], gbc1);
        pan1.add(button[11]);
      

    color();
        
        gbc1.ipady = 5;                     
        gbc1.ipadx = 5;                             
        getContentPane().add(pan1); 
        
    }// End of the method displayPanel().

    public int countClicks()// For incrementing the clicks counter. 
    {
        
        return(++click_count);
    }//End countClicks() method.

    public boolean checkStatus()// To check  the game is finished or not.
    {
        int i;
        if (button[0].getLabel() == "1" && 
        button[1].getLabel() == "2"&&
        button[2].getLabel() == "3" && 
        button[3].getLabel() == "4"&&
        button[4].getLabel() == "5" && 
        button[5].getLabel() == "6"&&
        button[6].getLabel() == "7" && 
        button[7].getLabel() == "8"&&
        button[8].getLabel() == " ")
        {
                return(true);
        }
        else        
            return(false);         
    }
     void colour()
        {
            int rn=(int)(Math.random()*12);
     if(rn==1)
     {pa4.setBackground(Color.red);
    
    } 
   
    else if(rn==2)
    {
    pa4.setBackground(Color.green);
}
     else if(rn==3)
    {
     pa4.setBackground(Color.white);
    }  
    else if(rn==4)
    {
    pa4.setBackground(Color.yellow);
    } 
    else if(rn==5)
    {
     pa4.setBackground(Color.blue);
     } 
    else if(rn==6)
    {
    pa4.setBackground(Color.gray);
}
else if(rn==7)
    {
    pa4.setBackground(Color.magenta);
}
else if(rn==8)
    {
    pa4.setBackground(Color.black);
}
else if(rn==9)
    {
    pa4.setBackground(Color.pink);
}
else if(rn==10)
    {
    pa4.setBackground(Color.orange);
}
else if(rn==11)
    {
    pa4.setBackground(Color.cyan);
}

}
 void color()
       {
        int r=(int)(Math.random()*11);
    if(r==1)
     {pan1.setBackground(Color.cyan);
    
   } 
   
    else if(r==2)
    {
    pan1.setBackground(Color.green);
}
     else if(r==3)
    {
     pan1.setBackground(Color.white);
    }  
    else if(r==4)
    {
    pan1.setBackground(Color.yellow);
    } 
    else if(r==5)
    {
     pan1.setBackground(Color.blue);
     } 
     else if(r==6)
    {
    pan1.setBackground(Color.gray);
}
else if(r==7)
    {
    pan1.setBackground(Color.magenta);
}
else if(r==8)
    {
    pan1.setBackground(Color.black);
}
else if(r==9)
    {
    pan1.setBackground(Color.pink);
}
else if(r==10)
    {
    pan1.setBackground(Color.orange);
}
}
}//End checkStatus() method.    
// End of nine_blocks class.




    
	
