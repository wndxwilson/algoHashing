import java.io.IOException;

public class Hashing
{
    private double loadFactor = 1;
    private int size;
    private HashingNode[] hashTable;
    private boolean hashMethod;
    private int prime;

    //constructor
    Hashing(double loadFactor, int max,boolean type){
        if(loadFactor <= 1){
            this.loadFactor = loadFactor;
        }
        //load factor = n/h , h = n/load factor
        this.size = (int)Math.ceil(max/this.loadFactor)+1;
        this.hashTable = new HashingNode[this.size];
        this.prime = 11;
        this.hashMethod = type;

        System.out.println("Hash table size: " +this.size);
    }

    public void addNode(int key,int value){

         //get hashcode
         int i = 0;
         int hash = hashCode(key,i,this.hashMethod);

        //Find an empty slot
        while(this.hashTable[hash] != null){
            i = i + 1;
            hash = hashCode(key,i,this.hashMethod);
        }
        //add value
        this.hashTable[hash] = new HashingNode(key,value);
        
       
            
        
    }


    private int hashCode(int key, int i, boolean type){
        if(type){
            return linear(key,i);
        }else{
            return doubleHash(key,i);
        }
    }

    private int linear(int key, int i){
        return (key+i) % this.size;
    }

    private int hash2(int key){
        return (key%this.prime)+1;
    }

    private int doubleHash(int key, int i){
        return (linear(key,0) + i*hash2(key) )% this.size;
    }

    public void printNode(){
        for (HashingNode node : this.hashTable){
            if(node != null){
                System.out.println(node.getValue());
            }else{
                System.out.println("null");
            }
        }
    }

    public Integer[] search(int key){
        int i = 0;
        //Print out the stats
        int compare = 0;
        long time;
        long start = System.nanoTime();
        long end;
        Integer[] ret = new Integer[2];
        int hash = hashCode(key,i,this.hashMethod);
        compare = compare + 1;
        while(this.hashTable[hash] != null){

            if(this.hashTable[hash].getKey() == key){
                end = System.nanoTime();
                time = end - start;
                ret[0] = (int)time;
                ret[1] =  compare;
                return ret;
            }else{
                i = i + 1;
                hash = hashCode(key,i,this.hashMethod);
                if(hash ==hashCode(key,0,this.hashMethod)){
                    break;
                }
            }
            compare = compare + 1;

        }

        end = System.nanoTime();
        time = end - start;
        ret[0] = (int)time;
        ret[1] =  compare;
        return ret;
    }

    public int searchValue(int key){
        int i = 0;
        int hash = hashCode(key,i,this.hashMethod);
        while(this.hashTable[hash] != null){

            if(this.hashTable[hash].getKey() == key){
                return this.hashTable[hash].getValue();
            }else{
                i = i + 1;
                hash = hashCode(key,i,this.hashMethod);
                if(hash ==hashCode(key,0,this.hashMethod)){
                    break;
                }
            }

        }

  
        return -1;
    }
}
