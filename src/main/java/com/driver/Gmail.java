package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
   List<mail> Inbox;
   List <mail>trash;

    public Gmail(String emailId) {
        super(emailId);
    }

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        Inbox = new ArrayList<>();
        trash = new ArrayList<>();
    }



    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        if (Inbox.size()==inboxCapacity){
            mail mail= Inbox.get(0);
            trash.add(mail);
            Inbox.remove(0);
        }
        mail mail = new mail(date,sender,message);
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
       for (int i=0;i<Inbox.size();i++){
           mail dumm =Inbox.get(i);
           if (dumm.getMessage().equals(message)){
              trash.add(Inbox.get(i));
              Inbox.remove(dumm);
           }
       }
    }

    public String findLatestMessage() {
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if (Inbox.size() == 0) {
            return null;
        } else {
            return Inbox.get(Inbox.size() - 1).getMessage();
        }
    }
    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if (Inbox.size() == 0) {
            return null;
        } else {
            return Inbox.get(0).getMessage();
        }

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find numbsr of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
//       i have to use comarator here
        int count=0;
       for (int i=0;i<Inbox.size();i++) {
           mail dummy = Inbox.get(i);
         if (dummy.getDate().compareTo(start)>=0 && dummy.getDate().compareTo(end)<=0){
count++;
         }
        }
       return count;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
  return Inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
return  trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
   trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
    return inboxCapacity;
    }
}
