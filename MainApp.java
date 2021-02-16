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
		int begin = 1;
		int end = 100;

		double load_factor = 0.5;

		// Generate dataset
		Random rand = new Random();
		List<Integer[]> dataset = new ArrayList<Integer[]>();
		for (int i = begin; i <= end; i++) {
			Integer[] list = { i, rand.nextInt(500) };
			dataset.add(list);
		}

		List<String[]> records = new ArrayList<>();

		BufferedReader csvReader = new BufferedReader(new FileReader("dataset.csv"));
		String row;
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
		records.remove(0);


		//Create Hashing(load_factor,max_list_size,hashin_type)
		Hashing h = new Hashing(load_factor,records.size(),true);

		//add node
		for(String[] data : records)
		{
			h.addNode(Integer.parseInt(data[0]),data[1]);
		}

		//Print out the hash map for debug purpose
		//h.printNode();

		//search , -1 if not found
		String x = h.search(0);
		System.out.println(x);
	}
}
	