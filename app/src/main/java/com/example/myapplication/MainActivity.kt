package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.myapplication.dados.FonteDeDados
import com.example.myapplication.model.IdImageDescricao
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
                    AppGaleriaDeFotos()

                }
            }
        }
    }
}
@Composable
fun AppGaleriaDeFotos(){
    LazyColumn(){
        items(FonteDeDados().CarregaListaMolduras()){
            molduraImagemDescricao-> MolduraImagemDescricao(molduraImagemDescricao )
        }
    }
}

@Composable
fun MolduraImagemDescricao(idImageDescricao: IdImageDescricao){
    Card() {
        Column() {
            Image(painter = painterResource(id = idImageDescricao.IdImagem),
                modifier = Modifier
                    .size(150.dp),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = idImageDescricao.IdImageDescricao)
            )
        }
        
    }
}
