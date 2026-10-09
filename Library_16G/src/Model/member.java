package Model;

import java.sql.Date;
import java.time.LocalDate;

public class member {

    private int member_id;
    private String name;
    private String nrc_no;
    private LocalDate date_of_birth;
    private String gender;
    private String email;
    private String phone_no;
    private String address;
    private LocalDate register_date;
    private LocalDate expired_date;
    private int book_count;

    public member() {}

    public member(int member_id, String name, String nrc_no,
    		LocalDate date_of_birth, String gender, String email,
            String phone_no, String address, LocalDate register_date,
            LocalDate expired_date, int book_count) {

        super();

        this.member_id = member_id;
        this.name = name;
        this.nrc_no = nrc_no;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.email = email;
        this.phone_no = phone_no;
        this.address = address;
        this.register_date = register_date;
        this.expired_date = expired_date;
        this.book_count = book_count;
    }

    @Override
    public String toString() {
        return "member [member_id=" + member_id
                + ", name=" + name
                + ", nrc_no=" + nrc_no
                + ", date_of_birth=" + date_of_birth
                + ", gender=" + gender
                + ", email=" + email
                + ", phone_no=" + phone_no
                + ", address=" + address
                + ", register_date=" + register_date
                + ", expired_date=" + expired_date
                + ", book_count=" + book_count + "]";
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNrc_no() {
        return nrc_no;
    }

    public void setNrc_no(String nrc_no) {
        this.nrc_no = nrc_no;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getRegister_date() {
        return register_date;
    }

    public void setRegister_date(LocalDate register_date) {
        this.register_date = register_date;
    }

    public LocalDate getExpired_date() {
        return expired_date;
    }

    public void setExpired_date(LocalDate expired_date) {
        this.expired_date = expired_date;
    }

    public int getBook_count() {
        return book_count;
    }

    public void setBook_count(int book_count) {
        this.book_count = book_count;
    }
}