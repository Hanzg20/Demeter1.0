package dataaccesslayer;

import model.UserDTO;
import java.util.List;

public class UserDaoImplTest {
    public static void main(String[] args) {
        // Create an instance of UserDaoImpl
        DAO<UserDTO> userDao = new UserDaoImpl();

        // Test insert method
        UserDTO newUser = new UserDTO();
        newUser.setUsername("John");
        newUser.setRoleId(1);
        newUser.setEmail("john@example.com");
        newUser.setPassword("password");

        int insertResult = userDao.insert(newUser);
        if (insertResult > 0) {
            System.out.println("User inserted successfully.");
        } else {
            System.out.println("Failed to insert user.");
        }

        // Test RetrieveAll method
        List<UserDTO> allUsers = userDao.RetrieveAll();
        System.out.println("All Users:");
        for (UserDTO user : allUsers) {
            System.out.println("User ID: " + user.getUserId() + ", Name: " + user.getUsername() + ", Role ID: " + user.getRoleId() + ", Email: " + user.getEmail() + ", Password: " + user.getPassword());
        }

        // Test Retrieve method
        int userIdToFind = 1;
        UserDTO foundUser = userDao.Retrieve(userIdToFind);
        if (foundUser != null) {
            System.out.println("User found by ID " + userIdToFind + ": " + foundUser.getUsername());
        } else {
            System.out.println("User with ID " + userIdToFind + " not found.");
        }

        // Test update method
        if (foundUser != null) {
            foundUser.setUsername("UpdatedName");
            int updateResult = userDao.update(foundUser);
            if (updateResult > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("Failed to update user.");
            }
        }

        // Test delete method
        int userIdToDelete = 2; // Change to the ID of the user you want to delete
        int deleteResult = userDao.delete(userIdToDelete);
        if (deleteResult > 0) {
            System.out.println("User with ID " + userIdToDelete + " deleted successfully.");
        } else {
            System.out.println("Failed to delete user with ID " + userIdToDelete + ".");
        }
    }
}
