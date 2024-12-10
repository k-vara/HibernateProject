// AccountInfoServiceImplTest.java
package com.hibernate.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import com.hibernate.serviceImpl.AccountInfoServiceImpl;
import com.hibernate.utility.InsufficientBalanceException;

public class AccountInfoServiceImplTest {

    AccountInfoServiceImpl accImpl = new AccountInfoServiceImpl();

    @ParameterizedTest
    @ValueSource(ints = {100,-1})
    void testInsertAccountInfoInsufficientBalance(int balance) throws InsufficientBalanceException {
        int actual = accImpl.testInsertAccountInfoInsufficientBalance(balance);
        Assertions.assertEquals(1, actual, "Balance should be sufficient");
    }
}
