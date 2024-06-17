import java.util.*;
class DBConnection{
	private ArrayList<Contact> contactList;
	private static DBConnection contactDBConnection;
	private DBConnection(){
        contactList=new ArrayList<>();
	}
	public static DBConnection getInstance(){
		if(contactDBConnection==null){
			contactDBConnection=new DBConnection();
		}
		return contactDBConnection;
	}
	public ArrayList<Contact> getContactList(){
		return  contactList;
	}
    public int size() {
        return contactList.size();
    }
	public boolean removeContact(Contact contact) {
        return contactList.remove(contact);
    }
    
}
