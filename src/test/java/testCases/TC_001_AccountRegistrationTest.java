package testCases;


import Pageobject.AccountRegistrationPage;
import Pageobject.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

import static org.testng.Assert.fail;

public class TC_001_AccountRegistrationTest extends BaseClass{


    @Test
    public void test_account_Registration() throws InterruptedException
    {
    try {
        HomePage hp = new HomePage(driver);
        logger.info("****MyAccount clicked");
        hp.clickMyAccount();
        hp.clickRegister();

        AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

        regpage.setFirstName(randomeString().toUpperCase());

        regpage.setLastName(randomeString().toUpperCase());

        regpage.setEmail(randomeString() + "@gmail.com");// randomly generated the email

        //  regpage.setTelephone(randomeNumber());

        String password = randomAlphaNumeric();
        regpage.setPassword(password);
        // regpage.setConfirmPassword(password);

        regpage.setPrivacyPolicy();
        logger.debug("click on checkbox");

        regpage.clickContinue();

        String confmsg = regpage.getConfirmationMsg();

        Assert.assertEquals(confmsg, "Your Account Has Been Created!");
    }
       catch(Exception e)
        {
            Assert.fail();
        }
    }


}

