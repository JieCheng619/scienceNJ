package com.science.basics.domain;

import java.util.List;

public class OrderFormDto {
	private List<SaleItem> saleitems;

	public List<SaleItem> getSaleitems() {
		return saleitems;
	}

	public void setSaleitems(List<SaleItem> saleitems) {
		this.saleitems = saleitems;
	}
	
}
