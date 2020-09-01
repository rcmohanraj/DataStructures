###Big O
Measure the performance of an Algorithm. How much scalable is the algorithm when the input grows.

#### O(1) => Runs in Constant Time
When an algorithm runs in a constant time. Size of the input object is doesn't matter.
```
private static void print(int[] numbers) {
	System.out.println(numbers[1]);
}
```
Regardless of the input array, fetching the value from specific index will always runs in constant time.
__
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

#### Arrays

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
#### Linked Lists
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
#### Stacks
