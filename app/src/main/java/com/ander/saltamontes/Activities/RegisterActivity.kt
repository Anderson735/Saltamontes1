package com.ander.saltamontes.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ander.saltamontes.R
import com.ander.saltamontes.entities.Operations
import com.ander.saltamontes.entities.Student

class RegisterActivity : AppCompatActivity() {

    var document: EditText? = null;
    var name: EditText? = null;
    var age: EditText? = null;
    var address: EditText? = null;
    var phone: EditText? = null;

    var course1: EditText? = null;
    var course2: EditText? = null;
    var course3: EditText? = null;
    var course4: EditText? = null;
    var course5: EditText? = null;

    var qualification1: EditText? = null;
    var qualification2: EditText? = null;
    var qualification3: EditText? = null;
    var qualification4: EditText? = null;
    var qualification5: EditText? = null;

    var operations:Operations? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        obtainInformation()
    }

    private fun obtainInformation() {
        operations = Operations();

        document = findViewById(R.id.txtDocumento);
        name = findViewById(R.id.txtNombre);
        age = findViewById(R.id.txtEdad);
        address = findViewById(R.id.txtDireccion);
        phone = findViewById(R.id.txtTelefono);

        course1 = findViewById(R.id.txtAsig1);
        course2 = findViewById(R.id.txtAsig2);
        course3 = findViewById(R.id.txtAsig3);
        course4 = findViewById(R.id.txtAsig4);
        course5 = findViewById(R.id.txtAsig5);

        qualification1 = findViewById(R.id.txtACalificación1);
        qualification2 = findViewById(R.id.txtCalificacion2);
        qualification3 = findViewById(R.id.txtCalificacion3);
        qualification4 = findViewById(R.id.txtCalificacion4);
        qualification5 = findViewById(R.id.txtCalificacion5);

        val btnSend: Button = findViewById(R.id.btnRegistration);
        btnSend.setOnClickListener {addStudent()};

    }

    private fun addStudent() {
        var student: Student = Student();

        if(
            document?.text.toString() == "" ||
            name?.text.toString() == "" ||
            age?.text.toString() == "" ||
            address?.text.toString() == "" ||
            phone?.text.toString() == "" ||
            course1?.text.toString() == "" ||
            course2?.text.toString() == "" ||
            course3?.text.toString() == "" ||
            course4?.text.toString() == "" ||
            course5?.text.toString() == "" ||
            qualification1?.text.toString() == "" ||
            qualification2?.text.toString() == "" ||
            qualification3?.text.toString() == "" ||
            qualification4?.text.toString() == "" ||
            qualification5?.text.toString() == ""

        ) {
            Toast.makeText(this, "Se solicita ingresar todos los campos", Toast.LENGTH_SHORT)
        } else {
            student.document = document?.text.toString();
            student.name = name?.text.toString();
            student.age = age?.text.toString().toInt();
            student.address = address?.text.toString();
            student.phone = phone?.text.toString();

            student.course1 = course1?.text.toString();
            student.course2 = course2?.text.toString();
            student.course3 = course3?.text.toString();
            student.course4 = course4?.text.toString();
            student.course5 = course5?.text.toString();

            student.qualification1 = qualification1?.text.toString().toDouble();
            student.qualification2 = qualification2?.text.toString().toDouble();
            student.qualification3 = qualification3?.text.toString().toDouble();
            student.qualification4 = qualification4?.text.toString().toDouble();
            student.qualification5 = qualification5?.text.toString().toDouble();

            student.average = operations!!.performAverage(student);
            student.state = operations!!.kwonStudentStatus(student);

            if (operations?.validateEnteredGrade(student) === true){
                operations?.addStudent(student);
                sendData(student)
            }

        }
    }

    private fun sendData(student: Student) {
        val intent = Intent(this,DataActivity::class.java);
        val bundle:Bundle = Bundle();

        bundle.putString("name", student.name);

        bundle.putString("course1", student.course1);
        bundle.putString("course2", student.course2);
        bundle.putString("course3", student.course3);
        bundle.putString("course4", student.course4);
        bundle.putString("course5", student.course5);

        bundle.putDouble("qualification1", student.qualification1);
        bundle.putDouble("qualification2", student.qualification2);
        bundle.putDouble("qualification3", student.qualification3);
        bundle.putDouble("qualification4", student.qualification4);
        bundle.putDouble("qualification5", student.qualification5);

        bundle.putString("state", student.state);
        bundle.putDouble("average", student.average);

        intent.putExtras(bundle);
        startActivity(intent);
    }
}