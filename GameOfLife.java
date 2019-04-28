import java.util.*;

/*
References:
  https://stackoverflow.com/questions/20157372/fill-a-matrix-2d-array-recursively-in-java
*/

/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules:
* Any live cell with fewer than two live neighbors dies, as if caused by under-population.
* Any live cell with two or three live neighbors lives on to the next generation.
* Any live cell with more than three live neighbors dies, as if by over-population..
* Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
* Write a function to compute the next state (after one update) of the board given its current state.
*/
// Example:
// nextGeneration([
//   [1, 1, 1],
//   [1, 0, 0],
//   [1, 1, 0]
// ])
//
// // Will return:
// [
//   [1, 1, 0],
//   [0, 0, 1],
//   [1, 1, 0]
// ]


public class GameOfLife{

  public static void main(String[] args){
    int[] inputData = {1,1,1,1,0,0,1,1,0};
    // create 2D matrix with values given:
    int[][] input = new int[3][3];
    fillInputMatrix(input,inputData);

    System.out.println("Input matrix:");
    printArray(input);

    int[][] output = new int[3][3];
    playLife(input,output,0,0);
    System.out.println("Output matrix:");
    printArray(output);

  } //EOM

  public static void playLife(int[][] in, int[][] out, int row, int col){
    if (row < in.length) {
        if (col < in[row].length) {
            System.out.println("In row: "+row+" In col: "+col);
            out[row][col] = ((willCellLive(in,row,col)) ? 1 : 0);
            playLife(in, out, row, col+1);
        } else {
            playLife(in, out, row+1, 0);
        }
    }
  }


  public static boolean willCellLive(int[][] arr, int row, int col){
    System.out.println("\t will cell live?? In row: "+row+" In col: "+col);
    int neighbors = 0;
    neighbors += ((checkUp(arr,row,col)) ? 1 : 0);
    neighbors += ((checkUpRight(arr,row,col)) ? 1 : 0);
    neighbors += ((checkRight(arr,row,col)) ? 1 : 0);
    neighbors += ((checkRightDown(arr,row,col)) ? 1 : 0);
    neighbors += ((checkDown(arr,row,col)) ? 1 : 0);
    neighbors += ((checkDownLeft(arr,row,col)) ? 1 : 0);
    neighbors += ((checkLeft(arr,row,col)) ? 1 : 0);
    neighbors += ((checkUpLeft(arr,row,col)) ? 1 : 0);
    System.out.println("\tneighbors: "+neighbors);
    if(arr[row][col] == 1){

      if(neighbors < 2){ // 0 or 1 neighbors
        return false;
      }else if(neighbors == 2 || neighbors == 3){ // 2 or 3 neighbors
        return true;
      }else{ // >3 neighbors
        return false;
      }

    }else if(arr[row][col] == 0){

      if(neighbors == 3){
        return true;
      }else{
        return false;
      }

    }else{
      System.out.println("Error! Should only be 0 or 1");
      System.exit(0);
    }
    return false;

  }
  public static boolean checkUp(int[][] arr, int row, int col){
    if(row-1 < 0) return false;
    if(arr[row-1][col] == 1) return true;
    return false;
  }
  public static boolean checkUpRight(int[][] arr, int row, int col){
    if(row-1 < 0 || col+1 >= arr.length) return false;
    if(arr[row-1][col+1] == 1) return true;
    return false;
  }

  public static boolean checkRight(int[][] arr, int row, int col){
    if(col+1 >= arr.length) return false;
    if(arr[row][col+1] == 1) return true;
    return false;
  }

  public static boolean checkRightDown(int[][] arr, int row, int col){
    if(row+1 >= arr[0].length || col+1 >= arr.length) return false;
    if(arr[row+1][col+1] == 1) return true;
    return false;
  }

  public static boolean checkDown(int[][] arr, int row, int col){
    if(row+1 >= arr[0].length) return false;
    if(arr[row+1][col] == 1) return true;
    return false;
  }

  public static boolean checkDownLeft(int[][] arr, int row, int col){
    if(row+1 >= arr[0].length || col-1 < 0) return false;
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
  public static void fillInputMatrix(int[][] in, int[] inData){
    int count = 0;
    for(int i = 0; i < in.length; i++){
      for(int j = 0; j < in[0].length; j++){
        in[i][j] = inData[count];
        count++;
      }
    }
  }

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
