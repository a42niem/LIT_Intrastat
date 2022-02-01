package it.idIta.idempiere.LIT_Intrastat.recordLayout.intrastat;

import com.ancientprogramming.fixedformat4j.annotation.Align;
import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.Record;

@Record(length = 90, paddingChar = ' ')
public class SEZ_1_Acquisti_Beni_Mensili {
	
	private String  codeState;
	private String  codIVA_fornitore;
	private Integer amtOperazioniEuro;
	private Integer amtOperazioniValuta;
	private String  codNaturaTransazione;
	private Integer codNCM;
	private Integer massaNettaKG;
	private Integer qtaUnitaSuppl;
	private Integer valStatEur;
	private String  codCondizioniConsegna;
	private Integer codModoTrasporto;
	private String  codStateProvenienza;
	private String  codStateOrigine;
	private String  codProvinciaDestMerce;
	
	@Field(offset = 29, length = 2)
	public String getCodeState() {
		return codeState;
	}
	public void setCodeState(String codeState) {
		this.codeState = codeState;
	}
	
	@Field(offset = 31, length = 12)
	public String getCodIVA_fornitore() {
		return codIVA_fornitore;
	}
	public void setCodIVA_fornitore(String codIVA_fornitore) {
		this.codIVA_fornitore = codIVA_fornitore;
	}
	
	@Field(offset = 43, length = 13, align = Align.RIGHT, paddingChar = '0')
	public Integer getAmtOperazioniEuro() {
		return amtOperazioniEuro;
	}
	public void setAmtOperazioniEuro(Integer amtOperazioniEuro) {
		this.amtOperazioniEuro = amtOperazioniEuro;
	}

	@Field(offset = 56, length = 13, align = Align.RIGHT, paddingChar = '0')
	public Integer getAmtOperazioniValuta() {
		return amtOperazioniValuta;
	}
	public void setAmtOperazioniValuta(Integer amtOperazioniValuta) {
		this.amtOperazioniValuta = amtOperazioniValuta;
	}
	
	@Field(offset = 69, length = 1)
	public String getCodNaturaTransazione() {
		return codNaturaTransazione;
	}
	public void setCodNaturaTransazione(String codNaturaTransazione) {
		this.codNaturaTransazione = codNaturaTransazione;
	}
	
	@Field(offset = 70, length = 8, align = Align.RIGHT, paddingChar = '0')
	public Integer getCodNCM() {
		return codNCM;
	}
	public void setCodNCM(Integer codNCM) {
		this.codNCM = codNCM;
	}
	
	@Field(offset = 78, length = 10, align = Align.RIGHT, paddingChar = '0')
	public Integer getMassaNettaKG() {
		return massaNettaKG;
	}
	public void setMassaNettaKG(Integer massaNettaKG) {
		this.massaNettaKG = massaNettaKG;
	}
	
	@Field(offset = 88, length = 10, align = Align.RIGHT, paddingChar = '0')
	public Integer getQtaUnitaSuppl() {
		return qtaUnitaSuppl;
	}
	public void setQtaUnitaSuppl(Integer qtaUnitaSuppl) {
		this.qtaUnitaSuppl = qtaUnitaSuppl;
	}
	
	@Field(offset = 98, length = 13, align = Align.RIGHT, paddingChar = '0')
	public Integer getValStatEur() {
		return valStatEur;
	}
	public void setValStatEur(Integer valStatEur) {
		this.valStatEur = valStatEur;
	}
	
	@Field(offset = 111, length = 1)
	public String getCodCondizioniConsegna() {
		return codCondizioniConsegna;
	}
	public void setCodCondizioniConsegna(String codCondizioniConsegna) {
		this.codCondizioniConsegna = codCondizioniConsegna;
	}
	
	@Field(offset = 112, length = 1, align = Align.RIGHT, paddingChar = '0')
	public Integer getCodModoTrasporto() {
		return codModoTrasporto;
	}
	public void setCodModoTrasporto(Integer codModoTrasporto) {
		this.codModoTrasporto = codModoTrasporto;
	}
	
	@Field(offset = 113, length = 2)
	public String getCodStateProvenienza() {
		return codStateProvenienza;
	}
	public void setCodStateProvenienza(String codStateProvenienza) {
		this.codStateProvenienza = codStateProvenienza;
	}
	
	@Field(offset = 115, length = 2)
	public String getCodStateOrigine() {
		return codStateOrigine;
	}
	public void setCodStateOrigine(String codStateOrigine) {
		this.codStateOrigine = codStateOrigine;
	}
	
	@Field(offset = 117, length = 2)
	public String getCodProvinciaDestMerce() {
		return codProvinciaDestMerce;
	}
	public void setCodProvinciaDestMerce(String codProvinciaDestMerce) {
		this.codProvinciaDestMerce = codProvinciaDestMerce;
	}
	
	
}
