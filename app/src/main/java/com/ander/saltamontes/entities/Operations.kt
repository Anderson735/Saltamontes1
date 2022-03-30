package com.ander.saltamontes.entities

class Operations {

    companion object {
        var Students = arrayListOf<Student>()
    }

    fun addStudent(student: Student) {
        Students.add(student)
    }

    fun showNumberOfRegistered(): Int {
        return Students.count()
    }

    fun validateRatingGrade(qualification: Double): Boolean {
        return qualification in 0.0..5.0
    }

    fun performAverage(student: Student): Double {
        var average: Double =
            (student.qualification1 + student.qualification2 + student.qualification3 +
                    student.qualification4 + student.qualification5) / 5;
        return average;
    }

    fun validateEnteredGrade(student: Student): Boolean {
        return (
                validateRatingGrade(student.qualification1) === true &&
                        validateRatingGrade(student.qualification2) === true &&
                        validateRatingGrade(student.qualification3) === true &&
                        validateRatingGrade(student.qualification4) === true &&
                        validateRatingGrade(student.qualification5) === true
                )
    }

    fun kwonStudentStatus(student: Student): String {
        var state = "";
        if (student.average >= 3.6) {
            state = "Gano el periodo";
        } else if (student.average >= 2.5) {
            state = "Puede recuperar el periodo"
        } else{
            state = "No puede recuperar el periodo"
        }
        return state;
    }

    fun showQuantity(estado:String):Int {
        var counter:Int = 0;
        for (i in Students){
            if(i.state == estado){
                counter ++;
            }
        }
        return counter;
    }
}