package aqa_hw_5.dataprovider;

import org.testng.annotations.DataProvider;

public class ProvideData {

    @DataProvider
    public Object[][] getSearchData(){
        return new Object[][]{
                {"someEmail@example.com", "123456"},
                {"email@example.com", "4568987"},
                {"someEmail@example.com", "852369"}
        };
    }
}
