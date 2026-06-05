package aqa_hw_22.dataprovider;

import aqa_hw_22.GetLoginPasswordDB;
import org.testng.annotations.DataProvider;

import java.util.Map;

public class ProvideData {

    @DataProvider
    public Object[][] getSearchData(){

        GetLoginPasswordDB data = new GetLoginPasswordDB();

        Map<String, String> users = data.getUsers();

        Object[][] result = new Object[users.size()][2];

        int i = 0;
        for (Map.Entry<String, String> entry : users.entrySet()) {
            result[i][0] = entry.getKey();
            result[i][1] = entry.getValue();
            i++;
        }

        return result;
    }
}
