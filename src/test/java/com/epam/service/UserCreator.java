package com.epam.service;

import com.epam.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserCreator {

    private static final String TEST_DATA_USERNAME ="testdata.user.name";
    private static final String TEST_DATA_PASSWORD ="testdata.user.password";
    private static final String TEST_DATA_USERNAMES ="testdata.user.names";

    public static User withAllCredentials(){
        return new User(TestDataReader.getTestData(TEST_DATA_USERNAME),
                TestDataReader.getTestData(TEST_DATA_PASSWORD));
    }


    public static List<User> getAllUsersFromProperty() {
        String usernames = TestDataReader.getTestData(TEST_DATA_USERNAMES);
        String password = TestDataReader.getTestData(TEST_DATA_PASSWORD);
        String[] usernameArray = usernames.split(",");
        List<User> users = new ArrayList<>();
        for (String username : usernameArray) {
            users.add(new User(username.trim(), password));
        }
        return users;
    }

}
