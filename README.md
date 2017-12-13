# Wattpad

This program automatically flags comments and messages that are deemed offensive. This is done by detecting key phrases in the text and assigning it a score. If the score is over a certain threshold, it is flagged as offensive.

Offensive Phrases
------------------
One file contains "low risk" phrases and the other, "high risk" phrases, one phrase per line. 

Input files
------------
The input files each one containing some possibly offensive text that the program will score. The offensive score is defined as:

(number of low risk phrases) + (number of high risk phrases * 2)


The program will write out one output file containing the scores of each input file in order, in the format:

<input-filename-1>:<score-1>

<input-filename-2>:<score-2>

