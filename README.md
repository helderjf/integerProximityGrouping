# integerProximityGrouping
Group arrays of N integers in N or less groups, by their proximity.


This project is part of a submition to a Java developer openening at a portugese software house.

The app receives an array of integers and a number of groups to divide them in, grouping them by their proximity.

Initialy I took the aproach of ordering the array, search for the N-1 biggest gaps between the numbers, dividing the array in those points.
That seemed like the obvious aproach to the problem, but I realized then that my results were not the same as the one in the examples listed in company's webpage.

So after some research I chose the K-Means algorithm, which is a clustering algorithm.After some tests on an online calculator, the results seemed ok so I went with it (it's an heuristic so the results are not always the same).
More about it here: https://en.wikipedia.org/wiki/K-means_clustering
For reference I maintained my initial aproach and made it available to use at runtime.