package com.driver;

import java.util.List;

public class Email {

    private String emailId;
    private String password;


    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special characte
        if (oldPassword!=password){
            return;
        }
        boolean uppercase =false;
        boolean lowecase =false;
        boolean digit = false;
        boolean special = false;
        if (newPassword.length()<8){
            return;
        }
        for (int i=0;i<newPassword.length();i++){
            char c = newPassword.charAt(i);
            if (c>='A' && c<='Z'){
                uppercase=true;
            }
            else if(c>='a' && c<='z'){
                lowecase=true;
            }
            else if (c>=0 && c<=9){
                digit=true;
            }else{
                special=true;
            }
        }
        if(uppercase==true && lowecase==true && digit==true && special==true){
            password=newPassword;
        }

                   }
}
