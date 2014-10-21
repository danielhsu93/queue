/**********************************************************************
 *  Randomized Queues and Deques
 **********************************************************************/

Name: Daniel Hsu
NetID: dh15

Partner name: Connie Feng
Partner NetID: clf6

Hours to complete assignment (optional):10


/**********************************************************************
 *  Explain briefly how you implemented the randomized queue and deque.
 *  Which data structure did you choose (array, linked list, etc.)
 *  and why?
 **********************************************************************/
We implemented the randomized queue with an array. We doubled the size 
whenever the length of the array matched the size (# of items currently
in array), and halved it whenever the size was one fourth of the length.
The randomized portion comes from the dequeue, where we uniformly randomly
choose an element to return. The iterator shuffles a list of indices, 
which we iterate over items based off of the shuffled indices. We chose
an array because it has constant time random access, versus a linked list,
which linear time.

The Deque was implemented with a doubly linked list, and we maintained 
references to both the head and tail. We chose to use a doubly linked list
because we wanted to pop off the front or last in constant time. We also 
didn’t need to know how long the list was going to be beforehand. 


/**********************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 **********************************************************************/
We received help from Omid and Dr.Fagan.
 
 
/**********************************************************************
 *  If you did NOT work with a partner, please state below
 *  that you worked alone
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 **********************************************************************/
We split up the work and used source control so we could work separately
when needed. Daniel worked on Deque, RandomizedQueue, and Subset. Connie
worked on Deque, RandomizedQueue, and Palindrome.



