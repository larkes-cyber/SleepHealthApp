package com.larkes.healthapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
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

@Composable
fun SettingsScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 22.dp)
            .padding(top = 40.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "Настройки",
            fontSize = 28.sp,
            color = Color(0xff2B2B2B),
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(17.dp))
        Card(
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Column(
                    modifier = Modifier.weight(0.65f)
                ) {
                    Text(
                        text = "Повязка для сна",
                        fontSize = 18.sp,
                        color = Color(0xff2B2B2B),
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .clip(RoundedCornerShape(100))
                                .background(Color.Red.copy(alpha = 0.8f))
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Не активно",
                            color = Color(0xFF7482A2),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Подключите повязку для сна, чтобы мы смогли синхронизировать данные для вашей аналитики.",
                        fontSize = 13.sp,
                        color = Color(0xff2B2B2B),
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {  },
                        contentPadding = PaddingValues(vertical = 7.dp, horizontal = 11.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffF1F3FA)),
                        shape = RoundedCornerShape(12.dp),
                        elevation = ButtonDefaults.elevation(0.dp)

                    ) {
                        Text(
                            text = "Подключить",
                            fontSize = 14.sp,
                            color = Color(0xff2B2B2B),
                            fontWeight = FontWeight.Medium
                        )

                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.photo6),
                    contentDescription = "",
                    modifier = Modifier
                        .height(100.dp)
                        .weight(0.3f),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Card(
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Column(
                    modifier = Modifier.weight(0.55f)
                ) {
                    Text(
                        text = "Музыка для сна",
                        fontSize = 18.sp,
                        color = Color(0xff2B2B2B),
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Добавьте вашу любимую музыку для сна. Устройство начнет проигрывание при засыпании.",
                        fontSize = 13.sp,
                        color = Color(0xff2B2B2B),
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {  },
                        contentPadding = PaddingValues(vertical = 7.dp, horizontal = 11.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffF1F3FA)),
                        shape = RoundedCornerShape(12.dp),
                        elevation = ButtonDefaults.elevation(0.dp)

                    ) {
                        Text(
                            text = "Добавить",
                            fontSize = 14.sp,
                            color = Color(0xff2B2B2B),
                            fontWeight = FontWeight.Medium
                        )

                    }

                }
                Image(
                    painter = painterResource(id = R.drawable.photo7),
                    contentDescription = "",
                    modifier = Modifier
                        .height(120.dp)
                        .weight(0.4f),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}