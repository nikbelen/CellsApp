package com.example.cellsapp.presentation.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.cellsapp.R
import com.example.cellsapp.data.Cell
import com.example.cellsapp.data.CellBase
import com.example.dogapp.utils.capitaliseFirst


@Composable
fun CellCard(
    cell: CellBase,
    modifier: Modifier = Modifier
) {
    val text: String
    val drawable: String
    if (cell is Cell){
        if(cell.isAlive) {
            text = "Живая"
            drawable = "https://media.allure.com/photos/62bdedcbee3c1952137736fb/4:3/w_3980,h_2985,c_limit/ryan%20gosling%20at%20ken%20barbie%20movie.jpeg"
        }
        else {
            text = "Мертвая"
            drawable = "https://www.rollingstone.com/wp-content/uploads/2018/06/bladerunner-2-trailer-watch-8bd914b0-744f-43fe-9904-2564e9d7e15c.jpg?w=1000&h=562&crop=1"
        }
    }
    else {
        if(cell.isAlive) {
            text = "Жизнь"
            drawable = "https://static1.colliderimages.com/wordpress/wp-content/uploads/2022/09/Drive-Ryan-Gosling.jpg?q=49&fit=crop&w=750&h=422&dpr=2"
        }
        else {
            text = "Жизнь (погибла)"
            drawable = "https://graphic-engine.swarthmore.edu/wp-content/uploads/2012/03/gosling.jpg"
        }
    }


    Surface(
        shape = MaterialTheme.shapes.medium,
        color = Color.White,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            val image: Painter =
                rememberAsyncImagePainter(drawable, error = painterResource(R.drawable.gooseling), placeholder = painterResource(R.drawable.gooseling))
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .padding(vertical = 8.dp, horizontal = 8.dp)
                    .clip(CircleShape)

            )
            Column {
                Text(
                    text = text.capitaliseFirst(),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                Text(
                    text = cell.randomComment.capitaliseFirst(),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 0.dp)
                )
            }
        }
    }
}
@Composable
fun CellCardText(
    drawable: String,
    text: String,
    subtext: String,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = Color.White,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            val image: Painter =
                rememberAsyncImagePainter(drawable, error = painterResource(R.drawable.gooseling), placeholder = painterResource(R.drawable.gooseling))
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .padding(vertical = 8.dp, horizontal = 8.dp)
                    .clip(CircleShape)

            )
            Column {
                Text(
                    text = text.capitaliseFirst(),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                Text(
                    text = subtext.capitaliseFirst(),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 0.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun CellCardComposablePreview() {
    CellCardText(drawable = "https://upload.wikimedia.org/wikipedia/commons/e/e6/Ryan_Gosling_by_Gage_Skidmore.jpg", text = "Это реально он!", subtext = "И даже не умер")
}