package it.idIta.idempiere.LIT_Intrastat;

public enum Type_Enum {
	TIPORIEPILOGO_Acquisti("A"),
	TIPORIEPILOGO_Cessioni("C"),
	PERIODICITA_Mensile("M"),
	PERIODICITA_Trimestrale("T"),
	ContenutoElenchi_0(0),
	ContenutoElenchi_8(8),
	ContenutoElenchi_9(0),
	CasiParticolari_7(7),
	CasiParticolari_8(8),
	CasiParticolari_9(9),
	CasiParticolari_0(0);
	
	
	private String str;
	private int  num;
	
	Type_Enum(String text){
		this.str = text;
	}
	
	public String stm(){
		return str;
	}
	
	Type_Enum(int number){
		this.num = number;
	}
	
	public int getNumb(){
		return num;
	}
}
