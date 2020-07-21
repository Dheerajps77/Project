package com.RoughWork;

public class OverLoadMainMethod {
	
	 public static void main(String[] args) {
	        System.out.println("First main method");
	        main("Calling second main method");
	        int n[] ={3,4,5,6,6,7,7,8,7};
	        main(n);
	    }

	    public static void main(String arg1) {
	        System.out.println(arg1);
	    }

	    public static void main(int[] n) {
	        for(int i=0;i<n.length;i++)
	        {
	        	System.out.print(n[i]+ " ");
	        }
	    }
/***
OUtPut :
First main method
Calling second main method
3 4 5 6 6 7 7 8 7 
*/
	    
/***
 * That's all about overloading and overriding main method in Java. Now you know that its 
 * possible to overload main in Java but its not possible to override it, simply because its a static method. 
 * Execution of Java program has no impact on overloading main because JVM always call the 
 * original main method and if it doesn't found in class then it throws java.lang.NoSuchMethodError: 
 * main Exception in thread "main" error at runtime.
 * 
 * The short answer to, can we overload the main method in Java is Yes, you can overloading, 
 * nothing stops from overloading, but JVM will always call the original main method, 
 * it will never call your overloaded main method. we will learn this in little more detail later, 
 * now coming to next question, 
 * can you override the main method in Java? the answer is No because main is a static 
 * method and static method cannot be overridden in Java.
 */
}
