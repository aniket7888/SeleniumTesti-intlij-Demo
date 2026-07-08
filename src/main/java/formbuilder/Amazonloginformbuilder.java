package formbuilder;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Getter
@Setter
public class Amazonloginformbuilder {

    @FindBy(xpath = "//span[@class='nav-line-2 ']")
    private WebElement accountList;

    @FindBy(id ="ap_email_login")
    private WebElement emailNumberInput;

    @FindBy(className = "a-button-input")
    private WebElement continueButton;
}
