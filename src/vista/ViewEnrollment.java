package vista;
import interfaces.IMostrarMensaje;
import modelo.Course;
import modelo.Enrollment;
import java.util.List;

public class ViewEnrollment implements IMostrarMensaje{
    public void displayListEnrollments(List<Enrollment> enrollments){
        System.out.println(" == Lista de Matriculas == ");
        for (Enrollment enrollment : enrollments) {
            System.out.println("Id Matricula: " + enrollment.getId() + ", Codigo del estudiante: " + enrollment.getStudentId() + ", Codigo del curso: " + enrollment.getCourseId());
        }
    }




}
