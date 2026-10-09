package Model;

import java.time.LocalDate;

public class users {

    private int user_id;
    private String name;
    private String passwords;
    private LocalDate date_of_birth;
    private String gender;
    private String email;
    private String phone_no;
    private String role;
    private String address;
    private LocalDate join_date;
    private String image;

    public users() {}

    public users(int user_id,String name, String passwords,
            LocalDate date_of_birth, String gender, String email,
            String phone_no, String role, String address,
            LocalDate join_date, String image) {

        super();
        this.user_id = user_id;
        this.name = name;
        this.passwords = passwords;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.email = email;
        this.phone_no = phone_no;
        this.role = role;
        this.address = address;
        this.join_date = join_date;
        this.image = image;
    }

    @Override
    public String toString() {
        return "users [user_id=" + user_id
                + ", name=" + name
                + ", passwords=" + passwords
                + ", date_of_birth=" + date_of_birth
                + ", gender=" + gender
                + ", email=" + email
                + ", phone_no=" + phone_no
                + ", role=" + role
                + ", address=" + address
                + ", join_date=" + join_date
                + ", image=" + image + "]";
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getJoin_date() {
        return join_date;
    }

    public void setJoin_date(LocalDate join_date) {
        this.join_date = join_date;
    }

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}