package com.example.arenas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.example.arenas.entities.Price;
import com.example.arenas.entities.Solar;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LabelFormatter;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jjoe64.graphview.series.Series;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class PriceGraphDialog {
    private static AlertDialog alertDialog;
    private static AlertDialog.Builder dialogBuilder;
    //private static GraphView priceEvolution;
    private static TextView priceEvolutionLabel;
    private static AnyChartView priceEvolution;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void showPriceGraph(Context context, AppCompatActivity activity, Solar solar, List<Price> prices){
        dialogBuilder = new AlertDialog.Builder(context);
        final View priceGraphPopupView =  activity.getLayoutInflater().inflate(R.layout.price_graph_layout, null);
        priceEvolutionLabel = priceGraphPopupView.findViewById(R.id.priceEvolutionLabel);
        priceEvolution = priceGraphPopupView.findViewById(R.id.priceEvolution);
        //priceEvolutionLabel.setText("Evolución de precio de Solar #" + solar.id);
        List<DataEntry> dataPoints = new ArrayList<DataEntry>();
        Cartesian cartesian = AnyChart.column();
        for(int i = 0; i<prices.size(); i++){
            Price price = prices.get(i);
            dataPoints.add(new ValueDataEntry(price.date.format(DateTimeFormatter.ofPattern("MM/yyyy")),price.price));
        }
        Column column = cartesian.column(dataPoints);

        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("${%Value}{groupsSeparator: }");

        cartesian.animation(true);
        cartesian.title("Evolución de precio de Solar #" + solar.id);

        cartesian.yScale().minimum(0d);

        cartesian.yAxis(0).labels().format("${%Value}{groupsSeparator: }");


        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);

        cartesian.xAxis(0).title("Fecha");
        cartesian.yAxis(0).title("Precio");

        priceEvolution.setChart(cartesian);

        dialogBuilder.setView(priceGraphPopupView);
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }
}
