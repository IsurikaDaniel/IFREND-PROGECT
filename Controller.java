import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;


class Controller {

    public static boolean addContact(Contact contact){
		ArrayList <Contact>contactList=DBConnection.getInstance().getContactList();
		return contactList.add(contact);	
	}

	//---------------sort by name---------------------
	
		public static ArrayList<Contact> sortByName() {
			ArrayList<Contact> contactList = DBConnection.getInstance().getContactList();
			
			// Sort the contactList using Collections.sort with a custom Comparator
			Collections.sort(contactList, new Comparator<Contact>() {
				
				public int compare(Contact c1, Contact c2) {
					return c1.getName().compareTo(c2.getName());
				}
			});
			
			return contactList;
		}
	

		//----------------sort by salary--------------------

		public static ArrayList<Contact> sortBySalary() {
			ArrayList<Contact> contactList = DBConnection.getInstance().getContactList();
			
			// Sort the contactList using Collections.sort with a custom Comparator
			Collections.sort(contactList, new Comparator<Contact>() {
				public int compare(Contact c1, Contact c2) {
					return Double.compare(c1.getSalary(), c2.getSalary());
				}
				
		
			});
			
			return contactList;
		}

		//--------------sort by Birthday---------------------
		
		public static ArrayList<Contact> sortByBirthDay() {
			ArrayList<Contact> contactList = DBConnection.getInstance().getContactList();
			
			// Sort the contactList using Collections.sort with a custom Comparator
			Collections.sort(contactList, new Comparator<Contact>() {
				
				public int compare(Contact c1, Contact c2) {
					return c1.getBirthday().compareTo(c2.getBirthday());
				}
				
			});
			
			return contactList;
		}


	//----------------------delete contact---------------
	public static boolean removeContact(Contact contact) {
        return DBConnection.getInstance().removeContact(contact);
    }

	//---------------------search method------------------
	public static List<Contact> searchContacts(String searchText) {
        ArrayList<Contact> allContacts = DBConnection.getInstance().getContactList();
        List<Contact> searchResults = new ArrayList<>();

        for (Contact contact : allContacts) {
            if (contact.getName().contains(searchText) ||
                contact.getPhoneNumber().contains(searchText)) {
                searchResults.add(contact);
            }
        }

        return searchResults;
    }
	
    // public static boolean deleteContact(int index) {
    //     ArrayList<Contact> contactList = DBConnection.getInstance().getContactList();
    //     if (index >= 0 && index < contactList.size()) {
    //         contactList.remove(index);
    //         return true;
    //     }
    //     return false;
    // }
	

	//----------------------delete conatact-----------------
    public static boolean deleteContact(Contact contact) {
        ArrayList<Contact> contactList = DBConnection.getInstance().getContactList();
        return contactList.remove(contact);
    }

	//-------------------GENERATE ID----------------
	public static String generateId() {
        ArrayList<Contact> contactList = DBConnection.getInstance().getContactList();
        int nextIndex = contactList.size();
        if (nextIndex == 0) {
            return "C0001";
        } else {
            return String.format("C%04d", (nextIndex + 1));
        }
    }
	
    //------------------------VALIDATE PHONENUMBER---------------------------
    public static boolean isValidPhoneNumber(String phoneNumber){
        if(phoneNumber.length()==10 && phoneNumber.charAt(0)=='0'){
            for(int i=1; i<phoneNumber.length(); i++){
                if(!Character.isDigit(phoneNumber.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    //------------------------VALIDATION SALARY-------------------------
    public static boolean isValidSalary(double salary){
        return salary>0;
    }

    //------------------------VALIDATION BIRTHDAY------------------------
    public static boolean isValidBirthday(String birthday){
        String y=birthday.substring(0,4);
		int year=Integer.parseInt(y);
		String m=birthday.substring(5,7);
		int month=Integer.parseInt(m);
		String d=birthday.substring(8,10);
		int day=Integer.parseInt(d);
		LocalDate currentDate = LocalDate.now();
		int currentMonthValue = currentDate.getMonthValue();
		int currentYear=currentDate.getYear();    
		int currentMonthDate=currentDate.getDayOfMonth();
			
		if(year%4!=0 & month==2){
			if(day>28){
				return false;
			}else{
				return true;
			}
		}
		if(year%4==0 & month==2){
			if(day>29){
				return false;
			}else{
				return true;
			}
		}
		if(month==4 || month==6 || month==9 || month==11){
			if(day>30){
				return false;					
			}
		}
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
			if(day>31){
				return false;
			}	
		}
		if(month>12){
			return false;
		}
		if(year<currentYear){
			return true;
			}else if(year==currentYear){
									
				if(month>currentMonthValue){
					return true;
				}else if(month==currentMonthValue){
									
					if(day<=currentMonthDate){
						return true;
					}
				}
			}
					return false;
    }


    
}
