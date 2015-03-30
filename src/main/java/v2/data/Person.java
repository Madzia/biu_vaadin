package v2.data;

public class Person {
	private String mail;
    private String password;

    public Person() {
    }
    
    public Person(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }
    
    public void SetPassword(String password) {
    	this.password = password;
    }

    public void SetMail(String mail) {
    	this.mail = mail;
    }
    
}
