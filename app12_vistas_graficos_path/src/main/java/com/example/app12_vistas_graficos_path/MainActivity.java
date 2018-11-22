package com.example.app12_vistas_graficos_path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiVistaPath(this));
    }

    public class MiVistaPath extends View {
        /**
         * Simple constructor to use when creating a view from code.
         *
         * @param context The Context the view is running in, through which it can
         *                access the current theme, resources, etc.
         */
        public MiVistaPath(Context context) {
            super(context);
        }

        /**
         * Implement this to do your drawing.
         *
         * @param canvas the canvas on which the background will be drawn
         */
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Path miTrazo = new Path();
            miTrazo.addCircle(350,350,100,Path.Direction.CCW);

            Paint miPincel = new Paint();
            miPincel.setColor(Color.RED);
            miPincel.setStrokeWidth(4);
            miPincel.setStyle(Paint.Style.STROKE);

            canvas.drawPath(miTrazo,miPincel);

            //
            miPincel.setStrokeWidth(1);
            miPincel.setStyle(Paint.Style.FILL);
            miPincel.setTextSize(40);
            miPincel.setTypeface(Typeface.SANS_SERIF);

            canvas.drawTextOnPath("texto ejemplo en Path",miTrazo,40,200,miPincel);

        }
    }
}
