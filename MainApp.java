import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
	public static void main(String[] args) throws FileNotFoundException {
		// params
		double load_factor = 0.75;


		// Generate dataset	
		List<String[]> records = new ArrayList<>();
		String row;

		//Load csv file
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
		//true - linear
		Hashing h = new Hashing(load_factor,records.size(),true);

		//add data into hashtable
		for(String[] data : records)
		{
			h.addNode(Integer.parseInt(data[0]),Integer.parseInt(data[2]));
		}
		
		//Create Hashing(load_factor,max_list_size,hashin_type)
		//false - double
		Hashing h2 = new Hashing(load_factor,records.size(),false);

		//add data into hashtable
		for(String[] data : records)
		{
			h2.addNode(Integer.parseInt(data[0]),Integer.parseInt(data[2]));
		}

		int result = h.searchValue(714337233);
		//int result = h2.searchValue();
		System.out.println("Age: "+result);

		/* //Uncomment to get average
		//search for every possible entry
		Integer[] value = new Integer[2];
		value[0] = 0;
		value[1] = 0;
		Integer time = 0;
		Integer compare = 0;

		for(String[] data : records){
			value[0] =  h.search(Integer.parseInt(data[0]))[0] + value[0];
			value[1] =  h.search(Integer.parseInt(data[0]))[1] + value[1];
		}
		time = value[0]/records.size();
		compare = value[1]/records.size();
		System.out.println("Average Successful time linear hash: " + time);
		System.out.println("Average Successful comparism linear hash: " + compare);
		System.out.println("");

		value[0] = 0;
		value[1] = 0;
		for(int i = 0;i<1000;i++){
			value[0] =  h.search(i)[0] + value[0];
			value[1] =  h.search(i)[1] + value[1];
		}
		time = value[0]/1000;
		compare = value[1]/1000;
		System.out.println("Average Unsuccessful time linear hash: " + time);
		System.out.println("Average Unsuccessful comparism linear hash: " + compare);
		System.out.println("");

		value[0] = 0;
		value[1] = 0;
		for(String[] data : records){
			value[0] =  h2.search(Integer.parseInt(data[0]))[0] + value[0];
			value[1] =  h2.search(Integer.parseInt(data[0]))[1] + value[1];
		}
		time = value[0]/records.size();
		compare = value[1]/records.size();
		System.out.println("Average Successful time double hash: " + time);
		System.out.println("Average Successful comparism double hash: " + compare);
		System.out.println("");

		value[0] = 0;
		value[1] = 0;
		for(int i = 0;i<1000;i++){
			value[0] =  h2.search(i)[0] + value[0];
			value[1] =  h2.search(i)[1] + value[1];
		}
		time = value[0]/1000;
		compare = value[1]/1000;
		System.out.println("Average Unsuccessful time double hash: " + time);
		System.out.println("Average Unsuccessful comparism double hash: " + compare);
		System.out.println("");
		*/
	}


}
	