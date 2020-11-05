package com.zerobank.pages.zerobankPages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardMenuPagePage {

    public DashboardMenuPagePage(){
        PageFactory.initElements(Driver.get(), this); }

    @FindBy(className = "active")
    public WebElement selectedMenu;

    public WebElement getBoardHeadByIndex(int index){
        return Driver.get().findElement(By.xpath("//h2["+index+"]"));
    }

    public WebElement getBoardHeadByName(String name){
        return Driver.get().findElement(By.xpath("//h2[@class='board-header'][contains(text(),'"+name+"')]"));
    }

    public List<WebElement> getTableColumnsByTableName(String name){
        return Driver.get().findElements(By.xpath("//h2[@class='board-header'][contains(text(),'"+name+"')]/following-sibling::div[1]//table//thead//th"));
    }

    public void goToMenu(String menu){
        Driver.get().findElement(By.xpath("//ul[@class='nav nav-tabs']//li//a[contains(text(),'"+menu+"')]")).click();
    }

    public void goToTab(String tabName){

        Driver.get().findElement(By.xpath("//ul[@class='ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all']//li//a[.='"+tabName+"']")).click();
    }

}
