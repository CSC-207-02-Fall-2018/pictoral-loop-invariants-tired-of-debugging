# pictoral-loop-invariants-tired-of-debugging
/*********************************************************************
     * Nate Williams and Carlton Segbefia                            *
     * PO Box 4580, 4439                                             *
     * Program for CSC 207                                           *
     *   Pictorial Loop Invariants lab writeup.                      *
     * Assignment for Friday, October 19th                           *
     *****************************************************************/


    /* ***************************************************************
     * Academic honesty certification:                               *
     *   Written/online sources used:                                *
     *          Pictorial Loop Invariants lab assignment             *
     *   Help obtained                                               *
     *      none						     *
     *   My signature below confirms that the above list of sources  *
     *   is complete AND that I have not talked to anyone else       *
     *   [e.g., CSC 161 students] about the solution to this problem *
     *                                                               *
     *   Signature:     Nathaniel Williams, Carlton Segbefia         *
     *****************************************************************/

Pictorial Loop Invariants Lab
Nate Williams & Carlton Segbefia
10/19/2018

1. 
The exit condition is where L >= R. This is true because L is on the outside edge
of the small elements and R is on the outside edge of the large elements,
so when L=R there is still one unsorted element between the large and small elements.

2-5
See Partition.java

6. 
For invariant A: 
We will keep track of boundaries with the variables red, white, blue, u, and length. 
Elements incuding red and up to white should be red, elements including white and
up to blue should be white, elements including blue and up to u should be blue,
and elements including u and up to length are unsorted.
red <= i < white -> element is red.
white <= i < blue -> element is white.
blue <= i < u -> element is blue.
u <= i < length -> element is unsorted.

For invariant B: 
We will keep track of boundaries with the variables red, white, u, blue, and length.
Elements including red and up to white should be red, elements including white and
up to u should be white, elements including u and up to blue are unsorted,
and elements including blue and up to length should be blue. 
red <= i < white -> element is red.
white <= i < u -> element is white.
u <= i < blue -> element is unsorted.
blue <= i < length -> element is blue.

9:
Test Plan:
Test each sorting method using arrays of both even and odd sizes, with seemingly random, 
increasing, and decreasing examples. The select method should be used with small and large
values of k.

Our programs are clearly correct: With each testing example, the partition function correctly
partitions the starting array and returns the index of the pivot value. Each kth smallest
element test returns the correct element. The median function returns the median element
for each testing example, rounding down for even-length arrays. 

Both dutch flag algorithms also function forrectly for our testing examples. For arrays 
that begin or end with 0, 1, or 2 (standing in for red, white, and blue, respectively),
the data is sorted properly within the arrays. 
