package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpaceApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier=Modifier){
    var  number by remember { mutableStateOf(1) }
     val img = when (number) {
        1 -> R.drawable.a
        2 -> R.drawable.b
        3 -> R.drawable.c
        4 -> R.drawable.d
        5 -> R.drawable.e
        6 -> R.drawable.f
        7 -> R.drawable.g
        8 -> R.drawable.h
        9 -> R.drawable.i
        10 -> R.drawable.j
        11 -> R.drawable.k
        12 -> R.drawable.l
        13 -> R.drawable.m
        14 -> R.drawable.n
        15 -> R.drawable.oo
         else->R.drawable.a
    }

    val detail = when (number) {
        1 -> stringResource(R.string.a)
        2 -> stringResource(R.string.b)
        3 -> stringResource(R.string.c)
        4 -> stringResource(R.string.d)
        5 -> stringResource(R.string.e)
        6 -> stringResource(R.string.f)
        7 -> stringResource(R.string.g)
        8 -> stringResource(R.string.h)
        9 -> stringResource(R.string.i)
        10 -> stringResource(R.string.j)
        11 -> stringResource(R.string.k)
        12 -> stringResource(R.string.l)
        13 -> stringResource(R.string.m)
        14 -> stringResource(R.string.n)
        15 -> stringResource(R.string.o)
        else -> stringResource(R.string.a)
    }

    val artist = when (number) {
        1 -> stringResource(R.string.aa)
        2 -> stringResource(R.string.ba)
        3 -> stringResource(R.string.ca)
        4 -> stringResource(R.string.da)
        5 -> stringResource(R.string.ea)
        6 -> stringResource(R.string.fa)
        7 -> stringResource(R.string.ga)
        8 -> stringResource(R.string.ha)
        9 -> stringResource(R.string.ia)
        10 -> stringResource(R.string.ja)
        11 -> stringResource(R.string.ka)
        12 -> stringResource(R.string.la)
        13 -> stringResource(R.string.ma)
        14 -> stringResource(R.string.na)
        15 -> stringResource(R.string.oa)
        else -> stringResource(R.string.aa)
    }

    val date = when (number) {
        1 -> stringResource(R.string.ad)
        2 -> stringResource(R.string.bd)
        3 -> stringResource(R.string.cd)
        4 -> stringResource(R.string.dd)
        5 -> stringResource(R.string.ed)
        6 -> stringResource(R.string.fd)
        7 -> stringResource(R.string.gd)
        8 -> stringResource(R.string.hd)
        9 -> stringResource(R.string.id)
        10 -> stringResource(R.string.jd)
        11 -> stringResource(R.string.kd)
        12 -> stringResource(R.string.ld)
        13 -> stringResource(R.string.md)
        14 -> stringResource(R.string.nd)
        15 -> stringResource(R.string.od)
        else -> stringResource(R.string.ad)
    }

    Column(modifier= Modifier
        .padding(horizontal = 20.dp)
        .verticalScroll(rememberScrollState())){
        Spacer(modifier = Modifier.height(70.dp))
        photo(imageResId = img)
        Spacer(modifier = Modifier.height(30.dp))
        description(modifier,detail,artist,date)
        Row (modifier=modifier.padding(vertical = 20.dp)){
            Button( onClick = {
                if(number==1){number=15}
                else{ number-- } },
                Modifier.fillMaxWidth(0.5f)) {
                Text(text = "Previous")
            }
            Button(
                onClick = {
                    if(number==15){number=1}
                    else{ number++ }},
                Modifier.fillMaxWidth(1f)
            ) {
                Text(text = "Next")
            }
        }
    }
}
@Composable
fun photo(modifier : Modifier=Modifier, imageResId: Int){
    val imageResId = painterResource(id = imageResId)
    Box(Modifier.background(color = Color.Gray).fillMaxHeight()){

        Image(
            painter = imageResId, contentDescription = null, modifier = Modifier
                .padding(20.dp)
        )
    }
}
@Composable
fun description(modifier: Modifier=Modifier.padding(horizontal = 20.dp),details:String,artistname:String,date:String){
    Column (
        Modifier
            .background(color = Color.LightGray)
            .padding(vertical = 20.dp, horizontal = 20.dp).fillMaxWidth()
            ){
    Text(details, fontSize = 25.sp)
    Row{
        Text(artistname, fontWeight = FontWeight.Bold)
        Text(date,Modifier.padding(horizontal =4.dp))
    }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}