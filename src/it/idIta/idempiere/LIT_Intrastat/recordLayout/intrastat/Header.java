package it.idIta.idempiere.LIT_Intrastat.recordLayout.intrastat;

import java.math.BigInteger;

import com.ancientprogramming.fixedformat4j.annotation.Align;
import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.Record;

@Record(length = 102, paddingChar = ' ')
public class Header {

	private String tipoRiepilogo;
	private int anno;
	private String periodicita;
	private int periodo;
	private String pIvaSoggettoObbligato;
	private int contenutoElenchi;
	private int casiParticolari;
	private String pIvaSoggettoDelegato;
	private int numRigSEZ_1;
	private int amtSEZ_1;
	private int numRigSEZ_2;
	private String amtSEZ_2; //TODO può essere importo negativo
	private int numRigSEZ_3;
	private int amtSEZ_3;
	private int numRigSEZ_4;
	private int amtSEZ_4;

	@Field(offset = 29, length = 1)
	public String getTipoRiepilogo() {
		return tipoRiepilogo;
	}
	public void setTipoRiepilogo(String tipoRiepilogo) {
		this.tipoRiepilogo = tipoRiepilogo;
	}

	@Field(offset = 30, length = 2, align = Align.RIGHT, paddingChar = '0')
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	@Field(offset = 32, length = 1)
	public String getPeriodicita() {
		return periodicita;
	}
	public void setPeriodicita(String periodicita) {
		this.periodicita = periodicita;
	}

	@Field(offset = 33, length = 2, align = Align.RIGHT, paddingChar = '0')
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	@Field(offset = 35, length = 11, align = Align.RIGHT, paddingChar = '0')
	public String getpIvaSoggettoObbligato() {
		return pIvaSoggettoObbligato;
	}
	public void setpIvaSoggettoObbligato(String pIvaSoggettoObbligato) {
		this.pIvaSoggettoObbligato = pIvaSoggettoObbligato;
	}

	@Field(offset = 46, length = 1, align = Align.RIGHT, paddingChar = '0')
	public int getContenutoElenchi() {
		return contenutoElenchi;
	}
	public void setContenutoElenchi(int contenutoElenchi) {
		this.contenutoElenchi = contenutoElenchi;
	}

	@Field(offset = 47, length = 1, align = Align.RIGHT, paddingChar = '0')
	public int getCasiParticolari() {
		return casiParticolari;
	}
	public void setCasiParticolari(int casiParticolari) {
		this.casiParticolari = casiParticolari;
	}

	@Field(offset = 48, length = 11, align = Align.RIGHT, paddingChar = '0')
	public String getpIvaSoggettoDelegato() {
		return pIvaSoggettoDelegato;
	}
	public void setpIvaSoggettoDelegato(String pIvaSoggettoDelegato) {
		this.pIvaSoggettoDelegato = pIvaSoggettoDelegato;
	}

	@Field(offset = 59, length = 5, align = Align.RIGHT, paddingChar = '0')
	public int getNumRigSEZ_1() {
		return numRigSEZ_1;
	}
	public void setNumRigSEZ_1(int numRigSEZ_1) {
		this.numRigSEZ_1 = numRigSEZ_1;
	}

	@Field(offset = 64, length = 13, align = Align.RIGHT, paddingChar = '0')
	public int getAmtSEZ_1() {
		return amtSEZ_1;
	}
	public void setAmtSEZ_1(int amtSEZ_1) {
		this.amtSEZ_1 = amtSEZ_1;
	}

	@Field(offset = 77, length = 5, align = Align.RIGHT, paddingChar = '0')
	public int getNumRigSEZ_2() {
		return numRigSEZ_2;
	}
	public void setNumRigSEZ_2(int numRigSEZ_2) {
		this.numRigSEZ_2 = numRigSEZ_2;
	}

	@Field(offset = 82, length = 13, align = Align.RIGHT, paddingChar = '0')
	public String getAmtSEZ_2() {
		return amtSEZ_2;
	}
	public void setAmtSEZ_2(String amtSEZ_2) {
		this.amtSEZ_2 = amtSEZ_2;
	}
	@Field(offset = 95, length = 5, align = Align.RIGHT, paddingChar = '0')
	public int getNumRigSEZ_3() {
		return numRigSEZ_3;
	}
	public void setNumRigSEZ_3(int numRigSEZ_3) {
		this.numRigSEZ_3 = numRigSEZ_3;
	}

	@Field(offset = 100, length = 13, align = Align.RIGHT, paddingChar = '0')
	public int getAmtSEZ_3() {
		return amtSEZ_3;
	}
	public void setAmtSEZ_3(int amtSEZ_3) {
		this.amtSEZ_3 = amtSEZ_3;
	}

	@Field(offset = 113, length = 5, align = Align.RIGHT, paddingChar = '0')
	public int getNumRigSEZ_4() {
		return numRigSEZ_4;
	}
	public void setNumRigSEZ_4(int numRigSEZ_4) {
		this.numRigSEZ_4 = numRigSEZ_4;
	}

	@Field(offset = 118, length = 13, align = Align.RIGHT, paddingChar = '0')
	public int getAmtSEZ_4() {
		return amtSEZ_4;
	}
	public void setAmtSEZ_4(int amtSEZ_4) {
		this.amtSEZ_4 = amtSEZ_4;
	}


}
