# algoHashing
cz2001 lab2

## 1.1 Problem Scenario and Dataset
A bank is disturbed with more and more customers leaving their credit card services. They hope to predict who is going to leave so they can proactively provide them better services and change their minds. This dataset consists of 10,000 customers with 18 attributes, such as their age, salary, marital_status, credit card limit, credit card category, etc. We used this dataset for searching the clientNumber and Age using our hashing algorithm.

## 1.2 Our Chosen Algorithm
We use Linear Probing and Double Hashing to rehash hable table collisions. A hash function may map different keys to the same slot, such as in many-to-one mapping and not one-to-one mapping. For example, in a dataset matching unique phone numbers to people, a phone number 66754372 can be hashed to the same location as 66752378 when the hash function is f(k) = kmod997, leading to collision.  

## 1.3 Load Factor for Open Address Hashing
Load factors to be tested are 0.25, 0.5, 0.75 and 1, the load factor for open address hashing can never be greater than 1, as each slot of the table size can only contain one key.

## 2 How to use
`git clone https://github.com/wndxwilson/algoHashing.git`

## 3 Search hashing 
In MainApp.java, add the key to search for the value.<br>
`int result = h.searchValue(key);`

## 4 Conclusion

Linear probing can create large primary clusters which can in turn create large primary clusters. This increases the run time for the find/ insert operations

In order for us to reduce primary clusters, we can implement 

(hash(key) + 1 * d ) % m

m = prime number 
d = constant int >1 and co-prime to m


Since d and m are co-prime, the probe sequence covers all the slots in the        hash table.

In our code, we have also concluded that double hashing yields better performance compared to linear probing and that a higher load factor resulted in a higher chance of conflict. Lastly, when the hash table size is kept to a prime number, the chance of having a conflict is significantly reduced thus we have implemented a function to round the hash table size to the nearest prime in our implementation.
