package it.idIta.idempiere.LIT_Intrastat.process;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MBPartner;
import org.compiere.model.MOrg;
import org.compiere.model.MOrgInfo;
import org.compiere.process.SvrProcess;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;

import com.ancientprogramming.fixedformat4j.format.FixedFormatManager;
import com.ancientprogramming.fixedformat4j.format.impl.FixedFormatManagerImpl;

import it.idIta.idempiere.LIT_Intrastat.Type_Enum;
import it.idIta.idempiere.LIT_Intrastat.recordLayout.intrastat.FixedPart;
import it.idIta.idempiere.LIT_Intrastat.recordLayout.intrastat.HeadRecord;
import it.idIta.idempiere.LIT_Intrastat.recordLayout.intrastat.Header;
import it.idIta.idempiere.LIT_Intrastat.recordLayout.intrastat.SEZ_1_Acquisti_Beni_Mensili;
import it.idIta.idempiere.LIT_Intrastat.recordLayout.intrastat.SEZ_1_Acquisti_Beni_Trimestrali;
import it.idIta.idempiere.LIT_Intrastat.recordLayout.intrastat.SEZ_1_Cessioni_Beni_Mensili;
import it.idIta.idempiere.LIT_Intrastat.recordLayout.intrastat.SEZ_1_Cessioni_Beni_Trimestrali;


public class Gen_Intrastat implements FixedLength_gen {
	
	private FileWriter fw = null;
	private static FixedFormatManager ffmanager = new FixedFormatManagerImpl();
	private static char[] eol = {'\r','\n'};
	
	private int recordCount = 0;
	
	private String p_sql;
	private String p_periodicita;
	private Timestamp p_dateFrom;
	private Timestamp p_dateTo;
	private int p_vatJournal_ID;
	
	private MOrg m_Org = null;
	private MOrgInfo m_OrgInfo = null;
	private Properties m_ctx = null;
	private SvrProcess m_serverProcess = null;
	
	private File fileRecords = null;
	
	private FixedPart m_fixed_part;
	
	private TreeMap<Integer, String> recLayout = null;
	private int indexTree = 0;
	//Acquisti
	private BigDecimal totAmtSEZ_1A = BigDecimal.ZERO;
	private BigDecimal totAmtSEZ_2A = BigDecimal.ZERO;
	private BigDecimal totAmtSEZ_3A = BigDecimal.ZERO;
	private BigDecimal totAmtSEZ_4A = BigDecimal.ZERO;
	
	private int      progRigaSEZ_1A = 0;
	private int      progRigaSEZ_2A = 0;
	private int      progRigaSEZ_3A = 0;
	private int      progRigaSEZ_4A = 0;
	
	//Cessioni
	private BigDecimal totAmtSEZ_1C = BigDecimal.ZERO;
	private BigDecimal totAmtSEZ_2C = BigDecimal.ZERO;
	private BigDecimal totAmtSEZ_3C = BigDecimal.ZERO;
	private BigDecimal totAmtSEZ_4C = BigDecimal.ZERO;
	
	private int      progRigaSEZ_1C = 0;
	private int      progRigaSEZ_2C = 0;
	private int      progRigaSEZ_3C = 0;
	private int      progRigaSEZ_4C = 0;
	
	
	/**	Logger							*/
	protected CLogger log = CLogger.getCLogger (getClass());
	

	public Gen_Intrastat(SvrProcess svrProc, Properties a_ctx, String sql, MOrgInfo orgInfo, String periodicita, Timestamp dateFrom, Timestamp dateTo, int vatJournal_ID) {
		m_ctx = a_ctx;
		m_serverProcess = svrProc;
		
		//m_Org = new MOrg(m_ctx, Env.getAD_Org_ID(m_ctx), null);
		//m_Org = new MOrg(m_ctx, Env.getAD_Client_ID(m_ctx), null);
		m_OrgInfo = orgInfo;
		
		p_sql = sql;
		p_periodicita = periodicita;
		p_dateFrom = dateFrom;
		p_dateTo   = dateTo;
		p_vatJournal_ID = vatJournal_ID;
		
		recLayout = new TreeMap<Integer, String>();
	}
	
	
	@Override
	public int writeHeader(String a_file, int progr) throws Exception {
		
		//File file = null;
		String ad_language = Env.getAD_Language(Env.getCtx());
		String strLog = "";
		try
		{
			fileRecords = new File(a_file);
			//  Must be a file
			if (fileRecords.isDirectory())
			{
				log.log(Level.WARNING, Msg.getMsg(m_ctx, "FileDir", true) + fileRecords.getAbsolutePath());
				throw new Exception(Msg.getMsg(m_ctx, "FileDir", true) + fileRecords.getAbsolutePath());
				//return 0;
			}
						
			if (fileRecords.exists())
				fileRecords.delete();
			
			fileRecords.createNewFile();
				
		}
		catch (Exception e)
		{
			log.log(Level.WARNING, Msg.getMsg(m_ctx, "FileCannotCreate", true)  + fileRecords.getAbsolutePath(), e);
			throw new Exception(Msg.getMsg(m_ctx, "FileCannotCreate", true) + fileRecords.getAbsolutePath());
		}
		
//		try
//		{
			fw = new FileWriter(fileRecords);
			m_fixed_part = new FixedPart();
			
			//per p.iva con zeri davanti
			DecimalFormat df = new DecimalFormat("00");
			
			//LIT_C_BPartnerINTRA_ID
			MBPartner bpTrasmitt = MBPartner.get(m_ctx, m_OrgInfo.get_ValueAsInt("LIT_C_BPartnerINTRA_ID"));
			if(bpTrasmitt==null || bpTrasmitt.getTaxID()==null || bpTrasmitt.getTaxID().isEmpty()) {
				if(ad_language.equals("it_IT"))
					strLog = "Controllare che il soggetto delegato dell'invio sia valorizzato nella maschera Informazioni Organizzazione "
							+ "e/o che abbia la P.IVA valorizzata";
				else
					strLog = "Check that the person delegated for sending is entered in the Organization Information form and / or that the VAT number is entered";
				throw new AdempiereException(strLog);
			}
			Number numb = df.parse(bpTrasmitt.getTaxID());
			BigInteger numIva = new BigInteger(numb.toString());
			//
			m_fixed_part.setpIva(numIva.toString());
			m_fixed_part.setRifElenco(progr);
			m_fixed_part.setTipoRecord(0);
			m_fixed_part.setProgRiga(0);
			
//			fw.write(ffmanager.export(m_fixed_part));
			

//		}
//		catch (Exception e)
//		{
//			log.log(Level.SEVERE, Msg.getMsg(m_ctx, "FileWriteError", true) , e);
//			throw new Exception(Msg.getMsg(m_ctx, "FileWriteError", true));
//		}
		
		
		return 0;
	}

	@Override
	public int writeTail() {
		return 0;
	}

	@Override
	public int writeRecord() throws Exception {
		
		writeCessioni();
		writeAcquisti(); 
		
		//At the end
		recordCount = 1;
		if(recLayout.get(1)!=null && !recLayout.get(1).isEmpty())
			recordCount = recordCount + ((recLayout.get(1).split(";")).length);
		if(recLayout.get(2)!=null && !recLayout.get(2).isEmpty())
			recordCount = recordCount + ((recLayout.get(2).split(";")).length);
		if(recLayout.get(3)!=null && !recLayout.get(3).isEmpty())
			recordCount = recordCount + ((recLayout.get(3).split(";")).length);
		if(recLayout.get(4)!=null && !recLayout.get(4).isEmpty())
			recordCount = recordCount + ((recLayout.get(4).split(";")).length);

		

		createHeadRecord(fileRecords.getAbsolutePath());
		
		writeALLRecordFile((recLayout.get(0)==null)?"":recLayout.get(0));
		writeALLRecordFile((recLayout.get(1)==null)?"":recLayout.get(1));
		writeALLRecordFile((recLayout.get(2)==null)?"":recLayout.get(2));
		writeALLRecordFile((recLayout.get(3)==null)?"":recLayout.get(3));
		writeALLRecordFile((recLayout.get(4)==null)?"":recLayout.get(4));
		
		
		fw.flush();
		fw.close();
		
		
		
		return 0;
	}
	
	public void createHeadRecord(String a_file)throws Exception{
		
		HeadRecord headRecord = new HeadRecord();
		File file  =  new File(a_file);
		
		headRecord.setCodUA(m_OrgInfo.get_ValueAsString("LIT_CodeUA").trim());
		headRecord.setNomeFlusso(file.getName());
		headRecord.setSezioneDoganale(14100);//TODO
		
		DecimalFormat df = new DecimalFormat("00");
		MBPartner bpTrasmitt = MBPartner.get(m_ctx, m_OrgInfo.get_ValueAsInt("LIT_C_BPartnerINTRA_ID"));
//		Number numb = df.parse(bpTrasmitt.getTaxID());
//		BigInteger numIva = new BigInteger(numb.toString());
		headRecord.setpIvaCFRichiedente(bpTrasmitt.getTaxID());//Riferimento di chi trasmette il flusso: l'obbligato o delegato
		headRecord.setProgressivoSedeUtente(1);
		headRecord.setNumeroRecord(recordCount+1);
		
		
		try
		{
			fw.write(ffmanager.export(headRecord));

			fw.write(eol);
			

		}catch (Exception e)
		{
			log.log(Level.SEVERE, Msg.getMsg(m_ctx, "FileWriteError", true) , e);
			throw new Exception(Msg.getMsg(m_ctx, "FileWriteError", true));
		}
		
		
	}
	

	//INTRA 1 bis
	private void writeCessioni()  throws Exception{
		String ad_language = Env.getAD_Language(Env.getCtx());
		String strLog = "";
		
		FixedPart fix = m_fixed_part;
		
		fix.setTipoRecord(1);
		//fix.setProgRiga(1);
		int progRiga = 1;
		
		String strALL = "";
		
		List<List<Object>> result = DB.getSQLArrayObjectsEx(null, p_sql, m_OrgInfo.getAD_Org_ID(), "Y", "Y", p_dateFrom, p_dateTo, p_vatJournal_ID/*, "%41%"*/); // art. 41 per cessioni......
		String countryCode="";
		String codeState = "";
		String pIvaAcquirente="";
		String tmpPiva = "";
		BigDecimal totalAmt= BigDecimal.ZERO;
		Integer codNomenclaturaCombinata;
		
		if(result!=null && !result.isEmpty()){
			
			SEZ_1_Cessioni_Beni_Mensili cesBeniMensili = null;
			//Periodo mensile
			if(p_periodicita.equals(Type_Enum.PERIODICITA_Mensile.stm())){
				
				for (List<Object> record : result) {
					strALL = "";
					//Se bpartner della fattura non ha una P.IVA valorizzata, by passo la scrittura e mando segnalazione
					if((record).get(8)==null) {
						MBPartner bpartner = new MBPartner(m_ctx, ((BigDecimal)(record).get(4)).intValue(), null);
						if(ad_language.equals("it_IT"))
							strLog = " : BPartner sprovvisto di partiva IVA; le sue fatture non vengono conteggiate nell'INTRA";
						else
							strLog = " : BPartner without VAT number; your invoices are not counted in the INTRA";
						m_serverProcess.addLog(bpartner.getName()+ strLog);
						return;
					}
					else
						pIvaAcquirente = (record).get(8).toString();
					//
					codeState = (String)(record).get(10);
					cesBeniMensili = new SEZ_1_Cessioni_Beni_Mensili();
					cesBeniMensili.setCodeState(codeState);
					if(pIvaAcquirente.contains(codeState))
						pIvaAcquirente = pIvaAcquirente.replace(codeState, "");
					cesBeniMensili.setCodIVA_acquirente(pIvaAcquirente);

					totalAmt = ((BigDecimal)(record).get(11)).setScale(0, RoundingMode.HALF_UP);
					cesBeniMensili.setAmtOperazioni(totalAmt.intValue());
					totAmtSEZ_1C = totAmtSEZ_1C.add(totalAmt);

					cesBeniMensili.setCodNaturaTransazione((record).get(13).toString());

					//Intra value possibile a NULL
					if((record).get(14)==null){
						if(ad_language.equals("it_IT"))
							strLog = "Sono presenti prodotti SENZA codice Intra. Verificare.";
						else
							strLog = "There are products WITHOUT Intra code. To verify.";
						m_serverProcess.addLog(strLog);
						cesBeniMensili.setCodNCM(0);
					}
					else{
						codNomenclaturaCombinata = Integer.parseInt((record).get(14).toString());
						cesBeniMensili.setCodNCM(codNomenclaturaCombinata);
					}
					//

					BigDecimal massa = (BigDecimal)(record).get(12);
					if(massa.compareTo(BigDecimal.ZERO)==0) {
						if(ad_language.equals("it_IT"))
							strLog = "Un prodotto ha un peso pari a '0'. Verificare.";
						else
							strLog = "A product has a weight of '0'. To verify.";
						throw new AdempiereException(strLog);
					}
					cesBeniMensili.setMassaNettaKG(massa.intValue());
					cesBeniMensili.setUnitaSuppl(((BigDecimal)(record).get(15)).intValue());
					cesBeniMensili.setValStatEur(0);
//					cesBeniMensili.setCodCondizioniConsegna((record).get(16).toString());  TOLTO non serve, vedi documentazione
					cesBeniMensili.setCodStateDest(codeState);

					String codeCountryOrig = "";
					if(m_OrgInfo.getM_Warehouse_ID()>0)
						codeCountryOrig = m_OrgInfo.getM_Warehouse().getC_Location().getC_Region().getName();
					else
						codeCountryOrig = m_OrgInfo.getC_Location().getC_Region().getName();
					cesBeniMensili.setCodProvinciaOrigMerce(codeCountryOrig);

					fix.setProgRiga(progRiga);
					createCessione(fix, cesBeniMensili);
					progRigaSEZ_1C = progRiga;
					
					progRiga++;
				}
			}
			//Periodo trimestrale
			else if (p_periodicita.equals(Type_Enum.PERIODICITA_Trimestrale.stm())){
				SEZ_1_Cessioni_Beni_Trimestrali cesBeniTrimestr = new SEZ_1_Cessioni_Beni_Trimestrali();
				countryCode = ((List<Object>)result.get(0)).get(10).toString();
				cesBeniTrimestr.setCodeState(countryCode);
				
				pIvaAcquirente = ((List<Object>)result.get(0)).get(8).toString();
				cesBeniTrimestr.setCodIVA_acquirente(pIvaAcquirente);
				
				totalAmt = ((BigDecimal)((List<Object>)result.get(0)).get(11)).setScale(0, RoundingMode.HALF_UP);
				cesBeniTrimestr.setAmtOperazioni(totalAmt.intValue());
				totAmtSEZ_1C = totAmtSEZ_1C.add(totalAmt);
				
				cesBeniTrimestr.setCodNaturaTransazione(((List<Object>)result.get(0)).get(13).toString());
				
				codNomenclaturaCombinata = (Integer)((List<Object>)result.get(0)).get(14);
				cesBeniTrimestr.setCodNCM(codNomenclaturaCombinata);
				
				
				//checkAddRecord(1, (ffmanager.export(m_fixed_part) + ffmanager.export(cesBeniTrimestr)));

			}
			String frontespizio = setFrontespizio(Type_Enum.TIPORIEPILOGO_Cessioni.stm(), "Y")+ ";";
			strALL = (recLayout.get(0)==null)?"":recLayout.get(0);
			strALL = strALL+frontespizio;
			recLayout.put(0, strALL);
			strALL = "";
		}
	
		
	}
	
	private void createCessione(FixedPart fix, SEZ_1_Cessioni_Beni_Mensili cesBeniMensili) {
		String tmpStr = null;
		String strALL = "";
		int indTypeCessioni = 1;
		
		tmpStr = (ffmanager.export(fix).trim());
		tmpStr = tmpStr + (ffmanager.export(cesBeniMensili).trim()) + ";";
		//
		strALL = (recLayout.get(indTypeCessioni)==null)?"":recLayout.get(indTypeCessioni);
		strALL = strALL+tmpStr;
		recLayout.put(indTypeCessioni, strALL);
		strALL = "";
	}

	private void writeAcquisti() throws Exception{
		String ad_language = Env.getAD_Language(Env.getCtx());
		String strLog = "";
		FixedPart fix = m_fixed_part;
		
		fix.setTipoRecord(1);
		//fix.setProgRiga(1);
		int progRiga = 1;
		
		String strALL = "";
		
		List<List<Object>> result = DB.getSQLArrayObjectsEx(null, p_sql, m_OrgInfo.getAD_Org_ID(), "N", "I", p_dateFrom, p_dateTo, p_vatJournal_ID/*, "%41%"*/); // art. 41 per cessioni......
		String countryCode="";
		String codeState = "";
		String pIvaFornitore="";
		String tmpPiva = "";
		BigDecimal totalAmt= BigDecimal.ZERO;
		Integer codNomenclaturaCombinata;
		
		if(result!=null && !result.isEmpty()){
			SEZ_1_Acquisti_Beni_Mensili acqBeniMensili = null;
			//Periodo mensile
			if(p_periodicita.equals(Type_Enum.PERIODICITA_Mensile.stm())){
				for (List<Object> record : result) {
					//Se bpartner della fattura non ha una P.IVA valorizzata, by passo la scrittura e mando segnalazione
					if((record).get(8)==null) {
						MBPartner bpartner = new MBPartner(m_ctx, ((BigDecimal)(record).get(4)).intValue(), null);
						if(ad_language.equals("it_IT"))
							strLog = " : BPartner sprovvisto di partiva IVA; le sue fatture non vengono conteggiate nell'INTRA";
						else
							strLog = " : BPartner without VAT number; your invoices are not counted in the INTRA";
						m_serverProcess.addLog(bpartner.getName()+ strLog);
						return;
					}
					else
						pIvaFornitore = (record).get(8).toString();
					//
					codeState = (String)(record).get(10);
					acqBeniMensili = new SEZ_1_Acquisti_Beni_Mensili();
					acqBeniMensili.setCodeState(codeState);
					if(pIvaFornitore.contains(codeState))
						pIvaFornitore = pIvaFornitore.replace(codeState, "");
					acqBeniMensili.setCodIVA_fornitore(pIvaFornitore);
					
					totalAmt = ((BigDecimal)(record).get(11)).setScale(0, RoundingMode.HALF_UP);
					acqBeniMensili.setAmtOperazioniEuro(totalAmt.intValue());
					//acqBeniMensili.setAmtOperazioniValuta(totalAmt.intValue()); TODO valuta estera??
					totAmtSEZ_1A = totAmtSEZ_1A.add(totalAmt);
					
					acqBeniMensili.setCodNaturaTransazione((record).get(13).toString());
					
					//Intra value possibile a NULL
					if((record).get(14)==null){
						if(ad_language.equals("it_IT"))
							strLog = "Sono presenti prodotti SENZA codice Intra. Verificare.";
						else
							strLog = "There are products WITHOUT Intra code. To verify.";
						m_serverProcess.addLog(strLog);
						acqBeniMensili.setCodNCM(0);
					}
					else{
						codNomenclaturaCombinata = Integer.parseInt((record).get(14).toString());
						acqBeniMensili.setCodNCM(codNomenclaturaCombinata);
					}
					//
					
					BigDecimal massa = (BigDecimal)(record).get(12);
					if(massa.compareTo(BigDecimal.ZERO)==0) {
						if(ad_language.equals("it_IT"))
							strLog = "Un prodotto ha un peso pari a '0'. Verificare.";
						else
							strLog = "A product has a weight of '0'. To verify.";
						throw new AdempiereException(strLog);
					}
					acqBeniMensili.setMassaNettaKG(massa.intValue());
					acqBeniMensili.setQtaUnitaSuppl(((BigDecimal)(record).get(15)).intValue());
					acqBeniMensili.setValStatEur(0);
					//acqBeniMensili.setCodCondizioniConsegna((record).get(16).toString()); TODO ? TOLTO non serve, vedi documentazione
					//acqBeniMensili.setCodModoTrasporto(codModoTrasporto); TODO ?
					//acqBeniMensili.setCodStateProvenienza(""); TODO ?
					//acqBeniMensili.setCodStateOrigine(""); TODO ?  
					
					
					String codeCountryDest = "";
					/*if(m_OrgInfo.getM_Warehouse_ID()>0)
						codeCountryOrig = m_OrgInfo.getM_Warehouse().getC_Location().getC_Region().getName();
					else
						codeCountryOrig = m_OrgInfo.getC_Location().getC_Region().getName();
					*/
					acqBeniMensili.setCodProvinciaDestMerce(codeCountryDest); 
					
					fix.setProgRiga(progRiga);
					createAcquisto(fix, acqBeniMensili);
					progRigaSEZ_1A = progRiga;
					
					progRiga++;
				}
			}
			//Periodo trimestrale
			else if (p_periodicita.equals(Type_Enum.PERIODICITA_Trimestrale.stm())){
				SEZ_1_Acquisti_Beni_Trimestrali acqBeniTrimestr = new SEZ_1_Acquisti_Beni_Trimestrali();
				countryCode = ((List<Object>)result.get(0)).get(10).toString();
				acqBeniTrimestr.setCodeState(countryCode);
				
				pIvaFornitore = ((List<Object>)result.get(0)).get(8).toString();
				acqBeniTrimestr.setCodIVA_fornitore(pIvaFornitore);
				
				totalAmt = ((BigDecimal)((List<Object>)result.get(0)).get(11)).setScale(0, RoundingMode.HALF_UP);
				acqBeniTrimestr.setAmtOperazioniEuro(totalAmt.intValue());
				//acqBeniMensili.setAmtOperazioniValuta(totalAmt.intValue()); TODO valuta estera??
				
				acqBeniTrimestr.setCodNaturaTransazione(((List<Object>)result.get(0)).get(13).toString());
				
				codNomenclaturaCombinata = (Integer)((List<Object>)result.get(0)).get(14);
				acqBeniTrimestr.setCodNCM(codNomenclaturaCombinata);
				
				fix.setProgRiga(progRiga);
				createAcquisto(fix, acqBeniMensili);
				progRigaSEZ_1A = progRiga;
				
				progRiga++;
			}
			String frontespizio = setFrontespizio(Type_Enum.TIPORIEPILOGO_Acquisti.stm(), "N")+ ";";
			strALL = (recLayout.get(0)==null)?"":recLayout.get(0);
			strALL = strALL+frontespizio;
			recLayout.put(0, strALL);
			strALL = "";
		}
	}
	private void createAcquisto(FixedPart fix, SEZ_1_Acquisti_Beni_Mensili acqBeniMensili) {
		String tmpStr = null;
		String strALL = "";
		int indTypeAcquisti = 1;
		
		tmpStr = (ffmanager.export(fix).trim());
		tmpStr = tmpStr + (ffmanager.export(acqBeniMensili).trim()) + ";";
		//
		strALL = (recLayout.get(indTypeAcquisti)==null)?"":recLayout.get(indTypeAcquisti);
		strALL = strALL+tmpStr;
		recLayout.put(indTypeAcquisti, strALL);
		strALL = "";
	}
	
	private String setFrontespizio(String tipoRiepilogo, String isSOTrx) throws Exception {
		
		FixedPart fix = m_fixed_part;
		fix.setTipoRecord(0);
		fix.setProgRiga(0);
		
		String frontespizio = "";
		 
		//List<Object> listResult = null;
		Header header = new Header();
		header.setTipoRiepilogo(/*Type_Enum.TIPORIEPILOGO_Cessioni.stm()*/tipoRiepilogo);

		LocalDate localDate = p_dateFrom.toLocalDateTime().toLocalDate();//For reference
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
		String formattedString = localDate.format(formatter);
		header.setAnno(Integer.parseInt(formattedString));
		header.setPeriodicita(p_periodicita);

		if(p_periodicita.equals(Type_Enum.PERIODICITA_Mensile.stm())){
			header.setPeriodo(p_dateFrom.toLocalDateTime().getMonthValue());

		}else if (p_periodicita.equals(Type_Enum.PERIODICITA_Trimestrale.stm())){

			int month = p_dateFrom.toLocalDateTime().getMonthValue();//TODO
			int quarter = 1;

			if (month <= 3) {
				quarter = 1;
			} else if (month <= 6) {
				quarter = 2;
			} else if (month <= 9) {
				quarter = 3;
			} else {
				quarter = 4;
			}
			header.setPeriodo(quarter);

		}
		header.setContenutoElenchi(Type_Enum.ContenutoElenchi_0.getNumb());
		//per p.iva con zeri davanti
		DecimalFormat df = new DecimalFormat("00");
		Number numb = df.parse(m_OrgInfo.get_ValueAsString("TaxID"));
		BigInteger numIva = new BigInteger(numb.toString());
		//
		header.setpIvaSoggettoObbligato(numIva.toString());

		header.setCasiParticolari(Type_Enum.CasiParticolari_0.getNumb());
		header.setpIvaSoggettoDelegato("0");

		//sez_1 beni...
		header.setNumRigSEZ_1((isSOTrx.equals("Y")?progRigaSEZ_1C:progRigaSEZ_1A));
		header.setAmtSEZ_1((isSOTrx.equals("Y")?totAmtSEZ_1C.intValue():totAmtSEZ_1A.intValue()));
		
//			header.setNumRigSEZ_2(0);
//			header.setAmtSEZ_2("0"); //può essere importo negativo, vedi Nota allegato punto 17 pagina 4
		
		//sez_3 servizi
		header.setNumRigSEZ_3((isSOTrx.equals("Y")?progRigaSEZ_3C:progRigaSEZ_3A));
		header.setAmtSEZ_3((isSOTrx.equals("Y")?totAmtSEZ_3C.intValue():totAmtSEZ_3A.intValue()));
		
//			header.setNumRigSEZ_4(0);
//			header.setAmtSEZ_4(0);

		//checkAddRecord(0, (ffmanager.export(m_fixed_part) + ffmanager.export(header)));
		frontespizio = (ffmanager.export(fix)).trim();
		frontespizio = frontespizio + (ffmanager.export(header).trim());
		
		return frontespizio;
		
	}
	
	private void writeALLRecordFile(String strExtr)throws Exception{
		
		if(strExtr.isEmpty())
			return;
		String arrayStr[]  = strExtr.split(";");
		for (String string : arrayStr) {
			try
			{
				fw.write(string);
				fw.write(eol);
			}catch (Exception e)
			{
				log.log(Level.SEVERE, Msg.getMsg(m_ctx, "FileWriteError", true) , e);
				throw new Exception(Msg.getMsg(m_ctx, "FileWriteError", true));
			}
		}
	}
}
