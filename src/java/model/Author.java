/* File: Author.java
 * Author: Stanley Pieda
 * Date: 2015
 * Modified: May/2022 changed Author to Author - kriger
 * Description: Demonstration of DAO Design Pattern
 */
package model;

public class Author {

    private Integer authorID;
    private String firstName;
    private String lastName;

    public Integer getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Integer authorID) {
        this.authorID = authorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
