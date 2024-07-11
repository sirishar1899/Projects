package com.pizzaBill;

public class Pizza {

	private int price;

	private Boolean veg;

	private int extraCheesePrice = 100;
	private int extraToppingPrice = 120;
	private int backPackPrice = 30;
	private int basePizzaPrice;
	private boolean isExtraCheeseAdded = false;
	private boolean isExtraToppingsAdded = false;
	private boolean isOptedForTakeAway = false;

	public Pizza(Boolean veg) {

		this.veg = veg;
		if (this.veg) {
			this.price = 300;
		} else {
			this.price = 400;
		}

		basePizzaPrice = this.price;
	}

	public void addExtraCheese() {
		isExtraCheeseAdded = true;

		this.price = price + extraCheesePrice;
	}

	public void addExtraToppings() {
		isExtraToppingsAdded = true;

		this.price = price + extraToppingPrice;
	}

	public void takeAway() {
		isOptedForTakeAway = true;

		this.price = price + backPackPrice;
	}

	public void getBill() {
		String bill = "";
		System.out.println("Pizza:" + basePizzaPrice);
		
		if (isExtraCheeseAdded) {
			bill += "Extra Cheese added: " +extraCheesePrice+ "\n";
		}
		 if (isExtraToppingsAdded) {
			bill += "Extra toppings added: " + extraToppingPrice + "\n";
		}
		 if (isOptedForTakeAway) {
			bill += "Take Away: " + backPackPrice + "\n";
		}

		bill += "Total Bill: " + this.price + "\n";
		System.out.println(bill);

	}

}
