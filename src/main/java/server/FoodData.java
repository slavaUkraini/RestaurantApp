/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

/**
 *
 * @author Vita
 */
public class FoodData{
		
		private String name;
		private String category;
		private String compound;
		private double price;
		public FoodData(String name, String category, String compound,
				double price) {
			super();
			this.name = name;
			this.category = category;
			this.compound = compound;
			this.price = price;
		}
		
		public FoodData(){
			
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getCompound() {
			return compound;
		}
		public void setCompound(String compound) {
			this.compound = compound;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		
		@Override
		public String toString() {
			return "FoodData [name=" + name + ", category=" + category
					+ ", compound=" + compound + ", price=" + price + "]";
		}
	}

