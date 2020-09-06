## Implementing custom Data Structures using Java

### Big O
Measure the performance of an Algorithm. How much scalable is the algorithm when the input grows.

#### O(1) => Runs in Constant Time
When an algorithm runs in a constant time. Size of the input object is doesn't matter.
```
private static void print(int[] numbers) {
	System.out.println(numbers[1]);
}
```
Regardless of the input array, fetching the value from specific index will always runs in constant time.

#### O(n) => Runs in Linear Time
When an algorithm run time increases while the input size is increased. Cost the algorithm grows linearly and in direct relationship with size of the input.
```
private static void print(int[] numbers) {
	Arrays
			.stream(numbers)
			.forEach(val -> System.out.println(val));
}
```

#### O(n^2) => Runs in Quadratic Time
Algorithm cost grows in Quadratic way when the input size grows.

O(1 + n * n) => O(n^2)

```
private static void print(int[] numbers) {
	System.out.println(numbers[1]); // O(1)
	for (int first: numbers) //O(n)
		for(int second: numbers) //O(n)
			System.out.println(first + " " + second);
	
	for(int number : numbers) //O(n)
		System.out.println(number);
}
```
Even if we add another for loop below these, the algorithm cost will be like O(n + n*n). Here always the n2 will grows faster than n, so we can represent the complexity as O(n^2)

#### O(log n) => Runs in Logarithmic Time 
Here algorithm cost will slowdown at some point rather than going linear. 

In the example of Linear Search where the searching an element from array from first index is O(1). But if the search element is present in the last index, then the algorithm will always takes O(n). Because when size of the array grows the cost will also increase. In the case of Binary Search the array will be divided into two parts and will divide further until the elements index found. Here cost will slowdown because the size of the array is divided in each steps. So Binary Search is faster than Linear Search.

#### O(2 ^ n) => Runs in Exponential Time  
Its really opposite to Logarithmic growth. Logarithmic curve slows down as the input size grows where as exponential curve will increase more and more when in the input size increases. So Exponential is not easily scalable.

---------------------------------------------------------------------------------------------
## Linear Data Structures
Line of items together in one after another formation.

### Arrays

Implemented Custom Array with Dynamic Size (CustomDynamicArray.java)

```
//Runtime Complexity
//Best Case O(1)    => if the item is at first, so it will run in constant time
//Worst Case O(n)   => if the item is at last, so it will run in linear time
public int indexof(int item) {
	for(int i = 0; i < actualSize; i++) {
		if(result[i] == item) return i;
	}
	return -1;
}
```

##### Runtime Complexities of Arrays
**Lookup by index**	=> O(1)	=> will run in constant time   
**Lookup by value**	=> O(n)	=> in worst case the lookup value can be at the last index  
**insert** 			=> O(n)	=> in worst case we need to create new array and copy existing array into new array and insert a new value (when the array is full)  
**delete** 			=> O(n)	=> in worst the deletion of items requires shifting all the items to the left  

##### Dynamic Array Implementation
1) Vector 		=> Grow by 100% of its original size during resize and synchronized  
2) ArrayList	=> Grow by 50% of its original size during resize and not synchronized  
---------------------------------------------------------------------------------------------
### Linked Lists
Store list of objects in sequence. It can grow and shrink automatically. Consist of group nodes in sequence. 
Each node holds two data. (Each node holds reference to the next node)
1) Value  
2) Address of next node in the list  

First Node 	=> Head  
Last Node	=> Tail

##### Runtime Complexities of Linked List
**Lookup by index**				=> O(n)	=> We can't directly search the list with index as nodes are stored in different memory. So we need to traverse the list to find out the value or index.  
**Lookup by value**				=> O(n)	=> It has to traverse from Head to Tail to find the value in the node. So in worst case the lookup value can be at tail.  
**insert at the beginning** 	=> O(1)	=> We can simply get the head node and point the head to new value.  
**insert at the end** 			=> O(1)	=> We can simply get the tail node and point the tail to new value and reference the previous tail node address to point new tail node.  
**insert at the middle** 		=> O(n)	=> We need to find that node O(n) and then update the links to new node which is O(1).  
**delete at the beginning** 	=> O(1)	=> We can simply get the head node and delink the head node and use the address to find the next node and make that next node as new head.  
**delete at the end** 			=> O(n)	=> We can simply get the tail node and but we need to find the previous node as we don't know the address of previous node. So here we need to traverse the list from head to tail which is O(n) to find the previous node and then delink the tail node and make the previous node as new tail node.  
**delete at the middle** 		=> O(n)	=> We need to traverse the list to find out the current node and its previous node. Then we can the link the previous node to point out the node after the current node.  

Implemented Custom Linked List(CustomLinkedList.java)

We have two implementation of LinkedList.  
1) Singly LinkedList	=> Only have the address of the next node  
2) Doubly LinkedList	=> Address of the next and previous nodes (So here delete at the end of list will give us complexity as O(1) as we have previous node address as well)  

Implemented solution for these two problems.
1) Reversing the Linked List  
2) Get Kth node from end in one pass. (One pass means we shouldn't traverse the list again)  
---------------------------------------------------------------------------------------------
### Stack => Last In First Out Behavior (LIFO)
Stacks are not meant for lookup or search functionality as like Arrays and Lists. It can be very useful in the case of implementing Undo feature and back button logic of browser. Whenever we want to do operation from reverse we can use Stack to achieve those problems.  

##### Runtime Complexities of Stack
push 	=> Adds the item to the top									=> O(1) as its only adds item to top  
pop 	=> Remove and return the item from top						=> O(1) as its only removes the top item  
peek	=> Return the item from top (this will not remove the item) => O(1) as its only peeks the top item  
isEmpty	=> Checks for empty											=> O(1) as its checks for empty  

##### Implemented the following problems:  
1) String Reverse (StringReverser.java)
2) Balanced Expression Verification (BalanceExpressionVerifier.java)

Stack can be implemented using Array or Linked List.

Finally created custom Stack using Array (CustomStack.java)

---------------------------------------------------------------------------------------------

### Queues => First In First Out Behavior (FIFO)
#### Example of using Queue
Printers
Operating System use Queues to manage the processes
Web server use Queues to manage incoming request

##### Runtime Complexities of Queue
enqueue		=> Adding item to the back of the queue.						=> O(1) as its only adds item to back  
dequeue		=> Removing item from the front of the queue.                   => O(1) as its only removes the item from front  
peek		=> Getting item at the front of the queue without removing.     => O(1) as its only peeks the front item  
isEmpty		=> Check whether the queue is empty                             => O(1) as its checks for empty  
isFull		=> Check whether the queue is full                             	=> O(1) as its checks for full  

Implemented Custom Queues using Array(CustomArrayQueue.java) and Stack (QueueWithTwoStacks.java)

PriorityQueue => used to sort the items based on the priority.  

Adding an item to the PriorityQueue is O(n) because we need to compare and shift the items.

Implemented custom PriorityQueue class (CustomPriorityQueue.java)

---------------------------------------------------------------------------------------------
### Hash Table => Key Value Pair

Fast lookups
#### Example of using Hash Table
##### Spell Checker 
##### Dictionaries
##### Compilers (quickly lookup the address of the functions and variables)
##### Code Editors

#### Implementation of Hash Tables
Java		=> HashMap  
Javascript	=> Object  
Python		=> Dictionary  
C#			=> Dictionary  

The Key will be passed to HashFunction, this HashFunction will tell where this Value will be stored in memory. Then HashTable will store the Value in that memory.
HashFunction is deterministic which means it will always return same value for same input.

##### Runtime Complexities of HashTable
HashFunction will tell where in the memory we should store an object or look it up for the given Key.
insert			=> O(1) as its using HashFunction for lookup  
lookup			=> O(1) as its using HashFunction for lookup  
delete			=> O(1) as its using HashFunction for lookup  
containsKey		=> O(1) as its using HashFunction for lookup  
containsValue	=> O(n) as it has to iterate the map to find the value

##### Implemented Two Real World Problems (FindCharacter.java)
1) Find the first non repeatable character in a String (method = findFirstNonRepeatableCharacter)  
2) Find the first repeatable character in a String (method = findFirstRepeatableCharacter())  

#### Hashing
Internally HashMap using Arrays to store the Values. In the context of Data Structures, hashing is the way for generating the array indexes based on the Key for storing the Values.

```
public static void main(String[] args) {
	System.out.println(hash("1253456")); //62
	System.out.println(hash(1253456));  //56
}

//To generate hash value between 0-99 (Array Indexes)
private static int hash(String key) {
	int hash = 0;
	for(Character ch : key.toCharArray()) {
		hash += ch;
	}
	return hash % 100;
}

private static int hash(Integer key) {
	return key % 100;
}

```

#### Collision
It occurs when the same hash value(Array index) has been generated for two different inputs. In that case we will have to maintain two Values with the same index. 
To Solve this we have two solutions  
1) Linked List 		=> We can use the linked list in the Array cells to maintain two different Values when there is a Collision(Its called as Chaining)  
2) Open Addressing	=> We can assign new address for the second Value during the Collision( Its called as Probing)  

##### Linear Probing
When the Collision occurs, we need to search for next empty cell. Here the new index will form cluster with other indexes. So in future the cluster size may increase and will increase the search time

Formula		=>	hash(key)+i (i is for looping the HashTable). 

##### Quadratic Probing
We can use this probing to square up the i and find the index. 

Formula		=>	(hash(key)+i^2)

##### Double Probing
We need to create another hash(hash2) and use that hash2 to generate the new index.
Formula:
1) For generating hash1 		=> hash1(key) = key table_size 				=> Here prime number should be less than the table_size  
1) For generating hash2 		=> hash2(key) = prime - (key % prime) 		=> Here prime number should be less than the table_size  
2) For generating new index		=> index = (hash1 + i * hash2) % table_size => Here prime number should be less than the table_size  

Implementing custom HashTable using LinkedList (CustomHashTable.java).

---------------------------------------------------------------------------------------------

## Non-Linear Data Structures

### Trees
Stores elements in hierarchy. 
Elements are Nodes and Lines connecting them are Edges. Top node is called Root. Nodes which doesn't have any Children are called as Leaf.

#### Example of using Tree
##### Database (for storing indexed columns)
##### Auto completion (used in Chrome while doing web search with past searches)
##### Compilers (Syntax tree to parse expressions)
##### Compression Algorithms (JPEG, MP3)

#### Binary Tree
Its a tree where a parent node will have left and right child. Not necessary to be in order. Also each node has up to two leaves

#### Binary Search Tree
Its similar to Binary Tree with left and right child will be order against its root nodes.

Binary search tree allows for quick lookup of data. Current node is always greater than left child and lesser than the right child. Also for the root node, all left sub tree nodes will be smaller and all the right sub tree nodes will be higher.

##### Runtime Complexities of Binary Tree
lookup			=> O(log n) because it will easily breakdown the tree into half by comparing the root node.
insert			=> O(log n) because we can use lookup to find the correct place to insert and then we can establish the link  which is O(1). So we can consider as O(log n)
delete			=> O(log n) similar to insert, after lookup we need to unlink the nodes

Implemented custom Binary Search Tree (CustomBinaryTree.java) with insert and find methods.

#### Tree Traversal
1) Breadth First(Level Order)	=> We visit all the nodes in the same level before visiting any other level.  
2) Depth First  
	i) Pre-Order	Root, Left, Right
   ii) In-Order		Left, Root, Right	(this will give us the nodes in either ascending or descending order)
  iii) Post-Order	Left, Right, Root	(this will be useful to start processing from leaf nodes to root node)
  
Implemented all the three Depth First Traversal's in CustomBinaryTree.java

#### Depth
Start from root node to count the edges till the child node. Depth of root node is 0.  

#### Height
Its opposite of depth. Starts from the leaf node till we reach the root node. Height of the leaf node is 0. For calculating root node height we need to calculate from the longest child of that root node.  
##### Height of root node
1+max(height(L), height(R))

```
public int height() {
	return height(root);
}

private boolean isLeaf(Node node) {
	return (node.left == null && node.right == null);
}

private int height(Node root) {
	if(root == null) return -1;
	if(isLeaf(root)) return 0;
	return 1 + Math.max(height(root.left), height(root.right));
}
```

For calculating height and minimum value we can use Post-Order traversal.

#### Min
```
public int minimum() {
	return min(root);
}

private boolean isLeaf(Node node) {
	return (node.left == null && node.right == null);
}

private int min(Node root) {
	if(root == null) return -1;
	if(isLeaf(root)) return root.value;
	int leftMin = min(root.left);
	int rightMin = min(root.right);
	return Math.min(Math.min(leftMin, rightMin), root.value);
}
```

Complexity of above min method for Binary Tree is O(n) because we are traversing both left and right child.

```
//Complexity is O(log n) as we are traversing only left child
public int minimumBinarySearchTree() {
	if(root == null) throw new IllegalStateException();
	Node current = root;
	Node last = current;
	while(current != null) {
		last = current;
		current = current.left;
	}
	return last.value;
}
```
Complexity of above minimumBinarySearchTree method for Binary Search Tree is O(log n) because we are traversing only left child.



