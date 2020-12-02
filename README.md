# MPMP19
My solution to [Matt Parker's Maths Puzzles 19](https://www.think-maths.co.uk/19challenge) which was described as

> "If you square all of the first 19 primes and add them you get a multiple of 19. Enter any number n where the first n primes squared, add to a multiple of n. Any n ≠ 1 counts, but bigger is better!"

The current largest value of n I've been able to find is 1,864,637 where the prime number is 30,116,309 and the running total is a rather large 539,391,065,522,650,998,496!

The code is still running and to date has processed the first 144,474,791 prime numbers finding just eight valid values for n, all of which (and the associated info can be) found in [results.tsv](./results.tsv).

As well as logging the valid values of n, I've also stored in a separate TSV file all prime numbers along with an extra column showing the remainder. These files are *huge* and so aren't checked in put I've attached them as releases, if people want to dig around and try and spot any other interesting patterns.
