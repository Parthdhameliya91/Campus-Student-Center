// Parth Dhameliya
// CSC 15
// Ben WHite
// Card (project 4)

// This class is helper for Memory Game Board 

public class Card {
	private int value;
	private boolean faceUp;
   
	// Define the initial value for card
	public Card(int initValue) {
		value = initValue;
		faceUp = false;
		}
	
   // It will store the value
	public int getValue() {
		return value;
	}
	
   // It will store the value of faceup card
	public boolean isFaceUp(){
		return faceUp;
	}
	
   // store the value of flip
	public void flipCard() {
		faceUp = !faceUp;
	}
	
   // True or False fro Set face up
	public void setFaceUp() {
		faceUp = true;
	}
	
	public void setFaceDown() {
		faceUp = false;
	}
	
   // Define the value of c
	public boolean equals(Card c) {
		if(value == c.value) {
			return true;
		}
		else{
			return false;
		}
	}
   
   // It will run the if or else mathod
   
	public String toString() {
	  if(faceUp) {
		  return String.format("%d",value);
	  }
	  else {
		  return "*";
	  }
	}
}
