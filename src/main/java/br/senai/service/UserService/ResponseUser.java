package br.senai.service.UserService;

import br.senai.model.User;

public class ResponseUser {
    private User user;

    private boolean isExist;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }
}
