package com.task8.model;

import java.util.Objects;

public class User {
        private String firstName;
        private String lastName;
        private String phone;
        private String email;
        private String login;
        private String password;
        private Role role;
        private boolean isActual;

        public Role getRole() {
            return role;
        }

        public boolean isActual() {
            return isActual;
        }
        public User(){

        }
        public User(String firstName, String lastName, String phone, String email, String login, String password, Role role)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phone = phone;
            this.email = email;
            this.login = login;
            this.password = password;
            this.role=role;
            this.isActual=true;
        }

        public String getLogin() {

            return login;
        }

        public String getPassword() {
            return password;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getPhone() {
            return phone;
        }

        public String getEmail() {
            return email;
        }

        public void setActual(boolean actual) {
            isActual = actual;
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        boolean a=isActual() == user.isActual() &&
                this.getFirstName().equals(user.getFirstName()) &&
                this.getLastName().equals(user.getLastName()) &&
                this.getPhone().equals(user.getPhone()) &&
                this.getEmail().equals( user.getEmail()) &&
                this.getLogin().equals(user.getLogin()) &&
                this.getPassword().equals(user.getPassword()) &&
                this.getRole() == user.getRole();
        return a;
    }

    @Override
    public int hashCode() {
            int i=this.getFirstName().hashCode()+this.getLastName().hashCode()+this.getPhone().hashCode()+this.getEmail().hashCode()+this.getPassword().hashCode();
        return i;
                //Objects.hash(getFirstName(), getLastName(), getPhone(), getEmail(), getLogin(), getPassword(), getRole(), isActual());
    }

    @Override
        public String toString() {
            return "User{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", phone='" + phone + '\'' +
                    ", email='" + email + '\'' +
                    ", login='" + login + '\'' +
                    ", password='" + password + '\'' +
                    ", role=" + role +
                    ", isActual=" + isActual +
                    '}';
        }
    }
