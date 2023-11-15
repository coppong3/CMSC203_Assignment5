/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: Create a utility class that manipulates a two-dimensional ragged array of doubles. This utility class will be used to create a Sales Report for Retail District #5. Create a utility class that will calculate holiday bonuses given a ragged array of doubles which represent the sales for each store in each category. It will also take in a bonus amount for the store with the highest sales in a category, the bonus amount for the store with the lowest sales in a category and the bonus amount for all other stores.
 * Due: 11/14/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or * any source. I have not given my code to any student.
 * Print your Name here: Chrissie Oppong
*/

/*	for(int row = 0; row < myArray.length; row++) {
				if(fileScan.hasNextLine()) {
					String str = fileScan.nextLine();
					String[] fileLine = str.split(" "); //split the line in the file
					if(fileLine[0] != null) {
						validRows++;
					}
				/*
					for(int col = 0; col < fileLine.length; col++) {
						myArray[row][col] = Double.parseDouble(fileLine[col]);//get the individual doubles from the file
						if(fileLine[col] != null) {//if the value isn't null, increase the number of valid columns
							validCols++;
						}
						
					}
					
				
				
				}
			}
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Arrays;
import java.io.PrintWriter;
public class TwoDimRaggedArrayUtility {
	
	public static double[][] readFile(File file) throws FileNotFoundException{
		try {
		double[][] tempArray = new double[10][10];
		
		int validRows = 0; //number of rows that don't start with null
		int validCols = 0; //number of valid elements in a row
		Scanner fileScan = new Scanner(new BufferedReader(new FileReader(file.getPath())));
		
		int[] validColsArray = new int[10];// array to hold number of cols in each array
		
			for(int row = 0; row < tempArray.length; row++) {
				if(fileScan.hasNextLine()) {
					validCols = 0; //reset to 0 each time
					String str = fileScan.nextLine(); //get the line from the file
					String[] fileLine = str.split(" "); //split the line into an array
					if(fileLine[0] != null) { //check if the first value is null to increase the number of rows
						validRows++;
					}
					for(int col = 0; col < fileLine.length; col++) {
						tempArray[row][col] = Double.parseDouble(fileLine[col]);//get the individual doubles from the file
						if(fileLine[col] != null) {//if the value isn't null, increase the number of valid columns
							validCols++;

						}
						
					}
					validColsArray[row] = validCols; //stores number of cols in that row 
				
				
				}
			}
			double[][] finalArray = new double[validRows][]; //create array using number of valid rows
			for(int row = 0; row < validRows; row++) {
				finalArray[row] = new double[validColsArray[row]]; //set the num of columns of each row using validColsArray
			}
			for(int row = 0; row < validRows; row++) {
				for(int col = 0; col < finalArray[row].length; col++) {
					finalArray[row][col] = tempArray[row][col]; //fill final array with values stored in temp array
				}
			}
			/*
			double[][] finalArray = new double[validRows][];
			for(int row = 0; row < validRows; row++) {
				for(int col = 0; col < myArray[row].length; col++) {
					finalArray[row][col] = myArray[row][col];
				}
			}
			/*
			double[][] temp = new double[validRows][];
			//double[][] finalArray = new double[validRows][];
			Scanner fileScan2 = new Scanner(new BufferedReader(new FileReader(file.getPath()))); 
			for(int row = 0; row < validRows; row++) {
				if(fileScan2.hasNextLine()) {
					String str = fileScan.nextLine();
					String[] fileLine = str.split(" "); //split the line in the file
					for(int col = 0; col < fileLine.length; col++) {
						myArray[row][col] = Double.parseDouble(fileLine[col]);//get the individual doubles from the file
						if(fileLine[col] != null) {//if the value isn't null, increase the number of valid columns
							validCols++;
						}
						
					}
					
				}
				temp[row] = new double[validCols];
			}
			*/
		//}
		//create new ragged array (not necessarily 10x10
		
		/*
		double[][] finalArray = new double[validRows][];
		for(int row = 0; row < temp.length; row++) {
			for(int col = 0; col < temp[row].length; col++) {
				finalArray[row][col] = temp[row][col];
			}
		}
		*/
			
		return finalArray; //return array
		
	}
		//String[][] temp = new String[10][10]; - from javadoc
		/*
		int numRows;
		int numCols;
		final int MAX_ROWS = 10;
		final int MAX_COLS = 10;
		double[][] tempArray = new double[MAX_ROWS][MAX_COLS];
		File readFile = new File(file.getPath());
		Scanner scan = new Scanner(readFile);
		
		for(int row = 0; scan.hasNextLine() && row < MAX_ROWS; row++){
			
		
			double[] numbers = new double[scan.nextLine().length()];
			for(int col = 0; col < MAX_COLS && col < numbers.length; col++) {
				numbers[col] = double.Parse(arr)
				myArray[row][col] = numbers[col];
			}
		}*/
		/*
		int numRows = 0;
		int numCols = 0;
		final int MAX_ROWS = 10;
		final int MAX_COLS = 10;
		
		try {
		String[][] tempArray = new String[MAX_ROWS][MAX_COLS];
		//String[] stringArray = new String[MAX_ROWS];
		File readFile = new File(file.getPath());
		Scanner scan = new Scanner(readFile);
		//for loop to read file into temporary string array
		for(int row = 0; row < tempArray.length; row++) {
			String[] line = scan.nextLine().trim().split(" ");
			for(int col = 0; col < line.length; col++) {
				tempArray[row][col] = line[col];
			}
			numRows++;
		}
		double[][] doubleArray = new double[numRows][];
		//for loop to convert strings to double
		for(int row = 0; row < tempArray.length; row++) {
			for(int col = 0; col < tempArray[row].length; col++) {
				if((tempArray[row][col] != null)) {
					doubleArray[row][col] = Double.parseDouble(tempArray[row][col]);
				}
			}
		}
		scan.close();
		return doubleArray;//return final array
		}
		*/
		
		catch(FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());	
			return null;
		}
		
	}//end of readFile()
	
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException{
		try
		{
			PrintWriter outFile = new PrintWriter(outputFile.getPath());
			for(int row = 0; row < data.length; row++) {
				for(int col = 0; col < data[row].length;) {
					outFile.print(data[row][col] + " ");
				}
			}
		}
		catch (FileNotFoundException e){
			System.out.println("Error: " + e.getMessage());			
		}
	}//end of writeToFile()
	
	public static double getTotal(double[][] data) {
		double sum = 0;
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				sum += data[row][col];
			}
		}
		return sum;
	}//end of getTotal()()
	
	public static double getAverage(double[][] data) {
		double dataSum = getTotal(data); //get the total using another method
		int numElements = 0;
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				if(data[row][col] == 0.0) {//check files for values of 0
					numElements++;
				}
			}
		}
		return (dataSum / numElements);
	}//end getAverage
	
	public static double getRowTotal(double[][] data, int row) {
		double rowSum = 0;
		for(int col = 0; col < data[row].length; col++) {
			rowSum += data[row][col];
		}
		return rowSum;
	}//end getRowTotal
	
	public static double getColumnTotal(double[][] data, int col) {
		double colSum = 0;
		
		for(int row = 0; row < data.length; row++) {
			if(data[row].length <= col) {//use <= in case ex: row length = 3 = col, but last index in row would be 2
				colSum += 0;
			}
			else {
				colSum += data[row][col];
			}
			
		}
		return colSum;
	}//end getColumnTotal
	
	public static double getHighestInRow(double[][] data, int row) {
		double highest = -999999;
		for(int col = 0; col < data[row].length; col++) {
			if(data[row][col] > highest) {
				highest = data[row][col];
			}
		}
		return highest;
	}//end getHighestInRow
	
	public static int getHighestInRowIndex(double[][] data, int row) {
		//return index in row
		double highest = getHighestInRow(data, row); //get the highest value in the row
		int highestIndex = 0;
		for(int col = 0; col < data[row].length; col++) {
			if(data[row][col] == highest) {
				highestIndex = col;
			}
		}
		return highestIndex;
	}//end getHighestInRowIndex
	
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = 999999;
		for(int col = 0; col < data[row].length; col++) {
			if(data[row][col] < lowest) {
				lowest = data[row][col];
			}
		}
		return lowest;
	}//end getLowestInRow
	
	public static int getLowestInRowIndex(double[][] data, int row) {
		//return index in row
		double lowest = getLowestInRow(data, row); //get the highest value in the row
		int lowestIndex =0;
		for(int col = 0; col < data[row].length; col++) {
			if(data[row][col] == lowest) {
				lowestIndex = col;
			}
		}
		return lowestIndex;
	}//end getLowestInRowIndex
	
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = -999999;
		for(int row = 0; row < data.length; row++) {
			if(data[row].length > col) {//use > to skip cases where there are less rows than cols
				if(data[row][col] > highest) {
					highest = data[row][col];
				}
			}
			
		}
		return highest;
	}//end getHighestInColumn
	
	public static int getHighestInColumnIndex(double[][] data, int col) {
		//return index in 
		double highest = getHighestInColumn(data, col); //get the highest value in the row
		int highestIndex = 0;
		for(int row = 0; row < data.length; row++) {
			if(data[row].length > col) {//use > to skip cases where there are less rows than cols
				if(data[row][col] == highest) {
					highestIndex = row;
				}
			}
			
		}
		return highestIndex;
	}//end getHighestInColumnIndex
	
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = 999999;
		for(int row = 0; row < data.length; row++) {
			if(data[row].length > col) {//use > to skip cases where there are less rows than cols
				if(data[row][col] < lowest) {
					lowest = data[row][col];
				}
			}
		}
		return lowest;
	}//end getLowestInColumn
	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		//return index in column
		double lowest = getLowestInColumn(data, col); //get the highest value in the row
		int lowestIndex = 0;
		for(int row = 0; row < data.length; row++) {
			if(data[row].length > col) {//use > to skip cases where there are less rows than cols
				if(data[row][col] == lowest) {
					lowestIndex = row;
				}
			}
			
		}
		return lowestIndex;
	}//end getLowestInColumnIndex
	
	public static double getHighestInArray(double[][] data) {
		double highest = -999999;
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				if(data[row][col] > highest) {
					highest = data[row][col];
				}
			}
		}
		return highest;
	}//end getHighestInArray
	
	public static double getLowestInArray(double[][] data) {
		double lowest = 999999;
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				if(data[row][col] < lowest) {
					lowest = data[row][col];
				}
			}
		}
		return lowest;
	}//end getHighestInArray
}//end of class
