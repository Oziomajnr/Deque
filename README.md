# Deque
A double sided queue where Items can be added and removed from both sides
This is a linked list implementation, each item is represented as a node object.
Each node holds a reference to two other nodes which are the previous and next nodes
If there is no previous or next node then the reference is null.
This data structure supports iterators but does not currently support nested iterators
Suggestions on improving this data structure should be sent to the author with the email address below 
Each operation in this datastructure takes O(1) worst case, and it uses very small memory in handling the data.
I have made sure of minimal memory overhead by limiting the usage of java libraries, the two packages imported in this project are 
1. java.util.Iterator for making iteration possible and 
2. java.util.NoSuchElementException for  throwing exeption when an illegal pop is called
