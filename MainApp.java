import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {
	public static void main(String[] args) throws FileNotFoundException {
		// params
		List<Double> load_factor = Arrays.asList(0.25, 0.5, 0.75, 1.0);
		long avgTime = 0;
		int avgCompare = 0;

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
			e.printStackTrace();
		}
		try {
			csvReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		records.remove(0);
	
		//Test with successful cases with 10127 key in hashtable, with different hashmethod and load factor
		for(int i = 0;i<2;i++){

			for (Double loadfactor : load_factor){
				//Create Hashing(load_factor,max_list_size,hashin_type)
				//true - Division hash method
				Hashing h = new Hashing(loadfactor,records.size(),(i==0));

				//add data into hashtable
				for(String[] data : records)
				{
					h.addNode(Integer.parseInt(data[0]),Integer.parseInt(data[2]));
				}
				
				avgTime = 0;
				avgCompare = 0;
				//Run search test with the whole dataset
				for(String[] data : records){
					h.search(Integer.parseInt(data[0]));
					avgTime = avgTime + h.getTime();
					avgCompare = avgCompare + h.getCompare();
				}
				avgTime = avgTime / records.size();
				avgCompare = avgCompare / records.size();
				System.out.println("Table size: "+h.getTableSize()+" Load factor: "+loadfactor+" Avg time: "+avgTime+" Avg Compare: "+avgCompare+" Hash method: "+(i==0)+" Status: successful");
			}

			System.out.println("");
		}

		//Test with unsuccessful cases with 10127 key not in hashtable, with different hashmethod and load factor
		for(int i = 0;i<2;i++){

			for (Double loadfactor : load_factor){
				//Create Hashing(load_factor,max_list_size,hashin_type)
				//true - Division hash method
				Hashing h = new Hashing(loadfactor,records.size(),(i==0));

				//add data into hashtable
				for(String[] data : records)
				{
					h.addNode(Integer.parseInt(data[0]),Integer.parseInt(data[2]));
				}
				
				avgTime = 0;
				avgCompare = 0;
				//Run search test with the whole dataset
				for(int j = 0; j < 10127;j++){
					h.search(j);
					avgTime = avgTime + h.getTime();
					avgCompare = avgCompare + h.getCompare();
				}
				avgTime = avgTime / records.size();
				avgCompare = avgCompare / records.size();
				System.out.println("Table size: "+h.getTableSize()+" Load factor: "+loadfactor+" Avg time: "+avgTime+" Avg Compare: "+avgCompare+" Hash method: "+(i==0)+" Status: unsuccessful");
			}

			System.out.println("");
		}
	
	}
}
	