package wb61.remuse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initPython();

        String text = getPythonHelloWorld();
        System.out.println(text);
    }

    private String getPythonHelloWorld() {
        Python python = Python.getInstance();
        PyObject pythonFile = python.getModule("helloworldscript");
        return pythonFile.callAttr("helloworld").toString();
    }

    private void initPython() {
        if(!Python.isStarted()){
            Python.start(new AndroidPlatform(this));
        }
    }
}
