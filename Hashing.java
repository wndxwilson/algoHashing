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
        this.size = (int)Math.ceil(max/this.loadFactor);
        this.hashTable = new HashingNode[this.size];
        this.prime = this.size/2 + 1;
        this.hashMethod = type;
    }

    public void addNode(int key,String value){

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
        return this.prime - (key%prime);
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

    public String search(int key){
        int i = 0;
        //Print out the stats
        int compare = 0;
        long time;
        long start = System.nanoTime();
        long end;

        int hash = hashCode(key,i,this.hashMethod);
       
        while(this.hashTable[hash] != null){
            compare = compare + 1;

            if(this.hashTable[hash].getKey() == key){
                end = System.nanoTime();
                time = end - start;
                System.out.println("Comparism: "+compare+" Time: " + time);
                return  this.hashTable[hash].getValue();
            }else{
                i = i + 1;
                hash = hashCode(key,i,this.hashMethod);
                if(hash ==hashCode(key,0,this.hashMethod)){
                    break;
                }
            }
        }

        end = System.nanoTime();
        time = end - start;
        System.out.println("Comparism: "+compare+" Time: " + time);
        return -1;
    }
}