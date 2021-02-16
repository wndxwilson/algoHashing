import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class MainApp {
	public static void main(String[] args) throws FileNotFoundException {
		// params
		int begin = 1;
		int end = 5;

		double load_factor = 1;
		// Generate dataset
		Random rand = new Random();
		List<Integer[]> dataset = new ArrayList<Integer[]>();
		for (int i = begin; i <= end; i++) {
			Integer[] list = { i*5, rand.nextInt(500) };
			dataset.add(list);
		}
		

		//Create Hashing(load_factor,max_list_size,hashin_type)
		Hashing h = new Hashing(load_factor,dataset.size(),false);

		//add node
		for(Integer[] data : dataset)
		{
			h.addNode(data[0],data[1]);
		}

		//Print out the hash map for debug purpose
		//h.printNode();

		//search , -1 if not found
		int x = h.search(20);
		System.out.println(x);
	}
}
	