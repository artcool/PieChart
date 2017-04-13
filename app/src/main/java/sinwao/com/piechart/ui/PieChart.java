package sinwao.com.piechart.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

import sinwao.com.piechart.entity.PieData;

/**
 * 描述：
 * Created by artcool on 2017/4/13.
 */

public class PieChart extends View {

    /**
    颜色表 (注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
     */
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    /**
     * 开始绘制的角度
     */
    private float mStartAngle = 0;

    /**
     * 数据
     */
    private List<PieData> mDatas;

    /**
     * 宽高
     */
    private int mWidth,mHeight;

    Paint paint = new Paint();

    public PieChart(Context context) {
        super(context);
        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        paint.setColor(Color.parseColor("#ff0000"));
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mDatas == null) {
            return;
        }
        float currentAngle = this.mStartAngle;
        canvas.translate(mWidth / 2,mHeight / 2);
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);

        RectF rect = new RectF(-r, -r, r, r);
        for (int i = 0; i < mDatas.size(); i++) {
            PieData pie = mDatas.get(i);
            paint.setColor(pie.getColor());
            canvas.drawArc(rect,currentAngle,pie.getAngle(),true,paint);
            currentAngle += pie.getAngle();
        }
    }

    /**
     * 设置起始角度
     * @param mStartAngle
     */
    public void setStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();
    }

    /**
     * 设置数据
     * @param mDatas
     */
    public void setData(List<PieData> mDatas) {
        this.mDatas = mDatas;
        initData(mDatas);
        invalidate();
    }

    /**
     * 初始化数据
     * @param mDatas
     */
    private void initData(List<PieData> mDatas) {
        if (mDatas == null || mDatas.size() == 0) {
            return;
        }
        //计算值
        float sumValue = 0;
        for (int i = 0; i < mDatas.size(); i++) {
            PieData data = mDatas.get(i);
            sumValue += data.getValue();
            //设置颜色
            int j = i % mColors.length;
            data.setColor(mColors[j]);


        }

        //计算角度
        float sumAngle = 0;
        for (int i = 0; i < mDatas.size(); i++) {
            PieData pieData = mDatas.get(i);
            float percent = pieData.getValue() / sumValue;
            float angle = percent * 360;
            pieData.setPercent(percent);
            pieData.setAngle(angle);
            sumAngle += angle;
        }

    }

    public PieChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
