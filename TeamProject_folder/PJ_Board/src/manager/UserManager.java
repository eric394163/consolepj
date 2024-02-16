package manager;

import model.User;

public class UserManager {
    private static UserManager userManager;
    private User currentUser;

    public UserManager() {
    }

    public static UserManager getInstance() {
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
}
