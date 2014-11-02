package com.example.erniesphoneapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
public class AnimatedView extends ImageView{
	
    
        private Context mContext;
//      int x = -1;
//      int y = -1;
        int x = getWidth();
        int y = getHeight();
        private int xVelocity = 10;
        private int yVelocity = 5;
        private Handler h;
        private final int FRAME_RATE = 30;

        
        
public AnimatedView(Context context, AttributeSet attrs)  {
                super(context, attrs);
                mContext = context;
                h = new Handler();
      }
         private Runnable r = new Runnable() {
                 @Override
                 public void run() {
                         invalidate();
                 }
         };
       
         public static Bitmap makeSrc(int w, int h) {
        	 Log.d("getBitmap", "getBitmap");
        	    Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        	    Canvas c = new Canvas(bm);
        	    Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

        	    p.setColor(0xFF66AAFF);
        	    c.drawRect(w / 3, h / 3, w * 19 / 20, h * 19 / 20, p);
        	    return bm;
        	  }    
         protected void onDraw(Canvas c) {
             Bitmap ball = Bitmap.createBitmap(64, 64, Bitmap.Config.ARGB_8888);
            		 //(BitmapDrawable) mContext.getResources().getDrawable(R.drawable.ball);

        	 
        	 if (x<0 && y <0) {
                 x = this.getWidth()/2;
                 y = this.getHeight()/2;
             } else {
                 x += xVelocity;
                 y += yVelocity;
                 if ((x > this.getWidth() - x) || (x < 0)) {
                         xVelocity = xVelocity*-1;
                 }
                 if ((y > this.getHeight() - y) || (y < 0)) {
                         yVelocity = yVelocity*-1;
                 }
            }
       
             int radius;
             radius = 100;
             Paint paint = new Paint();
             paint.setStyle(Paint.Style.FILL);
             paint.setColor(Color.WHITE);
             c.drawPaint(paint);
             // Use Color.parseColor to define HTML colors
             paint.setColor(Color.parseColor("#CD5C5C"));
             c.drawCircle(x / 2, y / 2, radius, paint);
            //c.drawBitmap(ball., x, y, null);
            h.postDelayed(r, FRAME_RATE);
      }
}