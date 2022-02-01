package it.idIta.idempiere.LIT_Intrastat.recordLayout.intrastat;

import com.ancientprogramming.fixedformat4j.annotation.Align;
import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.Record;

@Record(length = 71, paddingChar = ' ')
public class SEZ_3_Acquisti_Servizi {
	
	private String  codeState;
	private String  codIVA_fornitore;
	private Integer amtOperazioniEuro;
	private Integer amtOperazioniValuta;
	private String  numeroFattura;
	private String  dataFattura;
	private Integer codiceServizio;
	private String  modErogazione;
	private String  modIncasso;
	private String  codeState_pagam;
	
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
	
	@Field(offset = 69, length = 15)
	public String getNumeroFattura() {
		return numeroFattura;
	}
	public void setNumeroFattura(String numeroFattura) {
		this.numeroFattura = numeroFattura;
	}
	
	@Field(offset = 84, length = 6)
	public String getDataFattura() {
		return dataFattura;
	}
	public void setDataFattura(String dataFattura) {
		this.dataFattura = dataFattura;
	}
	
	@Field(offset = 90, length = 6, align = Align.RIGHT, paddingChar = '0')
	public Integer getCodiceServizio() {
		return codiceServizio;
	}
	public void setCodiceServizio(Integer codiceServizio) {
		this.codiceServizio = codiceServizio;
	}
	
	@Field(offset = 96, length = 1)
	public String getModErogazione() {
		return modErogazione;
	}
	public void setModErogazione(String modErogazione) {
		this.modErogazione = modErogazione;
	}
	
	@Field(offset = 97, length = 1)
	public String getModIncasso() {
		return modIncasso;
	}
	public void setModIncasso(String modIncasso) {
		this.modIncasso = modIncasso;
	}
	
	@Field(offset = 98, length = 2)
	public String getCodeState_pagam() {
		return codeState_pagam;
	}
	public void setCodeState_pagam(String codeState_pagam) {
		this.codeState_pagam = codeState_pagam;
	}
			
}
