package Oving5;

public class Names {
	private String forname = "";
	private String middlename = "";
	private String secondmiddlename = "";
	private String surname = "";
	
	public Names(String forname, String surname){
		this.forname = forname;
		this.surname = surname;
	}
	
	public Names(String forname, String middlename, String surname){
		this.forname = forname;
		this.middlename = middlename;
		this.surname = surname;
	}
	
	public Names(String forname, String middlename, String surname, String secondmiddlename){
		this.forname = forname;
		this.middlename = middlename;
		this.surname = surname;
		this.secondmiddlename = secondmiddlename;
	}
	
	public int getHashCode(){
		return hash() % 10;
	}
	
	private int hash(){
		if (middlename == "") return (forname.charAt(0)+surname.charAt(0));
		if (middlename != "" && secondmiddlename == "") return (forname.charAt(0)+middlename.charAt(0)+surname.charAt(0));
		else return (forname.charAt(0)+middlename.charAt(0)+secondmiddlename.charAt(0)+surname.charAt(0));
	}
	
	public String toString(){
		if (middlename == "") return this.forname+" "+this.surname;
		if (middlename != "" && secondmiddlename == "") return this.forname+" "+this.middlename+" "+this.surname;
		else return this.forname+" "+this.middlename+" "+this.secondmiddlename+" "+this.surname;
	}
}
