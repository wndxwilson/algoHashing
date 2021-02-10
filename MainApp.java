public class MainApp
{
	public static void main(String[] args)
	{
		//Create Hashing(load_factor,max_list_size)
		Hashing h = new Hashing(0.5,5);

		//add node
		h.addNode(1,2);
		h.addNode(2,6);
		h.addNode(3,4);
		h.addNode(4,4);
		h.addNode(5,4);

		//Print out the hash map
		h.printNode();

		//search , -1 if not found
		int x = h.search(1);
		System.out.println(x);
	}
}