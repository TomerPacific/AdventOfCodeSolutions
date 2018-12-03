# AdventOfCode2017Solutions
Solutions to Advent Of Code 2017 Challenges

Day 1 - 1.12.17
--------------
First Half :
Solution iterates over string and checks whether two adjacent digits are equal. Also checks if the first digit is equal to the last. Answer is 1216.

Second Half :
Added code that takes into consideration the fact to look ahead at puzzle length / 2. Answer is : 1072.

Day 2 - 2.12.17
--------------
First Half :
Solution iterates over each row in the matrix and finds
the minimum and maximum elements.
Adds the difference between them to a sum.
Answer is 54426.

Second Half :
Iterate over each row, find the two elements that are divisible by each other and add the result of their division to the sum.
Answer is 333.

Day 3 - 3.12.17
--------------
First Half :
Solution finds closest square to given puzzle input, which was 325489. Next, calculated the end position of the square of 571 * 571. Saw that it was 326041.
The difference between 326041 - 325489 is 552, meaning that the puzzle's position is on the bottom row. The position of 1 is in the center (285,285). Thus the steps needed to get from 325489 are 267 to the right and 285 to the center. Resulting in 552.

Second Half :
wrote code that generated the spiral matrix according to the rules. Printed the matrix and saw that the first value printed that is larger than 325489 is 330785.

Day 4 - 4.12.17
--------------

First Half : 
Solution opens the file and reads it line by line. For each line we store in a HashMap the values of the words in the line.
If any value appears twice, that line is not valid.
Answer is 451.

Second Half:
Added method to check if a line contains two words that are anagrams of each other.
Answer is 223.

Day 5 - 5.12.17
--------------

First Half :
Solution opens the file and counts the number of elements. Then, it converts the strings to integers.
Next we move over the array, each time updating the index and incrementing the position we are in.
Answer is 372671.

Second Half:
Added if clause to check if the value is greater or equal to 3. If so, decreased it by 1. Otherwise, increased it by one.
Answer is 25608480.

Day 6 - 6.12.17
--------------

First Half :
Solution finds the maximum element in the array with the lowest index.
Then we iterate over the array, going element by element, increasing each element by one while decreasing the maximum element we got.
We join the array and check if the current "picture" of the array has already been seen. If so, we return the amount of rounds it took.
If not, we add it and continue from the top.
Answer is 11137.

Second Half :
Found out the size of the map when we first placed the "picture" (10100), so it was just a case of simply subtracting that from the result of the first half. Answer is 1037.

Day 7 - 7.12.17
--------------
TBA


Day 8 - 8.12.17
--------------

First Half: 
Solution goes over the puzzle input and creats Register type objects for each register. Then, we go over the instructions and apply them in order to each register. Answer is : 6434.

Second Half:
Added global maximumValue variable to store the maximum value during the run. Answer is : 7184.

Day 9 - 9.12.17
--------------
TBA

Day 10 - 10.12.17
----------------
TBA

Day 11 - 11.12.17
----------------
TBA

Day 12 - 12.12.17
----------------

First Half:
Went over puzzle input and created a Program object for each Program. Each Program object has an array list of programs attached to it.
Found Program with ID of Zero and went over its array list of programs in a BFS fashion. Answer is 130.

Second Half:
Instead of finding the Program with id zero, I iterated over the ArrayList of programs and of each one found the list of programs attached to it.
Answer is 189.

Day 13 - 13.12.17
-----------------
First Half:
Created a Layer object for each layer of the firewall. Then iterated through the layers, seeing if there was a hit in each layer. If so, calculated the amount of the hit. Answer is 2164.


Day 14 - 14.12.17
-----------------
TBA

Day 15 - 15.12.17
-----------------
First Half:
Made the necessary calculations for each generator and using bitwise operators checked if the lower 16 bits were equal.
Answer is : 612.

Second Half:
Used the same logic as the first half, only making sure to compare generatorA numbers that are divisible by 4 with generatorB numbers that are divisible by 8. Answer is : 285.

Day 16 - 16.12.17
-----------------

First Half:
Iterated over puzzle input and made functions to handle each case. Answer is : padheomkgjfnblic.

Second Half:
Found out that the programs positions repeat themselves every 60 iterations. Therefore, after 1 Billion iterations is the same as 100 iterations. Answer is : bfcdeakhijmlgopn.

Day 23 - 23.12.17
-----------------
First Half :
Iterate over puzzle input, line by line, executing each command. Sum up the times the Mul command is executed. Answer is : 5929.

Day 24 - 24.12.17
-----------------
TBA

Day 25 - 25.12.17
-----------------
First Half :
Created states and iterated over them by switch case. Finally, counted the amount of 1's. Answer is : 633.