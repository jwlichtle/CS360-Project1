public class sortItAllOut {
	static boolean passesArg,sortArg,DOBsort = false;
	static int passes=1;
	static int[] qAssign = null;
	static int[] qCompare = null;
	static int[] rAssign = null;
	static int[] rCompare = null;
	
	public void readArgs(String[] args){
		int args_length=0;
		for(String string:args)
			args_length++;
		
		for(int x=0;x<args_length;x++) {
			switch(args[x]) {
				case("-n"): 
				case("-N"): 
					try {
						passes = Integer.parseInt(args[x+1]);
						if(passes<1){
							System.out.println("Make sure you have a positive integer argument after '-n'.");
							System.exit(1);
						}
					}
					catch(Exception e) {
						System.out.println("Make sure you have a positive integer argument after '-n'.");
						System.exit(1);
						return;
						
					}
					qAssign=new int[passes];
					qCompare=new int[passes];
					rAssign=new int[passes];
					rCompare=new int[passes];
					passesArg=true;
					break;
				case("-b"):
				case("-B"): 
					if(!sortArg){		//checks that both -b and -s are not entered
						sortArg=true;
						DOBsort=true;
					}
					else {
						System.out.println("It appears you entered two sort-by arguments. Please try again with the correct arguments.");
						System.exit(1);
					}
					break;
				case("-s"):
				case("-S"):
					if(!sortArg){		//checks that both -b and -s are not entered
						sortArg=true;
						DOBsort=false;
					}
					else {
						System.out.println("It appears you entered two sort-by arguments. Please try again with the correct arguments.");
						System.exit(1);
					}
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		sortItAllOut s = new sortItAllOut();
		readFile rf = new readFile();
		Person[] A = rf.read();;
		
		if(A!=null) {
			s.readArgs(args);
		
			if(sortArg && passesArg) {    //verifies that the correct arguments were passed in
				QuickSort q = new QuickSort();
				RadixSort r = new RadixSort();
				int length=0;
				for(Person prsn:A)
					length++;
				if(length>=passes) {
					int cnt=0;
					for(int x=1;x<=passes;x++) {		//calls QuickSort for each of the passes through the array
						int c=(length/passes)*x;
						if(x==passes) q.printQuicksort(q.Quicksort(A, 0, length-1,DOBsort));	
						else q.Quicksort(A,0,c-1,DOBsort);
						qAssign[cnt]=q.getAssign();
						qCompare[cnt]=q.getCompare();
						cnt++;
						q.clearCounts();
						A=rf.read();
					}
					q.printCompVals(qAssign, qCompare);
					
					if(DOBsort){							//checks if sorting by DOB or SSN
						cnt=0;
						for(int x=1;x<=passes;x++) {		//calls RadixSort for each of the passes through the array
							int c=(length/passes)*x;
							if(x==passes) r.printRadixSort(r.DOBRadixSort(A,length));	
							else r.DOBRadixSort(A, c);
							rAssign[cnt]=r.getAssign();
							rCompare[cnt]=r.getCompare();
							cnt++;
							r.clearCounts();
							A=rf.read();
						}
						r.printCompVals(rAssign, rCompare);
					}		
					else {
						cnt=0;
						for(int x=1;x<=passes;x++) {		//calls RadixSort for each of the passes through the array
							int c=(length/passes)*x;
							if(x==passes) r.printRadixSort(r.SSNRadixSort(A,length));
							else r.SSNRadixSort(A, c);
							rAssign[cnt]=r.getAssign();
							rCompare[cnt]=r.getCompare();
							cnt++;
							r.clearCounts();
							A=rf.read();
						}
						r.printCompVals(rAssign, rCompare);
					}
					
				}
		
			}
				
		}
	}
		
}


