package com.larkes.healthapp

import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.github.tehras.charts.line.LineChart
import com.github.tehras.charts.line.LineChartData
import com.github.tehras.charts.line.renderer.line.SolidLineDrawer
import com.github.tehras.charts.line.renderer.point.FilledCircularPointDrawer
import com.github.tehras.charts.line.renderer.xaxis.SimpleXAxisDrawer
import com.github.tehras.charts.line.renderer.yaxis.SimpleYAxisDrawer
import com.github.tehras.charts.piechart.PieChart
import com.github.tehras.charts.piechart.PieChartData
import com.github.tehras.charts.piechart.animation.simpleChartAnimation
import com.github.tehras.charts.piechart.renderer.SimpleSliceDrawer

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChartsScreen() {

    val donutChartData = listOf(
          PieChartData.Slice(9f, Color(0xff5342AC)),
          PieChartData.Slice(85f, Color(0xFFEF5DA8)),
          PieChartData.Slice(6f, Color(0xFFA0E3E2)),
        )

    val lineChartData = LineChartData(
       points =  listOf(
        LineChartData.Point(0f,"0:00"),
        LineChartData.Point(0f,"1:00"),
        LineChartData.Point(1f,"2:00"),
        LineChartData.Point(1.5f,"3:00"),
        LineChartData.Point(0.5f,"4:00"),
        LineChartData.Point(2f,"5:00"),
        LineChartData.Point(1.5f,"6:00"),
        LineChartData.Point(4f,"7:00")
         ),
        lineDrawer = SolidLineDrawer(color = Color(0xffAEAFF7)),
        startAtZero = true
    )
    
    val scrollState = rememberScrollState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 22.dp)
            .padding(top = 40.dp)
    ){
        item {
            Text(
                text = "Аналитика сна",
                fontSize = 28.sp,
                color = Color(0xff2B2B2B),
                fontWeight = FontWeight.Medium
            )
        }
        item {
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Box(
                    modifier = Modifier
                        .weight(0.45f)
                        .height(125.dp)
                ) {
                    AnimationBox(
                        enter = expandHorizontally()
                    ) {
                        Card(
                            modifier = Modifier.fillMaxSize(),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(horizontal = 10.dp, vertical = 12.dp)) {
                                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                    Text(
                                        text = "Сон",
                                        color = Color(0xff2B2B2B),
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_bedtime_24),
                                        contentDescription = "",
                                        tint = Color(0xff5342AC),
                                        modifier = Modifier.size(26.dp)
                                    )
                                }
                                Text(
                                    text = "7 ч 34 мин",
                                    color = Color(0xff5342AC),
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(0.45f)
                        .height(125.dp)
                ) {
                    AnimationBox(
                        enter = expandHorizontally()
                    ) {
                        Card(
                            modifier = Modifier.fillMaxSize(),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Column(modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 10.dp, vertical = 12.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Качество Сна",
                                    color = Color(0xff2B2B2B),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Box(contentAlignment = Alignment.Center) {
                                    CircularProgressIndicator(
                                        progress = 0.63f,
                                        modifier = Modifier.size(68.dp),
                                        color = Color(0xffF09E54).copy(alpha = 0.65f),
                                        strokeWidth = 6.dp
                                    )
                                    Text(
                                        text = "63%",
                                        color = Color(0xFFEE9545),
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        item{
            Spacer(modifier = Modifier.height(10.dp))
            AnimationBox(
                enter = expandHorizontally()
            ){
                Card(
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        Modifier
                            .padding(horizontal = 10.dp, vertical = 12.dp)
                    ) {
                        Text(
                            text = "Фазы сна",
                            color = Color(0xff2B2B2B),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .height(120.dp)
                                    .weight(0.3f)
                            ) {
                                PieChart(
                                    pieChartData = PieChartData(donutChartData),
                                    modifier = Modifier.fillMaxSize(),
                                    animation = simpleChartAnimation(),
                                    sliceDrawer = SimpleSliceDrawer(60f)
                                )
                            }
                            Column(modifier = Modifier.weight(0.55f)) {
                                DonutLabelItem(title = "Легкий сон", color = Color(0xFFEF5DA8), time = "5ч 25 мин")
                                DonutLabelItem(title = "Глубокий сон", color = Color(0xff5342AC), time = "1ч 11 мин")
                                DonutLabelItem(title = "Быстрый сон", color = Color(0xFFA0E3E2), time = "58 мин")
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        RowDonatStat(
                            title = "Время глубокого сна 56 балла",
                            text = "Норма 70-100 балла",
                            background = Color.Red.copy(alpha = 0.08f),
                            subtext = "Низкий",
                            colorText = Color.Red.copy(alpha = 0.48f)
                        )
                        RowDonatStat(
                            title = "Глубокий сон 16%",
                            text = "Норма 20-60%",
                            subtext = "Низкий",
                            colorText = Color(0xFF0E84E0).copy(alpha = 0.7f)
                        )


                    }

                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            AnimationBox(
                enter = expandHorizontally()
            ){
                Card(
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 12.dp)
                    ) {
                        Text(
                            text = "Активность",
                            color = Color(0xff2B2B2B),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        LineChart(
                            linesChartData = listOf(lineChartData),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(140.dp),
                            animation = simpleChartAnimation(),
                            pointDrawer = FilledCircularPointDrawer(),
                            xAxisDrawer = SimpleXAxisDrawer(),
                            yAxisDrawer = SimpleYAxisDrawer(),
                            horizontalOffset = 5f
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        RowDonatStat(
                            title = "Кол-во пробуждений 1 раз",
                            text = "Норма: 0-1 раз",
                            subtext = "",
                            background = Color.Green.copy(alpha = 0.10f)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        RowDonatStat(
                            title = "Кол-во дыхания 94 балла",
                            text = "Норма: 70-100 балла",
                            subtext = "",
                            background = Color.Green.copy(alpha = 0.05f)
                        )
                    }
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            AnimationBox(
                enter = expandHorizontally()
            ) {
                Card(
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 12.dp)
                    ) {
                        Text(
                            text = "Анализ и рекомендации",
                            color = Color(0xff2B2B2B),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Прошлой ночью вы спали нормально. Оценка качества непрерывного глубокого сна составила 63%. Это низкое значение. Глубокий сон был очень прерывистым. Пробуждения, повторяющиеся на протяжении долгого времени, нарушают работу эндокринной системы, ухудшают выработку инсулина и увеличивают риск развития диабета.",
                            color = Color(0xff2B2B2B),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(15))
                                .background(Color(0xffF1F3FA))
                                .fillMaxWidth()
                                .padding(horizontal = 15.dp, vertical = 10.dp)
                        ) {
                            Row{
                                Box(
                                    modifier = Modifier.padding(end = 4.dp, top = 2.dp)
                                ) {
                                    Icon(painterResource(id = R.drawable.baseline_edit_note_24),
                                        contentDescription = "",
                                        tint = Color(0xff5342AC),
                                        modifier = Modifier
                                            .size(20.dp)
                                    )
                                }
                                Text(
                                    text = "Расслабление мышц перед сном снимает тонус и успокаивает, облегчая засыпание. Это также поможет улучшить качество сна.",
                                    color = Color(0xFF7482A2),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium,
                                )
                            }
                        }
                    }
                }
            }
        }
        item { 
            Spacer(modifier = Modifier.height(85.dp))
        }
    }
}

@Composable
fun RowDonatStat(
    title:String,
    text:String,
    subtext:String,
    background:Color? = null,
    colorText:Color? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(background ?: Color.Transparent)
            .padding(vertical = 15.dp, horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text =  title ,
                color = Color(0xff2B2B2B),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = text,
                color = Color(0x8C2B2B2B),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Text(
            text = subtext,
            color = colorText ?: Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun DonutLabelItem(title:String, color: Color, time:String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Divider(modifier = Modifier
                .size(12.dp)
                .clip(RoundedCornerShape(100))
                .background(color))
            Text(
                text = title,
                color = Color(0xFF7482A2),
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Text(
            text = time,
            color = Color(0xFF7482A2),
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}