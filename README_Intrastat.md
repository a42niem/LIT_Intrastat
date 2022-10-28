# **PLUG-IN "LIT_Intrastat"**

## 1) Processi

- 'CreateSummaryIntrastat': 
  - processo a livello di TAB
    - *Invoice_Vendor (Fattura di acquisto[FDA00])*
    - *Invoice_Customer (Fattura di Vendita[FDV00])*
  - processo a livello di INFO_WINDOW
    - *Invoice Info (Ricerca Fattura)*
- 'GenerateFileIntrastat': 
  - processo a livello di MENU
    - "Generate File Intrastat (Genera File Intrastat)"

## 2) WINDOW

- Intrastat [INT15] : TABELLA -->  'LIT_Intrastat'

## 3) TAB

- Intra summary (Riepilogo Intrastat) : TABELLA --> 'LIT_InvoiceIntrastat'
  - *Invoice_Vendor (Fattura di acquisto[FDA00])* > ***Intra summary (Riepilogo Intrastat)***
  - *Invoice_Customer (Fattura di Vendita[FDV00])* > ***Intra summary (Riepilogo Intrastat)***