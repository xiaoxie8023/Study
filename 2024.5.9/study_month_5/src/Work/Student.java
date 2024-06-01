package Work;

/**
 * program: 2024.5.9
 * description: 学生类
 * author: xiaoxie
 * create: 2024-05-30 10:35
 **/
    public class Student {
        private String name;
        private String email;

        public Student(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setEmail(String email) {
            this.email = email;
        }
        public String getEmail() {
            return email;
        }
    }

