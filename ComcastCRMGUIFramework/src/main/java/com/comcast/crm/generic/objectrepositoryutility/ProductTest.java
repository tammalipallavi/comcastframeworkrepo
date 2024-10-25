package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductTest {
	@FindBy(xpath="//a[@href='index.php?module=Products&action=index']")
	private WebElement productlink;

}
