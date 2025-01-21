package com.org.demoPackage;
import org.openqa.selenium.WebDriver;

public class ActionSelector {
	

	public static void performAction(WebDriver driver, String actionName, String objectName, String testData) throws Exception {
		
		String orTemp [] = ObjectRepository.objectRepository.get(objectName).split("#");
		
		
	
		switch(actionName.toUpperCase()){

//Common cases to all test cases
		
		case "ENTER":
			Enter.Enter(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
			
		case "LOGIN":
			//System.out.println("Enterd in to login case");
			Login.login(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
			
		case "CLICK":
			Click.Click(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
			
		case "PRESS ENTER KEY":
			Enter.PressEnterKey(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
		case "PRESS DOWN ARROW":
			Enter.PressDownArrow(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
		case "WAIT":
			Wait.Wait(testData);
			break;
		case "WAIT TILL ELEMENT IS DISPLAYED":
			WaitForElement.WaitTillElementIsDisplayed(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
		case "PRESS TAB KEY":
			Enter.PressTabKey(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
		case "TYPE":
			Enter.Type(driver, testData);
			break;
		
		case "PRESS UP ARROW":
			Enter.PressUpArrow(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
			
		case "ALERTHANDLER":
			//System.out.println("inside alert");
			AlertHandler.AlertHandler(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
			
		case "SELECTELEMENT":
			selectElement.DropDownValueSelector(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
			
		case "SELECTELEMENT TWO":
			selectElement.DropDownValueSelector2(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
			
		case "ISDISPLAYED":
			IsDisplayed.IsDisplayed(driver, orTemp[0].trim());
			break;
			
		case "SCROLLDOWN":
			ScrollDown.ScrollDown(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
	    case "SWITCH TO FRAME":
			//System.out.println("inside switch to frame case");
			SwitchToFrame.Switchtoframe(driver);
			break;
	    case "SWITCH TO PARENT FRAME":
			//System.out.println("inside switch Back from frame case");
			SwitchToFrame.Switchfromframe(driver);
			break;
			
		case "SWITCH TO CHILD WINDOW":
			SwitchToChildWindow.SwitchToChild(driver,  orTemp[1].trim());
			break;
			
		case "SWITCH TO PARENT WINDOW":
			SwitchToParentWindow.SwitchToParent(driver,  orTemp[1].trim());
			break;
			
		case "FLUENT WAIT":
			DifferentTypesOfWaits.FluentWait(driver, orTemp[0].trim(), orTemp[1].trim());
			break;
			
		case "COMMON WRITE":
			ReadAndWriteIntoTxtFileForODKCC.Write(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
		
		case "ODKCC READ":
			ReadAndWriteIntoTxtFileForODKCC.Read(driver,orTemp[1].trim(), testData);
			break;
			
		case "FOR LOOP CLICK":
			DifferentTypesOfWaits.ForLoopWaitPlusClick(driver, orTemp[0].trim(), orTemp[1].trim());
			break;
			
		case "ODKCC INT POSTING WAIT PROGRESS VALUE":
			DifferentTypesOfWaits.ForLoopWaitBasedOnGetText(driver, orTemp[0].trim(), orTemp[1].trim());
			break;
			
		case "WRITE TRANSID OF OD INT POSTING":
			ReadAndWriteIntoTxtFileForODKCC.WriteODKCCIntPostingTransIDIntoTXTFile(driver, orTemp[0].trim());
			break;
		
		case "SEND KEYS FROM TXT FILE FOR TC INTERESTPOST OD":
			DifferentTypesOfWaits.ForLoopWaitPlusSendKeysFor_TC_INTERESTPOST_OD(driver, orTemp[1].trim(), testData);
			break;
			
		case "PRESS TAB KEY WITHOUT WAIT":
			DifferentTypesOfWaits.PressTabKeyWithoutWait(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
			
		case "IF ELSE CLICK":
			CommonIfElse.PreviousOverdueIfElse(driver, orTemp[0].trim(), orTemp[1].trim());
			break;
			
		case "FOR LOOP WAIT PLUS SEND KEYS WITH TEST DATA":
			DifferentTypesOfWaits.ForLoopWaitPlusSendKeysWithTestData(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
			
		case "COMMON WRITE GET ATTRIBUTE":
			ReadAndWriteIntoTxtFileForODKCC.WriteUsingGetAttribute(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
			
		case "COMMON READ AND WRITE":
			ReadAndWriteIntoTxtFileForODKCC.CommonRead(driver,orTemp[1].trim(), testData);
			break;
			
		//case "FOR LOOP WAIT PLUS SENDKEYS WITH TESTDATA":
			//DifferentTypesOfWaits.ForLoopWaitPlusSendKeysWithTestData(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			//break;
			
		case "FOR LOOP WAIT PLUS SELECT ELEMENT WITH TESTDATA":
			DifferentTypesOfWaits.ForLoopWaitPlusSelectElementWithTestData(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
			
		case "CONTROL PLUS TAB KEYS":
			Common2.CTRLTab(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
			
		case "SWITCH TABS":
			Common2.SwitchTabs(driver, orTemp[0].trim(), orTemp[1].trim());
			break;
			
		case "IF ELSE SELECT ELEMENT":
			CommonIfElse.IfElseSelect(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
		/*case "READ FROM REPOSITORY":
			WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;*/
			
		case "CONTROL PLUS DOWN ARROW":
			Common2.CTRLPlusDownArrow(driver, orTemp[0].trim(), orTemp[1].trim());
			break;
			
		case "DOUBLE CLICK":
			Click.DoubleClick(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
			
		case "GET TRANS DATE FROM TABLE AND SAVE INTO SPECIFIED FILE":
			ReadAndWriteIntoTxtFileForODKCC.GetTransDateFromTableAndSaveIntoSpecifiedFile(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
			
		case "READ ELEMENT AND SEND KEYS":
			   Common.ReadElementAndSendKeys(driver, orTemp[1].trim(), testData);
			   break;
			
//Reading Login Credentials			
		case "READ USER NAME":
			ReadUsername.ReadUsername( orTemp[1].trim());
			break;
			
		case "READ USER PASSWORD":
			ReadPassword.ReadPassword( orTemp[1].trim());
			break;	
			
		case "READ ADMIN USERNAME":
			ReadAdminUsername.getAdminUsername( orTemp[1].trim());
			break;
		case "READ ADMIN PASSWORD":
			ReadAdminPassword.getAdminPassword(orTemp[1].trim());
			break;
		case "READ CASHIER/MANAGER USERNAME":
			ReadCashierManagerUsername.getManagerCashierUsername(orTemp[1].trim());
			break;	
		case "READ CASHIER/MANAGER PASSWORD":
			ReadCashierManagerPassword.getCashierManagerPassword(orTemp[1].trim());
			break;
		case "READ CUST_ID":
			ReadCustomerID.getCustomerId(driver, orTemp[1].trim());
		 break;
		 
		case "READ SECOND CUST_ID":
			ReadCustomerID.getSecondCustomerId(driver, orTemp[1].trim());
		    break;
		    
		case "MODIFY DATE":
			DatabaseConnector.dateChanger();
			break;
		case "CALCULATE POST_AMOUNT":
			AutoPostAmountCalculator.PostAmountCalculator(driver,orTemp[1].trim());
			break;
			
//SB Account Opening Cash
		case "READ CUST_ID FOR SB":
			ReadCustomerID.getCustomerIdForSB1(driver, orTemp[1].trim());
			break;
		case "WRITE SB DETAILS_CASH MODE":
			WriteSBDetails_CashMode.writeSBOpeningDetails_CashMode(driver, orTemp[1].trim());
			break;
		case "VERIFY TEXT SB":
			VerifySB.Verify_SBOpening_CashMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
		case "FETCH SB_CASH TRANSID":
			Fetch_SB_TransID.getTransid(driver, orTemp[0].trim(), orTemp[1].trim());
			break;
//SB Account Opening Autopost
		case "READ SECOND CUST_ID FOR SB":
			ReadCustomerID.getCustomerIdForSB2(driver, orTemp[1].trim());
			break;
		case "CLICK GETVALUES":
			Common.ClickonGetValues(driver, orTemp[1].trim());
			break;
		case "GET TRANS SB ACCNO":
			CommisionCalculator.GetSBAccountNoForTransfer(driver, orTemp[1].trim());
			break;
		case "WRITE SB_TRANSFER DETAILS":
			WriteSBDetails_TransferMode.WriteSBOpeningDetails_TransferMode(driver, orTemp[1].trim());
			break;
		case "VERIFY FIELD":
			VerifySB.Verify_SBopening_TransferMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
		case "READ SB_TRAN_TRANSID":
			Read_SB_Transid.getTransid(orTemp[1].trim());
			break;
//SB Account Opening Batch
		case "WRITE SB DETAILS_BATCH":
			WriteSBDetails_Batch.writeSBOpeningDetails_Batch(driver, orTemp[1].trim());
			break;
		case "VERIFY ITEM SB":
			VerifySB.Verify_SBOpening_BatchMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
		case "GET SB-BATCH TRANID":
			GetSBTransID_batch.getTransid(orTemp[1].trim());
			break;
		case "READ AMOUNT":
			ReadAmountForSB.getAmount(orTemp[1].trim());
			break;
//CA Account Opening Cash
		case "WRITE CA DETAILS_CASH MODE":
			WriteCADetails_CASH_Mode.writeCAOpeningDetails_cash(driver,orTemp[1].trim());
			break;
		case "VERIFY SUMMARY TEXT SB":
			VerifySB.Verify_CAOpening_CashMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
		case "FETCH CA TRANID":
			GetCATransId_CashMode.getTransid(orTemp[1].trim());
			break;
//CA Account Opening Autopost
		case "WRITE CA_TRANSFER DETAILS":
			WriteCADetails_TransferMode.writeCADetails_transferMode(driver, orTemp[1].trim());
			break;
		case "VERIFY SUMMARY FIELD":
			VerifySB.Verify_CAOpening_TransferMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
		case "READ CA_TRAN_TRANSID":
			ReadCA_TRA_Transid.getCATransid(orTemp[1].trim());
			break;
//CA Account Opening Batch
		case "WRITE CA DETAILS_BATCH":
			WriteCADetails_BatchMode.writeCADetails_BatchMode(driver, orTemp[1].trim());
			break;
		case "VERIFY SUMMARY ITEM":
			VerifySB.Verify_CAOpening_BatchMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
		case "GET CA-BATCH TRANID":
			GetCATransID_batch.getTransid(orTemp[1].trim());
			break;
		case "Read CA Amount":
			ReadAmount.getAmountCA(orTemp[1].trim());
			break;
				
//FD opening in Cash mode		
		
		case "VERIFY TEXT":
			Verify.VerifySummary_FD_CashMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
		case "VERIFY VOUCHERNOS":
			VerifyFDSummaryValues.VerifyVoucherNos(driver);
			break;
		case "VERIFY TRANSIDS":	
			VerifyFDSummaryValues.VerifyTransIDs(driver);
			break;	
		case "VERIFY ACNOS":	
			VerifyFDSummaryValues.VerifyAccNos(driver);
			break;	
		case"WRITEFD_CASH":
			WriteFD_CASH.WriteFD_CASH_Details(driver, orTemp[1].trim());
			break;
		case "FETCH FD TRANSID":
			Fetch_FD_Cash_TransID.getTransid(driver, orTemp[0].trim(), orTemp[1].trim());
			break;
		case"VERIFY SUMMARY TEXT":
			Verify.VerifySummary_FD_CashMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
			
//FD account opening Auto post mode
			
	    case"WRITE FD_TRANSFER DETAILS":
	    	WriteAccountOpeningFD_TransferMode.writeAccountOpeningFDDetails_TransferMode(driver, orTemp[1].trim());
	    	break;
	    case "VERIFY TEXTFIELD":
	    	Verify.VerifySummary_FD_TransferMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
	    	break; 
	    case"READ FD-ACCOUNT TRANSID":
	    	Fetch_FD_Transfer_Transid.getTransid(orTemp[1].trim());
	    	break;

//FD account opening BATCH mode
	    	
	    	
	    case"WRITE FD_BATCH DETAILS":
	    	WriteAccountOpeningFD_BatchMode.writeAccountOpeningFDDetails_BatchMode(driver, orTemp[1].trim());
	    	break;
	    case"VERIFY TEXT_FIELD":
	    	Verify.VerifySummary_FD_BatchMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
	    	break;
	    case"READ BATCHFD-ACCOUNT TRANSID":
	    	Fetch_FD_Batch_Transid.getTransid(orTemp[1].trim());
	    	break; 
	    case"READ FD AMOUNT":
	    	ReadFDBatchAmount.getAmount(orTemp[1].trim());
	    	break; 
	    	
	    	
//Re Investment Deposit Cash mode
		   case"WRITE RID_CASH DETAILS":
			   WriteAccountOpeningRID_CashMode.writeAccountOpeningRIDDetails_CashMode(driver, orTemp[1].trim());
			   break; 
		   case "VERIFY SUMMARY":
			   Verify.VerifySummary_RID_CashMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			   break; 
		   case "VERIFY RID ACCOUNTNO":
			   VerifyRIDSummary.VerifyVoucherNos(driver);
			   break;
		   case "VERIFY RID TRANSID":
		    	VerifyRIDSummary.VerifyTransIDs(driver);
		    	break;
		   case "VERIFY RID VOUCHERNO":
		    	VerifyRIDSummary.VerifyAccNos(driver);
		    	break; 
		   case"FETCH  TRANID":
		   Fetch_RID_Cash_TransID.getTransid(driver, orTemp[0].trim(), orTemp[1].trim());
		   break;
		   
//Re Investment Deposit Autopost mode
		   case"WRITE RID_TRANSFER DETAILS":
			   WriteAccountOpeningRID_TransferMode.writeAccountOpeningRIDDetails_TransferMode(driver, orTemp[1].trim());
				break;	
		   case "VERIFY TRANSFER":
			   Verify.VerifySummary_RID_TransferMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;	
		   case"READ RID-ACCOUNT TRANSID":
			Fetch_RID_Transfer_TransID.getTransid(orTemp[1].trim());
				break;
	    	
//Re Investment Deposit  Batch mode			
		case"WRITE RID_BATCH_DETAILS":
			Write_RID_BATCH.WriteRID_Batch_Details(driver, orTemp[1].trim());
			break;	 
		case "VERIFY ELEMENT":
			Verify.VerifySummary_RID_BatchMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
		case"READ RID BATCH AMOUNT":
			Read_RID_Batch_Amount.getAmount(orTemp[1].trim());
			break;	
		case"READ RID-BATCH TRANSID":
			Get_RID_TransID_batch.getTransid(orTemp[1].trim());

			break;	
			
			
//Recurring Deposit Cash mode
		   case"WRITE RD_CASH_DETAILS":
			   WriteAccountOpeningRD_CashMode.writeAccountOpeningRDDetails_CashMode(driver, orTemp[1].trim());
				break;	
		   case "VERIFY ITEM CASH":
			   Verify.VerifySummary_RD_CashMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
		   case"FETCH  RD TRANID":
			   Fetch_RD_Cash_TransID.getTransid(driver, orTemp[0].trim(), orTemp[1].trim());
				break;
	

			
//Recurring Deposit Autopost mode	
		case "WRITE RD_AUTOPOST_DETAILS":
			Write_RD_Autopost_Details.RD_Autopost_Details(driver, orTemp[1].trim());
			break;
		case "VERIFY ITEM":
			Verify.Verify_RD_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;	
		case "READ RD AUTOPOST TRANSID":	
			Read_RD_Autopost_Transid.getTransid(driver, orTemp[0].trim(), orTemp[1].trim());
			break;	

//Recurring Deposit Batch mode
		   case"WRITE RD_BATCH_DETAILS":
			   WriteAccountOpeningRD_BatchMode.writeAccountOpeningRDDetails_BatchMode(driver, orTemp[1].trim());
				break;	
		   case "VERIFY ITEM BATCH":
			   Verify.VerifySummary_RD_BatchMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
		   case"READ BATCHRD-ACCOUNT TRANSID":
			   Fetch_RD_Batch_TransID.getTransid(driver, orTemp[0].trim(), orTemp[1].trim());
				break;
		   case"READ RD AMOUNT":
				ReadRDBatchAmount.getAmount(orTemp[1].trim());
				break;

//Daily Deposit opening in Cash mode				
		case "WRITE_DD_CASH":
			Write_DD_CashDetails.write_DD_Details_CashMode(driver, orTemp[1].trim());
			break;	
		case "VERIFY DD CASH FIELD":
			Verify.VerifySummary_DD_CashMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
		case "FETCH DD-CASH TRANSID":
			Fetch_DD_Cash_TransId.getTransid(driver, orTemp[0].trim(), orTemp[1].trim());
			break;
			
//Daily deposit opening in Batch mode			
		case "WRITE_DD_BATCH":
			Write_DD_BATCH.Write_DD_Batch_Details(driver, orTemp[1].trim());
			break;
		case "VERIFY DD BATCH FIELD":
			Verify.Verify_DD_CashMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;	
		case "FETCH DD-BATCH TRANSID":
			Fetch_DD_Batch_TransId.getTransid(driver, orTemp[0].trim(), orTemp[1].trim());
			break;	
		case "READ DD BATCH AMOUNT":
			Read_DD_Batch_Amount.getAmount(orTemp[1].trim());
			break;

//Daily Deposit opening in Auto post			
		case "WRITE_DD_AUTOPOST":
			Write_DD_Autopost.Write_DD_Autopost_Details(driver, orTemp[1].trim());
			break;
		case "VERIFY DD AUTOPOST FIELD":
			Verify.Verify_DD_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
		case "FETCH DD-AUTOPOST TRANSID":
			Fetch_DD_Autopost_TransID.getTransid(driver, orTemp[0].trim(), orTemp[1].trim());
			break;	
//Other Loan CASH mode	
			
			
		case "VERIFY":
			Verification.verify(driver,orTemp[1].trim());
			break;
		case "WRITE OL DETAILS_CASH MODE":
			Write_OL_CASH.WriteOLDetails_CASH(driver, orTemp[1].trim());
			break;
		case "VERIFY OL-CASH TEXT":
			VerifyOLSummary.Verify_OL_CASH_Summary(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
        case "VERIFY VOUCHER NUMBERS":
			VerifyOLSummary.VerifyVoucherNumbers(driver);
			break;
        case "VERIFY AMOUNTS":
			VerifyOLSummary.VerifyAmounts(driver);
			break;
        case "VERIFY AMOUNT TYPES":
			VerifyOLSummary.VerifyAmountTypes(driver);
			break;
        case "VERIFY GLAC CODES":
			VerifyOLSummary.VerifyGLAcCode(driver);
			break;
		case "VERIFY TRANS TYPES":
			VerifyOLSummary.VerifyTransTypes(driver);
			break;
        case "FETCH OL_CASH TRANSID":
			ReadTransID.GetTransIdODCash(driver, orTemp[0].trim(), orTemp[1].trim());
			break;
        case "READ CUST_ID FOR LOAN":
			ReadCustomerID.getCustomerIdForLoan(driver, orTemp[1].trim());
			break;
        case "READ CUST_ID FOR LOAN1":
			ReadCustomerID.getCustomerIdForOtherLoan1(driver, orTemp[1].trim());
			break;
        case "READ CUST_ID FOR LOAN2":
			ReadCustomerID.getCustomerIdForOtherLoan2(driver, orTemp[1].trim());
			break;
        case "READ CUST_ID FOR LOAN3":
			ReadCustomerID.getCustomerIdForOtherLoan3(driver, orTemp[1].trim());
			break;
        case "READ DOC NO":
			Common.GetDocNo(driver, orTemp[1].trim());
			break;
        case "VERIFY NET PAY":
			//System.out.println("inside verify net pay case");
			Common.verifyNETPAY(driver, orTemp[1].trim());
			break;
		
			
//Other loan mortgage OL -Autopost
		
			
		//case "CALCULATE ELIGIBLE OL AMOUNT":
			  // CalculateEligibleLoanAmount.CalculateAmountForOtherLoan(driver,orTemp[1].trim()); 
			   //break;
			   
	   case "VERIFY NETPAY":
			   Common.verifyNetPay(driver, orTemp[1].trim());
			   break;
	   case "GET DOC NO":
		   Common.GetDocNo(driver, orTemp[1].trim());
		   break;
	   case "READ  LOAN CUST_ID":
		   ReadLoanCustomerID.getCustomerId(driver, orTemp[1].trim());
		   break;   
	   case "CALCULATE ELIGIBLE OL AMOUNT":
		   CalculateEligibleLoanAmount.CalculateAmountForOtherLoan(driver,orTemp[1].trim()); 
		   break;	
	   case"WRITE OL DETAILS _AUTOPOST":
		   WritOL_AutopostMode.writeOLDetails_AutopostMode(driver, orTemp[1].trim());
		   break;
	   case "VERIFY OL AUTOPOST":
		   VerifyOLSummary.VerifySummary_OL_AutopostMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
		   break;	
		  	
	   case "VERIFY OL VOUCHER NO":
		   VerifyOLSummary.VerifyVoucherNos(driver);
		   break;
	   case "VERIFY OL TRANS TYPE":
		   VerifyOLSummary.VerifyTransType(driver);
		   break;
	   case "VERIFY OL AMOUNT":
		   VerifyOLSummary.VerifyAmount(driver);
		   break;
		   
	   case "VERIFY OL AMOUNT TYPE":
		   VerifyOLSummary.VerifyAmountType(driver);
		   break;
	   case "VERIFY OL GLAC":
		   VerifyOLSummary.VerifyGlac(driver);
		   break;
	   case "FETCH OL_AUTOPOST TRANSID":
			Fetch_OL_Autopost_TransID.getTransid(driver, orTemp[1].trim());
			break;	   
//	 Other loans Batch Mode  	   
		
	   
	   case"WRITE OL DETAILS _BATCH":
		   WriteOL_BatchMode.writeOLDetails_BatchMode(driver, orTemp[1].trim());
		   break;
	   case"READ OL BATCH TRANSID":
		   Fetch_OL_Batch_TransID.getTransid(orTemp[1].trim());
			break;
	   case"READ OL AMOUNT":
			ReadOLBatchAmount.getAmount(orTemp[1].trim());
			break;  
	   case "VERIFY OL BATCH":
		   VerifyOLSummary.VerifySummary_OL_BatchMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
		   break;
	   case "VERIFY OL BATCH VOUCHERNO":
		   VerifyOLSummary.VerifyVoucherNosBatch(driver);
		   break;
	   case "VERIFY OL BATCH TRANSTYPE":
		   VerifyOLSummary.VerifyTransTypeBatch(driver);
		   break;
	   case "VERIFY OL BATCH AMOUNT":
		   VerifyOLSummary.VerifyAmountBatch(driver);
		   break;
		   
	   case "VERIFY OL BATCH AMOUNTTYPE":
		   VerifyOLSummary.VerifyAmountTypeBatch(driver);
		   break;
	   case "VERIFY OL BATCH GLAC":
		   VerifyOLSummary.VerifyGlacBatch(driver);
		   break;	   
	   
	   
	   
	   case"VERIFY MESSAGE":
			Verify.Verify_message(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
			break;
			
//Deposit Loan Cash Mode
			
	   case "GET FD ACCNO":
			CommisionCalculator.GetFDAccountNo(driver, orTemp[1].trim());
			break;
	   case "GET FD ACCNO2":
			CommisionCalculator.GetFDAccountNo2(driver, orTemp[1].trim());
			break;
	   case "READ SANCTIONED AMOUNT":
		   CommisionCalculator.PostSanctionedAmountCalculator(driver,orTemp[1].trim());
			break;
	   case"WRITE DL_CASH DETAILS":
	    	WriteAccountOpeningDL_CashMode.writeAccountOpeningDLDetails_CashMode(driver, orTemp[1].trim());
	    	break;
	    case"VERIFY DL TEXT":
	    	VerifyDLSummary.VerifySummary_DL_CashMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
	    	break;
	    case"FETCH DL TRANSID":
	    	Fetch_DL_CASH_Transid.getTransid(orTemp[1].trim());
	    	break; 
//Deposit Loan Autopost Mode
	    	
	    case"WRITE DL_TRANSFER DETAILS":
	    	WriteAccountOpeningDL_TransferMode.writeAccountOpeningDLDetails_TransferMode(driver, orTemp[1].trim());
	    	break;
	    case "VERIFY DL AUTOPOST":
	    	VerifyDLSummary.VerifySummary_DL_TransferMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
	    	break; 
	    case"READ DL-AUTOPOST TRANSID":
	    	Fetch_DL_Transfer_Transid.getTransid(orTemp[1].trim());
	    	break;
//Deposit Loan Batch Mode		
	    case"WRITE DL_BATCH":
	    	WriteAccountOpeningDL_BatchMode.writeAccountOpeningDLDetails_BatchMode(driver, orTemp[1].trim());
	    	break;
	    case"VERIFY DL BATCH":
	    	VerifyDLSummary.VerifySummary_DL_BatchMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
	    	break;
	    case"READ DL-BATCH TRANSID":
	    	Fetch_DL_Batch_Transid.getTransid(orTemp[1].trim());
	    	break;
	    
	    case"READ DL AMOUNT":
	    	ReadDLBatchAmount.getAmount(orTemp[1].trim());
	    	break;
		default:
			break;



				
	//Jewel Loan Cash Mode

			case "READ CUST_ID FOR GL":
				ReadCustomerID.getCustomerIdForGoldLoan(driver, orTemp[1].trim());
				break;

			case "CALCULATE ELIGIBLE GL AMOUNT":
				CalculateEligibleLoanAmount.CalculateAmountForOtherGoldLoan(driver, orTemp[1].trim());
				break;
			case "WRITE GL DETAILS_CASH MODE":
				Write.Write_GL_Cash(driver, orTemp[1].trim());
				break;
			case "VERIFY NET PAY FOR GL":
				Common.verifyNetPayForGL(driver, orTemp[1].trim());
				break;

			case "VERIFY GL-CASH TEXT":
				VerifyGLSummary.Verify_GL_Cash_Summary(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;

			case "FETCH GL_CASH TRANSID":
				ReadTransID.ReadTransIdForGL_CASH(driver, orTemp[0].trim(), orTemp[1].trim());
				break;

			case "WRITE NETWEIGHT":
				Common.WriteNetWeightToFile(driver);
				break;

	//Jewel Autopost

			case "WRITE GL_AUTOPOST":
				Write.Write_GL_Autopost(driver, orTemp[1].trim());
				break;
			case "VERIFY GL-AUTOPOST TEXT":
				VerifyGLSummary.Verify_GL_Autopost_Summary(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
				
			case "READ AUTOPOST_GL_TRANSID":
				ReadTransID.ReadTransIdForGL_Autopost(driver, orTemp[0].trim(), orTemp[1].trim());
				break;

	//Jewel Batch

			case "WRITE GL_BATCH":
				Write.Write_GL_Batch(driver, orTemp[1].trim());
				break;

			case "VERIFY GL-BATCH TEXT":
				VerifyGLSummary.Verify_GL_Batch_Summary(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;

			case "READ BATCH_GL_TRANSID":
				ReadTransID.ReadTransIdForGL_Batch(driver, orTemp[0].trim(), orTemp[1].trim());
				break;

			case "READ DR AMOUNT":
				ReadAmount.getAmountForGL_BATCH(orTemp[1].trim());
				break;			
				
				//Suspense Liability cash

			case "READ CUST_ID FOR SUSLIA":
				ReadCustomerID.getCustomerIdForSL(driver, orTemp[1].trim());
				break;

			case "WRITE SL_CASH MODE":
				Write.Write_SL_Cash(driver, orTemp[1].trim());
				break;
			case "VERIFY SL-CASH TEXT":
				VerifySuspenseSummary.Verify_SL_CASH_Summary(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;

			case "FETCH SL_CASH TRANSID":
				ReadTransID.ReadTransIdForSL_CASH(driver, orTemp[0].trim(), orTemp[1].trim());
				break;
				
	//Suspense Liability autopost
				
			case"WRITE SL_AUTOPOST":
				Write.Write_SL_Autopost(driver,  orTemp[1].trim());
				break;
				
			case "VERIFY SL-AUTOPOST TEXT":
				//System.out.println("inside case");
				VerifySuspenseSummary.Verify_SL_Autopost_Summary(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
			case"READ SL_AUTOPOST TRANSID":
				ReadTransID.ReadTransIdForSL_AUTOPOST(driver, orTemp[0].trim(), orTemp[1].trim());
				break;
				
	//Suspense Liability batch
				
			case "WRITE SL_BATCH MODE":
				Write.Write_SL_Batch(driver,  orTemp[1].trim());
				break;
				
			case"VERIFY SL-BATCH TEXT":
				VerifySuspenseSummary.Verify_SL_BATCH_Summary(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
				
			case "READ BATCH_SL_TRANSID":
				ReadTransID.ReadTransIdForSL_BATCH(driver, orTemp[0].trim(), orTemp[1].trim());
				break;
			case "READ SL-DR AMOUNT":
				ReadAmount.getAmountForSL_BATCH(orTemp[1].trim());
				break;
				
	//suspense asset cash
				
			case "WRITE SA_CASH MODE":
				Write.Write_SA_Cash(driver, orTemp[1].trim());
				break;
			case "VERIFY SA-CASH TEXT":
				VerifySuspenseSummary.Verify_SA_CASH_Summary(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
			case "FETCH SA_CASH TRANSID":
				ReadTransID.ReadTransIdForSA_CASH(driver, orTemp[0].trim(), orTemp[1].trim());
				break;
				
	//Suspense Asset Batch
				
			case "WRITE SA_BATCH MODE":
				Write.Write_SA_Batch(driver, orTemp[1].trim());
				break;
				
			case "VERIFY SA-BATCH TEXT":
				VerifySuspenseSummary.Verify_SA_BATCH_Summary(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
				
			case "FETCH SA_BATCH TRANSID":
				ReadTransID.ReadTransIdForSA_BATCH(driver, orTemp[0].trim(), orTemp[1].trim());
				break;	
				
			case "READ SA-CR AMOUNT":
				ReadAmount.getAmountForSA_BATCH(orTemp[1].trim());
				break;
				
	// suspense Asset autopost
				
			case"WRITE SA_AUTOPOST":
				Write.Write_SA_Autopost(driver,  orTemp[1].trim());
				break;
				
			case "VERIFY SA-AUTOPOST TEXT":
				//System.out.println("inside case");
				VerifySuspenseSummary.Verify_SA_Autopost_Summary(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
			case"READ SA_AUTOPOST TRANSID":
				ReadTransID.ReadTransIdForSA_AUTOPOST(driver, orTemp[0].trim(), orTemp[1].trim());
				break;
				
	//OD OPening- CASH
			
			case "VERIFY OD NETPAY":
				   Common.verifyODNetPay(driver, orTemp[1].trim());
				   break;	
			case "CALCULATE ELIGIBLE OD AMOUNT":
				CalculateEligibleLoanAmount.CalculateAmountForOtherOD(driver, orTemp[1].trim());
				break;
				
			case "WRITE OD DETAILS_CASH":
				Write_OD_CASH.Write_OD_CASH_Details(driver, orTemp[1].trim());
				break;
				
			case "VERIFY OD-CASH TEXT":
				VerifyODSummary.Verify_OD_CASH_Summary(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
				
			case "VERIFY OD_VOUCHER NUMBERS":
				VerifyODSummary.Verify_OD_VoucherNumbers(driver);
				break;
			case "VERIFY OD_AMOUNTS":
				VerifyODSummary.Verify_OD_Amounts(driver);
				break;	
			case "VERIFY OD_AMOUNT TYPES":
				VerifyODSummary.Verify_OD_AmountTypes(driver);
				break;
			case "VERIFY OD_GLAC CODES":
				VerifyODSummary.Verify_OD_GLAcCode(driver);
				break;
			case "VERIFY OD_TRANS TYPES":
				VerifyODSummary.Verify_OD_TransTypes(driver);
				break;
			case "FETCH OD_CASH TRANSID":
				ReadTransID.GetTransIdForOD(driver, orTemp[0].trim(), orTemp[1].trim());
				break;
//OD Opening AUTOPOST
			case "WRITE OD DETAILS_AUTOPOST":
				Write_OD_CASH.Write_OD_AUTOPOST_Details(driver, orTemp[1].trim());
				break;
				
			case "VERIFY OD-AUTOPOST TEXT":
				VerifyODSummary.Verify_OD_AUTOPOST_Summary(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
				
			case "VERIFY OD VOUCHERNO":
				VerifyODSummary.VerifyODVoucherNos(driver);
				break;
			case "VERIFY OD AMOUNT":
				VerifyODSummary.VerifyODAmounts(driver);
				break;	
			case "VERIFY OD AMOUNTTYPE":
				VerifyODSummary.VerifyODAmtTypes(driver);
				break;
			case "VERIFY OD GLACCODE":
				VerifyODSummary.VerifyODGLcCodes(driver);
				break;
			case "VERIFY OD TRANSACTIONTYPE":
				VerifyODSummary.VerifyODTransactionTypes(driver);
				break;
			case "FETCH OD_AUTOPOST TRANSID":
				ReadTransID.GetTransIdForODAutopost(driver, orTemp[0].trim(), orTemp[1].trim());
				break;	
				
//OD Opening BATCH
			case "WRITE OD DETAILS_BATCH":
				Write_OD_CASH.Write_OD_BATCH_Details(driver, orTemp[1].trim());
				break;
				
			case "VERIFY OD-BATCH TEXT":
				VerifyODSummary.Verify_OD_BATCH_Summary(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
				
			case "VERIFY OD_VOUCHER NO":
				VerifyODSummary.Verify_OD_VoucherNos(driver);
				break;
			case "VERIFY OD_AMT":
				VerifyODSummary.Verify_OD_Amts(driver);
				break;	
			case "VERIFY OD_AMT TYPE":
				VerifyODSummary.Verify_OD_AmtTypes(driver);
				break;
			case "VERIFY OD_GLACCODE":
				VerifyODSummary.Verify_OD_GLcCodes(driver);
				break;
			case "VERIFY OD_TRANSACTION TYPE":
				VerifyODSummary.Verify_OD_TransactionTypes(driver);
				break;
			case "FETCH OD_BATCH TRANSID":
				ReadTransID.GetTransIdForODBatch(driver, orTemp[0].trim(), orTemp[1].trim());
				break;	
			case"READ OD AMOUNT":
				ReadOLBatchAmount.getAmountOD(orTemp[1].trim());
				break;	
				
//OL CREDIT CASH MODE
			case "READ OL ACNO":
				ReadCustomerID.getOLAcNo(driver, orTemp[1].trim());
				break;
			case "VERIFY INST DUE NO":
				TransactionsOperations.VerifyInstDueNo(driver, orTemp[1].trim());
				break;
			case "VERIFY INST DUE NO2":
				TransactionsOperations.VerifyInstDueNo2(driver, orTemp[1].trim());
				break;
			case "VERIFY INST DUE AMOUNT":
				TransactionsOperations.VerifyInstDueAmount(driver, orTemp[1].trim());
				break;
			case "VERIFY INST DUE AMOUNT2":
				TransactionsOperations.VerifyInstDueAmount2(driver, orTemp[1].trim());
				break;	
				
			//Added below case on Feb 12th, 2019
			case "VERIFY INSTALLMENT AMOUNT":
			      TransactionsOperations.VerifyInstallmentAmountForOL(driver, orTemp[1].trim());
			      break;
			case "WRITE OL_CREDIT_CASH":
				Write.Write_OLCr_Cash_Details(driver, orTemp[1].trim());
				break;
			case "VERIFY OL_CREDIT_CASH":
				VerifySummary.Verify_OLCr_Cash_Summary(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
			case "VERIFY OL CR AMOUNT":
				VerifySummary.Verify_OLCr_Amts(driver);
				break;	
			case "VERIFY OL CR AMOUNTTYPE":
				VerifySummary.Verify_OLCr_AmtTypes(driver);
				break;
			case "VERIFY OL CR GLCODE":
				VerifySummary.Verify_OLCr_GLcCodes(driver);
				break;
			case "READ OL_CREDIT_CASH TRANSID":
				ReadTransID.GetTransIdForOLCash(driver, orTemp[1].trim());
				break;	
			case "VERIFY OL CR INTEREST":
				TransactionsOperations.VerifyOLcreditInterest(driver, orTemp[1].trim());
				break;
	//OL CREDIT BATCH MODE
			case "WRITE OL_CREDIT_BATCH":
				Write.Write_OLCr_Batch_Details(driver, orTemp[1].trim());
				break;
			case "VERIFY OL_CREDIT_BATCH":
				VerifySummary.Verify_OLCr_Batch_Summary(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
			case "VERIFY OL CR AMT":
				VerifySummary.Verify_OLCr_Amount(driver);
				break;	
			case "VERIFY OL CR AMTTYPE":
				VerifySummary.Verify_OLCr_AmountTypes(driver);
				break;
			case "VERIFY OL CR GLCD":
				VerifySummary.Verify_OLCr_GLcCode(driver);
				break;
			case "FETCH OL CR BATCH TRANSID":
				ReadTransID.GetTransIdForOLBatch(driver, orTemp[1].trim());
				break;
			case "READ OL CR AMOUNT":
				ReadAmount.getAmountForOL_Credit(orTemp[1].trim());
				break;
	//OL CREDIT AUTOPOST MODE
			case "ENTER AUTOPOST AMOUNT":
				AutoPostAmountCalculator.PostAmountCalculator(driver, orTemp[1].trim());
				break;
			case "READ OL INTRBR ACNO":
				ReadCustomerID.getOLInterBranchAcNo(driver, orTemp[1].trim());
				break;
			case "WRITE OL_CREDIT_AUTOPOST":
				Write.writeOLCredit_Autopost(driver, orTemp[1].trim());
				break;
			case "VERIFY OL_CREDIT_AUTOPOST":
				VerifySummary.Verify_OLCredit_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
			case "VERIFY OL CR AUTO VRNO":
				VerifySummary.VerifyOLCrAutopostVrNo(driver);
				break;	
			case "VERIFY OL CR AUTO TRANSTYPE":
				VerifySummary.VerifyOLCrAutopostTrType(driver);
				break;
			case "VERIFY OL CR AUTO AMOUNT":
				VerifySummary.VerifyOLCrAutopostAmt(driver);
				break;	
			case "VERIFY OL CR AUTO AMOUNTTYPE":
				VerifySummary.VerifyOLCrAutopostAmtTypes(driver);
				break;
			case "VERIFY OL CR AUTO GLCODE":
				VerifySummary.VerifyOLCrAutopostGLCode(driver);
				break;
			case "VERIFY OL CR AUTO BRCODE":
				VerifySummary.VerifyOLCreditAutopostBrCode(driver);
				break;
			case "FETCH OL CR AUTO TRANSID":
				ReadTransID.GetTransIdForOLAutopost(driver, orTemp[1].trim());
				break;
 //OD CREDIT CASH MODE
			case "READ OD ACNO":
				ReadCustomerID.getODAcNo(driver, orTemp[1].trim());
				break;
			case "WRITE OD_CREDIT_CASH":
				Write.writeODCredit_Cash(driver, orTemp[1].trim());
				break;
			case "VERIFY OD_CREDIT_CASH":
				VerifySummary.Verify_ODCredit_Cash(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
			case "READ OD_CREDIT_CASH TRANSID":
				ReadTransID.GetTransIdForODCrCash(driver, orTemp[1].trim());
				break;
 //OD CREDIT BATCH MODE
			case "WRITE OD_CREDIT_BATCH":
				Write.writeODCredit_Batch(driver, orTemp[1].trim());
				break;
			case "VERIFY OD_CREDIT_BATCH":
				VerifySummary.Verify_ODCredit_Batch(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
			case "FETCH OD CR BATCH TRANSID":
				ReadTransID.GetTransIdForODCrBatch(driver, orTemp[1].trim());
				break;
			case "READ OD CR AMOUNT":
				ReadAmount.getAmountForOD_Credit(orTemp[1].trim());
				break;
 //OD CREDIT AUTOPOST MODE
			case "READ OD INTRBR ACNO":
				ReadCustomerID.getODInterBranchAcNo(driver, orTemp[1].trim());
				break;
			case "WRITE OD_CREDIT_AUTOPOST":
				Write.writeODCredit_Autopost(driver, orTemp[1].trim());
				break;
			case "VERIFY OD_CREDIT_AUTOPOST":
				VerifySummary.Verify_ODCredit_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
			case "VERIFY OD CR AUTO VRNO":
				VerifySummary.VerifyODCrAutopostVrNo(driver);
				break;	
			case "VERIFY OD CR AUTO TRANSTYPE":
				VerifySummary.VerifyODCrAutopostTrType(driver);
				break;
			case "VERIFY OD CR AUTO AMOUNTTYPE":
				VerifySummary.VerifyODCrAutopostAmtTypes(driver);
				break;
			case "VERIFY OD CR AUTO GLCODE":
				VerifySummary.VerifyODCrAutopostGLCode(driver);
				break;
			case "VERIFY OD CR AUTO BRCODE":
				VerifySummary.VerifyODCreditAutopostBrCode(driver);
				break;
			case "FETCH OD CR AUTO TRANSID":
				ReadTransID.GetTransIdForODCreditAutopost(driver, orTemp[1].trim());
				break;
//OD DEBIT CASH MODE
			case "READ OD DEBIT ACNO":
				ReadCustomerID.getODDebitAcNo(driver, orTemp[1].trim());
				break;
			case "WRITE OD_DEBIT_CASH":
				Write.writeODDebit_Cash(driver, orTemp[1].trim());
				break;
			case "VERIFY OD_DEBIT_CASH":
				VerifySummary.Verify_ODDebit_Cash(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
			case "READ OD_DEBIT_CASH TRANSID":
				ReadTransID.GetTransIdForODDrCash(driver, orTemp[1].trim());
				break;
//OD DEBIT BATCH MODE
			case "WRITE OD_DEBIT_BATCH":
				Write.writeODDebit_Batch(driver, orTemp[1].trim());
				break;
			case "VERIFY OD_DEBIT_BATCH":
				VerifySummary.Verify_ODDebit_Batch(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
			case "FETCH OD DR BATCH TRANSID":
				ReadTransID.GetTransIdForODDrBatch(driver, orTemp[1].trim());
				break;
			case "READ OD DR AMOUNT":
				ReadAmount.getAmountForOD_Debit(orTemp[1].trim());
				break;
//OD DEBIT AUTOPOST MODE
			case "READ OD DR INTRBR ACNO":
				ReadCustomerID.getODDebitInterBranchAcNo(driver, orTemp[1].trim());
				break;
			case "WRITE OD_DEBIT_AUTOPOST":
				Write.writeODDebit_Autopost(driver, orTemp[1].trim());
				break;
			case "VERIFY OD_DEBIT_AUTOPOST":
				VerifySummary.Verify_ODDebit_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
				break;
			case "VERIFY OD DR AUTO VRNO":
				VerifySummary.VerifyODDrAutopostVrNo(driver);
				break;	
			case "VERIFY OD DR AUTO TRANSTYPE":
				VerifySummary.VerifyODDrAutopostTrType(driver);
				break;
			case "VERIFY OD DR AUTO AMOUNTTYPE":
				VerifySummary.VerifyODDrAutopostAmtTypes(driver);
				break;
			case "VERIFY OD DR AUTO GLCODE":
				VerifySummary.VerifyODDrAutopostGLCode(driver);
				break;
			case "VERIFY OD DR AUTO BRCODE":
				VerifySummary.VerifyODDebitAutopostBrCode(driver);
				break;
			case "FETCH OD DR AUTO TRANSID":
				ReadTransID.GetTransIdForODDebitAutopost(driver, orTemp[1].trim());
				break;
	//DL Credit transactions Autopost mode
				
			  case "READ DL INTER ACNO":
				    ReadCustomerID.getDLCreditInterBranchAcNo(driver, orTemp[1].trim());
				    break;
			  case "READ VALUE DATE":
					Common.ReadValueDate(driver, orTemp[1].trim());
					break;
			  case "VERIFY_SB_LAST_BALANCE":
					TransactionsOperations.VerifyLastbalance(driver, orTemp[1].trim());
					break;
			  case"WRITE  DL_CREDIT_AUTOPOST":
				   WriteDLCredit.writeDLCredit_AutopostMode(driver, orTemp[1].trim());
				   break;
			  case "VERIFY DL-CREDIT_PRODUCTNAME":
				   VerifyDLCreditSummary.VerifyProductName(driver);
				   break; 
			  case "VERIFY DL-CREDIT_ACCNO":
				   VerifyDLCreditSummary.VerifyAccountNo(driver);
				   break; 
			  case "VERIFY DL-CREDIT_DISPLAYNAME":
				   VerifyDLCreditSummary.VerifyDisplayName(driver);
				   break;
		      case "VERIFY DL- CREDIT_ VOUCHERNO":
				   VerifyDLCreditSummary.VerifyVoucherNo(driver);
				   break;
		      case "VERIFY DL-CREDIT_TRANSTYPE":
				   VerifyDLCreditSummary.VerifyTranscationType(driver);
				   break;
			  case "VERIFY DL-CREDIT_AMTTYPE":
				   VerifyDLCreditSummary.VerifyAmountType(driver);
				   break;
			  case "VERIFY DL-CREDIT_GLCODE":
				   VerifyDLCreditSummary.VerifyGLCode(driver);
				   break;
			  case "VERIFY DL-CREDIT_BRCODE":
				   VerifyDLCreditSummary.VerifyBranchCode(driver);
				   break;
			  case "VERIFY DL-CREDIT_AUTOPOST":
				   VerifyDLCreditSummary.VerifyDLCredit_Autopost(driver,orTemp[0].trim(),orTemp[1].trim(),testData);
				   break;
			  case "READ DLCredit_AUTO TRANSID":
				   GetTransactionID.getDLCreditTransid(orTemp[1].trim());
					break;
	//DL CREDIT CASH MODE
			  case "READ DL ACNO":
					ReadCustomerID.getDLCreditAcNo(driver, orTemp[1].trim());
					break;
			  case "WRITE DL_CREDIT_CASH":
					Write.writeDLCredit_Cash(driver, orTemp[1].trim());
					break;
			  case "VERIFY DL_CREDIT_CASH":
					VerifySummary.Verify_DLCredit_Cash(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "READ DL_CREDIT_CASH TRANSID":
					ReadTransID.GetTransIdForDLCrCash(driver, orTemp[1].trim());
					break;
	//DL CREDIT BATCH MODE	
			  case "WRITE DL_CREDIT_BATCH":
					Write.writeDLCredit_Batch(driver, orTemp[1].trim());
					break;
			  case "VERIFY DL_CREDIT_BATCH":
					VerifySummary.Verify_DLCredit_Batch(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "FETCH DL CR BATCH TRANSID":
					ReadTransID.GetTransIdForDLCrBatch(driver, orTemp[1].trim());
					break;
			  case "READ DL CR AMOUNT":
					ReadAmount.getAmountForDL_Credit(orTemp[1].trim());
					break;
	//GL CREDIT CASH MODE
			  case "READ GL ACNO":
					ReadCustomerID.getGLCreditAcNo(driver, orTemp[1].trim());
					break;
			  case "WRITE GL_CREDIT_CASH":
					Write.writeGLCredit_Cash(driver, orTemp[1].trim());
					break;
			  case "VERIFY GL_CREDIT_CASH":
					VerifySummary.Verify_GLCredit_Cash(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "READ GL_CREDIT_CASH TRANSID":
					ReadTransID.GetTransIdForGLCrCash(driver, orTemp[1].trim());
					break;
    //GL CREDIT BATCH MODE	
			  case "WRITE GL_CREDIT_BATCH":
					Write.writeGLCredit_Batch(driver, orTemp[1].trim());
					break;
			  case "VERIFY GL_CREDIT_BATCH":
					VerifySummary.Verify_GLCredit_Batch(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "FETCH GL CR BATCH TRANSID":
					ReadTransID.GetTransIdForGLCrBatch(driver, orTemp[1].trim());
					break;
			  case "READ GL CR AMOUNT":
					ReadAmount.getAmountForGL_Credit(orTemp[1].trim());
					break;
	//GL CREDIT AUTOPOST MODE
			  case "READ GL INTER ACNO":
					ReadCustomerID.getGLCreditInterBranchAcNo(driver, orTemp[1].trim());
					break;
				case "WRITE GL_CREDIT_AUTOPOST":
					Write.writeGLCredit_Autopost(driver, orTemp[1].trim());
					break;
				case "VERIFY GL_CREDIT_AUTOPOST":
					VerifySummary.Verify_GLCredit_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
				case "VERIFY GL CR AUTO VRNO":
					VerifySummary.VerifyGLCrAutopostVrNo(driver);
					break;	
				case "VERIFY GL CR AUTO TRANSTYPE":
					VerifySummary.VerifyGLCrAutopostTrType(driver);
					break;
				case "VERIFY GL CR AUTO AMOUNTTYPE":
					VerifySummary.VerifyGLCrAutopostAmtTypes(driver);
					break;
				case "VERIFY GL CR AUTO GLCODE":
					VerifySummary.VerifyGLCrAutopostGLCode(driver);
					break;
				case "VERIFY GL CR AUTO BRCODE":
					VerifySummary.VerifyGLCreditAutopostBrCode(driver);
					break;
				case "READ GLCredit_AUTO TRANSID":
					ReadTransID.GetTransIdForGLCreditAutopost(driver, orTemp[1].trim());
					break;
	//FD INTEREST PAYMENT CASH MODE
				case "READ FD ACNO":
					ReadCustomerID.getFDInterestPaymentAcNo(driver, orTemp[1].trim());
					break;
				case "VERIFY_TOT_INT_PAYABLE":
					TransactionsOperations.VerifyTotIntPayable(driver,orTemp[1].trim());
					break;
				case "VERIFY_DEDUCTED_INTEREST":
					TransactionsOperations.VerifyDeductedInterest(driver,orTemp[1].trim());
					break;
				case "WRITE FD_IP_CASH":
					Write.writeFDInterestPayment_Cash(driver, orTemp[1].trim());
					break;
			  case "VERIFY FD_IP_CASH":
					VerifySummary.VerifyFDInterestPayment_Cash(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "READ FD_IP_CASH TRANSID":
					ReadTransID.GetTransIdForFDInterestPayment_Cash(driver, orTemp[1].trim());
					break;
	//FD INTEREST PAYMENT BATCH MODE
			  case "WRITE FD_IP_BATCH":
					Write.writeFDInterestPayment_Batch(driver, orTemp[1].trim());
					break;
			  case "VERIFY FD_IP_BATCH":
					VerifySummary.VerifyFDInterestPayment_Batch(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "FETCH FD IP  BATCH TRANSID":
					ReadTransID.GetTransIdForFDInterestPaymentBatch(driver, orTemp[1].trim());
					break;
			  case "READ  FD IP  AMOUNT":
					ReadAmount.getAmountForFDInterestPayment_Credit(orTemp[1].trim());
					break;
				
	//FD INTEREST PAYMENT AUTOPOST MODE				
			  case"WRITE FD_IP_AUTOPOST":
					Write.WriteFDInterestPayment_Autopost(driver,  orTemp[1].trim());
					break;
			  case "VERIFY FD-IP_AUTOPOST":
				    VerifySummary.VerifyFDInterestPayment_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case"READ FD_IP_AUTO TRANSID":
					ReadTransID.ReadTransIdForFDInterestPayment_AUTOPOST( orTemp[1].trim());
					break;
	//SB CLOSURE CASH MODE
			  case "READ SB ACNO":
					ReadCustomerID.getSBACCountClosure_AcNo(driver, orTemp[1].trim());
					break;
			  case "WRITE SB_ACC_CLOSURE_CASH":
					Write.writeSBAccClosure_Cash(driver, orTemp[1].trim());
					break;
			  case "VERIFY SB_ACC_CLOSURE_CASH":
					VerifySummary.VerifySBAccClosure_Cash(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY SBCLOSURE_VOUCHERNO":
					VerifySummary.VerifySBClosureVoucherNo_Cash(driver);
					break;
			  case "VERIFY SBCLOSURE_TRANSTYPE":
					VerifySummary.VerifySBClosureTransType_Cash(driver);
					break;
			  case "VERIFY SBCLOSURE_AMOUNT":
					VerifySummary.VerifySBClosureAmount_Cash(driver);
					break;
			  case "VERIFY SBCLOSURE_AMOUNTTYPE":
					VerifySummary.VerifySBClosureAmountType_Cash(driver);
					break;
			  case "VERIFY  SBCLOSURE_GLCODE":
					VerifySummary.VerifySBClosureGLCode_Cash(driver);
					break;
			  case "VERIFY SBCLOSURE_TRMODE":
					VerifySummary.VerifySBClosureTrMode_Cash(driver);
					break;
			  case "READ SBCLOSURE_CASH TRANSID":
					ReadTransID.GetTransIdForSBClosure_Cash(orTemp[1].trim());
					break;
	//SB CLOSURE BATCH MODE
			  case "WRITE SB_ACC_CLOSURE_BATCH":
					Write.writeSBAccClosure_Batch(driver, orTemp[1].trim());
					break;
			  case "VERIFY SB_ACC_CLOSURE_BATCH":
					VerifySummary.VerifySBAccClosure_Batch(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY SBCLRE_VOUCHERNO":
					VerifySummary.VerifySBClosureVoucherNo_Batch(driver);
					break;
			  case "VERIFY SBCLRE_TRANSTYPE":
					VerifySummary.VerifySBClosureTransType_Batch(driver);
					break;
			  case "VERIFY SBCLRE_AMOUNT":
					VerifySummary.VerifySBClosureAmount_Batch(driver);
					break;
			  case "VERIFY SBCLRE_AMOUNTTYPE":
					VerifySummary.VerifySBClosureAmountType_Batch(driver);
					break;
			  case "VERIFY  SBCLRE_GLCODE":
					VerifySummary.VerifySBClosureGLCode_Batch(driver);
					break;
			  case "VERIFY SBCLRE_TRMODE":
					VerifySummary.VerifySBClosureTrMode_Batch(driver);
					break;
			  case "READ SBCLOSURE_BATCH TRANSID":
					ReadTransID.GetTransIdForSBClosure_Batch(orTemp[1].trim());
					break;
			  case "READ SBCLOSURE AMOUNT":
					ReadAmount.getAmountForSBAccClosure_Batch(orTemp[1].trim());
					break;
	//SB CLOSURE AUTOPOST MODE
			  case "WRITE SB_ACC_CLOSURE_AUTO":
					Write.WriteSBAccountClosure_Autopost(driver,  orTemp[1].trim());
					break;
			  case "VERIFY SB_ACC_CLOSURE_AUTO":
				    VerifySummary.VerifySBAccountClosure_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY SBCLOSURE_VRNO":
					VerifySummary.VerifySBClosureVoucherNo_Autopost(driver);
					break;
			  case "VERIFY SBCLOSURE_TRTYPE":
					VerifySummary.VerifySBClosureTransType_Autopost(driver);
					break;
			  case "VERIFY SBCLOSURE_AMT":
					VerifySummary.VerifySBClosureAmount_Autopost(driver);
					break;
			  case "VERIFY SBCLOSURE_AMTTYPE":
					VerifySummary.VerifySBClosureAmountType_Autopost(driver);
					break;
			  case "VERIFY  SBCLOSURE_GL_CODE":
					VerifySummary.VerifySBClosureGLCode_Autopost(driver);
					break;
			  case "READ SBCLOSURE_AUTO TRANSID":
					ReadTransID.ReadTransIdForWriteSBAccountClosure_AUTOPOST( orTemp[1].trim());
					break;
	//FD CLOSURE CASH MODE
			  case "READ MATURED FD ACNO":
					ReadCustomerID.getFDACCountClosure_AcNo(driver, orTemp[1].trim());
					break;
			  case "WRITE FD_ACC_CLOSURE_CASH":
					Write.writeFDAccClosure_Cash(driver, orTemp[1].trim());
					break;
			  case "VERIFY FD_ACC_CLOSURE_CASH":
					VerifySummary.VerifyFDAccClosure_Cash(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY FDCLOSURE_AMOUNT":
					VerifySummary.VerifyFDClosureAmount_Cash(driver);
					break;
			  case "VERIFY FDCLOSURE_AMOUNTTYPE":
					VerifySummary.VerifyFDClosureAmountType_Cash(driver);
					break;
			  case "VERIFY  FDCLOSURE_GLCODE":
					VerifySummary.VerifyFDClosureGLCode_Cash(driver);
					break;
			  case "READ FDCLOSURE_CASH TRANSID":
					ReadTransID.GetTransIdForFDClosure_Cash(orTemp[1].trim());
					break;
					
	//FD CLOSURE BATCH MODE	
			  case "WRITE FD_ACC_CLOSURE_BATCH":
					Write.writeFDAccClosure_Batch(driver, orTemp[1].trim());
					break;
			  case "VERIFY FD_ACC_CLOSURE_BATCH":
					VerifySummary.VerifyFDAccClosure_Batch(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY FDCLRE_AMOUNT":
					VerifySummary.VerifyFDClosureAmount_Batch(driver);
					break;
			  case "VERIFY FDCLRE_AMOUNTTYPE":
					VerifySummary.VerifyFDClosureAmountType_Batch(driver);
					break;
			  case "VERIFY  FDCLRE_GLCODE":
					VerifySummary.VerifyFDClosureGLCode_Batch(driver);
					break;
			  case "READ FDCLOSURE_BATCH TRANSID":
					ReadTransID.GetTransIdForFDClosure_Batch(orTemp[1].trim());
					break;
			  case "READ FDCLOSURE AMOUNT":
					ReadAmount.getAmountForFDAccClosure_Batch(orTemp[1].trim());
					break;
	//FD CLOSURE AUTOPOST MODE
					
			  case "VERIFY PRE_MATUREDROI FD":
					TransactionsOperations.VerifyPrematureROI_FD(driver,orTemp[1].trim());
					break;
			    case "READ PREMATURED_FD ACNO":
					ReadCustomerID.getFDInterBranchAcNo(driver, orTemp[1].trim());
					break;
				case "WRITE FD_ACC_CLOSURE_AUTO":
					Write.writeFDAccountClosure_Autopost(driver, orTemp[1].trim());
					break;
				case "VERIFY FD_ACC_CLOSURE_AUTO":
					VerifySummary.Verify_FDAccountClosure_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
				case "VERIFY FDCLOSURE_VRNO":
					VerifySummary.VerifyFDAccountClosureAutopostVrNo(driver);
					break;	
				case "VERIFY FDCLOSURE_TRTYPE":
					VerifySummary.VerifyFDAccountClosureAutopostTrType(driver);
					break;
				case "VERIFY FDCLOSURE_AMTTYPE":
					VerifySummary.VerifyFDAccountClosureAutopostAmtTypes(driver);
					break;
				case "VERIFY  FDCLOSURE_GL_CODE":
					VerifySummary.VerifyFDAccountClosureAutopostGLCode(driver);
					break;
				case "VERIFY  FDCLOSURE_BRID":
					VerifySummary.VerifyFDAccountClosureAutopostBrCode(driver);
					break;
				case "READ FDCLOSURE_AUTO TRANSID":
					ReadTransID.GetTransIdForFDAccountClosureAutopost(orTemp[1].trim());
					break;
	//RD CLOSURE CASH MODE
			  case "READ MATURED RD ACNO":
					ReadCustomerID.getRDACCountClosure_AcNo(driver, orTemp[1].trim());
					break;
			  case "WRITE RD_ACC_CLOSURE_CASH":
					Write.writeRDAccClosure_Cash(driver, orTemp[1].trim());
					break;
			  case "VERIFY RD_ACC_CLOSURE_CASH":
					VerifySummary.VerifyRDAccClosure_Cash(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY RDCLOSURE_AMOUNT":
					VerifySummary.VerifyRDClosureAmount_Cash(driver);
					break;
			  case "VERIFY RDCLOSURE_AMOUNTTYPE":
					VerifySummary.VerifyRDClosureAmountType_Cash(driver);
					break;
			  case "VERIFY  RDCLOSURE_GLCODE":
					VerifySummary.VerifyRDClosureGLCode_Cash(driver);
					break;
			  case "READ RDCLOSURE_CASH TRANSID":
					ReadTransID.GetTransIdForRDClosure_Cash(orTemp[1].trim());
					break;
	//RD CLOSURE BATCH MODE
			  case "WRITE RD_ACC_CLOSURE_BATCH":
					Write.writeRDAccClosure_Batch(driver, orTemp[1].trim());
					break;
			  case "VERIFY RD_ACC_CLOSURE_BATCH":
					VerifySummary.VerifyRDAccClosure_Batch(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY RDCLRE_AMOUNT":
					VerifySummary.VerifyRDClosureAmount_Batch(driver);
					break;
			  case "VERIFY RDCLRE_AMOUNTTYPE":
					VerifySummary.VerifyRDClosureAmountType_Batch(driver);
					break;
			  case "VERIFY  RDCLRE_GLCODE":
					VerifySummary.VerifyRDClosureGLCode_Batch(driver);
					break;
			  case "READ RDCLOSURE_BATCH TRANSID":
					ReadTransID.GetTransIdForRDClosure_Batch(orTemp[1].trim());
					break;
			  case "READ RDCLOSURE AMOUNT":
					ReadAmount.getAmountForRDAccClosure_Batch(orTemp[1].trim());
					break;
	//RD CLOSURE AUTOPOST MODE
			 
			   case "READ PREMATURED_RD ACNO":
					ReadCustomerID.getRDInterBranchAcNo(driver, orTemp[1].trim());
					break;
			   case "VERIFY PRE_ROI RD":
					TransactionsOperations.VerifyPrematureROI_RD(driver,orTemp[1].trim());
					break;
			   case "WRITE RD_ACC_CLOSURE_AUTO":
					Write.writeRDAccountClosure_Autopost(driver, orTemp[1].trim());
					break;
			   case "VERIFY RD_ACC_CLOSURE_AUTO":
					VerifySummary.Verify_RDAccountClosure_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			   case "VERIFY RDCLOSURE_VRNO":
					VerifySummary.VerifyRDAccountClosureAutopostVrNo(driver);
					break;	
			   case "VERIFY RDCLOSURE_TRTYPE":
					VerifySummary.VerifyRDAccountClosureAutopostTrType(driver);
					break;
			  case "VERIFY RDCLOSURE_AMTTYPE":
					VerifySummary.VerifyRDAccountClosureAutopostAmtTypes(driver);
					break;
			  case "VERIFY  RDCLOSURE_GL_CODE":
					VerifySummary.VerifyRDAccountClosureAutopostGLCode(driver);
					break;
			  case "VERIFY  RDCLOSURE_BRID":
					VerifySummary.VerifyRDAccountClosureAutopostBrCode(driver);
					break;
			  case "READ RDCLOSURE_AUTO TRANSID":
					ReadTransID.GetTransIdForRDAccountClosureAutopost(orTemp[1].trim());
					break;
					
			  case "GO BUTTON":
					Common.ClickonGoButton(driver, orTemp[1].trim());
					break;
			  case "CLICK ON GO":
					Common.ClickonGoButton_InterestPayment(driver, orTemp[1].trim());
					break;		
					
					
	//DD CLOSURE CASH MODE
			  case "READ MATURED DD ACNO":
					ReadCustomerID.getDDACCountClosure_AcNo(driver, orTemp[1].trim());
					break;
			  case "WRITE DD_ACC_CLOSURE_CASH":
					Write.writeDDAccClosure_Cash(driver, orTemp[1].trim());
					break;
			  case "VERIFY DD_ACC_CLOSURE_CASH":
					VerifySummary.VerifyDDAccClosure_Cash(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY DDCLOSURE_AMOUNT":
					VerifySummary.VerifyDDClosureAmount_Cash(driver);
					break;
			  case "VERIFY DDCLOSURE_AMOUNTTYPE":
					VerifySummary.VerifyDDClosureAmountType_Cash(driver);
					break;
			  case "VERIFY  DDCLOSURE_GLCODE":
					VerifySummary.VerifyDDClosureGLCode_Cash(driver);
					break;
			  case "READ DDCLOSURE_CASH TRANSID":
					ReadTransID.GetTransIdForDDClosure_Cash(orTemp[1].trim());
					break;
	//DD CLOSURE BATCH MODE
			  case "WRITE DD_ACC_CLOSURE_BATCH":
					Write.writeDDAccClosure_Batch(driver, orTemp[1].trim());
					break;
			  case "VERIFY DD_ACC_CLOSURE_BATCH":
					VerifySummary.VerifyDDAccClosure_Batch(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY DDCLRE_AMOUNT":
					VerifySummary.VerifyDDClosureAmount_Batch(driver);
					break;
			  case "VERIFY DDCLRE_AMOUNTTYPE":
					VerifySummary.VerifyDDClosureAmountType_Batch(driver);
					break;
			  case "VERIFY  DDCLRE_GLCODE":
					VerifySummary.VerifyDDClosureGLCode_Batch(driver);
					break;
			  case "READ DDCLOSURE_BATCH TRANSID":
					ReadTransID.GetTransIdForDDClosure_Batch(orTemp[1].trim());
					break;
			  case "READ DDCLOSURE AMOUNT":
					ReadAmount.getAmountForDDAccClosure_Batch(orTemp[1].trim());
					break;
	//DD CLOSURE AUTOPOST MODE
			  
			    case "READ PREMATURED_DD ACNO":
					ReadCustomerID.getDDInterBranchAcNo(driver, orTemp[1].trim());
					break;
			    case "VERIFY PRE_ROI DD":
					TransactionsOperations.VerifyPrematureROI_DD(driver,orTemp[1].trim());
					break;	
				case "WRITE DD_ACC_CLOSURE_AUTO":
					Write.writeDDAccountClosure_Autopost(driver, orTemp[1].trim());
					break;
				case "VERIFY DD_ACC_CLOSURE_AUTO":
					VerifySummary.Verify_DDAccountClosure_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
				case "VERIFY DDCLOSURE_VRNO":
					VerifySummary.VerifyDDAccountClosureAutopostVrNo(driver);
					break;	
				case "VERIFY DDCLOSURE_TRTYPE":
					VerifySummary.VerifyDDAccountClosureAutopostTrType(driver);
					break;
				case "VERIFY DDCLOSURE_AMTTYPE":
					VerifySummary.VerifyDDAccountClosureAutopostAmtTypes(driver);
					break;
				case "VERIFY  DDCLOSURE_GL_CODE":
					VerifySummary.VerifyDDAccountClosureAutopostGLCode(driver);
					break;
				case "VERIFY  DDCLOSURE_BRID":
					VerifySummary.VerifyDDAccountClosureAutopostBrCode(driver);
					break;
				case "READ DDCLOSURE_AUTO TRANSID":
					ReadTransID.GetTransIdForDDAccountClosureAutopost(orTemp[1].trim());
					break;
	//RID CLOSURE CASH MODE
			  case "READ MATURED RID ACNO":
					ReadCustomerID.getRIDACCountClosure_AcNo(driver, orTemp[1].trim());
					break;
			  case "WRITE RID_ACC_CLOSURE_CASH":
					Write.writeRIDAccClosure_Cash(driver, orTemp[1].trim());
					break;
			  case "VERIFY RID_ACC_CLOSURE_CASH":
					VerifySummary.VerifyRIDAccClosure_Cash(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY RIDCLOSURE_AMOUNT":
					VerifySummary.VerifyRIDClosureAmount_Cash(driver);
					break;
			  case "VERIFY RIDCLOSURE_AMOUNTTYPE":
					VerifySummary.VerifyRIDClosureAmountType_Cash(driver);
					break;
			  case "VERIFY  RIDCLOSURE_GLCODE":
					VerifySummary.VerifyRIDClosureGLCode_Cash(driver);
					break;
			  case "READ RIDCLOSURE_CASH TRANSID":
					ReadTransID.GetTransIdForRIDClosure_Cash(orTemp[1].trim());
					break;	
	//RID CLOSURE BATCH MODE
			  case "WRITE RID_ACC_CLOSURE_BATCH":
					Write.writRIDDAccClosure_Batch(driver, orTemp[1].trim());
					break;
			  case "VERIFY RID_ACC_CLOSURE_BATCH":
					VerifySummary.VerifyRIDAccClosure_Batch(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY RIDCLRE_AMOUNT":
					VerifySummary.VerifyRIDClosureAmount_Batch(driver);
					break;
			  case "VERIFY RIDCLRE_AMOUNTTYPE":
					VerifySummary.VerifyRIDClosureAmountType_Batch(driver);
					break;
			  case "VERIFY  RIDCLRE_GLCODE":
					VerifySummary.VerifyRIDClosureGLCode_Batch(driver);
					break;
			  case "READ RIDCLOSURE_BATCH TRANSID":
					ReadTransID.GetTransIdForRIDClosure_Batch(orTemp[1].trim());
					break;
			  case "READ RIDCLOSURE AMOUNT":
					ReadAmount.getAmountForRIDAccClosure_Batch(orTemp[1].trim());
					break;
	//RID CLOSURE AUTOPOST MODE	
			  
			    case "READ PREMATURED_RID ACNO":
					ReadCustomerID.getRIDInterBranchAcNo(driver, orTemp[1].trim());
					break;
			    case "VERIFY PRE_ROI RID":
					TransactionsOperations.VerifyPrematureROI_RID(driver,orTemp[1].trim());
					break;
				case "WRITE RID_ACC_CLOSURE_AUTO":
					Write.writeRIDAccountClosure_Autopost(driver, orTemp[1].trim());
					break;
				case "VERIFY RID_ACC_CLOSURE_AUTO":
					VerifySummary.Verify_RIDAccountClosure_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
				case "VERIFY RIDCLOSURE_VRNO":
					VerifySummary.VerifyRIDAccountClosureAutopostVrNo(driver);
					break;	
				case "VERIFY RIDCLOSURE_TRTYPE":
					VerifySummary.VerifyRIDAccountClosureAutopostTrType(driver);
					break;
				case "VERIFY RIDCLOSURE_AMTTYPE":
					VerifySummary.VerifyRIDAccountClosureAutopostAmtTypes(driver);
					break;
				case "VERIFY  RIDCLOSURE_GL_CODE":
					VerifySummary.VerifyRIDAccountClosureAutopostGLCode(driver);
					break;
				case "VERIFY  RIDCLOSURE_BRID":
					VerifySummary.VerifyRIDAccountClosureAutopostBrCode(driver);
					break;
				case "READ RIDCLOSURE_AUTO TRANSID":
					ReadTransID.GetTransIdForRIDAccountClosureAutopost(orTemp[1].trim());
					break;
					
	//CASH CREDIT RENEWAL OD CASH
				case "GET CC OD ACNO":
					ReadCustomerID.getCashCreditODAcNo(driver, orTemp[1].trim());
					break;
				case "GET CC OD ACNO FOR RENEWAL BATCH":
					ReadCustomerID.GetODKCCAcNoForCashCrediRenewalBatch(driver, orTemp[1].trim());
					break;
				case "READ CC OD ACNO":
					ReadCustomerID.ReadCashCreditODAccountNo(orTemp[1].trim());
					break;
			   case "READ IP OD ACNO":
					ReadCustomerID.getInterestPostingODAcNo(driver, orTemp[1].trim());
					break;
			   case "READ CC OD RESOLUTION DATE":
					Common.ReadCCRenewalOD_ResolutionDate(driver, orTemp[1].trim());
					break;	
			   case "WRITE OD_CC_RENEWAL_CASH":
					Write.writeODCashCreditRenewal_Cash(driver, orTemp[1].trim());
					break;
			   case "VERIFY OD_CC_RENEWAL_CASH":
					VerifySummary.VerifyODCashCreditRenewal_Cash(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			   case "READ ODCCRENEWAL_CASH TRANSID":
					ReadTransID.GetTransIdForODCashCreditRenewalCash(driver, orTemp[1].trim());
					break;
					
	//CASH CREDIT RENEWAL OD AUTOPOST
	//CASH CREDIT RENEWAL OD BATCH	
			   case "WRITE OD_CC_RENEWAL_BATCH":
					Write.writeODCashCreditRenewal_Batch(driver, orTemp[1].trim());
					break;
			  case "VERIFY OD_CC_RENEWAL_BATCH":
					VerifySummary.VerifyODCashCreditRenewal_Batch(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "READ ODRENEWAL_BATCH TRANSID":
					ReadTransID.GetTransIdForODCashCreditRenewalBatch(driver, orTemp[1].trim());
					break;
			  case "READ OD RENEWAL AMOUNT":
					ReadAmount.getAmountForODCashCreditRenewal_Batch(orTemp[1].trim());
					break;
	//ACCOUNT RENEWAL FD CASH
			  case "CLICK ON SUBMIT":
					Common.ClickonSubmitButton(driver, orTemp[1].trim());
					break;
					
					
			  case "READ PREMATURE_FD ACNO":
					ReadCustomerID.getPrematureFDRenewalAcNo(driver, orTemp[1].trim());
					break;
			  case "CHECK FOR INTEREST TRANSFER":
					Common.CheckInterestTransfer(driver, orTemp[1].trim());
					break;
			  case "WRITE FD_ACC_RENEWAL_CASH":
					Write.writeFDRenewal_Cash(driver, orTemp[1].trim());
					break;
			  case "VERIFY FD_ACC_RENEWAL_CASH":
					VerifySummary.VerifyFDRenewal_Cash(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY FD_RL_VOUCHER_CASH":
					VerifySummary.VerifyFDRenewalVoucherNo_Cash(driver);
					break;
			  case "VERIFY FD_RL_TRANSTYPE_CASH":
					VerifySummary.VerifyFDRenewalTransType_Cash(driver);
					break;
			  case "VERIFY FD_RL_AMOUNT_CASH":
					VerifySummary.VerifyFDRenewalAmount_Cash(driver);
					break;
			  case "VERIFY FD_RL_AMTTYPE_CASH":
					VerifySummary.VerifyFDRenewalAmountType_Cash(driver);
					break;
			  case "VERIFY FD_RL_GLCODE_CASH":
					VerifySummary.VerifyFDRenewalGLCode_Cash(driver);
					break;
			  case "VERIFY FD_RL_TRMODE_CASH":
					VerifySummary.VerifyFDRenewalTrMode_Cash(driver);
					break;
			  case "READ FDRENEWAL_CASH TRANSID":
					ReadTransID.GetTransIdForFDRenewalCash(driver, orTemp[1].trim());
					break;
					
	//ACCOUNT RENEWAL FD AUTOPOST
					
			  case "READ MATURED_FD ACNO":
					ReadCustomerID.getMaturedFDRenewalInterBranchAcNo(driver, orTemp[1].trim());
					break;
			  case "VERIFY TOTAL AMOUNT":
					TransactionsOperations.VerifyFDRenewal_TotalAmount(driver,orTemp[1].trim());
					break;
			  case "WRITE FD_RENEWAL_AUTO":
					Write.writeFDRenewal_Autopost(driver, orTemp[1].trim());
					break;
			  case "VERIFY FD_RENEWAL_AUTO":
					VerifySummary.VerifyFDRenewal_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY FDRL_VRNO CASH":
					VerifySummary.VerifyFDRenewalVoucherNo_Autopost(driver);
					break;
			  case "VERIFY FDRL_TRTYPE CASH":
					VerifySummary.VerifyFDRenewalTransType_Autopost(driver);
					break;
			  case "VERIFY FDRL_AMT CASH":
					VerifySummary.VerifyFDRenewalAmount_Autopost(driver);
					break;
			  case "VERIFY FDRL_AMTTYPE CASH":
					VerifySummary.VerifyFDRenewalAmountType_Autopost(driver);
					break;
			  case "VERIFY  FDRL_GL_CODE CASH":
					VerifySummary.VerifyFDRenewalGLCode_Autopost(driver);
					break;
			  case "VERIFY  FDRL_BRID CASH":
					VerifySummary.VerifyFDRenewalTrMode_Autopost(driver);
					break;
			  case "READ FDRENEWAL_AUTO TRANSID":
					ReadTransID.GetTransIdForFDRenewalAutopost(driver, orTemp[1].trim());
					break;
			  case "CLICK BATCH SUBMIT":
					Common.ClickonSubmitButton_Batch(driver, orTemp[1].trim());
					break;
			  case "IF ELSE CHECK INTEREST TRANSFER":
					Common2.IfElseCheckInterestTransfer(driver, orTemp[0].trim(), orTemp[1].trim());
					break;
					
  //ACCOUNT RENEWAL FD BATCH
			  case "WRITE FD_RENEWAL_BATCH":
					Write.writeFDRenewal_Batch(driver, orTemp[1].trim());
					break;
			  case "VERIFY FD_RENEWAL_BATCH":
					VerifySummary.VerifyFDRenewal_Batch(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY FDRL_VRNO_BATCH":
					VerifySummary.VerifyFDRenewalVoucherNo_Batch(driver);
					break;
			  case "VERIFY FDRL_TRANSTYPE_BATCH":
					VerifySummary.VerifyFDRenewalTransType_Batch(driver);
					break;
			  case "VERIFY FDRL_AMT_BATCH":
					VerifySummary.VerifyFDRenewalAmount_Batch(driver);
					break;
			  case "VERIFY FDRL_AMTTYPE_BATCH":
					VerifySummary.VerifyFDRenewalAmountType_Batch(driver);
					break;
			  case "VERIFY FDRL_GLCODE_BATCH":
					VerifySummary.VerifyFDRenewalGLCode_Batch(driver);
					break;
			  case "READ FDRL_BATCH TRANSID":
					ReadTransID.GetTransIdForFDRenewalBatch(driver, orTemp[1].trim());
					break;
			  case "READ FDRENEWAL AMOUNT":
					ReadAmount.getAmountForFDRenewal_Batch(orTemp[1].trim());
					break;
					
	//GL RENEWAL CASH
					
			  case "ENTER SANCTIONED AMOUNT":
					TransactionsOperations.VerifyGLRenewal_SanctionedAmount(driver,orTemp[1].trim());
					break;
			  case "WRITE GL_RENEWAL_CASH":
					Write.writeGLRenewal_Cash(driver, orTemp[1].trim());
					break;
			  case "VERIFY GL_RENEWAL_CASH":
					VerifySummary.VerifyGLRenewal_Cash(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY GL_RL_VOUCHER_CASH":
					VerifySummary.VerifyGLRenewalVoucherNo_Cash(driver);
					break;
			  case "VERIFY GL_RL_TRANSTYPE_CASH":
					VerifySummary.VerifyGLRenewalTransType_Cash(driver);
					break;
			  case "VERIFY GL_RL_AMOUNT_CASH":
					VerifySummary.VerifyGLRenewalAmount_Cash(driver);
					break;
			  case "VERIFY GL_RL_AMTTYPE_CASH":
					VerifySummary.VerifyGLRenewalAmountType_Cash(driver);
					break;
			  case "VERIFY GL_RL_GLCODE_CASH":
					VerifySummary.VerifyGLRenewalGLCode_Cash(driver);
					break;
			  case "VERIFY GL_RL_TRMODE_CASH":
					VerifySummary.VerifyGLRenewalTrMode_Cash(driver);
					break;
			  case "READ GLRENEWAL_CASH TRANSID":
					ReadTransID.GetTransIdForGLRenewalCash(driver, orTemp[1].trim());
					break;
			  case "READ GL RENEWAL_CASH TRANSID":
					ReadTransID.WriteGLRenewCash(driver, orTemp[0].trim(), orTemp[1].trim());
					break;	
			  case "READ GLRENEWAL_CASH TRANSID2":
					ReadTransID.GetTransIdForGLRenewalCash2(driver, orTemp[1].trim());	
					break;	
	//GL RENEWAL BATCH
			  case "WRITE GL_RENEWAL_BATCH":
					Write.writeGLRenewal_Batch(driver, orTemp[1].trim());
					break;
			  case "VERIFY GL_RENEWAL_BATCH":
					VerifySummary.VerifyGLRenewal_Batch(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY GL_RL_VOUCHER_BATCH":
					VerifySummary.VerifyGLRenewalVoucherNo_Batch(driver);
					break;
			  case "VERIFY GL_RL_TRANSTYPE_BATCH":
					VerifySummary.VerifyGLRenewalTransType_Batch(driver);
					break;
			  case "VERIFY GL_RL_AMOUNT_BATCH":
					VerifySummary.VerifyGLRenewalAmount_Batch(driver);
					break;
			  case "VERIFY GL_RL_AMTTYPE_BATCH":
					VerifySummary.VerifyGLRenewalAmountType_Batch(driver);
					break;
			  case "VERIFY GL_RL_GLCODE_BATCH":
					VerifySummary.VerifyGLRenewalGLCode_Batch(driver);
					break;
			  case "READ GLRL_BATCH TRANSID":
					ReadTransID.GetTransIdForGLRenewalBatch(driver, orTemp[0].trim(), orTemp[1].trim());
					break;
			  case "READ GLRENEWAL AMOUNT":
					ReadAmount.getAmountForGLRenewal_Batch(orTemp[1].trim());
					break;
					
	//GL RENEWAL AUTOPOST	
			  case "WRITE GL_RENEWAL_AUTO":
					Write.writeGLRenewal_Autopost(driver, orTemp[1].trim());
					break;
			  case "VERIFY GL_RENEWAL_AUTO":
					VerifySummary.VerifyGLRenewal_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY GLRL_VRNO AUTO":
					VerifySummary.VerifyGLRenewalVoucherNo_Autopost(driver);
					break;
			  case "VERIFY GLRL_TRTYPE AUTO":
					VerifySummary.VerifyGLRenewalTransType_Autopost(driver);
					break;
			  case "VERIFY GLRL_AMT AUTO":
					VerifySummary.VerifyGLRenewalAmount_Autopost(driver);
					break;
			  case "VERIFY GLRL_AMTTYPE AUTO":
					VerifySummary.VerifyGLRenewalAmountType_Autopost(driver);
					break;
			  case "VERIFY  GLRL_GL_CODE AUTO":
					VerifySummary.VerifyGLRenewalGLCode_Autopost(driver);
					break;
			  case "VERIFY  GLRL_BRID AUTO":
					VerifySummary.VerifyGLRenewalTrMode_Autopost(driver);
					break;
			  case "READ GLRENEWAL_AUTO TRANSID":
					ReadTransID.GetTransIdForGLRenewalAutopost(driver, orTemp[1].trim());
					break;	
					
					
	//OTHER LOAN CLOSURE CASH
			  case "VERIFY INST DUE NO OL":
				  TransactionsOperations.VerifyInstDueNoForOL(driver, orTemp[1].trim());
				  break;
			  case "VERIFY INST DUE AMOUNT OL":
				  TransactionsOperations.VerifyInstDueAmountForOL(driver, orTemp[1].trim());
				  break;
			  case "VERIFY INST DUE AMOUNT OL2":
				  TransactionsOperations.VerifyInstDueAmountForOL2(driver, orTemp[1].trim());
				  break;		
			  case "WRITE OL_CLOSURE_CASH":
					Write.writeOLClosure_Cash(driver, orTemp[1].trim());
					break;
			  case "VERIFY OL_CLOSURE_CASH":
					VerifySummary.VerifyOLClosure_Cash(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY OLCLOSURE_AMNT_CASH":
					VerifySummary.VerifyOLClosureAmount_Cash(driver);
					break;
			  case "VERIFY OLCLOSURE_AMNTTYPE_CASH":
					VerifySummary.VerifyOLClosureAmountType_Cash(driver);
					break;
			  case "VERIFY  OLCLOSURE_GLCODE_CASH":
					VerifySummary.VerifyOLClosureGLCode_Cash(driver);
					break;
			  case "READ OLCLOSURE_CASH TRANSID":
					ReadTransID.GetTransIdForOLClosure_Cash(driver, orTemp[1].trim());
					break;
	//OTHER LOAN CLOSURE AUTOPOST
			  case "WRITE OL_CLOSURE_AUTO":
					Write.writeOLClosure_Autopost(driver, orTemp[1].trim());
					break;
			  case "VERIFY OL_CLOSURE_AUTO":
					VerifySummary.Verify_OLClosure_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
				case "VERIFY OLCLRE VRNO_AUTO":
					VerifySummary.VerifyOLClosureAutopostVrNo(driver);
					break;	
				case "VERIFY OLCLRE TRANSTYPE_AUTO":
					VerifySummary.VerifyOLClosureAutopostTrType(driver);
					break;
				case "VERIFY OLCLRE AMNT_ AUTO":
					VerifySummary.VerifyOLClosureAutopostAmt(driver);
					break;	
				case "VERIFY OLCLRE AMNTTYPE_ AUTO":
					VerifySummary.VerifyOLClosureAutopostAmtTypes(driver);
					break;
				case "VERIFY OLCLRE GLCODE_ AUTO":
					VerifySummary.VerifyOLClosureAutopostGLCode(driver);
					break;
				case "VERIFY OLCLRE BRCODE_AUTO":
					VerifySummary.VerifyOLClosureAutopostBrCode(driver);
					break;
				case "READ OLCLRE_AUTO TRANSID":
					ReadTransID.GetTransIdForOLClosureAutopost(driver, orTemp[1].trim());
					break;
	//OTHER LOAN CLOSURE BATCH
			  case "READ OL CLOSURE ACNO":
					ReadCustomerID.getOLClosureAcNo(driver, orTemp[1].trim());
					break;
			  case "WRITE OL_CLOSURE_BATCH":
					Write.writeOLClosure_Batch(driver, orTemp[1].trim());
					break;
			  case "VERIFY OL_CLOSURE_BATCH":
					VerifySummary.VerifyOLClosure_Batch(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY OLCLOSURE_AMT_BATCH":
					VerifySummary.VerifyOLClosureAmount_Batch(driver);
					break;
			  case "VERIFY OLCLOSURE_AMTTYPE_BATCH":
					VerifySummary.VerifyOLClosureAmountType_Batch(driver);
					break;
			  case "VERIFY  OLCLOSURE_GLCODE_BATCH":
					VerifySummary.VerifyOLClosureGLCode_Batch(driver);
					break;
			  case "READ OLCLOSURE  BATCH TRANSID":
					ReadTransID.GetTransIdForOLClosure_Batch(driver, orTemp[1].trim());
					break;
			  case "READ OLCLOSURE  AMOUNT":
					ReadAmount.getAmountForOLClosure_Batch(orTemp[1].trim());
					break;
	//OVERDRAFT LOAN CLOSURE CASH
			  case "WRITE OD_ACC_CLOSURE_CASH":
					Write.writeODClosure_Cash(driver, orTemp[1].trim());
					break;
			  case "VERIFY OD_ACC_CLOSURE_CASH":
					VerifySummary.VerifyODClosure_Cash(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY ODCLOSURE_AMT_CASH":
					VerifySummary.VerifyODClosureAmount_Cash(driver);
					break;
			  case "VERIFY ODCLOSURE_AMTTYPE_CASH":
					VerifySummary.VerifyODClosureAmountType_Cash(driver);
					break;
			  case "VERIFY  ODCLOSURE_GLCODE_CASH":
					VerifySummary.VerifyODClosureGLCode_Cash(driver);
					break;
			  case "READ ODCLOSURE_CASH TRANSID":
					ReadTransID.GetTransIdForODClosure_Cash(driver, orTemp[1].trim());
					break;
	//OVERDRAFT LOAN CLOSURE AUTOPOST
			    case "WRITE OD_CLOSURE_AUTO":
					Write.writeODClosure_Autopost(driver, orTemp[1].trim());
					break;
			    case "VERIFY OD_CLOSURE_AUTO":
					VerifySummary.Verify_ODClosure_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
				case "VERIFY ODCLRE VRNO_AUTO":
					VerifySummary.VerifyODClosureAutopostVrNo(driver);
					break;	
				case "VERIFY ODCLRE TRANSTYPE_AUTO":
					VerifySummary.VerifyODClosureAutopostTrType(driver);
					break;
				case "VERIFY ODCLRE AMNT_ AUTO":
					VerifySummary.VerifyODClosureAutopostAmt(driver);
					break;	
				case "VERIFY ODCLRE AMNTTYPE_ AUTO":
					VerifySummary.VerifyODClosureAutopostAmtTypes(driver);
					break;
				case "VERIFY ODCLRE GLCODE_ AUTO":
					VerifySummary.VerifyODClosureAutopostGLCode(driver);
					break;
				case "VERIFY ODCLRE BRCODE_AUTO":
					VerifySummary.VerifyODClosureAutopostBrCode(driver);
					break;
				case "READ ODCLRE_AUTO TRANSID":
					ReadTransID.GetTransIdForODClosureAutopost(driver, orTemp[1].trim());
					break;
	//OVERDRAFT LOAN CLOSURE BATCH
			  case "READ OD CLOSURE ACNO":
					ReadCustomerID.getODClosureAcNo(driver, orTemp[1].trim());
					break;
			  case "WRITE OD_ACC_CLOSURE_BATCH":
					Write.writeODClosure_Batch(driver, orTemp[1].trim());
					break;
			  case "VERIFY OD_ACC_CLOSURE_BATCH":
					VerifySummary.VerifyODClosure_Batch(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY ODCLRE_AMT_BATCH":
					VerifySummary.VerifyODClosureAmount_Batch(driver);
					break;
			  case "VERIFY ODCLRE_AMTTYPE_BATCH":
					VerifySummary.VerifyODClosureAmountType_Batch(driver);
					break;
			  case "VERIFY  ODCLRE_GLCODE_BATCH":
					VerifySummary.VerifyODClosureGLCode_Batch(driver);
					break;
			  case "READ ODCLOSURE  BATCH TRANSID":
					ReadTransID.GetTransIdForODClosure_Batch(driver, orTemp[1].trim());
					break;
			  case "READ ODCLOSURE AMOUNT":
					ReadAmount.getAmountForODClosure_Batch(orTemp[1].trim());
					break;
			  
	//DEPOSIT LOAN CLOSURE CASH
			  case "WRITE DL_ACC_CLOSURE_CASH":
					Write.writeDLClosure_Cash(driver, orTemp[1].trim());
					break;
			  case "VERIFY DL_ACC_CLOSURE_CASH":
					VerifySummary.VerifyDLClosure_Cash(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY DLCLOSURE_AMT_CASH":
					VerifySummary.VerifyDLClosureAmount_Cash(driver);
					break;
			  case "VERIFY DLCLOSURE_AMTTYPE_CASH":
					VerifySummary.VerifyDLClosureAmountType_Cash(driver);
					break;
			  case "VERIFY  DLCLOSURE_GLCODE_CASH":
					VerifySummary.VerifyDLClosureGLCode_Cash(driver);
					break;
			  case "READ DLCLOSURE_CASH TRANSID":
					ReadTransID.GetTransIdForDLClosure_Cash(driver, orTemp[1].trim());
					break;
	//DEPOSIT LOAN CLOSURE AUTOPOST
			    case "WRITE DL_CLOSURE_AUTO":
					Write.writeDLClosure_Autopost(driver, orTemp[1].trim());
					break;
			    case "VERIFY DL_CLOSURE_AUTO":
					VerifySummary.Verify_DLClosure_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
				case "VERIFY DLCLRE VRNO_AUTO":
					VerifySummary.VerifyDLClosureAutopostVrNo(driver);
					break;	
				case "VERIFY DLCLRE TRANSTYPE_AUTO":
					VerifySummary.VerifyDLClosureAutopostTrType(driver);
					break;
				case "VERIFY DLCLRE AMNT_ AUTO":
					VerifySummary.VerifyDLClosureAutopostAmt(driver);
					break;	
				case "VERIFY DLCLRE AMNTTYPE_ AUTO":
					VerifySummary.VerifyDLClosureAutopostAmtTypes(driver);
					break;
				case "VERIFY DLCLRE GLCODE_ AUTO":
					VerifySummary.VerifyDLClosureAutopostGLCode(driver);
					break;
				case "VERIFY DLCLRE BRCODE_AUTO":
					VerifySummary.VerifyDLClosureAutopostBrCode(driver);
					break;
				case "READ DLCLRE_AUTO TRANSID":
					ReadTransID.GetTransIdForDLClosureAutopost(driver, orTemp[1].trim());
					break;
	//DEPOSIT LOAN CLOSURE BATCH
			  case "WRITE DL_ACC_CLOSURE_BATCH":
					Write.writeDLClosure_Batch(driver, orTemp[1].trim());
					break;
			  case "VERIFY DL_ACC_CLOSURE_BATCH":
					VerifySummary.VerifyDLClosure_Batch(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY DLCLOSURE_AMT_BATCH":
					VerifySummary.VerifyDLClosureAmount_Batch(driver);
					break;
			  case "VERIFY DLCLOSURE_AMTTYPE_BATCH":
					VerifySummary.VerifyDLClosureAmountType_Batch(driver);
					break;
			  case "VERIFY  DLCLOSURE_GLCODE_BATCH":
					VerifySummary.VerifyDLClosureGLCode_Batch(driver);
					break;
			  case "READ DLCLOSURE  BATCH TRANSID":
					ReadTransID.GetTransIdForDLClosure_Batch(driver, orTemp[1].trim());
					break;
			  case "READ DLCLOSURE  AMOUNT":
					ReadAmount.getAmountForDLClosure_Batch(orTemp[1].trim());
					break;
	//JEWEL LOAN CLOSURE CASH
			  case "WRITE GL_ACC_CLOSURE_CASH":
					Write.writeGLClosure_Cash(driver, orTemp[1].trim());
					break;
			  case "VERIFY GL_ACC_CLOSURE_CASH":
					VerifySummary.VerifyGLClosure_Cash(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY GLCLOSURE_AMT_CASH":
					VerifySummary.VerifyGLClosureAmount_Cash(driver);
					break;
			  case "VERIFY GLCLOSURE_AMTTYPE_CASH":
					VerifySummary.VerifyGLClosureAmountType_Cash(driver);
					break;
			  case "VERIFY  GLCLOSURE_GLCODE_CASH":
					VerifySummary.VerifyGLClosureGLCode_Cash(driver);
					break;
			  case "READ GLCLOSURE_CASH TRANSID":
					ReadTransID.GetTransIdForGLClosure_Cash(driver, orTemp[1].trim());
					break;
	//JEWEL LOAN CLOSURE AUTOPOST
			    
			    case "WRITE GL_CLOSURE_AUTO":
					Write.writeGLClosure_Autopost(driver, orTemp[1].trim());
					break;
			    case "VERIFY GL_CLOSURE_AUTO":
					VerifySummary.Verify_GLClosure_Autopost(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
				case "VERIFY GLCLRE VRNO_AUTO":
					VerifySummary.VerifyGLClosureAutopostVrNo(driver);
					break;	
				case "VERIFY GLCLRE TRANSTYPE_AUTO":
					VerifySummary.VerifyGLClosureAutopostTrType(driver);
					break;
				case "VERIFY GLCLRE AMNT_ AUTO":
					VerifySummary.VerifyGLClosureAutopostAmt(driver);
					break;	
				case "VERIFY GLCLRE AMNTTYPE_ AUTO":
					VerifySummary.VerifyGLClosureAutopostAmtTypes(driver);
					break;
				case "VERIFY GLCLRE GLCODE_ AUTO":
					VerifySummary.VerifyGLClosureAutopostGLCode(driver);
					break;
				case "READ GLCLRE_AUTO TRANSID":
					ReadTransID.GetTransIdForGLClosureAutopost(driver, orTemp[1].trim());
					break;
	//JEWEL LOAN CLOSURE BATCH
			  case "WRITE GL_ACC_CLOSURE_BATCH":
					Write.writeGLClosure_Batch(driver, orTemp[1].trim());
					break;
			  case "VERIFY GL_ACC_CLOSURE_BATCH":
					VerifySummary.VerifyGLClosure_Batch(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "VERIFY GLCLRE_AMT_BATCH":
					VerifySummary.VerifyGLClosureAmount_Batch(driver);
					break;
			  case "VERIFY GLCLRE_AMTTYPE_BATCH":
					VerifySummary.VerifyGLClosureAmountType_Batch(driver);
					break;
			  case "VERIFY  GLCLRE_GLCODE_BATCH":
					VerifySummary.VerifyGLClosureGLCode_Batch(driver);
					break;
			  case "READ GLCLOSURE  BATCH TRANSID":
					ReadTransID.GetTransIdForGLClosure_Batch(driver, orTemp[1].trim());
					break;
			  case "READ GLCLOSURE AMOUNT":
					ReadAmount.getAmountForGLClosure_Batch(orTemp[1].trim());
					break;
		//Add New Customer
			  case "FILE PHOTO UPLOAD":
						TestFileUploadSikuli.PhotoUpload(driver);
						break;
			  case "FILE SIGN UPLOAD":
					TestFileUploadSikuli.SignUpload(driver);
					   break;
			  case "CLICK CHECK AVAILABILITY":
					Common.ClickonCheckAvailability(driver, orTemp[1].trim());	
				       break;
			  case "CHECK AVAILABILITY":
					Common.CheckAvailabilityforQuickCustomer(driver, orTemp[1].trim());	
				       break;
			  case "CLICK SAVE BUTTON":
					Common.HandlePopup(driver);	
				       break;
				    
		//Interest Posting OD
				       
			  case "GET INTEREST":
				  TransactionsOperations.InterestPostingOD(driver, orTemp[1].trim());
					break; 
			  case "VERIFY NO:OF RECORDS":
				  TransactionsOperations.VerifyInterestPostingOD_VerifyNoofRecords(driver, orTemp[1].trim());
					break; 	
			  case "VERIFY STATUS":
				  TransactionsOperations.VerifyInterestPostingOD_status(driver, orTemp[1].trim());
					break; 
			  case "VERIFY PROGRESS VALUE":
				  TransactionsOperations.VerifyInterestPostingOD_ProgressValue(driver, orTemp[1].trim());
					break; 
			  case "VERIFY NO:OF COMPLETED ACCOUNTS":
				  TransactionsOperations.VerifyInterestPostingOD_CompletedAccounts(driver, orTemp[1].trim());
					break; 
			  case "VERIFY INTEREST":
				  TransactionsOperations.VerifyInterestPostingOD_Interest(driver, orTemp[1].trim());
					break; 
			  case "VERIFY ACCMASTERID":
				  TransactionsOperations.VerifyInterestPostingOD_AccMasterId(driver, orTemp[1].trim());
					break; 
					
		//NPA PROCESSING OL
					
			  case "VERIFY PROCESS":
				    TransactionsOperations.VerifyNPAProcessing(driver, orTemp[1].trim());
					break;
			  case "VERIFY NPA STATUS":
					TransactionsOperations.VerifyNPAProcessing_status(driver, orTemp[1].trim());
					break;
			  case "VERIFY NPA PROGRESSVALUE":
					TransactionsOperations.VerifyNPAProcessing_ProgressValue(driver, orTemp[1].trim());
					break;
	 //A CLASS SHARE CASH
					
			  case"READ CUST_ID ACLASS":
					ReadCustomerID.getCustomerIdforAClass(driver,orTemp[1].trim());
					break;		
		      case"VERIFY CGST":
					VerifyCGST.VerifyCGSTvalueShare(driver,orTemp[1].trim());
					break;
			  case"VERIFY SHARE TOTAL":	
					VerifyShareTotal.verifyShareTotal(driver, orTemp[1].trim());
					break;
			  case"VERIFY RECOVERY TOTAL":
					VerifyRecoveries.verifyRecoveryTotal(driver, orTemp[1].trim());
					break;
			  case"VERIFY TOTAL":
					VerifyTotal.VerifyTotalFigures(driver, orTemp[1].trim());
					break;
			  case"WRITE SHARE DETAILS CASH MODE":
					WriteShareCashModeOpeningDetailsToFile.writeShareOpeningDetails_CashMode(driver, orTemp[1].trim());
					break;
			  case"VERIFY SUMMARY TEXT ACLASS":
					VerifyAclass.Verify_ShareOpening_CashMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case"FETCH ACLASS-SHARE TRANID":
				  ReadTransID.getTransid(orTemp[1].trim());
					break;
	 //A CLASS SHARE AUTOPOST
			  case"WRITE SHARE DETAILS_TRANSFER MODE":
				  WriteShareOpeningDetails_TransferMode.writeShareOpeningDetails_TransferMode(driver, orTemp[1].trim());
					break;
			  case "VERIFY TEXT ACLASS":
				  VerifyAclass.Verify_ShareOpening_TransferMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case"READ ACLASS-SHARE TRANID":
				  ReadTransID.getTransid_Autopost(orTemp[1].trim());
					break;
	 //A CLASS SHARE BATCH
			  case"WRITE SHARE DETAILS_BATCH":
					WriteShareDetails_Batch.writeShareOpeningDetails_Batch(driver, orTemp[1].trim());
					break;
			  case "VERIFY ELEMENT ACLASS":
				  VerifyAclass.Verify_ShareOpening_BatchMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case"GET ACLASS-SHARE TRANID":
				  GetAclassShareTransID_batch.getTransid(orTemp[1].trim());
					break;
			  case"READ AMOUNT ACLASS":
					ReadAmount.getAmount(orTemp[1].trim());
					break;	
	 //C CLASS SHARE CASH
			  case"VERIFY PROCESSING FEE": 
					VerifyNomialShare_ProcessingFee.Verify_NominalShare_ProcessFee(driver, orTemp[1].trim());	
					break;
			  case"VERIFY RECOVERIES": 
					VerifyNominalShare_Recoveries.verifyRecoveryTotal(driver, orTemp[1].trim());
					break;
			  case"VERIFY SHARETOTAL": 
					VerifyNominalShare_Total.VerifyFinalTotal(driver,  orTemp[1].trim());
					break;
			  case"WRITE CSHARE DETAILS_CASH":
					WriteNominalShareDetails_CashMode.writeNominalShareOpeningDetails_CashMode(driver, orTemp[1].trim());
					break;
			  case "VERIFY FIELD CCLASS":
					VerifyCClass.Verify_NominalShareOpening_CashMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case "FETCH CCLASS-SHARE TRANID":
				   GetCclassTransId_CashMode.getTransid(orTemp[1].trim());
					break;
	 //C CLASS SHARE AUTOPOST
			  case"WRITE CSHARE DETAILS_TRANSFER MODE":
					WriteNominalShareDetails_TransferMode.writeNominalShareOpeningDetails_TransferMode(driver, orTemp[1].trim());
					break;
			  case "VERIFY ITEM CCLASS":
				  VerifyCClass.Verify_NominalShareOpening_TransferMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case"READ CCLASS-SHARE TRANID":
				  ReadCclassShare_transid.getTransid(orTemp[1].trim());
					break;
	//C CLASS SHARE BATCH	
			  case"WRITE CSHARE DETAILS_BATCH":
					WriteNominalShareDetails_BatchMode.writeNominalShareOpeningDetails_BatchMode(driver, orTemp[1].trim());
					break;
			  case "VERIFY SUMMARY ITEM CCLASS":
				  VerifyCClass.Verify_NominalShareOpening_BatchMode(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			  case"GET CCLASS-SHARE TRANID":
				  GetCclassShareTransID_batch.getTransid(orTemp[1].trim());
					break;
			  case"READ BATCH AMOUNT":
					ReadBatchAmount.getAmount(orTemp[1].trim());
					break;			
					//SB CREDIT TRANSACTION CASH
					
			   case"VERIFY SHADOW BALANCE":
			    	TransactionsOperations.VerifyNextShadowbalance1(driver, orTemp[1].trim());
					break;
				
							
	//SB CREDIT TRANSACTION AUTOPOST
								
				
								
	//SB CREDIT TRANSACTION BATCH
								
				
				case "READ SB_CR_BATCH TRANSID":
					ReadSB_transid.ReadTransIdForSBCredit_Batch(orTemp[1].trim());
					  break;
				case "READ SB_CREDIT AMT BATCH":
					ReadAmount.getAmountForSBCredit_Batch(orTemp[1].trim());
					  break;
	//SB DEBIT TRANSACTION CASH
				
				case "READ ACCOUNT NUMBER":
					Fetch_SB_TransID.ReadAccountNoForSB(driver, orTemp[0].trim(), orTemp[1].trim());
					break;
				
				case "VERIFY NEXT SH_BALANCE":
					TransactionsOperations.VerifyNextShadowbalance(driver, orTemp[1].trim());
					break;
				
				case "DATE CHANGE":
					Common.ChangeTransactionDate();
					break;
					
 //SB DEBIT TRANSACTION AUTOPOST
				case "READ ACCOUNT NO TRANS":
					Fetch_SB_TransID.ReadAccountNoForSBAutopost(driver, orTemp[0].trim(), orTemp[1].trim());
					break;
				
				case "ENTER SB CR AMOUNT":
					AutoPostAmountCalculator.SBCreditAmountCalculator(driver, orTemp[1].trim());
					break;
						
//SB Debit TRANSACTION BATCH	//changed Credit
	           
				case "READ SB CREDIT AMOUNT":
					ReadAmount.getAmountForSBDebit(orTemp[1].trim());
					break;	
					
//DD Credit CASH Mode
					
				case "VERIFY DD NEXT SH_BALANCE":
					TransactionsOperations.VerifyDDNextShadowbalance(driver, orTemp[1].trim());
					break;
				case "READ DD CREDIT ACCNO":
					FetchDDCredit_TransID.ReadAcNo_DDCreditCash(orTemp[1].trim());
					break;
				
		//DD Credit BATCH Mode
					
				case "MONTH CHANGE":
					Common.ChangeTransactionMonth();
					break;
				
		//DD Credit Autopost Mode
					
				case "READ AGENT CODE":
					FetchDDCredit_TransID.ReadAgentCode_DDCrAutopost(driver,orTemp[1].trim());
					break;
				case "READ DD CR INTBR ACCNO":
					FetchDDCredit_TransID.ReadAcNo_DDCrAutopost(driver,orTemp[1].trim());
					break;
				case "READ DD CR INTBR AMOUNT":
					AutoPostAmountCalculator.DDCreditInstallmentAmount(driver, orTemp[1].trim());
					break;
				
					
	//RD Credit Transactions CASH Mode
					
				
				case "READ RD CREDIT ACCNO":
					FetchDDCredit_TransID.ReadAcNo_RDCreditCash(orTemp[1].trim());
					break;
				
			    case "VERIFY FINE":
					TransactionsOperations.VerifyFineAmount(driver, orTemp[1].trim());
					break;
				

	//RD Credit Transactions AUTOPOST Mode
					
					
			    case "VERIFY RD NEXT SH_BALANCE":
					TransactionsOperations.VerifyRDNextShadowbalance(driver, orTemp[1].trim());
					break;		
				case "READ RD CR INTBR ACCNO":
					FetchDDCredit_TransID.ReadAcNo_RDCrAutopost(driver,orTemp[1].trim());
					break;
				
				case "ENTER RD CR AMOUNT":
					AutoPostAmountCalculator.RDCreditAmountCalculator(driver, orTemp[1].trim());
					break;
					
		//RD Credit Transactions Batch Mode
					
				
					
	// General
			  case "WAITSYNC":
				  Wait.WaitSync(driver);
				  break;
			  case "GETUNIQUENUMBER":
				  GeneralUtilities.getAadhaar();
				  break;
			  case "VERIFYSUMMARYDATA":
				  VerifySummary.verifySummaryData(driver, orTemp[0].trim(), orTemp[1].trim(), testData );
				  break;
			  case "VERIFYSUMMARY_DATA":
				  VerifySummary.verifySummaryData_Exceptions(driver, orTemp[0].trim(), orTemp[1].trim(), testData );
				  break;
			  case "ARREARPOPUPS":
				  GeneralUtilities.ArrearPopUps(driver, orTemp[0].trim(), orTemp[1].trim(), testData );
				  break;
				//NPA PROCESSING OL

			  case "VERIFY OL STATUS":

			              TransactionsOperations.VerifyNPAstatus_OL(driver, orTemp[1].trim());
			 	     break;
			  case "VERIFY OL PROGRESSVALUE":
			              TransactionsOperations.VerifyNPAProgressValue_OL(driver, orTemp[1].trim());
			 	     break;
			 					
			 //NPA PROCESSING OD
			 					
			 case "VERIFY OD STATUS":
			 	 TransactionsOperations.VerifyNPAstatus_OD(driver, orTemp[1].trim());
			 	 break;
			 case "VERIFY OD PROGRESSVALUE":
			 	TransactionsOperations.VerifyNPAProgressValue_OD(driver, orTemp[1].trim());
			 	break;  
			 	
			 	//DayEnd_Branch                 
				case "START PROCESSING":
				    TransactionsOperations.StartProcessing(driver, orTemp[1].trim());
					break; 			
				case "VERIFY PROCESSNAME":
					VerifySummary.verifyDayEndProcessName(driver, orTemp[0].trim(), orTemp[1].trim(), testData );
                  break;	
				//case "VERIFY  VALUES":
				//	TransactionsOperations.VerifyValues(driver, orTemp[1].trim());
				//	break;
				case "WRITE VALUES":
				    TransactionsOperations.WriteValues(driver, orTemp[1].trim());
					break;
				case "AUTHORIZE":
				    TransactionsOperations.DayEndAuthorize(driver, orTemp[1].trim());
					break;
				case "AUTHORIZE MGR_CASH":
				    TransactionsOperations.DayEndAuthorizeManager_Cash(driver, orTemp[1].trim());
					break;
				case "AUTHORIZE MGR_TRANS":
				    TransactionsOperations.DayEndAuthorizeManager_Transfer(driver, orTemp[1].trim());
					break;
				case "AUTHORIZE MGR_OTHERS":
				    TransactionsOperations.DayEndAuthorizeManager_Others(driver, orTemp[1].trim());
					break;
			   case "VERIFY DAYEND STATUS":
					TransactionsOperations.VerifyDayEnd_status(driver, orTemp[1].trim());
					break;
			   case "CLICK SUBMIT BTN":
				    TransactionsOperations.DayEndSubmit(driver, orTemp[1].trim());
					break;
	//DayEnd_Datacenter
			   case "VERIFY ADMIN PROCESSNAME":
					VerifySummary.verifyDayEndAdminProcessName(driver, orTemp[0].trim(), orTemp[1].trim(), testData );
                 break;	
			   case "START ADMIN PROCESSING":
				    TransactionsOperations.AdminStartProcessing(driver, orTemp[1].trim());
					break; 
			   case "VERIFY DAYEND ADMIN STATUS":
					TransactionsOperations.VerifyAdminDayEnd_status(driver, orTemp[1].trim());
					break;
			   case "DAYENDDATACENTERALERTHANDLERALONE":
				   TransactionsOperations.DayEndDataCenterAlertHandlerAlone(driver);
				   break;
	//DayBegin_Admin
			   case"VERIFY DAY BEGIN DATE":
				   TransactionsOperations.verifyDayBegindate(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
	//DayBegin_Branch
			   case"VERIFY BOD":
				   TransactionsOperations.verifyBOD(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;	
			   case "ACCEPT ALERT":
					System.out.println("inside accept alert");
					AlertHandler.AcceptAlert(driver);
					break;
			   case"VERIFY DAYBEGIN STATUS":
				   TransactionsOperations.Verify_status(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
			   case "EXEC SP":
				   Common.Execute_SP();
				   break;
				   
	// Locker module -------------------------------------------------------------------------------------------------------
			   case "WRITE LOCKER NUMBER":
				   WriteLockerDetails.WriteLockerNo(driver, orTemp[1].trim());
				   break;
			   case "READ LOCKER NUMBER AND SEND KEYS":
				   DifferentTypesOfWaits.ForLoopWaitPlusSendKeysWithoutTestData(driver, orTemp[1].trim(), testData);
				   break;
			   case "LOCKER RENT VERIFICATION":
				   LockerRentVerification.VerifyLockerRent(driver, orTemp[1].trim(), testData);
				   break;
			   case "LOCKER NO ALREADY EXISTS":
				   LockerRentVerification.LockerNumberAlreadyExist(driver, orTemp[1].trim());
				   break;
			   case "CLEAR TEXT FIELD":
				   LockerRentVerification.ClearTextField(driver, orTemp[1].trim());
				   break;
			   case "LOCKER NUMBER GENERATION":
				   WriteLockerDetails.GeneratingLockerNumber(driver, orTemp[1].trim(), testData);
				   break;
			   case "WRITE LOCKER RENT DETAILS":
				   WriteLockerDetails.WriteLockerRentDetails(driver, orTemp[1].trim());
				   break;
			   case "LOCKER RENT VERIFICATION WITH DATABASE":
					WriteIntoDataFiles.LockerRentSettingRentVerification(driver, orTemp[1].trim(), testData);
					break;
				case "LOCKER GRACE DURATION VERIFICATION WITH DATABASE":
					WriteIntoDataFiles.LockerRentGraceDurationVerification(driver, orTemp[1].trim(), testData);
					break;
				case "LOCKER NO OF FREE VISIT VERIFICATION WITH DATABASE":
					WriteIntoDataFiles.LockerRentNoOfFreeVisitVerification(driver, orTemp[1].trim(), testData);
					break;
				case "GET CUSTOMERID FOR LOCKER OPENING":
				    Locker.GetCustomerIDForLockerOpening(driver, orTemp[1].trim(), testData);
				    break;
				case "READ FROM TXT AND SEND KEYS":
				    Locker.ReadFromTXTFileAndSendKeys(driver, orTemp[1].trim(), testData);
				    break;  
				case "READ FROM TXT AND SEND KEYS2":
				    Locker.ReadFromTXTFileAndSendKeys2(driver, orTemp[1].trim(), testData);
				    break;
				case "READ FROM TXT AND SEND KEYS FOR LOCKER NUMBER":
				    Locker.ReadFromTXTFileAndSendKeysForLockerNumber(driver, orTemp[1].trim(), testData);
				    break;
				case "RENT VERIFICATION FOR LOCKER OPENING":
				    Locker.RentVerificationLockerOpening(driver, orTemp[1].trim(), testData);
				    break;
				case "ENTER CAUTION DEP ACNO":
				    Locker.EnterCautionDepAcNo(driver, orTemp[1].trim(), testData);
				    break;
				case "LOCKER RENT WAIT IN LOCKER OPENING":
					Locker.ForLoopWaitBasedOnGetTextLocker(driver, orTemp[0].trim(), orTemp[1].trim());
					break;
				case "LOCKER ACCOUNT NO SAVING":
					Locker.GetAttributeAndSaveValueinTXT(driver, orTemp[0].trim(), orTemp[1].trim(), testData);
					break;
				case "TABLE VERIFICATION AFTER LOCKER OPENING":
					Locker.TableVerificationAfterLockerOpening(driver, orTemp[1].trim(), testData);
					break;
				case "LOCKER AVAILABILITY CHECKING":
				    Locker.LockerAvailabilityChecking(driver, orTemp[1].trim(), testData);
				    break; 
				case "GET CUSTOMERID OPERATOR FOR LOCKER OPENING":
				    Locker.GetCustomerIDForLockerOpeningOperator(driver, orTemp[1].trim(), testData);
				    break;
				case "OPERATOR CUST READ FROM TXT AND SEND KEYS":
				    Locker.OperatorCustReadFromTXTFileAndSendKeys(driver, orTemp[1].trim(), testData);
				    break; 
				case "READ LOCKER NO AND SEND KEYS":
					Locker.LockerNoReadAndWrite(driver, orTemp[1].trim(), testData);
				    break;
				case "LOCKER ATTENDANCE TBL VERIFICATION":
					Locker.LockerAttendanceTblVerification(driver, orTemp[1].trim(), testData);
				    break;
				case "LOCKER VISITED MEMBERS TBL VERIFICATION":
					Locker.LockerVisitedMembersTblVerification(driver, orTemp[1].trim(), testData);
				    break;
				case "CLICK AND NEW TAB ACTIONS":
					   DifferentTypesOfWaits.NewTabActions(driver, orTemp[1].trim(), testData);
					   break;
				case "GET TRANSACTION DATE":
					DatabaseConnector.GetCurrentTransactionDate();
					break;
	 //-------------------------------------------------------------------------------------------------------------------  
				   
  } // End of switch statement
	
		//return driver;
		
		
	} // End of main method

}
