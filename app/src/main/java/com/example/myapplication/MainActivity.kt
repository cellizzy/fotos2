package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}
@Composable
fun Fotos2(
idImagem:Int,
idDescricao:Int

){
    Card() {
        Column() {
            Image(painter = painterResource(id = idImagem),
                modifier = Modifier
                    .size(150.dp),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = idDescricao)
            )
        }
        
    }
}
@Preview
@Composable
fun PreviewMoldura(){
    Column() {

        Fotos2(idImagem = R.drawable.fotos2,
            idDescricao = R.string.descricaofoto2
        )
        Fotos2(idImagem = R.drawable.fots2a,
            idDescricao = R.string.descricaofoto2a
        )
        Fotos2(idImagem = R.drawable.fotos2b,
            idDescricao = R.string.descricaofoto2b
        )
        Fotos2(idImagem = R.drawable.fotos2c,
            idDescricao = R.string.descricaofoto2c
        )
    }
}