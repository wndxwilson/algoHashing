public class HashingNode {

    private int key;
    private int value;
    HashingNode(int key,int value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){
        return this.key;
    }

    public int getValue(){
        return this.value;
    }

    public void updateValue(int value){
        this.value = value;
    }
}
