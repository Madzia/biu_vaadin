package v2.model;

import java.util.Date;

public class PetLifeCycle {
	private int learning;
	private int life;
	private int happy;
	private Date creating_pet_date;
	private Date last_change_date;
	private double points;
	
	public void SetPetLifeCycle (int learning, int life, int happy, Date last_change_date) {
		this.learning = learning;
		this.life = life;
		this.happy = happy;
		this.last_change_date = last_change_date;
	}
	
	public void SetPoints (double points) {
		this.points = points;
	}
	
	public void SetCreatingPetDate (Date creating_pet_date) {
		this.creating_pet_date = creating_pet_date;
	}
	
	public void SetLearning (int learning) {
		this.learning = learning;
	}
	
	public void SetLife (int life) {
		this.life = life;
	}
	
	public void SetHappy (int happy) {
		this.happy = happy;
	}
	
	public void SetLastChangeDate (Date last_change_date) {
		this.last_change_date = last_change_date;
	}
	
	public Double GetPoints () {
		return points;
	}
	
	public Date GetCreatingPetDate () {
		return creating_pet_date;
	}
	
	public int GetLearning () {
		return learning;
	}
	
	public int GetLife () {
		return life;
	}
	
	public int GetHappy () {
		return happy;
	}
	
	public Date GetLastChangeDate () {
		return last_change_date;
	}
}
