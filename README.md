# algoHashing
cz2001 lab2 
Using open address hashing and linear probing, compare between different hashing functions (Group 3).

## 1.1 Problem Scenario and Dataset
A bank is disturbed with the increasing number of customers leaving their credit card services. They hope to predict who is going to leave so they can proactively provide them better services and change their minds. They’ve formed a dataset of 10,000 customers with 18 attributes, such as their age, salary, marital_status, credit card limit, credit card category, etc. Each customer record can be uniquely identified by the CLIENTNUM attribute, a unique 9 digit number. Using this example, our team has decided to implement open address hashing and linear probing using 2 hash functions, before comparing their average CPU time and average number of key comparisons for successful and unsuccessful searches.


## 1.2 Our Chosen Algorithm
A hash function may map different keys to the same slot. For example, in a dataset matching unique phone numbers to people, a phone number 66754372 can be hashed to the same location as 66752378 when the hash function is f(k) = kmod997, leading to collision. For our tests, we use linear probing to resolve these collisions by placing the new key in the subsequent available cell. Linear probing is faster than other rehashing methods due to locality of reference. As each slot of the table size can only contain one key, the load factor for open address hashing can never be greater than 1. Hence, collision is handled by rehashing. 

If the hashTable[hash] is filled, the next CLIENTNUM will be stored directly below that filled slot. To search through the hash table, the hash code is obtained through the key. There are two outcomes in the search: Success or Fail. Linear Probing will go on until the algorithm either reaches the starting point of the search or reaches an empty slot.
 

## 1.3 Load Factor for Open Address Hashing
Load factors to be tested are 0.25, 0.5, 0.75 and 1, the load factor for open address hashing can never be greater than 1, as each slot of the table size can only contain one key.

## 1.4 Compare division with mutiplication hash method
For hash division method, the functions takes the form of h(key) = key mode table size, while for the multiplication method, the function takes the form of h(key_ = floor(table size * (key * A mod 1)). Our team wil compare and analyze both hash function and record its findings. The finding can be found in the record.txt.

## 2 How to use
`git clone https://github.com/wndxwilson/algoHashing.git` <br>
Follow MainApp.java for example

## 3 Search hashing 
In MainApp.java, add the key to search for the value.<br>
`int result = h.search(key);`

## 4 Conclusion

When load factor approaches 1, both division and multiplication methods will have to probe through all the list to find a value.
    Our findings are consistent with what is expected. For the multiplication method, despite having lesser comparison as compared to the division method, the average CPU time is significantly higher. This is logically so as the multiplication function has a higher computational complexity correlation to higher average CPU time.
    In terms of lesser comparison, multiplication method is better, whereas division hashing is better in terms of average CPU time. However, as average CPU time varies depending on the specifications of your computer, it is not necessarily an accurate indication of efficiency or complexity.
    However, if we were to conclude on our findings, the division method would be good to use as it requires less computational time even as it approaches a load factor of 1. Average CPU time is important as hashing is used to index and retrieve items in a database because it is faster to find the item using the shorter hashed key than to find it using the original value. 



