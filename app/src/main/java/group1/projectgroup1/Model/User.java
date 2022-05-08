package group1.projectgroup1.Model;

public class User {
    String email_User,image_Cover,name_User,password_User,phone_User;

    public User() {
    }

    public User(String email_User, String image_Cover, String name_User, String password_User, String phone_User) {
        this.email_User = email_User;
        this.image_Cover = image_Cover;
        this.name_User = name_User;
        this.password_User = password_User;
        this.phone_User = phone_User;
    }

    public String getEmail_User() {
        return email_User;
    }

    public void setEmail_User(String email_User) {
        this.email_User = email_User;
    }

    public String getImage_Cover() {
        return image_Cover;
    }

    public void setImage_Cover(String image_Cover) {
        this.image_Cover = image_Cover;
    }

    public String getName_User() {
        return name_User;
    }

    public void setName_User(String name_User) {
        this.name_User = name_User;
    }

    public String getPassword_User() {
        return password_User;
    }

    public void setPassword_User(String password_User) {
        this.password_User = password_User;
    }

    public String getPhone_User() {
        return phone_User;
    }

    public void setPhone_User(String phone_User) {
        this.phone_User = phone_User;
    }
}
