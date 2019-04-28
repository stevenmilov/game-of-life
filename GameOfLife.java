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
            out[row][col] = ((willCellLive(in,row,col)) ? 1 : 0);

            playLife(in, out, row, col+1);
        } else {
            playLife(in, out, row+1, 0);
        }
    }

  }

  public static boolean willCellLive(int[][] arr, int row, int col){
    return true;
  }
  public static void checkUp(){

  }
  public static void checkUpRight(){

  }

  public static void checkRight(){

  }

  public static void checkRightDown(){

  }

  public static void checkDown(){

  }

  public static void checkDownLeft(){

  }

  public static void checkLeft(){

  }

  public static void checkUpLeft(){

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
