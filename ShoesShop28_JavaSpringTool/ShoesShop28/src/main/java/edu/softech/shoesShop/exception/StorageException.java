//1

package edu.softech.shoesShop.exception;

public class StorageException extends RuntimeException{
	//Alt + Shift + S => Generate Constructors from Superclass
	public StorageException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public StorageException(String message, Exception e) {
		super(message, e);
	}
	

}
