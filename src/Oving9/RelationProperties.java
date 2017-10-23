package Oving9;

class RelationProperties {
    /*
     * Assuming that a two column array containing the relation and a one column          * array containing the set the relation is on is given in each method. 
     * No checks are performed.
     */

    public static boolean isReflexive(char[][] relation, char [] set){
	return false;
    }

    public static boolean isSymmetric(char[][] relation, char [] set){
	return false;
    }

    public static boolean isTransitive(char[][] relation, char [] set){
	return false;
    }

    public static boolean isAntiSymmetric(char[][] relation, char [] set){
	return false;
    }

    public static boolean isEquivalenceRelation(char[][] relation, char [] set){
	return false;
    }

    public static boolean isPartialOrder(char[][] relation, char [] set){
	return false;
    }

    public static void main(String[] args) {
	char[] setA = {'a','x','r','m','2','0'};
	char[][] rel1 = {{'a','a'},{'r','a'},{'a','2'},{'x','x'},
					{'r','2'},{'r','r'},{'m','m'},{'2','r'},
					{'0','0'},{'a','r'},{'2','2'},{'2','a'}};
	char[][] rel2 = {{'a','x'},{'r','2'},{'0','0'},{'m','2'}};
	System.out.println("Rel1 is reflexive: " + isReflexive(rel1, setA));
	System.out.println("Rel2 is reflexive: " + isReflexive(rel2, setA));
	System.out.println("Rel1 is symmetric: " + isSymmetric(rel1, setA));
	System.out.println("Rel2 is symmetric: " + isSymmetric(rel2, setA));
	System.out.println("Rel1 is transitive: " + isTransitive(rel1, setA));
	System.out.println("Rel2 is transitive: " + isTransitive(rel2, setA));
	System.out.println("Rel1 is antisymmetric: " + isAntiSymmetric(rel1, setA));
	System.out.println("Rel2 is antisymmetric: " + isAntiSymmetric(rel2, setA));
	System.out.println("Rel1 is an equivalence relation: " + isEquivalenceRelation(rel1, setA));
	System.out.println("Rel2 is an equivalence relation: " + isEquivalenceRelation(rel2, setA));
	System.out.println("Rel1 is a partial order: " + isPartialOrder(rel1, setA));
	System.out.println("Rel2 is a partial order: " + isPartialOrder(rel2, setA));
	/* skal gi følgende utskrift:
	   Rel1 is reflexive: true
	   Rel2 is reflexive: false
	   Rel1 is symmetric: true
	   Rel2 is symmetric: false
	   Rel1 is transitive: true
	   Rel2 is transitive: true
	   Rel1 is antisymmetric: false
	   Rel2 is antisymmetric: true
	   Rel1 is an equivalence relation: true
	   Rel2 is an equivalence relation: false
	   Rel1 is a partial order: false
	   Rel2 is a partial order: false
	 */
    }


}
