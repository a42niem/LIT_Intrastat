package it.idIta.idempiere.LIT_Intrastat.recordLayout.intrastat;

import com.ancientprogramming.fixedformat4j.annotation.Align;
import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.Record;

@Record(length = 75, paddingChar = ' ')
public class HeadRecord {
	
	private String codUA;
	private String nomeFlusso;
	private int sezioneDoganale;
	private String pIvaCFRichiedente;
	private int progressivoSedeUtente;
	private int numeroRecord;
	
	@Field(offset = 1, length = 4)
	public String getCodUA() {
		return codUA;
	}
	public void setCodUA(String codUA) {
		this.codUA = codUA;
	}
	
	@Field(offset = 17, length = 12)
	public String getNomeFlusso() {
		return nomeFlusso;
	}
	public void setNomeFlusso(String nomeFlusso) {
		this.nomeFlusso = nomeFlusso;
	}
	
	@Field(offset = 41, length = 6, align = Align.RIGHT, paddingChar = '0')
	public int getSezioneDoganale() {
		return sezioneDoganale;
	}
	public void setSezioneDoganale(int sezioneDoganale) {
		this.sezioneDoganale = sezioneDoganale;
	}
	
	@Field(offset = 51, length = 16)
	public String getpIvaCFRichiedente() {
		return pIvaCFRichiedente;
	}
	public void setpIvaCFRichiedente(String pIvaCFRichiedente) {
		this.pIvaCFRichiedente = pIvaCFRichiedente;
	}
	
	@Field(offset = 67, length = 3, align = Align.RIGHT, paddingChar = '0')
	public int getProgressivoSedeUtente() {
		return progressivoSedeUtente;
	}
	public void setProgressivoSedeUtente(int progressivoSedeUtente) {
		this.progressivoSedeUtente = progressivoSedeUtente;
	}
	
	@Field(offset = 71, length = 5, align = Align.RIGHT, paddingChar = '0')
	public int getNumeroRecord() {
		return numeroRecord;
	}
	public void setNumeroRecord(int numeroRecord) {
		this.numeroRecord = numeroRecord;
	}

	

}
