package Oving5;

public class Names {
	private int length = 4;
	private String[] name = new String[length];
	
	/**
	 * Constructor for names with only forname and surname
	 * 
	 * @param forname
	 * @param surname
	 */
	public Names(String forname, String surname){
		this.name[0] = forname;
		this.name[1] = null;
		this.name[2] = null;
		this.name[3] = surname;
	}
	
	
	/**
	 * Constructor for names with forname, one middlename and surname
	 * 
	 * @param forname
	 * @param middlename
	 * @param surname
	 */
	public Names(String forname, String middlename, String surname){
		this.name[0] = forname;
		this.name[1] = middlename;
		this.name[2] = null;
		this.name[3] = surname;
	}
	
	/**
	 * Constructor for names with forname, two middlenames and surname
	 * 
	 * @param forname
	 * @param middlename
	 * @param surname
	 * @param secondmiddlename
	 */
	public Names(String forname, String middlename, String surname, String secondmiddlename){
		this.name[0] = forname;
		this.name[1] = middlename;
		this.name[2] = secondmiddlename;
		this.name[3] = surname;
	}
	
	public int getHashCode(){
		return hash1();
	}
	
	private int hash1(){
		if (name[1] == null){
			return h1(this.name[0].charAt(0))+h1(this.name[3].charAt(0));
		}
		if (name[1] != null && name[2] == null){
			return (h1(this.name[0].charAt(0))+h1(this.name[1].charAt(0))+h1(this.name[3].charAt(0)));
		}
		else{
			return (h1(this.name[0].charAt(0))+h1(this.name[1].charAt(0))+h1(this.name[2].charAt(0))+h1(this.name[3].charAt(0)));
		}
	}
	
	private int h1(int key){
		return key % 43;
	}
	
	public String toString(){
		if (name[1] == null) return this.name[0]+" "+this.name[3];
		if (name[2] == null) return this.name[0]+" "+this.name[1]+" "+this.name[3];
		else return this.name[0]+" "+this.name[1]+" "+this.name[2]+" "+this.name[3];
	}
	
	public boolean equals(Object obj){
		Names otherName = (Names) obj;
		if (this.name[1] == null){
			return (this.name[0].equals(otherName.name[0]) && this.name[3].equals(otherName.name[3]));
		}
		if (this.name[2] == null){
			return (this.name[0].equals(otherName.name[0]) && this.name[1].equals(otherName.name[1]) && this.name[3].equals(otherName.name[3]));
		}
		else{
			return (this.name[0].equals(otherName.name[0]) && this.name[1].equals(otherName.name[1]) && this.name[2].equals(otherName.name[2]) && this.name[3].equals(otherName.name[3]));
		}
	}
}
