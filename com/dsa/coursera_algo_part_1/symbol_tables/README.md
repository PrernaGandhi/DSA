    Symbol tables are key value pairs and can be implemented using the following methods:

    1. We can use linked list, to store elements in symbol table
    cost : Search O(N)
    cost : Insert O(N)

    2. Binary search in ordered array :
    we use two parallel arrays, one for key and one for values,
    we find the index of key using binary search and return corresponding to that
    index from the values array
    search O(log N)
    insert O(N)
    
    3. Binary search tree
    search O(log N)
    insert O(log N)
