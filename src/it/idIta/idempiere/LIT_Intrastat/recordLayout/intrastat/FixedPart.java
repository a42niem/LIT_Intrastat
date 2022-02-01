package it.idIta.idempiere.LIT_Intrastat.recordLayout.intrastat;

import com.ancientprogramming.fixedformat4j.annotation.Align;
import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.Record;

@Record(length = 29, paddingChar = ' ')
public class FixedPart {
	
	private String pIva;
	private int     rifElenco;
	private int     tipoRecord;
	private int     progRiga;
	
	@Field(offset = 1, length = 5)
	public String getCampoFisso()
	{
		return "EUROX";
	}

	@Field(offset = 6, length = 11, align = Align.RIGHT, paddingChar = '0')
	public String getpIva() {
		return pIva;
	}

	public void setpIva(String pIva) {
		this.pIva = pIva;
	}

	@Field(offset = 17, length = 6, align = Align.RIGHT, paddingChar = '0')
	public int getRifElenco() {
		return rifElenco;
	}

	public void setRifElenco(int rifElenco) {
		this.rifElenco = rifElenco;
	}

	@Field(offset = 23, length = 1, align = Align.RIGHT, paddingChar = '0')
	public int getTipoRecord() {
		return tipoRecord;
	}

	public void setTipoRecord(int tipoRecord) {
		this.tipoRecord = tipoRecord;
	}

	@Field(offset = 24, length = 5, align = Align.RIGHT, paddingChar = '0')
	public int getProgRiga() {
		return progRiga;
	}

	public void setProgRiga(int progRiga) {
		this.progRiga = progRiga;
	}
	
}
