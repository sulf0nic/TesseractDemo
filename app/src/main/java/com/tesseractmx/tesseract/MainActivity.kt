package com.tesseractmx.tesseract

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import com.tesseractmx.tesseract.db.SQLIteHelper
import com.tesseractmx.tesseract.screen.LoginScreen
import com.tesseractmx.tesseract.ui.theme.TesseractTheme

class MainActivity : ComponentActivity() {

     lateinit var clientesSQLiteHelper:SQLIteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        clientesSQLiteHelper = SQLIteHelper(this)
        clientesSQLiteHelper.anadirDato("RICARDO", "ARENAS", "CARRANZA","18/07/1990",
                "rd.arenas@ebc.edu.mx", "558377448484", "M", "$12345.67", "1234");
        clientesSQLiteHelper.revisarTabla()
        val composeView = ComposeView(this)
        composeView.setContent {
            // TODO: Agrega aquí tu UI de Compose
        }

        setContentView(composeView)
        setContent {
            TesseractTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    //Greeting("Android")
                    LoginScreen(onLoginClicked = {})

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TesseractTheme {
        Greeting("Android")
    }
}