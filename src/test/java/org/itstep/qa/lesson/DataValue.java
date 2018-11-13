package org.itstep.qa.lesson;

import org.testng.annotations.DataProvider;

public class DataValue {
    @DataProvider(name = "testValue")
    public Object[][] dataProvider(){
        return new Object[][]{
                {"test@test.ru", null},
                {" ", "* Необходимо заполнить\n"},
                {"123",""},
                {"asd",""},
                {"@#%",""},
                {"test @test.ru",""},
                {"@test.ru",""},
                {"test@.ru",""},
                {"test@@test.ru",""}
        };
    }
}
