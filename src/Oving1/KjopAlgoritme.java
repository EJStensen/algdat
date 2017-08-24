package Oving1;

public class KjopAlgoritme {
	
	public static int[] FyllRandomTabell(int dager){
		java.util.Random ran = new java.util.Random();
		int[] output = new int[dager];
		for (int i = 0; i < output.length; i++){
			output[i] = ran.nextInt((10 - (-10)) + 1) + (-10);
		}
		return output;
	}
	
	public static void Tidsbruk(int[] AksjeEndring){
		long TotalTidsbruk = 0;	
		long StartTid = System.currentTimeMillis();
		int[] res = kjopOgSalgAksjer(AksjeEndring);
		long SluttTid = System.currentTimeMillis();
		TotalTidsbruk += (SluttTid - StartTid);
		System.out.println("Kjøper på dag "+res[0]+", selger på dag "+res[1]+", fortjeneste på "+res[2]);
		System.out.println("Total tidsbruk for algoritmen er: "+TotalTidsbruk+" millisekund\n");
	}
	
	//Generell algoritme, kompleksitet = O(n^2)
	public static int[] kjopOgSalgAksjer(int[] AksjeEndring){
		int kjopsdag = -1;
		int salgsdag = -1;
		int fortjeneste = 0;		
		int[] output = new int[3];

		for (int i = 0; i < AksjeEndring.length; i++){
			int prisforskjell = 0;
			for (int j = i; j < AksjeEndring.length; j++){
				prisforskjell += AksjeEndring[j];
				if (prisforskjell > fortjeneste){
					fortjeneste = prisforskjell;
					kjopsdag = i;
					salgsdag = j+1;
					output = new int[] {kjopsdag, salgsdag, fortjeneste};
				}
			}
		}
		//System.out.println("kjøp: "+output[0]+", salg:"+output[1]+", differanse: "+output[2]);
		return output;
	}
	
	public static void TestMedTabellFraBoka(){
		int kjopsdag = -1;
		int salgsdag = -1;
		int fortjeneste = 0;
		int[] output = new int[3];
		int[] tabell = new int[] {-1, 3, -9, 2, 2, -1, 2, -1, -5};

		for (int i = 0; i < tabell.length; i++){
			int prisforskjell = 0;
			for (int j = i; j < tabell.length; j++){
				prisforskjell += tabell[j];
				if (prisforskjell > fortjeneste){
					fortjeneste = prisforskjell;
					kjopsdag = i;
					salgsdag = j+1;
					output = new int[] {kjopsdag, salgsdag, fortjeneste};
				}
			}
		}
		System.out.println("kjøpsdag: "+output[0]+", salgsdag:"+output[1]+", fortjeneste: "+output[2]);
	}
	
	public static void main(String[] args){
		
		//TestMedTabellFraBoka();
		
		int[] VerdiEndring = FyllRandomTabell(50000);
		Tidsbruk(VerdiEndring);

		int[] VerdiEndring2 = FyllRandomTabell(100000);
		Tidsbruk(VerdiEndring2);
		
		int[] VerdiEndring3 = FyllRandomTabell(200000);
		Tidsbruk(VerdiEndring3);
	}
}