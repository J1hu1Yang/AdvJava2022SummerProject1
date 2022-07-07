package edu.pdx.cs410J.jihuyang;

import com.google.common.annotations.VisibleForTesting;
import edu.pdx.cs410J.AbstractPhoneBill;
import java.util.Scanner;
/**
 * The main class for the CS410J Phone Bill Project
 */
public class Project1 {

  @VisibleForTesting
  static boolean isValidPhoneNumber(String phoneNumber) {
    return true;
  }

  public static void main(String[] args) {
    PhoneCall call = new PhoneCall();  // Refer to one of Dave's classes so that we can be sure it is on the classpath
    PhoneBill bill = new PhoneBill();
    Scanner myObj = new Scanner(System.in);
    System.out.println(" 1.set caller phone number");
    String caller = myObj.nextLine();
    boolean a = bill.setCaller(caller);
    System.out.println(" 2.set callee phone number");
    String callee = myObj.nextLine();
    a = bill.setCallee(callee);
    System.out.println(" 3.set start call time");
    String start = myObj.nextLine();
    a = bill.setCallStartTime(start);
    System.out.println(" 4.set end call time");
    String end = myObj.nextLine();
    a = bill.setCallEndTime(start);
    System.out.println(bill.getCaller());
    System.out.println(bill.getCallee());
    System.out.println(bill.getCallStartTime());
    System.out.println(bill.getCallEndTime());

    for (String arg : args) {
      System.out.println(arg);
    }
  }

}