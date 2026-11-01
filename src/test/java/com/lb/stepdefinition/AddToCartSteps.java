package com.lb.stepdefinition;

import com.lb.objectrepository.LoginValidationPage;
import com.lb.resources.CommonActions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.lb.objectrepository.CartPage;
import com.lb.objectrepository.HomePage;
import com.lb.objectrepository.PDPPage;
import com.lb.objectrepository.PLPPage;


public class AddToCartSteps extends CommonActions{
	
	CommonActions ca=new CommonActions();
	CartPage c=new CartPage();
	HomePage h=new HomePage();
	PDPPage pd=new PDPPage();
	PLPPage pl=new PLPPage();
	
	@When("Hover on the Clothing")
	public void hover_on_the_clothing() {
	    ca.highlightElement(h.getClothing());
	    ca.hover(h.getClothing());
	}
	@When("Click on the Tops")
	public void click_on_the_tops() {
		ca.highlightElement(h.getTops());
	    ca.button(h.getTops());
	}
	@When("Click on the product")
	public void click_on_the_product() {
		ca.scrollToElement(pl.getPLP_Product1());
		ca.highlightElement(pl.getPLP_Product1());
	    ca.button(pl.getPLP_Product1());
	}
	@When("Select the size")
	public void select_the_size() {
		ca.selectFirstAvailableSize(pd.getAvailableSizes());
	    
	}
	@When("Click on the add to bag")
	public void click_on_the_add_to_bag() {
	    ca.highlightElement(pd.getAddToBag());
	    ca.button(pd.getAddToBag());
	}
	@When("Click on the view bag")
	public void click_on_the_view_bag() {
		//ca.waitForElementVisible(pd.getViewBag());
	    ca.highlightElement(pd.getViewBag());
	    ca.button(pd.getViewBag());
	}
	@Then("verify the product added in cart")
	public void verify_the_product_added_in_cart() {
	    ca.highlightElement(c.getCartProductName());
	    ca.printValue(c.getCartProductName());
	    
	}
	@Then("verify the cart quantity")
	public void verify_the_cart_quantity() {
	    ca.highlightElement(c.getCartQuantity());
	    ca.printValue(c.getCartQuantity());
	}
	@Then("verify the estimated total")
	public void verify_the_estimated_total() {
		ca.highlightElement(c.getCartTotal());
		ca.printValue(c.getCartTotal());
	}
}
