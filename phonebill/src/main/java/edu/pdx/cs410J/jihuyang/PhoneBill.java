package edu.pdx.cs410J.jihuyang;

import edu.pdx.cs410J.AbstractPhoneBill;

import java.util.Collection;

public class PhoneBill extends AbstractPhoneBill<PhoneCall> {
  private final String customer;

  private Collection<PhoneCall> calls = new ArrayList<>();

  public PhoneBill(String customer) {
    this.customer = customer;
  }

  @Override
  public String getCustomer() {
    return this.customer;
  }

  @Override
  public void addPhoneCall(PhoneCall Acall) {
    if(this.calls.isEmpty() == true) { // If  PhoneBill is empty
      this.calls.add(Acall);
      List callList = (List) this.calls;
      Collections.sort(callList);
      this.calls = callList;
    }
    else { //  If  PhoneBill is not empty
      for (PhoneCall n : this.calls) { // Compare new call to old
        if (n.compareTo(Acall) == 0) { // If it exists, stop add
          System.err.println("Call at  "+ n.getStartTimeString() + "  from  "+ n.getCaller()+"  is exist.");
          return;
        }
      }

      this.calls.add(Acall);
      List callList = (List) this.calls;
      Collections.sort(callList);
      this.calls = callList;
      return;
    }
  }

  @Override
  public Collection<PhoneCall> getPhoneCalls() {
    return this.calls;
  }
  public void setCustomer(String name) { this.customer = name; }
}
