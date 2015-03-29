package v2.model;

public class Person {
	private String mail;
    private String password;
    private Pet pet;

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
    public Pet getPet() {
        return pet == null ?
                (pet = new Pet())
                : pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
}
