package com.skillsup.patterns;


import com.skillsup.patterns.dto.User;

public class App
{
    public static void main( String[] args )
    {

        User user=new User.UserBuilder().setUserId(1).setUserLogin("Taras").setUserPassword("345").toCreate();
        User secondUser=new User.UserBuilder().setUserId(2).setUserLogin("Ostap").setUserPassword("123").toCreate();
        System.out.println(user);
        System.out.println(secondUser);
    }
}
