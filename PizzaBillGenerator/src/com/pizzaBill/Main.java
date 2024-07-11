package com.pizzaBill;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//
//		Pizza basePizza = new Pizza(true);
//		//basePizza.addExtraCheese();
//		basePizza.addExtraToppings();
//		basePizza.getBill();
//		
		DeluxPizza dp = new DeluxPizza(true);
//		dp.takeAway();
		dp.addExtraCheese(); // we don't want to give the functionality to the user so we have to disble in deluxpizza by overidden
		dp.getBill();
		
	
		
	}

}