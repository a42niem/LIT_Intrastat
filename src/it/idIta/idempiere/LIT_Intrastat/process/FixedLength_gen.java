package it.idIta.idempiere.LIT_Intrastat.process;

public interface FixedLength_gen {
	
	public abstract int writeHeader(String a_file, int progr)throws Exception;;
	
	public abstract int writeTail();
	
	public abstract int writeRecord()throws Exception;
	
	public abstract void createHeadRecord(String a_file)throws Exception;

}
