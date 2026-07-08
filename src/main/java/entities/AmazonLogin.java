package entities;

import Pagerepository.AmazonLoginPageRepo;
import formbuilder.Amazonloginformbuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AmazonLogin {
    private Amazonloginformbuilder amazonloginformbuilder;
    AmazonLoginPageRepo amazonLoginPageRepo = new AmazonLoginPageRepo();
    public AmazonLogin(Amazonloginformbuilder amazonloginformbuilder) {
        this.amazonloginformbuilder = amazonloginformbuilder;
        if(amazonloginformbuilder.getAccountList()!= null){
            amazonLoginPageRepo.setAccountList(true);
        }
        if(amazonloginformbuilder.getEmailNumberInput()!= null){
            amazonLoginPageRepo.setEmailNumberInput(amazonloginformbuilder.getEmailNumberInput().getText());
        }
        if(amazonloginformbuilder.getContinueButton()!= null) {
            amazonLoginPageRepo.setContinueButton(true);
        }



    }

}
