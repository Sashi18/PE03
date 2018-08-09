package com.stackroute.PE3;

import java.text.SimpleDateFormat;
import java.util.Date;

class StudentMarks{
	
	private int numOfStudents, stuGrades [];

	public StudentMarks(int numOfStudents, int [] stuGrades) {
		this.numOfStudents = numOfStudents;
		this.stuGrades = stuGrades;
	}
	
	public int getNumOfStudents() {
		return numOfStudents;
	}

	public void setNumOfStudents(int numOfStudents) {
		this.numOfStudents = numOfStudents;
	}

	public String checkError() {
		for(int i = 0;i < stuGrades.length;i++) {
			try {
				if(stuGrades[i]>100 || stuGrades[i]<0)
					throw new NumberFormatException("Not in range 0 to 100");
			}catch(NumberFormatException n) {
				return n.getMessage();
			}
		}
		return "All in range";
	}
	
	public int[] getStuGrades() {
		return stuGrades;
	}

	public void setStuGrades(int[] stuGrades) {
		this.stuGrades = stuGrades;
	}
	
}

public class App {
	
    public int[][] getMatrix(int r, int c, int [][] ar1, int [][] ar2){
    	if((r == 0) || (c == 0) || (ar1 == null) || (ar2 == null) || (ar1.length != ar2.length))
    		return null;
    	int [][] arr = new int[r][c];
    	for(int i = 0;i < r;i++) {
			for(int j = 0;j < c;j++) {
				arr[i][j] = ar1[i][j] + ar2[i][j];
    		}
    	}
    	return arr;
    }
    
    String [] arr = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    
	@SuppressWarnings("deprecation")
	public String getDate() {
    	Date d = new Date();
    	Date d1 = new Date(d.getTime()-(d.getDay()-1)*24*60*60*1000);
    	Date d2 = new Date(d.getTime()+(6-(d.getDay()-1))*24*60*60*1000);
    	SimpleDateFormat f = new SimpleDateFormat("E dd/MM/yyyy");
    	String s1 = f.format(d1);
    	String s2 = f.format(d2);
    	return (s1+" "+s2);
    }
	
	public String [] remVow(String [] arr) {
		if((arr == null) || (arr.length < 1))
			return null;
		for(int i = 0;i < arr.length;i++) {
			arr[i] = arr[i].replaceAll("a|e|i|o|u|A|E|I|O|U", "");
			//System.out.println("Place name without vowels:"+arr[i]);
		}
		return arr;
	}
	
	public String[][] chess(){
		String [][] arr = new String[8][8];
		for(int i = 0;i < 8;i++) {
			for(int j = 0;j < 8;j++) {
				if((i+j)%2 == 0)
					arr[i][j] = "WW|";
				else
					arr[i][j] = "BB|";
			}
		}
		return arr;
	}
	
	public String isConsecutive(String [] arr) {
		if((arr == null) || (arr.length == 0))
			return null;
		int num1 = Integer.parseInt(arr[0]);
		int num2 = Integer.parseInt(arr[1]);
		if(num1 > num2) {
			for(int i = 1;i < arr.length;i++) {
				int a = Integer.parseInt(arr[i]);
				if(a == (num1-1))
					num1 = a;
				else 
					return "non consecutive numbers";
			}
		}
		else if(num2 > num1) {
			for(int i = 1;i < arr.length;i++) {
				int a = Integer.parseInt(arr[i]);
				if(a == (num1+1))
					num1 = a;
				else 
					return "non consecutive numbers";
			}
		}
		return "are consecutive numbers";
	}
	
	@SuppressWarnings("null")
	public String exceptionGen() {
		String msg = "";
		try {
			@SuppressWarnings("unused")
			int [] a = new int[-1];
		}catch(NegativeArraySizeException e) {
			msg += e.toString() + " ";
		}
		try {
			int [] a = new int[3];
			@SuppressWarnings("unused")
			int b = a[5];
		}catch(IndexOutOfBoundsException e) {
			msg += e.toString() + " ";
		}
		try {
			String s = null;
			s = s.toString();
		}catch(NullPointerException e) {
			msg += e.toString() + " ";
		}
		return msg;
	}
	
    public static String ob = null;
    
	public static void main(String [] args) {
		class Ques7{
			public String except() {
				String s = null;
				try {
					throw new Exception("Exception Occured");
				}catch(Exception e) {
					s = e.getMessage();
				}
				//finally {System.out.println(s);};
				return s;
			}
		}
		ob = new Ques7().except();
	}
	
}
