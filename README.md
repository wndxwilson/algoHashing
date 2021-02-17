# algoHashing
cz2001 lab2

## 1 Problem Statement  
Using open address hashing and linear probing, compare between different hashing functions (Group 3).

### 1.1 Problem Scenario and Dataset:
We used the bank churners dataset by searching the clientNumber and Age for our hashing algorithm.

### 1.2 Our chosen algorithm:
We use Linear Probing and Double Hashing to avoid hable table collision. As a hash function may map different keys to the same slot such as a many-to-one mapping and not one-to-one mapping. Example will be phone number 66754372 hashes to the same location as 66752378. Since the two keys have the same hash value it leads to collision.

### 1.3 Load factor for open hashing:
Load factors to be tested are 0.25, 0.5, 0.75 and 1, the load factor for open address hashing can never be greater than 1, as each slot of the table size can only contain one key.

## 2 How to use
`git clone https://github.com/wndxwilson/algoHashing.git`

## 3 Search hashing 
In MainApp.java, add the key to search for the value.
'int result = h.searchValue(key);'

## 4 Conclusion

Linear probing can create large primary clusters which can in turn create large primary clusters. This increases the run time for the find/ insert operations

In order for us to reduce primary clusters, we can implement 

(hash(key) + 1 * d ) % m

m = prime number 
d = constant int >1 and co-prime to m


Since d and m are co-prime, the probe sequence covers all the slots in the        hash table.

In our code, we have also concluded that double hashing yields better performance compared to linear probing and that a higher load factor resulted in a higher chance of conflict. Lastly, when the hash table size is kept to a prime number, the chance of having a conflict is significantly reduced thus we have implemented a function to round the hash table size to the nearest prime in our implementation.
