package Mapping.POJO;
// Generated Mar 7, 2015 9:53:12 AM by Hibernate Tools 4.3.1



/**
 * Student generated by hbm2java
 */
public class Student  implements java.io.Serializable {


     private String email;
     private String firstname;
     private String lastname;
     private String password;
     private Boolean loggedin;
     private Integer schoolid;

    public Student() {
    }

	
    public Student(String email, String firstname, String lastname) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public Student(String email, String firstname, String lastname, String password, Boolean loggedin, Integer schoolid) {
       this.email = email;
       this.firstname = firstname;
       this.lastname = lastname;
       this.password = password;
       this.loggedin = loggedin;
       this.schoolid = schoolid;
    }
   
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean getLoggedin() {
        return this.loggedin;
    }
    
    public void setLoggedin(Boolean loggedin) {
        this.loggedin = loggedin;
    }
    public Integer getSchoolid() {
        return this.schoolid;
    }
    
    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }




}

