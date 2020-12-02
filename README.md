# MPMP19
My solution to [Matt Parker's Maths Puzzles 19](https://www.think-maths.co.uk/19challenge) which was described as

> "If you square all of the first 19 primes and add them you get a multiple of 19. Enter any number n where the first n primes squared, add to a multiple of n. Any n ≠ 1 counts, but bigger is better!"

## My Results

The current largest value of n I've been able to find is 1,864,637 where the prime number is 30,116,309 and the running total is a rather large 539,391,065,522,650,998,496!

The code is still running and to date has processed the first 144,474,791 prime numbers finding just eight valid values for n, all of which (and the associated info can be) found in [results.tsv](./results.tsv).

As well as logging the valid values of n, I've also stored in a separate TSV file all prime numbers along with an extra column showing the remainder. These files are *huge* and so aren't checked in put I've attached them as releases, if people want to dig around and try and spot any other interesting patterns.

## The Approach Taken

I wrote a very small Java application that uses Java Streams to essentially emit an infinite list of odd integers. Each of those is checked to see if it is prime. Those that are prime are then checked to see if the fulfil the criteria of the puzzle. Using the streams in this way, along with BigInteger, means that I should never run out of numbers or have any issue with stack sizes etc. In otherwords the code should just run forever.

Given the approach I took it's possibly not the most efficient way of finding primes but as I said no limits are placed on how big any of the numbers can grow. If you can see any way of speeding it up then please do make a pull request.

## Compiling and Running the Code

The code can be compiled simply by doing

```
javac MPMP19.java
```

To run it and collect the output into a compressed file I then used the command

```
java MPMP19 > results.tsv  2> >(gzip > primes.tsv.gz)
```
