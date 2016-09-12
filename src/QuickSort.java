
public class QuickSort {
	int assign,compare = 0;
	
	//the extra boolean parameter for this method determines to sort by DOB or SSN
	public Person [] Quicksort(Person[] P,int p, int r, boolean sortByDOB) {
		int q;
		compare++;
		if(p<r) {
			assign++;
			q= Partition(P,p,r,sortByDOB);
			Quicksort(P,p,q-1,sortByDOB);
			Quicksort(P,q+1,r,sortByDOB);
		}
		return P;
	}
	//the extra boolean parameter for this method determines to sort by DOB or SSN
	public int Partition(Person[] P,int p, int r, boolean sortByDOB) {
		int x, i;
		Person temp;
		if(sortByDOB) x=P[r].getDOB();
		else x=P[r].getSSN();
		i=p-1;
		assign+=2;
		for(int j=p;j<r;j++) {
			compare++;
	
			if (sortByDOB&&P[j].getDOB()<=x || !sortByDOB&&P[j].getSSN()<=x) {	
				i=i+1;
				temp=P[i];
				P[i]=P[j];
				P[j]=temp;
				assign+=4;
			}
		}
		temp=P[i+1];
		P[i+1]=P[r];
		P[r]=temp;
		assign++;
		return i+1;
	}
		
	public void printQuicksort(Person[] qs) {
		System.out.println(" * Quicksort\n - Sorted Array\n");
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
	public void printCompVals(int[] a, int[] c) {
		System.out.print("\n - Assignments\n");
		for(int as:a) {
			System.out.print(Integer.toString(as)+" ");
		}
		System.out.print("\n - Comparisons\n");
		for(int co:c) {
			System.out.print(Integer.toString(co)+" ");
		}
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
