package it.idIta.idempiere.LIT_Intrastat.recordLayout.intrastat;

import com.ancientprogramming.fixedformat4j.annotation.Align;
import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.Record;

@Record(length = 58, paddingChar = ' ')
public class SEZ_3_Cessioni_Servizi {
	
	private String  codeState_acquirente;
	private String  codIVA_acquirente;
	private Integer amtOperazioni;
	private String  numeroFattura;
	private String  dataFattura;
	private Integer codiceServizio;
	private String  modErogazione;
	private String  modIncasso;
	private String  codeState_pagam;
	
	@Field(offset = 29, length = 2)
	public String getCodeState_acquirente() {
		return codeState_acquirente;
	}
	public void setCodeState_acquirente(String codeState_acquirente) {
		this.codeState_acquirente = codeState_acquirente;
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
	
	@Field(offset = 56, length = 15)
	public String getNumeroFattura() {
		return numeroFattura;
	}
	public void setNumeroFattura(String numeroFattura) {
		this.numeroFattura = numeroFattura;
	}
	
	@Field(offset = 71, length = 6)
	public String getDataFattura() {
		return dataFattura;
	}
	public void setDataFattura(String dataFattura) {
		this.dataFattura = dataFattura;
	}
	
	@Field(offset = 77, length = 6, align = Align.RIGHT, paddingChar = '0')
	public Integer getCodiceServizio() {
		return codiceServizio;
	}
	public void setCodiceServizio(Integer codiceServizio) {
		this.codiceServizio = codiceServizio;
	}
	
	@Field(offset = 83, length = 1)
	public String getModErogazione() {
		return modErogazione;
	}
	public void setModErogazione(String modErogazione) {
		this.modErogazione = modErogazione;
	}
	
	@Field(offset = 84, length = 1)
	public String getModIncasso() {
		return modIncasso;
	}
	public void setModIncasso(String modIncasso) {
		this.modIncasso = modIncasso;
	}
	
	@Field(offset = 85, length = 2)
	public String getCodeState_pagam() {
		return codeState_pagam;
	}
	public void setCodeState_pagam(String codeState_pagam) {
		this.codeState_pagam = codeState_pagam;
	}
	
}
