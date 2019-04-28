/*==============================================================================
This program simulates one iteration of the game of life.

In order to change the initial matrix, you must change inputData and input
as described below.

==============================================================================*/

import java.util.*;

public class GameOfLife{

  public static void main(String[] args){
    // ============================== CHANGE DATA OF MATRIX HERE
    int[] inputData = {1,1,1,1,0,0,1,1,0,1,1,1};

    // ============================== CHANGE MATRIX SIZE HERE
    int[][] input = new int[4][3];
    fillInputMatrix(input,inputData);

    System.out.println("Input matrix:");
    printArray(input);

    int[][] output = new int[input.length][input[0].length];
    // ============================== PLAY LIFE!
    playLife(input,output,0,0);
    System.out.println("Output matrix:");
    printArray(output);

  } //EOM

/**
  * This is a recursive function to check every value in the given matrix
  *
  * @param  in   the initial matrix
  * @param  out   the final matrix
  * @param  row   the current row
  * @param  col   the current column
  */

  public static void playLife(int[][] in, int[][] out, int row, int col){
    if (row < in.length) {
        if (col < in[row].length) {
            //System.out.println("In row: "+row+" In col: "+col);
            out[row][col] = ((willCellLive(in,row,col)) ? 1 : 0);
            playLife(in, out, row, col+1);
        } else {
            playLife(in, out, row+1, 0);
        }
    }
  }

/**
  * This function counts neighbors and determines the current cell's fate
  *
  * @param  arr   the given initial matrix
  * @param  row   the current row
  * @param  col   the current column
  * @return       true if cell will live, false if cell will die
  */

  public static boolean willCellLive(int[][] arr, int row, int col){
    int neighbors = 0;
    neighbors += ((checkUp(arr,row,col)) ? 1 : 0);
    neighbors += ((checkUpRight(arr,row,col)) ? 1 : 0);
    neighbors += ((checkRight(arr,row,col)) ? 1 : 0);
    neighbors += ((checkRightDown(arr,row,col)) ? 1 : 0);
    neighbors += ((checkDown(arr,row,col)) ? 1 : 0);
    neighbors += ((checkDownLeft(arr,row,col)) ? 1 : 0);
    neighbors += ((checkLeft(arr,row,col)) ? 1 : 0);
    neighbors += ((checkUpLeft(arr,row,col)) ? 1 : 0);
    //System.out.println("\tneighbors: "+neighbors);
    if(arr[row][col] == 1){

      if(neighbors < 2){ // 0 or 1 neighbors
        return false;
      }else if(neighbors == 2 || neighbors == 3){ // 2 or 3 neighbors
        return true;
      }else{ // >3 neighbors
        return false;
      }

    }else if(arr[row][col] == 0){

      if(neighbors == 3){ //dead cell will only live if it has 3 neighbors
        return true;
      }else{ // stay dead
        return false;
      }

    }else{ //should never happen
      System.out.println("Error! Should only be 0 or 1");
      System.exit(0);
    }
    return false;

  }

/**
  * These following functions check every surrounding cell and counts neighbors
  *
  * @param  arr   the initial matrix
  * @param  row   the current row
  * @param  col   the current column
  * @return       true if specified neighbor is alive
  */

  public static boolean checkUp(int[][] arr, int row, int col){
    if(row-1 < 0) return false;
    if(arr[row-1][col] == 1) return true;
    return false;
  }
  public static boolean checkUpRight(int[][] arr, int row, int col){
    if(row-1 < 0 || col+1 >= arr[0].length) return false;
    if(arr[row-1][col+1] == 1) return true;
    return false;
  }

  public static boolean checkRight(int[][] arr, int row, int col){
    if(col+1 >= arr[0].length) return false;
    if(arr[row][col+1] == 1) return true;
    return false;
  }

  public static boolean checkRightDown(int[][] arr, int row, int col){
    if(row+1 >= arr.length || col+1 >= arr[0].length) return false;
    if(arr[row+1][col+1] == 1) return true;
    return false;
  }

  public static boolean checkDown(int[][] arr, int row, int col){
    if(row+1 >= arr.length) return false;
    if(arr[row+1][col] == 1) return true;
    return false;
  }

  public static boolean checkDownLeft(int[][] arr, int row, int col){
    if(row+1 >= arr.length || col-1 < 0) return false;
    if(arr[row+1][col-1] == 1) return true;
    return false;
  }

  public static boolean checkLeft(int[][] arr, int row, int col){
    if(col-1 < 0) return false;
    if(arr[row][col-1] == 1) return true;
    return false;
  }

  public static boolean checkUpLeft(int[][] arr, int row, int col){
    if(row-1 < 0 || col-1 < 0) return false;
    if(arr[row-1][col-1] == 1) return true;
    return false;
  }

/**
  * Helper function
  *
  * @param  in   the initial matrix to fill
  * @param  inData   the given data to fill the initial matrix
  */

  public static void fillInputMatrix(int[][] in, int[] inData){
    int count = 0;
    for(int i = 0; i < in.length; i++){
      for(int j = 0; j < in[0].length; j++){
        in[i][j] = inData[count];
        count++;
      }
    }
  }

/**
  * Helper function
  *
  * @param  arr   array to be printed
  *
  */

  public static void printArray(int[][] arr){
    System.out.println("===============");
    for (int[] i : arr){
      for (int j : i){
        System.out.print(j + " ");
      }
      System.out.println();
    }
    System.out.println("===============");
  }







} //EOF
