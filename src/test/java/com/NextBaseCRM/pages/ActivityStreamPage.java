package com.NextBaseCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class ActivityStreamPage extends BasePage{


    @FindBy(xpath = "//a[@id=\"blog-post-addc-add-1892\"]")
    public WebElement commentButton;


    @FindBy(xpath = "(//a[@class=\"bx-ilike-text\"])[1]")
    public WebElement likeButton;

    @FindBy(xpath = "(//a[@href=\"javascript:void(0);\"])[6]")
    public WebElement unfollowButton;



    @FindBy(xpath = "//*[@id=\"bx-html-editor-iframe-cnt-idLHE_blogCommentFormVi7L\"]/iframe")
    public WebElement writeComment;

    @FindBy(css = "[id^=\"lhe_button_submit_blogCommentFormwHZw\"]")
    public WebElement sendcommentButton;

}
