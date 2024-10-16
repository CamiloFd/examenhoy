package controlador;

import modelo.Enrollment;
import modelo.Grade;
import vista.ViewEnrollment;
import vista.ViewGrade;

import java.util.List;


    public class GradeController {
        private ViewGrade view;

        public GradeController(ViewGrade view) {
            this.view = view;
        }

        public void insertNewGrade(Grade newGrade) {
            Grade.insertGrade(newGrade);
            view.mostrarMensaje("\nNota guardado correctamente!");
        }

        public void displayAllGrades() {
            List<Grade> grades = Grade.getAllGrade();
            view.displayListGrades(grades);
        }

    }


