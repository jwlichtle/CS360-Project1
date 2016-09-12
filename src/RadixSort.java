public class RadixSort {
	int assign,compare = 0;

	public Person[] DOBRadixSort(Person[] Ain, int stop) {
		Person B[] = new Person[stop]; 
		int Bits[] = new int[stop];
		int C[] = new int[10];
		boolean lastB=true;
		for(int x=10;x<=100000000;x*=10){			//loops through every bit of DOB for counting sort
			for(int l=0;l<stop;l++){	//sets an integer array with the DOB bit values
				assign++;
				if(lastB) Bits[l]=((Ain[l].getDOB()%x)-(Ain[l].getDOB()%(x/10)))/(x/10); //gets one digit at a time from the DOB for counting sort
				else Bits[l]=((B[l].getDOB()%x)-(B[l].getDOB()%(x/10)))/(x/10); //gets one digit at a time from the DOB for counting sort
			}
			for(int i=0; i<10; i++) {				//sets auxiliary array to  0 
				assign++;
				C[i]=0;
			}
			for(int j=0; j<stop;j++){			//adds 1 to C for each instance of a value in Bit
				assign++;
				C[Bits[j]]++;
			}
			for(int i=1; i<10; i++){				//sets C to the running total of positions
				assign++;
				C[i]+=C[i-1];
			}
			for(int j=stop-1; j>=0; j--){
				assign+=2;
				if(lastB) B[C[Bits[j]]-1]=Ain[j];
				else Ain[C[Bits[j]]-1]=B[j];
				C[Bits[j]]--;
			}
			lastB=!lastB;
		}
		if(lastB) return Ain;
		else return B;
	}
	public Person[] SSNRadixSort(Person[] Ain, int stop) {
		Person B[] = new Person[stop]; 
		int Bits[] = new int[stop];
		int C[] = new int[10];
		boolean lastB=true;
		for(int x=10;x<=1000000000;x*=10){			//loops through every bit of SSN for counting sort
			for(int l=0;l<stop;l++){	//sets an integer array with the SSN bit values
				assign++;
				if(lastB) Bits[l]=(Ain[l].getSSN()%x-Ain[l].getSSN()%(x/10))/(x/10); //gets one digit at a time from the SSN for counting sort
				else Bits[l]=(B[l].getSSN()%x-B[l].getSSN()%(x/10))/(x/10); //gets one digit at a time from the SSN for counting sort
			}
			for(int i=0; i<10; i++) {				//sets auxiliary array to  0 
				assign++;
				C[i]=0;
			}
			for(int j=0; j<stop;j++){			//adds 1 to C for each instance of a value in Bit
				assign++;
				C[Bits[j]]++;
			}
			for(int i=1; i<10; i++){				//sets C to the running total of positions
				assign++;
				C[i]+=C[i-1];
			}
			for(int j=stop-1; j>=0; j--){
				assign+=2;
				if(lastB) B[C[Bits[j]]-1]=Ain[j];
				else Ain[C[Bits[j]]-1]=B[j];
				C[Bits[j]]--;
			}
			lastB=!lastB;
		}
		if(lastB) return Ain;
		else return B;
	}

	public void printRadixSort(Person[] qs) {
		System.out.println("\n\n\n * Radix Sort\n - Sorted Array\n");
		String ssn, dob;
		for(Person x: qs) {
			System.out.print(x.getName()+" ");
			ssn=Integer.toString(x.getSSN());
			System.out.print(ssn.substring(0,3)+"-"+ssn.substring(3, 5)+"-"+ssn.substring(5));
			System.out.print(" DOB:");
			dob=Integer.toString(x.getDOB());
			if(dob.length()==7)
				System.out.print("0"+dob.substring(0,1)+"/"+dob.substring(1,3)+"/"+dob.substring(3)+"\n");
			else
				System.out.print(dob.substring(0,2)+"/"+dob.substring(2,4)+"/"+dob.substring(4)+"\n");
		}
	}
	public void printCompVals(int[] a,int[] c) {
		System.out.print("\n - Assignments\n");
		for(int as:a) {
			System.out.print(Integer.toString(as)+" ");
		}
		System.out.print("\n - Comparisons\n");
		for(int co:c) {
			System.out.print(Integer.toString(co)+" ");
		}
		System.out.print("\n\n");
	}
	
	
	
	public int getAssign(){
		return assign;
	}
	public int getCompare(){

		return compare;
	}
	public void clearCounts(){
		assign=0;
		compare=0;
	}
	

}
