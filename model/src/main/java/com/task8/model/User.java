package com.task8.model;

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
    }
