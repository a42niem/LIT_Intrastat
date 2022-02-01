package it.idIta.idempiere.LIT_Intrastat.recordLayout.intrastat;

import com.ancientprogramming.fixedformat4j.annotation.Align;
import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.Record;

@Record(length = 75, paddingChar = ' ')
public class SEZ_1_Cessioni_Beni_Mensili {
	
	private String  codeState;
	private String  codIVA_acquirente;
	private Integer amtOperazioni;
	private String  codNaturaTransazione;
	private Integer codNCM;
	private Integer massaNettaKG;
	private Integer unitaSuppl;
	private Integer valStatEur;
	private String  codCondizioniConsegna;
	private Integer codModoTrasporto;
	private String  codStateDest;
	private String  codProvinciaOrigMerce;
	
	@Field(offset = 29, length = 2)
	public String getCodeState() {
		return codeState;
	}
	public void setCodeState(String codeState) {
		this.codeState = codeState;
	}
	
	@Field(offset = 31, length = 12)
	public String getCodIVA_acquirente() {
		return codIVA_acquirente;
	}
	public void setCodIVA_acquirente(String codIVA_acquirente) {
		this.codIVA_acquirente = codIVA_acquirente;
	}
	
	@Field(offset = 43, length = 13, align = Align.RIGHT, paddingChar = '0')
	public Integer getAmtOperazioni() {
		return amtOperazioni;
	}
	public void setAmtOperazioni(Integer amtOperazioni) {
		this.amtOperazioni = amtOperazioni;
	}
	
	@Field(offset = 56, length = 1)
	public String getCodNaturaTransazione() {
		return codNaturaTransazione;
	}
	public void setCodNaturaTransazione(String codNaturaTransazione) {
		this.codNaturaTransazione = codNaturaTransazione;
	}
	
	@Field(offset = 57, length = 8, align = Align.RIGHT, paddingChar = '0')
	public Integer getCodNCM() {
		return codNCM;
	}
	public void setCodNCM(Integer codNCM) {
		this.codNCM = codNCM;
	}
	
	@Field(offset = 65, length = 10, align = Align.RIGHT, paddingChar = '0')
	public Integer getMassaNettaKG() {
		return massaNettaKG;
	}
	public void setMassaNettaKG(Integer massaNettaKG) {
		this.massaNettaKG = massaNettaKG;
	}
	
	@Field(offset = 75, length = 10, align = Align.RIGHT, paddingChar = '0')
	public Integer getUnitaSuppl() {
		return unitaSuppl;
	}
	public void setUnitaSuppl(Integer unitaSuppl) {
		this.unitaSuppl = unitaSuppl;
	}
	
	@Field(offset = 85, length = 13, align = Align.RIGHT, paddingChar = '0')
	public Integer getValStatEur() {
		return valStatEur;
	}
	public void setValStatEur(Integer valStatEur) {
		this.valStatEur = valStatEur;
	}
	
	@Field(offset = 98, length = 1)
	public String getCodCondizioniConsegna() {
		return codCondizioniConsegna;
	}
	public void setCodCondizioniConsegna(String codCondizioniConsegna) {
		this.codCondizioniConsegna = codCondizioniConsegna;
	}
	
	@Field(offset = 99, length = 1, align = Align.RIGHT, paddingChar = '0')
	public Integer getCodModoTrasporto() {
		return codModoTrasporto;
	}
	public void setCodModoTrasporto(Integer codModoTrasporto) {
		this.codModoTrasporto = codModoTrasporto;
	}
	
	@Field(offset = 100, length = 2)
	public String getCodStateDest() {
		return codStateDest;
	}
	public void setCodStateDest(String codStateDest) {
		this.codStateDest = codStateDest;
	}
	
	@Field(offset = 102, length = 2)
	public String getCodProvinciaOrigMerce() {
		return codProvinciaOrigMerce;
	}
	public void setCodProvinciaOrigMerce(String codProvinciaOrigMerce) {
		this.codProvinciaOrigMerce = codProvinciaOrigMerce;
	}
	
}
