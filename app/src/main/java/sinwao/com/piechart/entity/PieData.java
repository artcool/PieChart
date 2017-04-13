package sinwao.com.piechart.entity;

/**
 * 描述：
 * Created by artcool on 2017/4/13.
 */

public class PieData {
    /**
     * 名字
     */
    private String name;
    /**
     *  数值
     */
    private float value;
    /**
     * 百分比
     */
    private float percent;

    /**
     * 颜色
     */
   private int color = 0;

    /**
     * 角度
     */
    private float angle = 0;



    public PieData(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}
