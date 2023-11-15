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
public class HolidayBonus {
	//constants for bonuses
	static final double HIGHEST_BONUS = 5000.0;
	static final double MIDDLE_BONUS = 2000.0;
	static final double LOWEST_BONUS = 1000.0;
	
	
	public static double[] calculateHolidayBonus(double[][] data) {//calculate total bonuses for each store
		TwoDimRaggedArrayUtility twoDim = new TwoDimRaggedArrayUtility();//object to call methods from TwoDimRaggedArrayUtility utility class
		//rows in holidayBonus array correspond to rows in data array
		//find the highest, lowest, and middle values in each col
		//each store's bonus increases by a certain number depending on how much they sold
		//repeat for each column
		double[] holidayBonus = new double[data.length];
		for(int i = 0; i < holidayBonus.length; i++) {
			holidayBonus[i] = 0; //initialize every element to 0
		}
		//get max number of cols
		int maxCols = 0;
		for(int row = 0; row < data.length; row++) {
			if(data[row].length > maxCols) {
				maxCols = data[row].length;//length of row is same as num of cols	
			}
		}
		
		//go through each array to find highest and lowest values
		
		for(int col = 0; col < maxCols; col++){ //cols are outer array
			double highestInCol = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
			int highestRowIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col); //gives row index for highest value in col

			double lowestInCol = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);
			int lowestRowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);
			
			
			if(highestInCol <= 0) {
				holidayBonus[highestRowIndex] += 0;
			}
			else {
				holidayBonus[highestRowIndex] += HIGHEST_BONUS;
			}
			if((lowestInCol <= 0) || (lowestInCol == highestInCol)) {
				holidayBonus[lowestRowIndex] += 0;
			}
			else {
				holidayBonus[lowestRowIndex] += LOWEST_BONUS;
			}
			
			for(int row = 0; row < data.length; row++) { //rows are inner
				if((row != highestRowIndex) && (row != lowestRowIndex)) {
					if((data[row].length <= col) || (data[row][col] <= 0)) { //if store didn't sell anything or sales are negative
						holidayBonus[row] += 0; //no bonus
					}
					else {
						holidayBonus[row] += MIDDLE_BONUS;
					}
				
				
			}
			
			}
			System.out.println("h[0]: " + holidayBonus[0]);
		}
		return holidayBonus;
		
		/*
		//each row in 2d utility array corresponds to one element in 1d array?
		double[] holidayBonus = new double[data.length];
		int highestIndex = 0, lowestIndex = 0;
		
		
		//find row of lowest/highest values, and every other row is given middle level bonus?
		//make sure that rows of 1d col match up with rows of 2d col
		double highest = twoDim1.getHighestInArray(data);
		for(int row = 0; row < data.length; row++) { //very similar to getHighestIndex methods
			for(int col = 0; col < data[row].length; col++) {
				if(data[row][col] == highest) {
					highestIndex = row;
				}
			}
		}
		
		double lowest = twoDim1.getLowestInArray(data);
		for(int row = 0; row < data.length; row++) { //very similar to getLowestIndex methods
			for(int col = 0; col < data[row].length; col++) {
				if(data[row][col] == lowest) {
					lowestIndex = row;
				}
				
			}
		}
		//use for loop set values in holiday bonus array
		for(int i = 0; i < holidayBonus.length; i++) {
			if(i == highestIndex) {
				holidayBonus[i] = HIGHEST_BONUS;
			}
			else if(i == lowestIndex) {
				holidayBonus[i] = LOWEST_BONUS;
			}
			//people who didn't sell anything?
			else {
				holidayBonus[i] = MIDDLE_BONUS;
			}
		}
		return holidayBonus;
		*/
	}//end calculateHolidayBonus
	
	public static double calculateTotalHolidayBonus(double[][] data) {
		double[] holidayBonus = calculateHolidayBonus(data); //get the 2d array of bonuses
		double sum = 0;
		for(int i = 0; i < holidayBonus.length; i++) {
			sum += holidayBonus[i];
		}
		return sum;
	}//end calculateTotalHolidayBonus
}
