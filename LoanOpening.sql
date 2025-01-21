---Loan Openings
-------------------------------------OtherLoan&OverDraft Loan------------------------------------------------
select IsActive,*
from ProductAcCodeLink
where ProductID=24001 and ProductOperationCode=1 and IsActive=1

--update ProductAcCodeLink
--set IsAmountDisplayBasedOnSettings=1
--where LinkID=191


select *
from SetSpecialCharges
where SetID in(191,192)

--update SetSpecialCharges
--set SetModeID=2,Amount=10,BasedOnAmtType=104
--where SetID=192

select *
from TransactionAmountType
where AmtTypeText like '%pro%'

Update TransactionAmountType
set AmtTypeText='ShareRecovery' ,AmtTypeRemarks='ShareRecovery'
where AmtType=149

select VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails (3615628)

Select * from Ac_Head

Select * from TransactionAmountType where AmtTypeText Like '%Provident%'

Select * from SetSecurityEligibility where ProductID=24001 and SecurityType=2

Update SetSecurityEligibility
set Eligiblepercentage=100
where SetID=114

----Other Loan-Principal,Riskfund,FormFee,Insurance
---OverDraft Loan-Principal,FormFee,Riskfund,ShareRecovery,InterBranch(2)
-------------------------------------End of OtherLoan&OverDraft Loan-----------------------------------------

------------------------------------------Deposit Loan-------------------------------------------------------
--Open a FD Account Within the LIMIT of Purpose

---Geting FD AccNo

Select Top 1 AcNo,* from viAccMaster --a join securitymaster m on a.accmasterid=m.accmasterid
where ProductID=12001 and DueDate>(Select * from TransactionDate) and IsClosed=0 and OrgBranchID=102
and RecordStatus=3 
and AccMasterID not in (Select DepositAccMasterID from SecurityDeposits)and AcOpeningAmount<=100000

-------------------------------------End of Deposit Loan-------------------------------------------------------


