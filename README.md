# Game of Life - Steven Milov

### Execution instructions
Assuming you have a JVM:
* ```javac GameOfLife.java```
* ```java GameOfLife```

### Resources and people
The only resource I used was:
https://stackoverflow.com/questions/20157372/fill-a-matrix-2d-array-recursively-in-java
in order to remind myself of proper recursion techniques, since the last time I used recursion was a year ago.

I worked on this project at my local coffee shop, and ran into a classmate from this semester. The big question I asked him was to confirm whether there was a better way to solve this without using recursion, which is the most logical way I  believe would solve this program. He agreed with me and confirmed my belief that recursion is definitely the way to go about this problem.

### Duration of Project
I started this project about an hour before my first commit, which was roughly 2 hours ago.

This project took me around 3 hours in total, including the write-up.

### Last Comments
This project had a pretty simple objective, but was very enjoyable to optimize nonetheless. Please let me know if you have any other questions or would like me to generalize this to accept any matrix as an input instead of changing the actual code.   

### Project Guidelines
```
/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules:
* Any live cell with fewer than two live neighbors dies, as if caused by under-population.
* Any live cell with two or three live neighbors lives on to the next generation.
* Any live cell with more than three live neighbors dies, as if by over-population..
* Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
* Write a function to compute the next state (after one update) of the board given its current state.

Example:
nextGeneration([
  [1, 1, 1],
  [1, 0, 0],
  [1, 1, 0]
])

// Will return:
[
  [1, 1, 0],
  [0, 0, 1],
  [1, 1, 0]
]
*/
```
