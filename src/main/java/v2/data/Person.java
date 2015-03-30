package v2.data;

public class Person {
	private String mail;
    private String password;
    private String login;

    public Person() {
    }
    
    public Person(String login, String mail, String password) {
        this.mail = mail;
        this.login = login;
        this.password = password;
    }
    
    public void SetPassword(String password) {
    	this.password = password;
    }

    public void SetMail(String mail) {
    	this.mail = mail;
    }

    public void SetLogin(String login) {
    	this.login = login;
    }
    
    public String GetPassword() {
    	return password;
    }

    public String GetMail() {
    	return mail;
    }

    public String GetLogin() {
    	return login;
    }
}
