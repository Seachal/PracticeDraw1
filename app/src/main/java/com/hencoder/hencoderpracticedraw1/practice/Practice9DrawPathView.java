package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class Practice9DrawPathView extends View {
    Paint paint = new Paint();
    Path path = new Path(); // 初始化 Path 对象

    Paint mPaint2 = new Paint();

    {
        // 使用 path 对图形进行描述（这段描述代码不必看懂）
        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        path.lineTo(400, 542);
    }

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        //   canvas.drawPath(path,paint);

        path = new Path();
        paint.setStyle(Paint.Style.STROKE);
        path.lineTo(300, 100);
        path.lineTo(300, 200);
        canvas.drawPath(path, paint);
        path.rLineTo(300, 100);// 把当前位置的坐标当做（0，0）向右平移300，向下平移200
        path.moveTo(300, 80);
        path.lineTo(300, 0);
        canvas.drawPath(path, paint);

       // paint = new Paint();
        mPaint2.setColor(Color.BLUE);
        //path.moveTo(600, 100);
        path.lineTo(800,100);
        path.lineTo(700,200);
        path.close(); //封闭当前路径
        canvas.drawPath(path, paint);


    }
}
