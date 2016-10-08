package marphain.web.bean;

public class User
{
    private String username;
    
    private String password;
    
    private String sex;

    /**
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the sex
     */
    public String getSex()
    {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex)
    {
        this.sex = sex;
    }

}
