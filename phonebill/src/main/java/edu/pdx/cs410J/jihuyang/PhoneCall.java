package edu.pdx.cs410J.jihuyang;

import edu.pdx.cs410J.AbstractPhoneCall;

public class PhoneCall extends AbstractPhoneCall {
  private String caller = " ";
  private String callee = " ";
  private String CallStart = " ";
  private String CallEnd = " ";

  @Override
  public String getCaller() {
    return caller;
  }

  public Boolean setCaller(String PhoneNumber) {
    boolean PhoneNumberVeri = verifyPhoneNumberFormat(PhoneNumber);
    if(PhoneNumberVeri == true) {
      this.caller = PhoneNumber;
    }
    return PhoneNumberVeri;
  }


  @Override
  public String getCallee() {
    return callee;
  }

  public Boolean setCallee(String PhoneNumber) {
    boolean PhoneNumberVeri = verifyPhoneNumberFormat(PhoneNumber);
    if(PhoneNumberVeri == true) {
      this.callee = PhoneNumber;
    }
    return PhoneNumberVeri;
  }

  @Override
  public String getCallStartTime () {
    return CallStart;
  }
  public Boolean setCallStartTime(String time) {
    boolean TimeNumberVeri = verifyTimeFormat(time);
    if(TimeNumberVeri == true) {
      this.CallStart = time;
    }
    return TimeNumberVeri;
  }
  @Override
  public String getCallEndTime () {
    return CallEnd;
  }
  public Boolean setCallEndTime(String time) {
    boolean TimeNumberVeri = verifyTimeFormat(time);
    if(TimeNumberVeri == true) {
      this.CallEnd = time;
    }
    return TimeNumberVeri;
  }



  public boolean verifyPhoneNumberFormat (String phone) {
    String PhoneDigit = phone;
    int FirstIndex = 0;
    int LastIndex = 0;
    LastIndex = phone.indexOf("-");

    if(LastIndex < 0) {
      System.err.println("Missing '-'.");
      return false;
    }
    PhoneDigit = phone.substring(FirstIndex, LastIndex);

    // Three characters (0-9)
    if(DigitsVerify(PhoneDigit) != 3) {
      System.err.println("Phone number NOT ###-###-#### format");
      return false;
    }

    FirstIndex = LastIndex + 1;
    LastIndex = phone.indexOf("-", FirstIndex);

    if(LastIndex < 0) {
      System.err.println("Missing '-'.");
      return false;
    }
    PhoneDigit = phone.substring(FirstIndex, LastIndex);

    // 3 characters from 0-9
    if(DigitsVerify(PhoneDigit) != 3) {
      System.err.println("Phone number NOT ###-###-#### format");
      return false;
    }

    FirstIndex = LastIndex + 1;
    LastIndex = phone.length();
    if(LastIndex < 0) {
      System.err.println("Missing '-'.");
      return false;
    }
    PhoneDigit = phone.substring(FirstIndex, LastIndex);

    // 4 characters from 0-9
    if(DigitsVerify(PhoneDigit) != 4) {
      System.err.println("Phone number NOT ###-###-#### format");
      return false;
    }
    return true;
  }


  public boolean verifyTimeFormat(String time) {
    String TimeDigit = time;
    int FirstIndex = 0;
    int LastIndex = 0;

    LastIndex = time.indexOf("/");
    if(LastIndex < 0) {
      System.err.println("Missing at least one '/'.");
      return false;
    }
    TimeDigit = time.substring(FirstIndex, LastIndex);

    // One or two characters (0-9) allowed for month
    if(DigitsVerify(TimeDigit) != 1 && DigitsVerify(TimeDigit) != 2) {
      System.err.println("Month must contain 1 or 2 digits.");
      return false;
    }

    FirstIndex = LastIndex + 1;
    LastIndex = time.indexOf("/", FirstIndex);
    if(LastIndex < 0) {
      System.err.println("Missing at least one '/'.");
      return false;
    }
    TimeDigit = time.substring(FirstIndex, LastIndex);

    // One or two characters (0-9) allowed for day
    if(DigitsVerify(TimeDigit) != 1 && DigitsVerify(TimeDigit) != 2) {
      System.err.println("Day must contain 1 or 2 digits.");
      return false;
    }

    FirstIndex = LastIndex + 1;
    LastIndex = time.length();
    if(LastIndex < 0) {
      System.err.println("Missing a space between the date and time.");
      return false;
    }
    TimeDigit = time.substring(FirstIndex, LastIndex);

    // Four characters (0-9) required for year
    if(DigitsVerify(TimeDigit) != 4) {
      System.err.println("Year must contain only 4 digits.");
      return false;
    }

    LastIndex = time.indexOf(":");
    if(LastIndex < 0) {
      System.err.println("Missing ':' between hours and minutes.");
      return false;
    }
    TimeDigit = time.substring(FirstIndex, LastIndex);

    // One or two characters (0-9) allowed for hour
    if(DigitsVerify(TimeDigit) != 1 && DigitsVerify(TimeDigit) != 2) {
      System.err.println("Hour must contain only 1 or 2 digits.");
      return false;
    }
    // One semicolon
    FirstIndex = LastIndex + 1;
    LastIndex = time.length();
    TimeDigit = time.substring(FirstIndex, LastIndex);

    // Two characters (0-9) required for minutes
    if(DigitsVerify(TimeDigit) != 2) {
      System.err.println("Minutes must contain only 1 or 2 digits.");
      return false;
    }


    return true;
  }

  public int DigitsVerify (String Dig) {
    int num = 0;
    for(int i = 0; i < Dig.length(); ++i) {
      if(!Character.isDigit(Dig.charAt(i))) {
        return 0;
      }
      ++num;
    }
    return num;
  }





  @Override
  public String getBeginTimeString() {
    throw new UnsupportedOperationException("This method is not implemented yet");
  }

  @Override
  public String getEndTimeString() {
    throw new UnsupportedOperationException("This method is not implemented yet");
  }
}
