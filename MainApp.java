import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainApp {
	public static void main(String[] args) throws FileNotFoundException {
		// params
		int begin = 50;
		int end = 1000;

		double load_factor = 0.5;
		int a[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		// Generate dataset
		Random rand = new Random();
		List<Integer[]> dataset = new ArrayList<Integer[]>();
		for (int i = begin; i <= end; i++) {
			Integer[] list = { i+90123400, rand.nextInt(500) };
			dataset.add(list);
		}
		
		List<String[]> records = new ArrayList<>();
		String row;
		BufferedReader csvReader = new BufferedReader(new FileReader("BankChurners.csv"));
		try {
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(",");
				// do something with the data
				records.add(data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		records.remove(0);
	
		//Create Hashing(load_factor,max_list_size,hashin_type)
		Hashing h = new Hashing(load_factor,records.size(),false);

			//add node
			for(String[] data : records)
			{
				h.addNode(Integer.parseInt(data[0]),Integer.parseInt(data[2]));
			}

		//search , -1 if not found
		int x = h.search(20);
		if(x == -1){
			System.out.println("Not found");
		}
		//Create Hashing(load_factor,max_list_size,hashin_type)
		Hashing h2 = new Hashing(load_factor,records.size(),true);

		//add node
		for(String[] data : records)
		{
			h2.addNode(Integer.parseInt(data[0]),Integer.parseInt(data[2]));
		}

		//Print out the hash map for debug purpose
		//h.printNode();

		//search , -1 if not found
		x = h2.search(0);
		if(x == -1){
			System.out.println("Not found");
		}
	
	}
}
	