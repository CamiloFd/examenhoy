import controlador.CourseController;
import controlador.EnrollmentController;
import controlador.StudentController;
import controlador.TeacherController;
import db.connection;
import modelo.Course;
import modelo.Enrollment;
import modelo.Student;
import modelo.Teacher;
import vista.ViewCourse;
import vista.ViewEnrollment;
import vista.ViewStudent;
import vista.ViewTeacher;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido a nuestro sistema academico!");

        // Inicializar vistas
        ViewStudent viewStudent = new ViewStudent();
        ViewTeacher viewTeacher = new ViewTeacher();
        ViewCourse viewCourse = new ViewCourse();
        ViewEnrollment viewEnrollment = new ViewEnrollment();

        // Inicializar controladores
        StudentController studentController = new StudentController(viewStudent);
        TeacherController teacherController = new TeacherController(viewTeacher);
        CourseController courseController = new CourseController(viewCourse);
        EnrollmentController enrollmentController = new EnrollmentController(viewEnrollment);

        // Inicializar objeto estudiante
        Student newStudent = new Student(12345, "Daniel", "daniel@gmail.com");
        Student newStudent1 = new Student(4321, "Juanito", "juanito@gmail.com");
        // Guardar estudiante en la base de datos
        studentController.insertNewStudent(newStudent);
        // Mostrar datos en las vistas
        studentController.displayAllStudents();

        // Inicializar objeto profesor
        Teacher newTeacher = new Teacher(1235, "Pablo", "Ciencias Sociales");
        // Guardar proesor en la base de datos
        teacherController.insertNewTeacher(newTeacher);
        //Mostrar datos en las vistas
        teacherController.displayAllTeachers();

        Course newCourse = new Course(1234, "Historia", "...", true, newTeacher.getId());
        courseController.insertNewCourse(newCourse);
        courseController.displayAllCourses();

        Enrollment newEnrollment = new Enrollment(1,12345,1234);
        enrollmentController.insertNewEnrollment(newEnrollment);
        enrollmentController.displayAllEnrollments();

    }
}