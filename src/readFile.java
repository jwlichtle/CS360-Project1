import java.io.BufferedReader;
import java.io.FileReader;


public class readFile {
	public readFile(){
	}
	
	public Person[] read() {
		Person Ain[] = null;
		int size, cntr;
		String s = "";
		String d = "";
		String csvFile = "personnel.csv";
		//add JFileChooser above
		BufferedReader br = null;
		String line = "";

		try {
			
			br = new BufferedReader(new FileReader(csvFile));
			
			if((line = br.readLine()) != null){
				size = Integer.parseInt(line.substring(0, line.indexOf(",")));
				Ain = new Person[size];
				for(int x=0;x<size;x++){
					Ain[x]= new Person();
			}
			}
			cntr=0;
			while ((line = br.readLine()) != null) { 
				Ain[cntr].setName(line.substring(0,line.indexOf(",")));
				d = line.substring(line.indexOf(",")+1, line.lastIndexOf(","));
				Ain[cntr].setDOB(Integer.parseInt(d));
				s=line.substring(line.lastIndexOf(",")+1, line.indexOf("-"));
				s+=line.substring(line.indexOf("-")+1, line.lastIndexOf("-"));
				s+=line.substring(line.lastIndexOf("-")+1, line.length());
				Ain[cntr].setSSN(Integer.parseInt(s));
				
				
				cntr++;
			}
		} 
		catch (Exception e) {
			System.out.println("Read file error");
			System.exit(1);
		} 
		finally {
			if (br != null) {
				try {
					br.close();
				} 
				catch (Exception e) {
					System.out.println("Read file error");
					System.exit(1);	
				}
			}
		}
		return Ain;
	}
}
