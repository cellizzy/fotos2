package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
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
    var expandir by remember { mutableStateOf(false) }
    Card() {
        Column() {
            Image(painter = painterResource(id = idImageDescricao.IdImagem),
                modifier = Modifier
                    .size(150.dp)
                    .padding(10.dp)
                    .clickable { expandir= !expandir

                    },
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Text(
                text = stringResource(id = idImageDescricao.IdImageDescricao)
            )


            if (expandir== true){
                Spacer(modifier = Modifier.size(20.dp))
                Text(
                    text ="Harry Potter é uma série de sete romances de " +
                            "fantasia escrita pela autora britânica J. K. Rowling. A série narra as " +
                            "aventuras de um jovem chamado Harry James Potter, que descobre aos 11 anos de" +
                            " idade que é um bruxo ao ser convidado para estudar na Escola de " +
                            "Magia e Bruxaria de Hogwarts.",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center

                )
            }
        }
        
    }
}
