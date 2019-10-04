package com.tbsm.projectla;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import com.tbsm.projectla.models.Numbers;

public class FindNumbers {
	private Map<String, String> foundStuff;

	private String generalAbstractNotificationsNotifyMeHowLongPrior; // Notify me how long prior (Milliseconds)?
	private String rentRentSchedulesContractRentable; // Contract Rentable
	private String opexCamCamAuditSetupIndexBase; // 489 Index Base
	private String rightsOtherRightsCovenantArea; // 396 Covenant Area
	private String insuranceInsuranceClauseDetailsMinimumRatingRequirement; // 539 Minimum Rating Requirement
	private String parkingSpaceTypesNumberOfSpaces; // 595 Number of Spaces
	private String coTenancyCoTenancyItemCoTenancyPerArea; // 620 Co-Tenancy Per Area
	private String otherClausesOtherClausesArea; // 681 Area
	private String accountingFaSb13TreatmentIncrementalBorrowingRate; // 706 Incremental Borrow Rate
			

	private String rentIndexAdjustmentsIndexAdjustmentBaseYear; // Base Year	
	private String rentPercentageRentClauseFoundInPage; // Found In Page
	private String rentCommissionsFoundInPage; // Found In Page
	private String defaultClauseDetailsFoundInPage; // 273 Found In Page
	private String defaultClauseDetailsNumberOfMonetaryEvents; // 280	Number of Monetary Events
	private String defaultClauseDetailsNumberOfNonMonetaryEvents; // 284	Number of Non-Monetary Events
	private String securityDepositClauseDetailsFoundInPage; // 305
	private String rightsAlterationsFoundInPage; // 350 Found In Page
	private String rightsAssignmentSublettingFoundInPage; // 361	Found In Page
	private String rightsHoldoverFoundInPage; // 374	Found In Page
	private String rightsOtherRightsFoundInPage; // 387 Found In Page
	private String rightsSignageFoundInPage; // 401 Found In Page
	private String rightsRestorationObligationsFoundInPage; // 416 Found In Page
	private String allowancesClauseDetailsFoundInPage; // 435 Found In Page
	private String opexCamClauseDetailsFoundInPage; // 467 Found In Page
	private String insuranceClauseDetailsFoundInPage; // 515 Found In Page
	private String taxClauseDetailsFoundInPage; // 554 Found In Page
	private String parkingClauseDetailsFoundInPage; // 587 Found In Page
	private String coTenancyClauseDetailsFoundInPage; // 601 Found In Page
	private String greenLeaseProvisionsClauseDetailsFoundInPage; // 625 Found In Page
	private String responsibilitiesClauseDetailsFoundInPage; // 652 Found In Page
	
	public FindNumbers(Map<String, String> foundStuff) {
		this.foundStuff = foundStuff;
	}
	
	
	public Numbers processNumbers() {		
		Numbers numbers = new Numbers();
		
		numbers.setGeneralAbstractNotificationsNotifyMeHowLongPrior( searchDouble( generalAbstractNotificationsNotifyMeHowLongPrior ) ); // Notify me how long prior (Milliseconds)?
		numbers.setRentRentSchedulesContractRentable( searchDouble( rentRentSchedulesContractRentable ) ); // Contract Rentable
		numbers.setOpexCamCamAuditSetupIndexBase( searchDouble( opexCamCamAuditSetupIndexBase ) ); // 489 Index Base
		numbers.setRightsOtherRightsCovenantArea( searchDouble( rightsOtherRightsCovenantArea ) ); // 396 Covenant Area
		numbers.setInsuranceInsuranceClauseDetailsMinimumRatingRequirement( searchDouble( insuranceInsuranceClauseDetailsMinimumRatingRequirement ) ); // 539 Minimum Rating Requirement
		numbers.setParkingSpaceTypesNumberOfSpaces( searchDouble( parkingSpaceTypesNumberOfSpaces ) ); // 595 Number of Spaces
		numbers.setCoTenancyCoTenancyItemCoTenancyPerArea( searchDouble( coTenancyCoTenancyItemCoTenancyPerArea ) ); // 620 Co-Tenancy Per Area
		numbers.setOtherClausesOtherClausesArea( searchDouble( otherClausesOtherClausesArea ) ); // 681 Area
		numbers.setAccountingFaSb13TreatmentIncrementalBorrowingRate( searchDouble( accountingFaSb13TreatmentIncrementalBorrowingRate ) ); // 706 Incremental Borrow Rate
					
		numbers.setRentIndexAdjustmentsIndexAdjustmentBaseYear( searchInteger( rentIndexAdjustmentsIndexAdjustmentBaseYear ) ); // Base Year	
		numbers.setRentPercentageRentClauseFoundInPage( searchInteger( rentPercentageRentClauseFoundInPage ) ); // Found In Page
		numbers.setRentCommissionsFoundInPage( searchInteger( rentCommissionsFoundInPage ) ); // Found In Page
		numbers.setDefaultClauseDetailsFoundInPage( searchInteger( defaultClauseDetailsFoundInPage ) ); // 273 Found In Page
		numbers.setDefaultClauseDetailsNumberOfMonetaryEvents( searchInteger( defaultClauseDetailsNumberOfMonetaryEvents ) ); // 280	Number of Monetary Events
		numbers.setDefaultClauseDetailsNumberOfNonMonetaryEvents( searchInteger( defaultClauseDetailsNumberOfNonMonetaryEvents ) ); // 284	Number of Non-Monetary Events
		numbers.setSecurityDepositClauseDetailsFoundInPage( searchInteger( securityDepositClauseDetailsFoundInPage ) ); // 305
		numbers.setRightsAlterationsFoundInPage( searchInteger( rightsAlterationsFoundInPage ) ); // 350 Found In Page
		numbers.setRightsAssignmentSublettingFoundInPage( searchInteger( rightsAssignmentSublettingFoundInPage ) ); // 361	Found In Page
		numbers.setRightsHoldoverFoundInPage( searchInteger( rightsHoldoverFoundInPage ) ); // 374	Found In Page
		numbers.setRightsOtherRightsFoundInPage( searchInteger( rightsOtherRightsFoundInPage ) ); // 387 Found In Page
		numbers.setRightsSignageFoundInPage( searchInteger( rightsSignageFoundInPage ) ); // 401 Found In Page
		numbers.setRightsRestorationObligationsFoundInPage( searchInteger( rightsRestorationObligationsFoundInPage ) ); // 416 Found In Page
		numbers.setAllowancesClauseDetailsFoundInPage( searchInteger( allowancesClauseDetailsFoundInPage ) ); // 435 Found In Page
		numbers.setOpexCamClauseDetailsFoundInPage( searchInteger( opexCamClauseDetailsFoundInPage ) ); // 467 Found In Page
		numbers.setInsuranceClauseDetailsFoundInPage( searchInteger( insuranceClauseDetailsFoundInPage ) ); // 515 Found In Page
		numbers.setTaxClauseDetailsFoundInPage( searchInteger( taxClauseDetailsFoundInPage ) ); // 554 Found In Page
		numbers.setParkingClauseDetailsFoundInPage( searchInteger( parkingClauseDetailsFoundInPage ) ); // 587 Found In Page
		numbers.setCoTenancyClauseDetailsFoundInPage( searchInteger( coTenancyClauseDetailsFoundInPage ) ); // 601 Found In Page
		numbers.setGreenLeaseProvisionsClauseDetailsFoundInPage( searchInteger( greenLeaseProvisionsClauseDetailsFoundInPage ) ); // 625 Found In Page
		numbers.setResponsibilitiesClauseDetailsFoundInPage( searchInteger( responsibilitiesClauseDetailsFoundInPage ) ); // 652 Found In Page
		
		return numbers;		
	}
	
	private Double searchDouble(String s) {
		if( s != null && s != "" ) {
			List<String> criteriaList = Arrays.asList(s.split(","));				
			for (String criteria : criteriaList) {
				Optional<Entry<String, String>> map = foundStuff.entrySet().stream()
			      .filter (e -> e.getValue().toLowerCase().contains( criteria.toLowerCase() )).findFirst();
				
				if(map.isPresent()) {
					return Double.valueOf( map.get().getKey() );
				}
			}
		}
		return null;		
	}
	
	private Integer searchInteger(String s) {
		if( s != null && s != "" ) {
			List<String> criteriaList = Arrays.asList(s.split(","));				
			for (String criteria : criteriaList) {
				Optional<Entry<String, String>> map = foundStuff.entrySet().stream()
			      .filter (e -> e.getValue().toLowerCase().contains( criteria.toLowerCase() )).findFirst();
				
				if(map.isPresent()) {
					return Integer.valueOf( map.get().getKey() );
				}
			}
		}
		return null;		
	}
}