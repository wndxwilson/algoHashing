public class Hashing
{
    private double loadFactor = 1;
    private int size;
    private HashingNode[] hashTable;
    private boolean hashMethod;
    private long time;
    private int compare;

    //constructor
    Hashing(double loadFactor, int max,boolean type){
        if(loadFactor <= 1){
            this.loadFactor = loadFactor;
        }
        //load factor = n/h , h = n/load factor
        this.size = (int)Math.ceil(max/this.loadFactor);
        this.hashTable = new HashingNode[this.size];
        this.hashMethod = type;
    }

    public void addNode(int key,int value){

         //get hashcode
         int i = 0;
         int hash = hashCode(key,i,this.hashMethod);

        //Linear probing
        while(this.hashTable[hash] != null){
            i = i + 1;
            hash = hashCode(key,i,this.hashMethod);
        }
        //add value
        this.hashTable[hash] = new HashingNode(key,value);
    }


    private int hashCode(int key, int i, boolean type){
        if(type){
            return division(key,i);
        }else{
            return multiplication(key,i);
        }
    }

    private int division(int key, int i){
        //h(key) = key mod table_size 
        return (key+i) % this.size;
    }

    private int multiplication(int key, int i){
        //h(k) = floor (m * (k * c mod 1))
        //c = (sqrt(5)-1)/2 = 0.6180339887
        double c = 0.6180339887;
        return  (int)Math.floor(this.size*((key+i)*c%1));
         
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

    public int search(int key){
        //Start the timer and reset comparism
        long start = System.nanoTime();
        this.compare = 1;
        int i = 0;
        
        int hash = hashCode(key,i,this.hashMethod);
        while(this.hashTable[hash] != null){

            if(this.hashTable[hash].getKey() == key){
                this.time = System.nanoTime() - start;
                return this.hashTable[hash].getValue();
            }else{
                i = i + 1;
                hash = hashCode(key,i,this.hashMethod);
                if(hash ==hashCode(key,0,this.hashMethod)){
                    break;
                }
            }
            this.compare = this.compare + 1;

        }

        this.time = System.nanoTime() - start;
        return -1;
    }

    public long getTime(){
        return this.time;
    }

    public int getCompare(){
        return this.compare;
    }

    public int getTableSize(){
        return this.size;
    }
}
