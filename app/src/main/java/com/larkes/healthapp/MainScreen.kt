package com.larkes.healthapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun MainScreen() {

    val recs = listOf<Recom>(
        Recom(
            title = "Физические упражнения",
            text = "Занимайтесь физическими упражнениями. Однако постарайтесь заканчивать занятия как минимум за три часа до сна.",
            color = Color(0xffFEE2CF),
            image = R.drawable.photo1
        ),
        Recom(
            title = "Ограничьте дневной сон",
            text = " он может мешать ночному. Если вы спите днем, то постарайтесь делать это недолго и просыпаться до пяти часов вечера.",
            color = Color(0xffF1F3FA),
            image = R.drawable.photo2
        ),
        Recom(
            title = "Не заставляйте себя уснуть",
            text = "Не ложитесь спать, если вы не чувствуете сонливость. Если вы пролежали в кровати 20 минут и не уснули, то лучше встать.",
            color = Color(0xffDDF2FF),
            image = R.drawable.photo3
        ),
        Recom(
            title = "Питание",
            text = "Кажется, информация об этом звучала из каждого утюга, но для тех, кто пропустил, повторяем: последний прием пищи должен быть за 3-4 часа до сна.",
            color = Color(0xffFEE2CF),
            image = R.drawable.photo4
        ),
        Recom(
            title = "Температура в спальне",
            text = "Начнем с того, почти все люди спят в одежде для сна: пижамах, сорочках, футболках. Все это дополнительно согревает наше тело.",
            color = Color(0xffF1F3FA),
            image = R.drawable.photo5
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(horizontal = 22.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(RoundedCornerShape(100))
                        .background(Color(0xffA294F6)),
                    contentAlignment = Alignment.Center
                ){
                    AsyncImage(
                        model = "https://sun9-13.userapi.com/impg/ZQXeQlLwOot6PQATRlB-2ZU8K9n0Di5iaPpneg/7K0dMemnuk8.jpg?size=960x1280&quality=95&sign=d37fd89ac583f9713809e4c1f9dabea1&type=album",
                        contentDescription = "",
                        modifier = Modifier
                            .size(42.dp)
                            .clip(RoundedCornerShape(100)),
                        contentScale = ContentScale.Crop
                    )
                }

                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "",
                    modifier = Modifier.size(34.dp)
                )
            }

            Column(modifier = Modifier.padding(top = 10.dp)) {
                Text(
                    text = "Добрый День,",
                    fontSize = 28.sp,
                    color = Color(0xff2B2B2B),
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Кирилл!",
                    fontSize = 28.sp,
                    color = Color(0xff2B2B2B),
                    fontWeight = FontWeight.SemiBold
                )

            }
            Spacer(modifier = Modifier.height(25.dp))
        }
        Box {

            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .padding(top = 0.dp)
            ){
                item{
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(192.dp)
                            .clip(
                                RoundedCornerShape(15.dp)
                            )
                            .background(Color(0xffDDF2FF))
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 20.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(46.dp)
                                    .clip(RoundedCornerShape(100))
                                    .background(Color(0xffAEAFF7)),
                                contentAlignment = Alignment.Center
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.herbary),
                                    contentDescription = "",
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                            Column {
                                Text(
                                    text = "Тренеровка Медитации",
                                    fontSize = 18.sp,
                                    color = Color(0xff2B2B2B),
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "Саморазвитие",
                                    fontSize = 14.sp,
                                    color = Color(0xff2B2B2B),
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .fillMaxWidth()
                                .height(38.dp)
                        ) {
                            LinearProgressIndicator(
                                progress = 0.3f,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(10.dp)),
                                backgroundColor = Color(0x1A000000),
                                color = Color.White
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(start = 25.dp),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "5 День",
                                    fontSize = 16.sp,
                                    color = Color(0xff2B2B2B),
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                        }

                        Box(
                            modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                        ) {
                            Button(
                                onClick = {  },
                                contentPadding = PaddingValues(vertical = 7.dp, horizontal = 11.dp),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                                shape = RoundedCornerShape(12.dp),
                                elevation = ButtonDefaults.elevation(0.dp)

                            ) {
                                Row(horizontalArrangement = Arrangement.spacedBy(4.dp), verticalAlignment = Alignment.CenterVertically){
                                    Text(
                                        text = "Продолжить",
                                        fontSize = 14.sp,
                                        color = Color(0xff2B2B2B),
                                        fontWeight = FontWeight.Medium
                                    )
                                    Icon(
                                        imageVector = Icons.Default.ArrowForward,
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(20.dp)
                                            .padding(top = 4.dp)
                                    )
                                }

                            }
                        }


                    }
                }
                item {
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Рекомендации",
                        fontSize = 24.sp,
                        color = Color(0xff2B2B2B),
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
                itemsIndexed(recs){index, item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp))
                            .background(item.color)
                            .padding(vertical = 18.dp, horizontal = 15.dp),
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Column(modifier = Modifier.weight(0.7f)) {
                            Text(
                                text = item.title,
                                fontSize = 18.sp,
                                color = Color(0xff2B2B2B),
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = item.text,
                                fontSize = 12.sp,
                                color = Color(0xff2B2B2B),
                                fontWeight = FontWeight.Medium
                            )
                        }
                        Image(
                            painter = painterResource(id = item.image),
                            contentDescription = "",
                            modifier = Modifier
                                .weight(0.3f)
                                .heightIn(max = 100.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color.Black.copy(alpha = 0.04f)))
        }
    }
}