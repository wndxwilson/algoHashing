public class HashingNode {

    private int key;
    private String value;
    HashingNode(int key,String value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){
        return this.key;
    }

    public String getValue(){
        return this.value;
    }

    public void updateValue(String value){
        this.value = value;
    }
}
