/**The Card class contains information on each individual held by a player or in the deck
*	
*
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Card {
	int index; //1-52 value representation
	int value; //2-14 value representation regardless of suit
	char suit; //first letter of suit i.e. s,d,h, or c
	ImageIcon jPic; //Image to display on GUI
	String faceVal; //string representation of face value
	
	/** default constructor
	*	@param int index - fills in data depending on the value of hte card.
	*/
	public Card(int index) {
		this.index = index;
		
		switch(index / 13) { 				//determine suit
			case 0: suit = 's';
				break;
			case 1: suit = 'c';
				break;
			case 2: suit = 'd';
				break;
			case 3: suit = 'h';
				break;
		}
		
		switch(index % 13) {				//determine face value
			case 0: faceVal = "ace";
				value = 14;
				break;
			case 1: faceVal = "2";
				value = 2;
				break;
			case 2: faceVal = "3";
				value = 3;
				break;
			case 3: faceVal = "4";
				value = 4;
				break;
			case 4: faceVal = "5";
				value = 5;
				break;
			case 5: faceVal = "6";
				value = 6;
				break;
			case 6: faceVal = "7";
				value = 7;
				break;
			case 7: faceVal = "8";
				value = 8;
				break;
			case 8: faceVal = "9";
				value = 9;
				break;
			case 9: faceVal = "10";
				value = 10;
				break;
			case 10: faceVal = "jack";
				value = 11;
				break;
			case 11: faceVal = "queen";
				value = 12;
				break;
			case 12: faceVal = "king";
				value = 13;
				break;
		}
		ImageIcon jPic = new ImageIcon("cardPics//"+faceVal+suit+".jpg"); //create imageIcon for gui
	}
	
	/**getVal
	*	@return int - the numeric value of the card regardless of suit
	*/
	public int getVal() {
		return this.value;
	}
	
	/** getImage()
	*	@return String representation of the filename containing a jpeg of the card
	*/
	public String getImage() {
		return faceVal+suit;
	}
}