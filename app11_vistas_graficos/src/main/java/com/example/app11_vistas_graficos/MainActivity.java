package com.example.app11_vistas_graficos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //
        //En este ejemplo la vista no es XML. Se crea directamente por código.
        // Para hacerla visible se fija como vista la clase creada para dibujar
        setContentView(new MiPropiaVista(this));
    }


    //Clase interna que extiende de View que dibuja sobre un lienzo(canvas)
    public class MiPropiaVista extends View {

        /**
         * Simple constructor to use when creating a view from code.
         *
         * @param context The Context the view is running in, through which it can
         *                access the current theme, resources, etc.
         */
        public MiPropiaVista(Context context) {
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

            //objeto de características de trazado(pincel)
            Paint miPincel = new Paint();
            miPincel.setColor(Color.BLUE);
            miPincel.setStrokeWidth(8);
            miPincel.setStyle(Paint.Style.FILL);

            //varias pruebas de métodos para dibujar figuras con varios pinceles
            canvas.drawCircle(175,175,100,miPincel);


            //color argb con alfa
            miPincel.setColor(Color.argb(100,0,255,255));
            miPincel.setStrokeWidth(8);
            miPincel.setStyle(Paint.Style.FILL_AND_STROKE);
            RectF rect = new RectF(10,500,200,700);
            canvas.drawRoundRect(rect , 64, 64, miPincel);

            miPincel.setColor(Color.argb(100,255,0,255));
            miPincel.setStrokeWidth(8);
            miPincel.setStyle(Paint.Style.FILL_AND_STROKE);
            RectF rect2 = new RectF(110,500,310,700);
            canvas.drawRoundRect(rect2 , 64, 64, miPincel);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                miPincel.setColor(Color.RED);
                miPincel.setStrokeWidth(1);
                miPincel.setStyle(Paint.Style.STROKE);
                canvas.drawRoundRect(500,500,700,700,16,16,miPincel);
            }

            //color del archivo resources color
            int miColor;
            miColor= ContextCompat.getColor(getContext(),R.color.verde);
            miPincel.setColor(miColor);
            miPincel.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(200,1000,100,miPincel);
        }

    }
}
