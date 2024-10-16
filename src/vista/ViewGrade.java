package vista;

import interfaces.IMostrarMensaje;
import modelo.Enrollment;
import modelo.Grade;
import modelo.Grade_type;

import java.util.List;




    public class ViewGrade implements IMostrarMensaje {
        public void displayListGrades(List<Grade> grades) {
            System.out.println(" == Lista de Matriculas == ");
            for (Grade grade : grades) {
                System.out.println("Id " + grade.getId() + ", enrrollment_id: " + grade.getEnrrollmentId() + ", grade_type_id: " + grade.getGrade_typeId() + ", grade: " + grade.getgrade());
            }
        }




    }


