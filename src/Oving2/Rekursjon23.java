package Oving2;

public class Rekursjon23 {

	private static double RekursjonAvansert(double x, int n){
		if (n == 0) return 1;
		if ((n % 2) == 0) return RekursjonAvansert((x*x), (n / 2));
		else return x*RekursjonAvansert((x*x), ((n-1) / 2));
	}
	
	private static int YtelseRekursjonAvansert(double x, int n, int testrunder){
		int runder = 0;
		long start = System.currentTimeMillis();
		long tidsbruk = 0;
		long slutt;
		int resultat;
		do {
			resultat = (int) RekursjonAvansert(x, n);
			slutt = System.currentTimeMillis();
			runder++;
			tidsbruk += (slutt - start);
		} while(tidsbruk < testrunder);
		double tid = (double) (tidsbruk / runder);
		System.out.println("Millisekund pr. runde (rekursjon): "+ tid);
		return resultat;
	}
	
	private static int YtelseMathPow(double x, int n, int testrunder){
		int runder = 0;
		long start = System.currentTimeMillis();
		long tidsbruk = 0;
		long slutt;
		int resultat;
		do {
			resultat = (int) Math.pow(x, n);
			slutt = System.currentTimeMillis();
			runder++;
			tidsbruk += (slutt - start);
		} while(tidsbruk < testrunder);
		double tid = (double) (tidsbruk / runder);
		System.out.println("Millisekund pr. runde (Math.pow): "+ tid);
		return resultat;
	}
	
	public static void main(String[] args){
		double x = 1.01;
		int n = 10000;
		int testrunder = 100000;
		System.out.println("Resultat: "+YtelseRekursjonAvansert(x, n, testrunder));
		System.out.println("Resultat: "+YtelseMathPow(x, n, testrunder));
	}
}
