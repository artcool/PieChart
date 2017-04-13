package sinwao.com.piechart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import sinwao.com.piechart.entity.PieData;
import sinwao.com.piechart.ui.PieChart;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PieChart view = new PieChart(this);
        setContentView(view);

        List<PieData> mList = new ArrayList<>();
        PieData pieData = new PieData("artcool", 60);
        PieData pieData1 = new PieData("coolart", 30);
        PieData pieData2 = new PieData("john", 40);
        PieData pieData3 = new PieData("rose", 20);
        PieData pieData4 = new PieData("sam", 20);
        PieData pieData5 = new PieData("jimmy", 10);
        mList.add(pieData);
        mList.add(pieData1);
        mList.add(pieData2);
        mList.add(pieData3);
        mList.add(pieData4);
        mList.add(pieData5);
        view.setData(mList);

    }
}
