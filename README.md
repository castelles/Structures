## Structures

This repository has a kotlin implementation of some data structures developed by me. Also, each structure has it own basic operators like add, remove, size, contains, and so on. Down below you can see more details of each data structure.

### Chained List

Is a structure which has a parameter generic type, what allows it to retain any class of data to store in its structure. Also, the chained list has a second parameter of 'self' type pointing to the next stored node.
It's possible to execute operators like:
 - add(item: T) 
 - remove(item: T)
 - addAt(index: Int, item: T)
 - size()
 - contains(item: T)
 - forEach { } iterator
 - exactlyTo(list: ChainedList<T>)
 - equalsTo(list: ChainedList<T>)
 - containsAllItems(list: ChainedList<T>)
 - replace(itemToReplace: T, replaceWith: T)
 - replaceAll(itemToReplace: T, replaceWith: T)

All these methods passed through intensive testing which are implemented at the ChainedListTest class. The test had a 100% of line coverage and an amount of 32 test methods executed.
