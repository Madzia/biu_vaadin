package v2.model;

public class Pet {
	//? private String id;
	private String owner_login;
	private String pet_name;
	private int scores_sum;
	private int evaluations_number;
	private PetLifeCycle petlifecycle;
	
	public void SetOwnerLogin (String owner_login) {
		this.owner_login = owner_login;
	}

	public void SetPetName (String pet_name) {
		this.pet_name = pet_name;
	}
	
	public void SetScoresSumAndCount (int scores_sum, int evaluations_number) {
		this.scores_sum = scores_sum;
		this.evaluations_number = evaluations_number;
	}
	
	public String GetOwnerLogin () {
		return owner_login;
	}
	
	public String GetPetName () {
		return pet_name;
	}
	
	public double GetPetAvg() {
		return (double)scores_sum / (double)evaluations_number;
	}

    public PetLifeCycle getPetLifeCycle() {
        return petlifecycle == null ?
                (petlifecycle = new PetLifeCycle())
                : petlifecycle;
    }

    public void setPetLifeCycle(PetLifeCycle petlifecycle) {
        this.petlifecycle = petlifecycle;
    }
}
