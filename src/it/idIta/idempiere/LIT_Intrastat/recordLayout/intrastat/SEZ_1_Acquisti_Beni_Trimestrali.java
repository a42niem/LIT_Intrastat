package it.idIta.idempiere.LIT_Intrastat.recordLayout.intrastat;

import com.ancientprogramming.fixedformat4j.annotation.Align;
import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.Record;

@Record(length = 49, paddingChar = ' ')
public class SEZ_1_Acquisti_Beni_Trimestrali {
	
	private String  codeState;
	private String  codIVA_fornitore;
	private Integer amtOperazioniEuro;
	private Integer amtOperazioniValuta;
	private String  codNaturaTransazione;
	private Integer codNCM;
	
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
	
}
