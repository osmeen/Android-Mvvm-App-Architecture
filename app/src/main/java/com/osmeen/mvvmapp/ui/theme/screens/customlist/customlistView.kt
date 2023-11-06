package com.osmeen.mvvmapp.ui.theme.screens.customlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.osmeen.mvvmapp.R


data class PersonModel(
    val name:String,
    val image : Int,
    val description: String
)

private val personsList = mutableListOf<PersonModel>(
    PersonModel("Erick", R.drawable.profile1, "Follow me on my instagram page"),
    PersonModel("John", R.drawable.profile2, "Book your movie tickets with me"),
    PersonModel("Celine", R.drawable.profile3, "Hi There, subscribe to my channel"),
    PersonModel("Cate", R.drawable.profile4, "Welcome to my channel"),
    PersonModel("Rita", R.drawable.profile5, "Watch my shows online"),
    PersonModel("Mercy", R.drawable.profile6, "Support my video shows"),

    )

@Composable
fun CustomListView(navController: NavHostController, model: PersonModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color.Gray)
            .border(1.dp, Color.LightGray)
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = " ",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)

        )

        Column {
            Text(
                text = model.name,
                modifier = Modifier.padding(5.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Serif,
                color = Color.Blue
            )

            Text(
                text = model.description,
                modifier = Modifier.padding(6.dp),
                fontSize = 12.sp,
                color = Color.Black
            )
        }
    }
}

@Composable
fun CustomListScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        item {
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "LIST VIEW",
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(5f, 5f),
                        blurRadius = 5f
                    )
                ),
                fontSize = 25.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )
        }
        items(personsList){ model ->
            CustomListView(navController = navController, model = model)

        }

    }

}

@Preview
@Composable
fun CustomListScreenPreview() {
    CustomListScreen(rememberNavController())

}



