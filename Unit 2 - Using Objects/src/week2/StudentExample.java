package week2;

public class StudentExample {
    public static void main(String[] args) {
        // ritchie is a variable to an instance of the class student
        // ritchie is an Object (instances of a class)
        Student ritchie = new Student("Ritchie", "45646", 10);
        Student yola = new Student("Yola", "123456", 10);

        // ritchie and yola are references to two different students

        Student rastin = ritchie;

        // because rastin and ritchie refer to the same Student object
        // it increases the grade for both (still its only 1 Object)
        rastin.increaseGrade();

        ritchie = null;
        // Student tristan; tristan is currently the null reference

        // ritchie.increaseGrade(); // throws java.lang.NullPointerExeption because
        // ritchie is null

    }
}
