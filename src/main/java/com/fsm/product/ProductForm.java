package com.fsm.product;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductForm {
	
	private String vendorEmail;
	private String productName;
	private String price;
	private String discount;
	//private String netAmount; //calculate in backend

}
