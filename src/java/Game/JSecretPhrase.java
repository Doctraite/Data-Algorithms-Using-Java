package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/** secret phrase class */
public class JSecretPhrase extends JApplet implements ActionListener{
    
    //declaring componets
    JLabel titlelb = new JLabel("                         Secret Phrase Game                    ");
    JLabel directionslb = new JLabel("Play our game - guess the phrase   Enter one letter");
    JLabel secretlb = new JLabel();
    JLabel statuslb = new JLabel();
    JButton[] letterbn = new JButton[26];   
    
    //get content pane of applet
    Container con = getContentPane();
    
    //initialize random class
    Random rand = new Random();
    
    //constant holds the ordinal values of A
    final int FIRST_CHAR = 65;
    
    //constant holds value of max phrases
    final int PHRASE_MAX = 5;
    
    //initializing array of phrases
    String[] arrayList = new String[PHRASE_MAX];
    
    //string that will old the mask text
    String secret;    
    
    //string that will hold the answer key
    String choice;
    
    //initialize letter to hold the first character of the alphabet
    int letter = FIRST_CHAR;    

    /** applet initiation method */
    public void init(){
        
        //set text for the string array
        arrayList[0] = "Eat At Joes Crab Shack";
        arrayList[1] = "Gone with the wind";
        arrayList[2] = "Java is a great language";
        arrayList[3] = "Rip to pascal";
        arrayList[4] = "Jimmy cracked corn";
        choice = randomStr(arrayList,PHRASE_MAX);
        secret = maskStr(choice);
 
        //set labels font
        titlelb.setFont(new Font("Garrmond", Font.BOLD, 24));
        directionslb.setFont(new Font("Garrmond", Font.BOLD, 16));
        
        //get secret label text
        secretlb.setText(secret);
        
        //add componets to container
        con.add(titlelb);
        con.add(directionslb);
        con.add(secretlb);
        con.add(statuslb);
        
        //initializing buttons
        for( int x = 0; x < 26; x++ ){
            letterbn[x] = new JButton(Character.toString((char)(letter + x)));
            letterbn[x].addActionListener(this);
            con.add(letterbn[x]);
        }
       
        //set FlowLayout as the layout for the container
        con.setLayout(new FlowLayout());
        
	//visible 
        this.setVisible(true);
            
    }
    
    /** function to catch actions */
    public void actionPerformed(ActionEvent e){
       
        if(isMasked(secret)){
            Object source = e.getSource();
       
            if(source == letterbn[0]){
                letterbn[0].setEnabled(false);
                reveal('A', choice);
            }
            if(source == letterbn[1]){
                letterbn[1].setEnabled(false);
                reveal('B', choice);            
            }
            if(source == letterbn[2]){
                letterbn[2].setEnabled(false);
                reveal('C', choice);            
            }
            if(source == letterbn[3]){
                letterbn[3].setEnabled(false);
                reveal('D', choice);            
            }       
            if(source == letterbn[4]){
                letterbn[4].setEnabled(false);
                reveal('E', choice);            
            }       
            if(source == letterbn[5]){
                letterbn[5].setEnabled(false);
                reveal('F', choice);            
            } 
            if(source == letterbn[6]){
                letterbn[6].setEnabled(false);
                reveal('G', choice);            
            } 
            if(source == letterbn[7]){
                letterbn[7].setEnabled(false);
                reveal('H', choice);            
            }
            if(source == letterbn[8]){
                letterbn[8].setEnabled(false);
                reveal('I', choice);            
            }
            if(source == letterbn[9]){
                letterbn[9].setEnabled(false);
                reveal('J', choice);            
            }
            if(source == letterbn[10]){
                letterbn[10].setEnabled(false);
                reveal('K', choice);            
            }
            if(source == letterbn[11]){
                letterbn[11].setEnabled(false);
                reveal('L', choice);            
            }
            if(source == letterbn[12]){
                letterbn[12].setEnabled(false);
                reveal('M', choice);            
            }
            if(source == letterbn[13]){
                letterbn[13].setEnabled(false);
                reveal('N', choice);            
            }
            if(source == letterbn[14]){
                letterbn[14].setEnabled(false);
                reveal('O', choice);            
            }
            if(source == letterbn[15]){
                letterbn[15].setEnabled(false);
                reveal('P', choice);            
            }
            if(source == letterbn[16]){
                letterbn[16].setEnabled(false);
                reveal('Q', choice);            
            }
            if(source == letterbn[17]){
                letterbn[17].setEnabled(false);
                reveal('R', choice);            
            }
            if(source == letterbn[18]){
                letterbn[18].setEnabled(false);
                reveal('S', choice);            
            }
            if(source == letterbn[19]){
                letterbn[19].setEnabled(false);
                reveal('T', choice);            
            }
            if(source == letterbn[20]){
                letterbn[20].setEnabled(false);
                reveal('U', choice);            
            }
            if(source == letterbn[21]){
                letterbn[21].setEnabled(false);
                reveal('V', choice);            
            }
            if(source == letterbn[22]){
                letterbn[22].setEnabled(false);
                reveal('W', choice);            
            }
            if(source == letterbn[23]){
                letterbn[23].setEnabled(false);
                reveal('X', choice);            
            }
            if(source == letterbn[24]){
                letterbn[24].setEnabled(false);
                reveal('Y', choice);            
            }
            if(source == letterbn[25]){
                letterbn[25].setEnabled(false);
                reveal('Z', choice);            
            }
       }
        else
            JOptionPane.showMessageDialog(null, "The Puzzle has already been solved!");
    }
    
    /** reveals a character in secret label */
    private void reveal(char letter, String str){        
        
        //ensure str is all caps
        str = str.toUpperCase();
       
        //if the letter is not convert it to uppercase
        if(Character.isLowerCase(letter))
            letter = Character.toUpperCase(letter);
        
        //if the character is within the string display correct else display not in phrase message
        if( str.indexOf(letter) != -1)
            statuslb.setText("Correct");
        else
            statuslb.setText("Sorry - not in the phrase: " + letter);
        
        //loop and replace the selected masked character in secret
        for(int x = 0; x < str.length(); x++){            
            if(str.charAt(x) == letter)
                secret = replaceCharAt(secret,x,letter);                                             
        }
        
        //show the new secret string in secret label
        secretlb.setText(secret);
        
        //if the secret is not masked displayed display winning message
        if(!isMasked(secret)){
            statuslb.setText("Congradulations!");
        }
        
    }
  
    /** returned a masked string */
    public String maskStr(String str){       
        for(int x = 0; x < str.length(); x++){
            if(str.charAt(x) != ' '){
                str = replaceCharAt(str,x,'x');
            }
        }
        return str;
    }   
    
    /** returns a string with a replaced character */
    public static String replaceCharAt(String s, int pos, char c) {
        return s.substring(0,pos) + c + s.substring(pos+1);
    }

    /** returns random string from a array of strings */
    public String randomStr(String[] str,int strSize){
        return str[rand.nextInt(strSize)];
    }

    //check if the string is still partial masked
    public boolean isMasked(String str){
        if( str.indexOf('x') == -1 ) 
            return false;
        else
            return true;
    }

}

