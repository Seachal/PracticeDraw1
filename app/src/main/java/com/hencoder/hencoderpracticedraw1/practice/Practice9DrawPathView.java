package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
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
    public static int TRIANG_SIDE_LENGTH = 50;  //等腰三角形的腰长

    private final Paint mPaint = new Paint(Paint.DITHER_FLAG);
    private Paint mFillPaint = null;
    public static final int PADDING = 10;
    Path mBubbleLegPrototype = new Path();

    {
        // 使用 path 对图形进行描述（这段描述代码不必看懂）
        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        path.lineTo(400, 542);
    }

    {
        mBubbleLegPrototype.moveTo(0, 0);
        mBubbleLegPrototype.lineTo(PADDING * 1.5f, -PADDING / 1.5f);
        mBubbleLegPrototype.lineTo(PADDING * 1.5f, PADDING / 1.5f);
        mBubbleLegPrototype.close();
    }
//    {
//     mBubbleLegPrototype.moveTo(0, 0);
//        mBubbleLegPrototype.lineTo(TRIANG_SIDE_LENGTH * 1.5f, -TRIANG_SIDE_LENGTH / 2.0f); //向负方向画路径，目前会被被隐藏
//        mBubbleLegPrototype.moveTo(0, 0);
//        mBubbleLegPrototype.lineTo(TRIANG_SIDE_LENGTH * 1.5f, TRIANG_SIDE_LENGTH / 2.0f);
//        mBubbleLegPrototype.close();//封闭路径
//    }
    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 根据显示方向，获取尖角位置矩阵（主要用于处理尖角，尖角的方向）
     *
     * @param width
     * @param height
     * @return
     */
    private Matrix renderBubbleLegMatrix(final float width, final float height) {

        final float MIN_LEG_DISTANCE = 20.0f;
        //偏移量
        final float offset = Math.max(30, MIN_LEG_DISTANCE);

        float dstX = 0;
        float dstY = Math.min(offset, height - MIN_LEG_DISTANCE);
        final Matrix matrix = new Matrix();

               dstX = Math.min(offset, width - MIN_LEG_DISTANCE);
                dstY = 0;
                matrix.postRotate(90);  // 等腰三角形，旋转90

        matrix.postTranslate(300, dstY); //平移，
        return matrix;
    }



    {

        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(5);
        mPaint.setStrokeJoin(Paint.Join.MITER);
        //注释掉，影响圆角对称
        //mPaint.setPathEffect(new CornerPathEffect(CORNER_RADIUS));

        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(LAYER_TYPE_SOFTWARE, mPaint);
        }

        mFillPaint = new Paint(mPaint);
        mFillPaint.setColor(Color.WHITE);
        mFillPaint.setShader(new LinearGradient(100f, 0f, 100f, 200f, Color.WHITE, Color.WHITE, Shader.TileMode.CLAMP));

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
//        //   canvas.drawPath(path,paint);
//
//        path = new Path();
//        paint.setStyle(Paint.Style.STROKE);
//        path.lineTo(300, 100);
//        path.lineTo(300, 200);
//        canvas.drawPath(path, paint);
//        path.rLineTo(300, 100);// 把当前位置的坐标当做（0，0）向右平移300，向下平移200
//        path.moveTo(300, 80);
//        path.lineTo(300, 0);
//        canvas.drawPath(path, paint);
//
//       // paint = new Paint();
//        mPaint2.setColor(Color.BLUE);
//        //path.moveTo(600, 100);
//        path.lineTo(800,100);
//        path.lineTo(700,200);
//        path.close(); //封闭当前路径
//        canvas.drawPath(path, paint);

//        final float  CORNER_RADIUS = 30.0f;
//        final float width = canvas.getWidth();
//        final float height = canvas.getHeight();
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setColor(Color.BLUE);
//        final Path mPath = new Path();
//
//        mPath.rewind();
//        mPath.addRoundRect(new RectF(PADDING, PADDING, width - PADDING, height - PADDING), CORNER_RADIUS, CORNER_RADIUS, Path.Direction.CW);
//     //   mPath.addPath(mBubbleLegPrototype, renderBubbleLegMatrix(width, height));
//
//        canvas.drawPath(mPath, mPaint);
//
////        canvas.scale((width - STROKE_WIDTH) / width, (height - STROKE_WIDTH) / height, width / 2f, height / 2f);
////
//    //    canvas.drawPath(mPath, mFillPaint);





        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        canvas.translate(0,300);
        canvas.drawPath(mBubbleLegPrototype,paint);



    }
}
