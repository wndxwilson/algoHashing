public class Hashing
{
    private double loadFactor = 1;
    private int size;
    private HashingNode[] hashTable;
    private boolean hashMethod = true;

    //constructor
    Hashing(double loadFactor, int max){
        if(loadFactor <= 1){
            this.loadFactor = loadFactor;
        }
        //load factor = n/h , h = n/load factor
        this.size = (int)Math.ceil(max/this.loadFactor);
        this.hashTable = new HashingNode[this.size];
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

            return 0;
        }
    }

    private int linear(int key, int i){
        return (key+i) % this.size;
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
        int i = 0;

        int hash = hashCode(key,i,this.hashMethod);
       
        while(this.hashTable[hash] != null){
            if(this.hashTable[hash].getKey() == key){
                return  this.hashTable[hash].getValue();
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
