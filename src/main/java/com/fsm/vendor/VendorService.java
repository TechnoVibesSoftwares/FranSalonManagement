package com.fsm.vendor;

import org.springframework.stereotype.Service;

@Service
public interface VendorService {
	public VendorEntity createOrSaveVendor(VendorDetailsForm form) ;
}
