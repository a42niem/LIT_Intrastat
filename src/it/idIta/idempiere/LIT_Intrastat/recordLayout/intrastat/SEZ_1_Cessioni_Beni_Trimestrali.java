package it.idIta.idempiere.LIT_Intrastat.recordLayout.intrastat;

import com.ancientprogramming.fixedformat4j.annotation.Align;
import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.Record;

@Record(length = 75, paddingChar = ' ')
public class SEZ_1_Cessioni_Beni_Trimestrali {
	
	private String  codeState_acquirente;
	private String  codIVA_acquirente;
	private Integer amtOperazioni;
	private String  codNaturaTransazione;
	private Integer codNCM;
	
	@Field(offset = 29, length = 2)
	public String getCodeState() {
		return codeState_acquirente;
	}
	public void setCodeState(String codeState) {
		this.codeState_acquirente = codeState;
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

}
