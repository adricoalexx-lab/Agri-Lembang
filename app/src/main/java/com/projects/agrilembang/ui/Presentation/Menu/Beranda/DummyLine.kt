package com.projects.agrilembang.ui.Presentation.Menu.Beranda

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.LineType
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine

@Composable
fun LineChart(
    modifier: Modifier = Modifier,

) {
    val steps = 6
    val pointsData1 = listOf(
        Point(0f, 30f),
        Point(1f, 50f),
        Point(2f, 25f),
        Point(3f, 55f),
        Point(4f, 35f),
        Point(5f, 45f),
        Point(6f, 40f)
    )
    val pointsData2 = listOf(
        Point(0f, 60f),
        Point(1f, 70f),
        Point(2f, 50f),
        Point(3f, 80f),
        Point(4f, 65f),
        Point(5f, 75f),
        Point(6f, 60f)
    )

    val xAxisData = AxisData.Builder()
        .axisStepSize(100.dp)
        .backgroundColor(Color.White)
        .steps(pointsData1.size -1)
        .labelData { i -> "Apr ${i * 5}" }
        .labelAndAxisLinePadding(15.dp)
        .axisLineColor(Color(0xFF155B36))
        .axisLabelColor(Color.Black)
        .build()

    val yAxisData = AxisData.Builder()
        .steps(steps)
        .backgroundColor(Color.White)
        .labelAndAxisLinePadding(20.dp)
        .labelData { i ->
            val yScale = 100 / steps
            "${i * yScale}%"
        }
        .axisLineColor(Color(0xFF155B36))
        .axisLabelColor(Color.Black)
        .build()

    val lineChartData =  LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointsData1,
                    LineStyle(
                        color = Color(0xFF155B36),
                        lineType = LineType.SmoothCurve()
                    ),
                    IntersectionPoint(Color.Transparent),
                    SelectionHighlightPoint(Color.Transparent),
                    ShadowUnderLine(
                        alpha = 0.5f,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF155B36),Color.White)
                            )
                        ),
                    SelectionHighlightPopUp()
                    ),
                Line(
                    dataPoints = pointsData2,
                    LineStyle(
                        color = Color(0xFF3354F4),
                        lineType = LineType.SmoothCurve()
                    ),
                    IntersectionPoint(Color.Transparent),
                    SelectionHighlightPoint(Color.Transparent),
                    ShadowUnderLine(
                        alpha = 0.5f,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF3354F4), Color.Transparent
                            )
                        )
                    ),
                    SelectionHighlightPopUp()
                )
            )
        ),
        backgroundColor = Color.White,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(Color.Transparent)
        )

    co.yml.charts.ui.linechart.LineChart(
        modifier = modifier
            .background(Color.White),
        lineChartData = lineChartData,

    )
}