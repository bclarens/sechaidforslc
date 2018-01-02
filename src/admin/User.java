package admin;

public class User {
    private int uid;
    private String firstName;
    private String lastName;
    private String userName;
    private String atype;
    private String passwd;
    
    public User(int userid, String fname, String lname, String uname, String atype, String pwd){
        this.uid = userid;
        this.firstName = fname;
        this.lastName = lname;
        this.userName = uname;
        this.atype = atype;
        this.passwd = pwd;
    }
    
    public int getUserId(){
        return uid;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getUserName(){
        return userName;
    }

    public String getAccountype(){
        return atype;
    }
    
    public String getPwd(){
        return passwd;
    }
}
