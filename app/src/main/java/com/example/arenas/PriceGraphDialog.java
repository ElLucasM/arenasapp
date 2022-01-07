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

import com.example.arenas.entities.Price;
import com.example.arenas.entities.Solar;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LabelFormatter;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jjoe64.graphview.series.Series;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;

public abstract class PriceGraphDialog {
    private static AlertDialog alertDialog;
    private static AlertDialog.Builder dialogBuilder;
    private static GraphView priceEvolution;
    private static TextView priceEvolutionLabel;

    public static void showPriceGraph(Context context, AppCompatActivity activity, Solar solar, List<Price> prices){
        dialogBuilder = new AlertDialog.Builder(context);
        final View priceGraphPopupView =  activity.getLayoutInflater().inflate(R.layout.price_graph_layout, null);
        priceEvolutionLabel = priceGraphPopupView.findViewById(R.id.priceEvolutionLabel);
        priceEvolution = priceGraphPopupView.findViewById(R.id.priceEvolution);
        priceEvolutionLabel = priceGraphPopupView.findViewById(R.id.priceEvolutionLabel);
        priceEvolutionLabel.setText("Evolución de precio de Solar #" + solar.id);
        DataPoint[] dataPoints = new DataPoint[prices.size()];
        for(int i = 0; i<dataPoints.length; i++){
            Price price = prices.get(i);
            dataPoints[i] = new DataPoint(price.date,price.price);
            priceEvolution.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
                @Override
                public String formatLabel(double value, boolean isValueX) {
                    if(isValueX){
                        return (new SimpleDateFormat("MM/yy")).format(new Date((long) value));
                    }
                    return super.formatLabel(value, isValueX);
                }
            });
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(dataPoints);
        PointsGraphSeries<DataPoint> pointSeries = new PointsGraphSeries<DataPoint>(dataPoints);
        pointSeries.setSize(10);
        priceEvolution.addSeries(series);
        priceEvolution.addSeries(pointSeries);
        priceEvolution.getViewport().setScalable(true);
        dialogBuilder.setView(priceGraphPopupView);
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }
}
