package com.ander.saltamontes.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.ander.saltamontes.R
import com.ander.saltamontes.entities.Operations

class DataActivity : AppCompatActivity() {



    var name: TextView? = null;

    var course1: TextView? = null;
    var course2: TextView? = null;
    var course3: TextView? = null;
    var course4: TextView? = null;
    var course5: TextView? = null;

    var qualification1: TextView? = null;
    var qualification2: TextView? = null;
    var qualification3: TextView? = null;
    var qualification4: TextView? = null;
    var qualification5: TextView? = null;

    var average: TextView? = null;
    var state:TextView? = null;

    var operation: Operations? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        bringComponents();
    }

    private fun bringComponents() {
        operation = Operations();

        name = findViewById(R.id.txtNombre);

        course1 = findViewById(R.id.txtAsig1);
        course2 = findViewById(R.id.txtAsig2);
        course3 = findViewById(R.id.txtAsig3);
        course4 = findViewById(R.id.txtAsig4);
        course5 = findViewById(R.id.txtAsig5);

        qualification1 = findViewById(R.id.txtnota1);
        qualification2 = findViewById(R.id.txtnota2);
        qualification3 = findViewById(R.id.txtnota3);
        qualification4 = findViewById(R.id.txtnota4);
        qualification5 = findViewById(R.id.txtnota5);

        average = findViewById(R.id.txtPromedio);
        state = findViewById(R.id.txtEstado);

        showDatas()
    }

    private fun showDatas() {
        var bundle:Bundle? = this.intent.extras;

        if (bundle != null){
            name!!.text = "${bundle.getString("name")}";

            course1!!.text = "${bundle.getString("course1")}";
            course2!!.text = "${bundle.getString("course2")}";
            course3!!.text = "${bundle.getString("course3")}";
            course4!!.text = "${bundle.getString("course4")}";
            course5!!.text = "${bundle.getString("course5")}";

            qualification1!!.text = "${bundle.getDouble("qualification1")}";
            qualification2!!.text = "${bundle.getDouble("qualification2")}";
            qualification3!!.text = "${bundle.getDouble("qualification3")}";
            qualification4!!.text = "${bundle.getDouble("qualification4")}";
            qualification5!!.text = "${bundle.getDouble("qualification5")}";

            average!!.text = "${bundle.getDouble("average")}";
            state!!.text = "${bundle.getString("state")}";
        }
    }
}