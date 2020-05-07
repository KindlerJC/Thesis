# Thesis Project

## About

Program used in Honors Thesis project for Appalachian State Computer Science Department in Spring 2020. Uses dynamic programming techniques to solve tabular graph algorithms on trees with O(n) time complexity.

Author: Josh Kindler

Advisor: Dr. Alice McRae

## Abstract
An Independent Open Irredundant (ioir) Set is a subset S of a graph G for which every vertex in S has an external private neighbor in G - S. An external private neighbor for a vertex v ∈ S is a vertex in G - S that is adjacent to v, but not to any other vertex in S. One interesting part of this set is that it must also be maximal, meaning that adding any vertex from G - S to S should be impossible without violating a property of the set. This constraint prevents the problem from being solved trivially by selecting a single vertex, regardless of the tree’s composition. The ioir-set belongs to a family of graph problems, including graph domination, that are only known to have solutions with exponential time complexity. Using T.V. Wimer’s dynamic programming techniques for tabular algorithms, it is possible to solve these problems in linear time, as long as the graph is a tree. To  test these algorithms, including one to find ioir-sets in trees, I have also written a program to execute them. It is difficult to prove the accuracy of these algorithms, but with this program, it is possible to disprove them by verifying their outputs over multiple runs on one tree, each time rooted arbitrarily. 
