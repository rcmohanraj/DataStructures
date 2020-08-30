Big O:
Measure the performance of an Algorithm. How much scalable is the algorithm when the input grows.

#### O(1): Constant
When an algorithm runs in a constant time. Size of the input object is doesn't matter.
```
private static void print(int[] numbers) {
	System.out.println(numbers[1]);
}
```
Regardless of the input array, fetching the value from specific index will always runs in constant time.

#### O(n): Linear
When an algorithm run time increases while the input size is increased. Cost the algorithm grows linearly and in direct relationship with size of the input.
```
private static void print(int[] numbers) {
	Arrays
			.stream(numbers)
			.forEach(val -> System.out.println(val));
}
```

#### O(n^2): Quadratic
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

#### O(log n): Logarithmic 
Here algorithm cost will slowdown at some point rather than going linear. 

In the example of Linear Search where the searching an element from array from first index is O(1). But if the search element is present in the last index, then the algorithm will always takes O(n). Because when size of the array grows the cost will also increase. In the case of Binary Search the array will be divided into two parts and will divide further until the elements index found. Here cost will slowdown because the size of the array is divided in each steps. So Binary Search is faster than Linear Search.

#### O(2 ^ n): Exponential  
Its really opposite to Logarithmic growth. Logarithmic curve slows down as the input size grows where as exponential curve will increase more and more when in the input size increases. So Exponential is not easily scalable.

#### Custom Array with Dynamic Size

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

Runtime Complexities:
Lookup by index	=> O(1)
Lookup by value	=> O(n)
insert 			=> O(n)
delete 			=> O(n)

##### Dynamic Array Implementation:
1) Vector 		=> Grow by 100% of its original size during resize and synchronized
2) ArrayList	=> Grow by 50% of its original size during resize and not synchronized

